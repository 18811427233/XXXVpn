package com.demo.xxxvpn.domain.entity.network;


import java.util.List;


public class LoginResponse {

    private CdVO cdAdDay;
    private List<CdVO> cdAdHourList;
    private Integer adRewardFlows;
    private String adTextNew;
    private Integer isForbid;
    private String token;
    private Double userFlows;
    private String uuid;

    public CdVO getCdAdDay() {
        return cdAdDay;
    }

    public void setCdAdDay(CdVO cdAdDay) {
        this.cdAdDay = cdAdDay;
    }

    public List<CdVO> getCdAdHourList() {
        return cdAdHourList;
    }

    public void setCdAdHourList(List<CdVO> cdAdHourList) {
        this.cdAdHourList = cdAdHourList;
    }

    public Integer getAdRewardFlows() {
        return adRewardFlows;
    }

    public void setAdRewardFlows(Integer adRewardFlows) {
        this.adRewardFlows = adRewardFlows;
    }

    public String getAdTextNew() {
        return adTextNew;
    }

    public void setAdTextNew(String adTextNew) {
        this.adTextNew = adTextNew;
    }

    public Integer getIsForbid() {
        return isForbid;
    }

    public void setIsForbid(Integer isForbid) {
        this.isForbid = isForbid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getUserFlows() {
        return userFlows;
    }

    public void setUserFlows(Double userFlows) {
        this.userFlows = userFlows;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
