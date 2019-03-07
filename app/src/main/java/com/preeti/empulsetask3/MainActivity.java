package com.preeti.empulsetask3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.preeti.empulsetask3.Database.DataHelper;
import com.preeti.empulsetask3.Model.LoginResponse;
import com.preeti.empulsetask3.Model.SendObject;
import com.preeti.empulsetask3.Model.UserInformation;
import com.preeti.empulsetask3.Network.APIClient;
import com.preeti.empulsetask3.Network.APIInterface;
import com.preeti.empulsetask3.Network.CommonMethod;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<LoginResponse> dummylist;
    DataHelper dbHelper;
    String templateid="1";
    String templatetypeid="1";
    ProgressDialog progressDoalog;
    Button btn;
    List<UserInformation> userinfomodels = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
       // dummylist=new ArrayList<>();
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");

        dbHelper = new DataHelper(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDoalog.show();
                if (CommonMethod.isNetworkAvailable(MainActivity.this)) {
                    loginRetrofit2Api(templateid,templatetypeid);
                }
                else {
                    getFromDatabase();
                }
               // loginRetrofit2Api(templateid,templatetypeid);
            }
        });

    }




    private void getFromDatabase(){
        if (dbHelper.getUserCount() != 0) {
            Cursor cursor = dbHelper.getuser();
            while(cursor.moveToNext()){
                String questionid  =cursor.getString(0);
                String component_type=cursor.getString(1);
                String obj_desp=cursor.getString(2);
                String obj_desp_ans=cursor.getString(3);
                UserInformation p = new UserInformation();
                p.setQuestionid(questionid);
                p.setComponent_type(component_type);
                p.setObj_desp(obj_desp);
                p.setObj_desp_ans(obj_desp_ans);
                userinfomodels.add(p);
            }

         //   generateDataList(userinfomodels);

            for(int i=0;i<userinfomodels.size();i++){
                Log.d("guestioniddd",userinfomodels.get(i).questionid);
                String questionid=userinfomodels.get(i).questionid;
                String component_type=userinfomodels.get(i).component_type;
                String obj_desp=userinfomodels.get(i).obj_desp;
                String obj_desp_ans=userinfomodels.get(i).obj_desp_ans;

                Toast.makeText(MainActivity.this, questionid+component_type+obj_desp+obj_desp_ans, Toast.LENGTH_SHORT).show();
            }

            progressDoalog.dismiss();
        }
        else {

            CommonMethod.showAlert("Internet Connectivity Failure", MainActivity.this);
        }


    }


    private void loginRetrofit2Api(String templateid,String templatetypeid) {

        SendObject sendObject=new SendObject();
           sendObject.setTemplateid(templateid);
           sendObject.setTemplatetypeid(templatetypeid);

        APIInterface service = APIClient.getClient().create(APIInterface.class);
        Call<LoginResponse> call=service.getFriendsLocation(sendObject);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse=response.body();

                List<UserInformation> userinforamtion=loginResponse.getItems();

                Log.d("Dataaaaaa",userinforamtion.toString());

                dbHelper.deleteUser();
                progressDoalog.dismiss();

                Log.i("Data",userinforamtion.toString());
                Log.d("checkkkk",loginResponse.getBiddingschedulestemplate_list().get(0).questionid);


                for(int i=0;i<loginResponse.getBiddingschedulestemplate_list().size();i++){
                    Log.d("guestioniddd",loginResponse.getBiddingschedulestemplate_list().get(i).questionid);
                    String questionid=loginResponse.getBiddingschedulestemplate_list().get(i).questionid;
                    String component_type=loginResponse.getBiddingschedulestemplate_list().get(i).component_type;
                    String obj_desp=loginResponse.getBiddingschedulestemplate_list().get(i).obj_desp;
                    String obj_desp_ans=loginResponse.getBiddingschedulestemplate_list().get(i).obj_desp_ans;

                    dbHelper.adduser(MainActivity.this, questionid,component_type, obj_desp, obj_desp_ans);

                    Toast.makeText(MainActivity.this, questionid+component_type+obj_desp+obj_desp_ans, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!"+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }


}
