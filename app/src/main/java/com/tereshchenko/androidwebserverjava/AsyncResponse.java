package com.tereshchenko.androidwebserverjava;

import org.json.JSONObject;

public interface AsyncResponse {

    void finishTask(JSONObject output);
}
