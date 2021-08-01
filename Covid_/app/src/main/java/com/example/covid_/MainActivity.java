package com.example.covid_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covid_.api.ApiUtilities;
import com.example.covid_.api.CountryData;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private TextView totalConfirm,totalActive,totalRecovered,totalDeath,totalTest;
    private TextView todayConfirm,todayRecovered,todayDeath,dateTv;

    private List<CountryData> list;

    private PieChart pieChartD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();

        init();
        findViewById(R.id.cName).setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this,CountryActivity.class)));

        ApiUtilities.getApiInterface().getCountryData()
                .enqueue(new Callback<List<CountryData>>() {
                    @Override
                    public void onResponse(Call<List<CountryData>> call, Response<List<CountryData>> response) {
                        list.addAll(response.body());

                        for(int i =0;i<list.size();i++){
                            if(list.get(i).getCountry().equals("India")){
                                int confirm = Integer.parseInt( list.get(i).getCases());
                                int active = Integer.parseInt( list.get(i).getActive());
                                int recovered = Integer.parseInt( list.get(i).getRecovered());
                                int deaths = Integer.parseInt( list.get(i).getDeaths());

                                totalConfirm.setText(NumberFormat.getInstance().format(confirm));

                                totalActive.setText(NumberFormat.getInstance().format(active));
                                totalRecovered.setText(NumberFormat.getInstance().format(recovered));
                                totalDeath.setText(NumberFormat.getInstance().format(deaths));

                                todayDeath.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayDeaths())));
                                todayRecovered.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayRecovered())));
                                todayConfirm.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTodayCases())));
                                totalTest.setText(NumberFormat.getInstance().format(Integer.parseInt(list.get(i).getTests())));

                                setText(list.get(i).getUpdated());

                                pieChartD.addPieSlice(new PieModel("Confirm", confirm,getResources().getColor(R.color.yellow)));
                                pieChartD.addPieSlice(new PieModel("Active", active,getResources().getColor(R.color.md_blue_700)));
                                pieChartD.addPieSlice(new PieModel("Recovered", recovered,getResources().getColor(R.color.md_green_700)));
                                pieChartD.addPieSlice(new PieModel("Deaths", deaths,getResources().getColor(R.color.md_red_700)));
                                pieChartD.startAnimation();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CountryData>> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Error : "+t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
    }

    private void setText(String updated) {
        DateFormat format = new SimpleDateFormat("MMM, dd, yyyy");

        Long milliSecond =  Long.parseLong(updated);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSecond);

        dateTv.setText("Update at "+format.format(calendar.getTime()));
    }

    private void init(){
        totalConfirm = (TextView)findViewById(R.id.totalConfirm);
        todayConfirm= (TextView)findViewById(R.id.todayConfirm);
        totalActive= (TextView)findViewById(R.id.totalActive);
        totalRecovered= (TextView)findViewById(R.id.totalRecovered);
        todayRecovered= (TextView)findViewById(R.id.todayRecovered);
        totalDeath = (TextView)findViewById(R.id.totalDeath);
        todayDeath= (TextView)findViewById(R.id.todayDeath);
        totalTest= (TextView)findViewById(R.id.totalTest);
        pieChartD= (PieChart)findViewById(R.id.pieChart);
        dateTv = (TextView)findViewById(R.id.date);
    }
}