package com.mec.libapi.domain.pojo.bookModule;

public class Detail {

    private Long id;
    private String condition;
    private String buyType;
    private String provider;
    private String deliverySlip;

    public Detail() {
    }

    public Detail(Long id, String condition, String buyType, String provider, String deliverySlip) {
        this.id = id;
        this.condition = condition;
        this.buyType = buyType;
        this.provider = provider;
        this.deliverySlip = deliverySlip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getBuyType() {
        return buyType;
    }

    public void setBuyType(String buyType) {
        this.buyType = buyType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDeliverySlip() {
        return deliverySlip;
    }

    public void setDeliverySlip(String deliverySlip) {
        this.deliverySlip = deliverySlip;
    }
}
