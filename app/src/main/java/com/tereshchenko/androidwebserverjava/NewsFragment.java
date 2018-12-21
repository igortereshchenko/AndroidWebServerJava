package com.tereshchenko.androidwebserverjava;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment implements AsyncResponse{

    ListView lstNews;
    ProgressBar progressBar;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View layout  = inflater.inflate(R.layout.fragment_news, container, false);

        lstNews = (ListView)layout.findViewById(R.id.lstNews);
        progressBar = (ProgressBar)layout.findViewById(R.id.progressBar);


        Button btn = (Button) layout.findViewById(R.id.btnTest);


        progressBar.setProgress(20);


        btn.setOnClickListener(view->{

//            TaskLoadNews task = new TaskLoadNews();
//            task.execute(lstNews,progressBar, getView());


              ServerDataHandler handler = new ServerDataHandler();
              handler.delegate = this;
              handler.execute("http://10.100.0.87:8080/NewsServer/news");


        });

        return layout;
    }


    @Override
    public void finishTask(JSONObject output) {

        try {

            News news = new News(Integer.parseInt(output.getString("id")),output.getString("title"),output.getString("content"));

            Toast.makeText(getContext(),news.toString(),Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
