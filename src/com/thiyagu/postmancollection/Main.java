package com.thiyagu.postmancollection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws JSONException {


        File file = new File("C:\\Users\\Thiyagu\\Desktop\\sample.postman_collection.json");


        try {


            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            StringBuilder sb = new StringBuilder();
            String line = bufferedReader.readLine();


            while (line != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }


            String json = sb.toString();
            //System.out.println(json);

            JSONObject jsonObject = new JSONObject(json);
            JSONObject info = jsonObject.getJSONObject("info");
            //System.out.println(info);

            String _postman_id = info.getString("_postman_id");
            String name = info.getString("name");

            String schema = info.getString("schema");


            JSONArray jsonArray = jsonObject.getJSONArray("item");
            JSONObject jsonObject1 = jsonArray.getJSONObject(0);
            String item_name = jsonObject1.getString("name");


            JSONObject request = new JSONObject(jsonObject1.getString("request"));
            String descriptionmain = request.getString("description");

            if(request.has("auth"))
            {
                JSONObject auth = new JSONObject(request.getString("auth"));
                String type = auth.getString("type");
                System.out.println("auth found");
                System.out.println("type" + type);
            }
           else
            {

                System.out.println("no auth found");
            }
            String method = request.getString("method");
            JSONArray header = request.getJSONArray("header");

            System.out.println(jsonArray.length());
            System.out.println(_postman_id);
            System.out.println(name);

            System.out.println(schema);
            System.out.println(item_name);

            System.out.println(method + "method");

            JSONArray header_array = request.getJSONArray("header");


            if (request.has("header")) {
                System.out.println("===========Found header===============");
                for (int i = 0; i < header_array.length(); i++) {

                    JSONObject jsonObject2 = header_array.getJSONObject(i);

                    String key = jsonObject2.getString("key");
                    String value = jsonObject2.getString("value");

                    String header_type = jsonObject2.getString("type");
                    if (jsonObject2.has("disabled")) {
                        //get Value of video
                        String disabled = jsonObject2.optString("disabled");
                        System.out.println("disabled " + disabled);
                    }
                    if (jsonObject2.has("description")) {
                        //get Value of video
                        String description = jsonObject2.getString("description");
                        System.out.println("description " + description);
                    }

                    System.out.println("key " + key);
                    System.out.println("value " + value);

                    System.out.println("header_type " + header_type);


                }
                System.out.println("===========Found header===============");
            } else {
                System.out.println("===========Header not Found===============");

            }

            if (request.has("body"))
            {
                System.out.println("=====================Body exists==============");
                JSONObject object = request.getJSONObject("body");
                String mode = object.getString("mode");
                System.out.println(mode);

                switch (mode) {

                    case "formdata":



                        JSONArray formdata_Array = object.getJSONArray("formdata");
                                for(int i=0;i<formdata_Array.length();i++)
                                {
                                    

                                }
                        System.out.println("=====================Found FormData==============");
                        break;

                    case "urlencoded":
                        System.out.println("=====================Found urlencoded==============");
                        break;

                    case "raw":
                        System.out.println("=====================Found raw==============");
                        break;

                    case "file":
                        System.out.println("=====================Found file==============");
                        break;

                    default:
                        break;


                }

                System.out.println(mode);
            } else {

                System.out.println("============No Body exists===================");
            }


            JSONObject url = request.getJSONObject("url");
            String raw = url.getString("raw");

            JSONArray hostarray = url.getJSONArray("host");
            String host1 = hostarray.getString(0);
            String host2 = hostarray.getString(1);
            String host3 = hostarray.getString(2);
            System.out.println(raw);

            System.out.println(host1 + host2 + host3);
            JSONArray query_array = url.getJSONArray("query");
            for (int i = 0; i < query_array.length(); i++) {
                JSONObject jsonObject2 = query_array.getJSONObject(i);


                String key = jsonObject2.getString("key");
                String value = jsonObject2.getString("value");
                String description = jsonObject2.getString("description");

                System.out.println("key " + key);
                System.out.println("value " + value);
                System.out.println("description " + description);


                if (jsonObject2.has("disabled")) {
                    //get Value of video
                    String disabled = jsonObject2.optString("disabled");
                    System.out.println("disabled " + disabled);
                }

            }


            String response = jsonObject1.getString("response");
            System.out.println(descriptionmain);
        } catch (Exception e) {

            System.out.println(e.toString());
            e.printStackTrace();
        }


//
//System.out.println(info.get("_postman_id"));

        // write your code here
    }
}
