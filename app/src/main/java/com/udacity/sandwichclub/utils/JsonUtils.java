package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich newSandwich = new Sandwich();

        try {
            JSONObject mainJson = new JSONObject(json);

            JSONObject nameJson =  mainJson.getJSONObject("name");

            newSandwich.setMainName(nameJson.getString("mainName"));

            newSandwich.setAlsoKnownAs(changeArray(nameJson.getJSONArray("alsoKnownAs")));

            newSandwich.setPlaceOfOrigin(mainJson.getString("placeOfOrigin"));

            newSandwich.setDescription(mainJson.getString("description"));

            newSandwich.setImage(mainJson.getString("image"));

            newSandwich.setIngredients(changeArray(mainJson.getJSONArray("ingredients")));

        } catch (JSONException e) { e.printStackTrace(); }

        return newSandwich;
    }

    private static List<String> changeArray(JSONArray arr){

        List<String> str = new ArrayList<>();

        for(int i =0; i<arr.length(); i++){
            try{ str.add(arr.getString(i)); }
            catch (JSONException e){e.printStackTrace();}
        }

        return str;
    }
}
