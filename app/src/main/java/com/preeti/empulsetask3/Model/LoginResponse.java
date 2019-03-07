package com.preeti.empulsetask3.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {

    @SerializedName("templateid")
    private String templateid;

    @SerializedName("templatetypeid")
    private String templatetypeid;

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getTemplatetypeid() {
        return templatetypeid;
    }

    public void setTemplatetypeid(String templatetypeid) {
        this.templatetypeid = templatetypeid;
    }

    public String getBiddingid() {
        return biddingid;
    }

    public void setBiddingid(String biddingid) {
        this.biddingid = biddingid;
    }

    public List<UserInformation> getBiddingschedulestemplate_list() {
        return biddingschedulestemplate_list;
    }

    public void setBiddingschedulestemplate_list(List<UserInformation> biddingschedulestemplate_list) {
        this.biddingschedulestemplate_list = biddingschedulestemplate_list;
    }

    @SerializedName("biddingid")
    private String biddingid;

    @SerializedName("biddingschedulestemplate_list")
   public List<UserInformation> biddingschedulestemplate_list;

    public List<UserInformation> getItems() {
        return biddingschedulestemplate_list;
    }

    public void setItems(List<UserInformation> items) {
        this.biddingschedulestemplate_list = items;
    }
}
