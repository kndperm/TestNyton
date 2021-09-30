package com.knd.test_nyton.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knd.test_nyton.model.Trade;
import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {

    public static JSONArray getJSONArrayFromMOEXJson(JSONObject json, String base){
        return json.getJSONObject(base).getJSONArray("data");
    }
}
