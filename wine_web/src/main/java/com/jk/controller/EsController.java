package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.pojo.ConstantUtil;
import com.jk.pojo.WineBean;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

@Controller
@RequestMapping("es")
public class EsController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @GetMapping("queryWineInfo")
    @ResponseBody
    public HashMap<String,Object> queryWineInfo(Integer page, Integer rows, WineBean wineBean){
        HashMap<String, Object> result = new HashMap<String, Object>();
        Client client = elasticsearchTemplate.getClient();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("wine")
                .setTypes("elwine").setQuery(boolQueryBuilder);

        if(wineBean.getWineName() !=null && wineBean.getWineName() != "" ){
           boolQueryBuilder.must(QueryBuilders.matchQuery("winename", wineBean.getWineName()));

        }

        if(wineBean.getStartPrice() !=null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("wineprice").gte(wineBean.getStartPrice()));

        }
        if(wineBean.getEndPrice() !=null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("wineprice").lte(wineBean.getEndPrice()));
            //boolQueryBuilder.must(QueryBuilders.rangeQuery("commodityprice").lte(commodityBean.getEndPrice()));
        }
        searchRequestBuilder.setExplain(true);

        //销量排序
        if(wineBean.getSortNum() != null && wineBean.getSortNum() == ConstantUtil.ORDER_SORTNUM_ASC){
            searchRequestBuilder.addSort("winesalesvolume", SortOrder.ASC);
        }

        if(wineBean.getSortNum() != null && wineBean.getSortNum() == ConstantUtil.ORDER_SORTNUM_DESC){
            searchRequestBuilder.addSort("winesalesvolume", SortOrder.DESC);
        }


        //价格排序
        if(wineBean.getSortPrice() != null && wineBean.getSortPrice() == ConstantUtil.ORDER_SORTPRICE_ASC){
            searchRequestBuilder.addSort("wineprice", SortOrder.ASC);
        }

        if(wineBean.getSortPrice() != null && wineBean.getSortPrice() == ConstantUtil.ORDER_SORTPRICE_DESC){
            searchRequestBuilder.addSort("wineprice", SortOrder.DESC);
        }

        Integer startIndex = rows*(page-1);
        searchRequestBuilder.setFrom(startIndex).setSize(rows);

        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("winename");
        highlightBuilder.preTags("<font color='red'>");
        highlightBuilder.postTags("</font>");

        //设置高亮查询
        searchRequestBuilder.highlighter(highlightBuilder);
        //执行查询 拿到返回值
        SearchResponse searchResponse = searchRequestBuilder.get();
        //拿到命中条数
        SearchHits hits = searchResponse.getHits();

        //获取总条数 用来分页
        long totalHits = hits.getTotalHits();
        //获取到结果集迭代器
        Iterator<SearchHit> iterator = hits.iterator();

        List<WineBean> wineList = new ArrayList<>();

        while (iterator.hasNext()) {
            SearchHit next = iterator.next();
            //获取到源码内容 以json字符串的形式获取
            String sourceAsString = next.getSourceAsString();
            //获取高亮字段
            Map<String, HighlightField> highlightFields = next.getHighlightFields();
            HighlightField winename = highlightFields.get("winename");

            WineBean wine = JSON.parseObject(sourceAsString, WineBean.class);
            if(winename !=null ){
                Text[] fragments = winename.fragments();
                String title = "";
                for (Text texts : fragments) {
                    title += texts;
                }
                wine.setWineName(title);
            }

            wineList.add(wine);

        }
        result.put("total", totalHits);
        result.put("rows", wineList);
        return result;
    }

}
