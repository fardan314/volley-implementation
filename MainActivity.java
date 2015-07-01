package com.example.panacloud.volleyimplementation;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {
    String email = new String("junaidwarsi1994@yahoo.com");
    String url = "https://bikerapi.herokuapp.com/api/signup";
    String firstName ="junaid";
    String lastName = "warsi";
    String password = "1234";
    String userID = "junni1994";

//    private String url = 'https://panacloudapi.herokuapp.com/api/signin';
    private Button button;
    private TextView display;
    private RequestQueue rq;
    private JsonObjectRequest sr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add();

    }





    public void add()
    {

        button = (Button) findViewById(R.id.requestButton);
        display = (TextView)findViewById(R.id.display);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            JSONObject jo = new JSONObject();
                try {
                    jo.put("email", email);
                    jo.put("firstName", firstName);
                    jo.put("lastName", lastName);
                    jo.put("password", password);
                    jo.put ("userID",userID);
                }
                catch (Exception e )
                {
                    Log.d("Exception Found","");
                }
                rq  = Volley.newRequestQueue(MainActivity.this);
               sr = new JsonObjectRequest(Request.Method.POST,url,jo, new Response.Listener<JSONObject>() {
                   @Override
                   public void onResponse(JSONObject jsonObject) {
                       display.setText(jsonObject.toString());
                       //Log.d ("Elements",""+jsonObject);
                       Toast.makeText(MainActivity.this, "Request done", Toast.LENGTH_SHORT).show();
                   }
               },new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError volleyError) {
                       Toast.makeText(MainActivity.this, "Request failed", Toast.LENGTH_SHORT).show();
                   }
               }

               );


                rq.add(sr);

            }
        });



    }

}
