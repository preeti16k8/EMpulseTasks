package com.preeti.empulsetask3.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendObject {
    public SendObject(String templateid, String templatetypeid) {
        this.templateid = templateid;
        this.templatetypeid = templatetypeid;
    }

    public SendObject() {

    }

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

    @SerializedName("templateid")

    @Expose
    private String templateid;

    @SerializedName("templatetypeid")
    @Expose
    private String templatetypeid;
}
