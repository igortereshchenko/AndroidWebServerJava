package com.tereshchenko.androidwebserverjava;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class ServerDataHandler extends AsyncTask<String,Void,JSONObject> {

    public AsyncResponse delegate = null;


    @Override
    protected JSONObject doInBackground(String... strings) {

    try {
        URL url = new URL(strings[0]);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");

        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line="";

        String result="";

        while ((line=reader.readLine())!=null){

            result+=line;
        }

        JSONObject jsonObject =  new JSONObject(result);

        return jsonObject;
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
        return null;
    }


    protected void onPostExecute(JSONObject result) {

        delegate.finishTask(result);
    }
}
