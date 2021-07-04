package com.example.demolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    ListView listView;
    //String[] title  = {"Rahul","Ram","Jitendra","Rakesh","Akash","Ramesh","Rajesh","Ganesh"};
    //String[] desc  = {"Student","Actor","Student","Doctor","Businessman","Developer","Developer 1","Doctor"};

    //int[] imageList = {R.drawable.heart,R.drawable.clipart,R.drawable.linkedin,R.drawable.wifi};
    ArrayList<String> centerList,districtList;
    ArrayList<Boolean> availableList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);

        centerList =  new ArrayList<String>();
        districtList =  new ArrayList<String>();
        availableList =  new ArrayList<Boolean>();

        String urlString = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin" +
                "?pincode=826001&date=01-05-2021";

        StringRequest request = new StringRequest(Request.Method.GET, urlString,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CustomListViewActivity.this,"Url hit successfully",
                                Toast.LENGTH_LONG).show();

                        try {
                            JSONObject parentObj = new JSONObject(response);
                            JSONArray centers = parentObj.getJSONArray("centers");
                            JSONObject jsonObject;
                            String name,district;
                            boolean isAvailable = false;
                            JSONArray sessionArray;
                            int available_capacity , min_age_limit;

                            getSupportActionBar().setTitle("Centers Found : "+centers.length());

                            for(int i = 0;i<centers.length();i++){
                                jsonObject = centers.getJSONObject(i);
                                 name  = jsonObject.getString("name");
                                 district = jsonObject.getString("district_name");
                                 isAvailable = false;



                                sessionArray = jsonObject.getJSONArray("sessions");

                                for(int j = 0;j<sessionArray.length();j++){
                                    available_capacity = (sessionArray.getJSONObject(j))
                                            .getInt("available_capacity");
                                    min_age_limit = (sessionArray.getJSONObject(j))
                                            .getInt("min_age_limit");

                                    if(available_capacity > 0 && min_age_limit == 45){
                                        district += " , "+available_capacity + " available";
                                        isAvailable = true;

                                    }

                                }
                                centerList.add(name);
                                districtList.add(district);
                                availableList.add(isAvailable);

                            }

                            CustomAdapter arrayAdapter = new CustomAdapter();

                            listView = findViewById(R.id.ListView);
                            listView.setAdapter(arrayAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CustomListViewActivity.this,"Url hit Failed",
                                Toast.LENGTH_LONG).show();

                    }
                }
        );
        RequestQueue requestQueue = Volley.newRequestQueue(CustomListViewActivity.this);
        requestQueue.add(request);



    }
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return centerList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.custom_row_layout,null);

            TextView txtTitle = convertView.findViewById(R.id.textView);
            txtTitle.setText(centerList.get(position));

            TextView txtDesc = convertView.findViewById(R.id.textView2);
            txtDesc.setText(districtList.get(position));

            ImageView imageView = convertView.findViewById(R.id.imageView);
            if(availableList.get(position)){
                imageView.setImageResource(R.drawable.vaccineicon);
            }
            else {
                imageView.setImageResource(R.drawable.vacsin);
            }

            return convertView;
        }
    }
}