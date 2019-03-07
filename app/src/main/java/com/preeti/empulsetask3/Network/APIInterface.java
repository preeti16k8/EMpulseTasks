package com.preeti.empulsetask3.Network;
import com.preeti.empulsetask3.Model.LoginResponse;
import com.preeti.empulsetask3.Model.SendObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {


    @Headers({
            "Accept: application/json",
            "Content-type: application/json"
    })
    @POST("bidding_ScheduleinfoTemplateDetails")
    Call<LoginResponse> getFriendsLocation(@Body SendObject friendModel);


}


