package com.tereshchenko.androidwebserverjava;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskLoadNews extends AsyncTask<View, Integer, List<String>>{

    private ListView lstNews;
    private ProgressBar progressBar;
    private View mainView;

    List<String> testList;



    @Override
    protected void onPreExecute() {
        super.onPreExecute();


        testList = new ArrayList<>();

        //TODO connect to database

    }

    @Override
    protected List<String> doInBackground(View... views) {

        lstNews = (ListView) views[0];
        progressBar = (ProgressBar)views[1];
        mainView = (View)views[2];


        int count = 100; //TODO select count ...

        int patch_size = 2; //TODO calculate patch size

        int iteration_count = count/patch_size +1;

        for(int i=0;i<iteration_count;i++){

            int count_of_load = 2; //TODO calculate count_of_load

            publishProgress(i,count_of_load,iteration_count);
            SystemClock.sleep(500);

            testList.add("item "+ i);

        }

        return testList;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {

        int interation_number = values[0];
        int count_of_load = values[1];
        int iteration_count = values[2];

        int persentage = Math.round(((float)interation_number/(float)iteration_count)*100.0f);

        progressBar.setProgress(persentage);
    }


    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);

        //TODO load strings to ListView

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mainView.getContext(), android.R.layout.simple_list_item_1, strings);

        lstNews.setAdapter(arrayAdapter);
    }
}
