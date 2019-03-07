package com.preeti.empulsetask3.Model;

import com.google.gson.annotations.SerializedName;

public class UserInformation {

    @SerializedName("questionid")
    public String questionid;

    @SerializedName("component_type")
    public String component_type;

    @SerializedName("obj_desp")
    public String obj_desp;

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public String getComponent_type() {
        return component_type;
    }

    public void setComponent_type(String component_type) {
        this.component_type = component_type;
    }

    public String getObj_desp() {
        return obj_desp;
    }

    public void setObj_desp(String obj_desp) {
        this.obj_desp = obj_desp;
    }

    public String getObj_desp_ans() {
        return obj_desp_ans;
    }

    public void setObj_desp_ans(String obj_desp_ans) {
        this.obj_desp_ans = obj_desp_ans;
    }

    @SerializedName("obj_desp_ans")

    public String obj_desp_ans;

    public UserInformation() {

    }


}
