package com.jk.pojo;

import java.math.BigDecimal;

public class WineBean {


    private Integer id;

    private String  wineName;

    private Double winePrice;

    private Integer  wineStock;

    private Integer  wineSalesVolume;

    private Integer  wineTypeId;

    private String  wineTypeName;

    private String   wineInfo;

    private String  wineImg;

    private String  wineCreateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
