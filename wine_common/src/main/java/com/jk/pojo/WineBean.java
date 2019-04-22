package com.jk.pojo;

import java.math.BigDecimal;

public class WineBean {


    private Integer id;

    private String  wineName;

    private Double winePrice;

    private Double startPrice;

    private Double endPrice;

    private Integer  wineStock;

    private Integer  wineSalesVolume;

    private Integer  wineTypeId;

    private String  wineTypeName;

    private String   wineInfo;

    private String  wineImg;

    private String  wineCreateTime;

    private Integer sortNum;

    private Integer sortPrice;

    public Integer getSortPrice() {
        return sortPrice;
    }

    public void setSortPrice(Integer sortPrice) {
        this.sortPrice = sortPrice;
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public Double getEndPrice() {
        return endPrice;
    }

    public void setEndPrice(Double endPrice) {
        this.endPrice = endPrice;
    }

    public String getWineName() {
        return wineName;
    }

    public void setWineName(String wineName) {
        this.wineName = wineName;
    }

    public Double getWinePrice() {
        return winePrice;
    }

    public void setWinePrice(Double winePrice) {
        this.winePrice = winePrice;
    }

    public Integer getWineStock() {
        return wineStock;
    }

    public void setWineStock(Integer wineStock) {
        this.wineStock = wineStock;
    }

    public Integer getWineSalesVolume() {
        return wineSalesVolume;
    }

    public void setWineSalesVolume(Integer wineSalesVolume) {
        this.wineSalesVolume = wineSalesVolume;
    }

    public Integer getWineTypeId() {
        return wineTypeId;
    }

    public void setWineTypeId(Integer wineTypeId) {
        this.wineTypeId = wineTypeId;
    }

    public String getWineTypeName() {
        return wineTypeName;
    }

    public void setWineTypeName(String wineTypeName) {
        this.wineTypeName = wineTypeName;
    }

    public String getWineInfo() {
        return wineInfo;
    }

    public void setWineInfo(String wineInfo) {
        this.wineInfo = wineInfo;
    }

    public String getWineImg() {
        return wineImg;
    }

    public void setWineImg(String wineImg) {
        this.wineImg = wineImg;
    }

    public String getWineCreateTime() {
        return wineCreateTime;
    }

    public void setWineCreateTime(String wineCreateTime) {
        this.wineCreateTime = wineCreateTime;
    }
}
