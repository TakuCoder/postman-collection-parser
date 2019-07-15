package com.thiyagu.postmancollection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;


public class CollectionMaker {

    public static void main(String[] args) {
        JsonObject info = new JsonObject();
        info.addProperty("_postman_id", "942b9d0a-01db-48c4-a3e1-e52a5824681a");
        info.addProperty("name", "sample");
        info.addProperty("schema", "https://schema.getpostman.com/json/collection/v2.1.0/collection.json");

        JsonArray item = new JsonArray();
        JsonObject name = new JsonObject();
        name.addProperty("name", "sample");
        JsonObject request = new JsonObject();
        request.addProperty("method", "get");

        JsonArray header = new JsonArray();
        JsonObject header_object = new JsonObject();
        header_object.addProperty("key", "key1");
        header_object.addProperty("value", "value1");
        header_object.addProperty("description", "desc");
        header_object.addProperty("type", "text");
        header.add(header_object);
        request.add("header", header);

        JsonObject url = new JsonObject();
        url.addProperty("raw", "www.google.com?key1=value1");

        JsonArray host = new JsonArray();
        host.add(new JsonPrimitive("www"));
        host.add(new JsonPrimitive("www"));
        host.add(new JsonPrimitive("www"));
        url.add("host", host);


        JsonArray query = new JsonArray();
        JsonObject query_object = new JsonObject();
        query_object.addProperty("key", "key1");
        query_object.addProperty("value", "value1");
        query_object.addProperty("description", "desc");
        query_object.addProperty("type", "text");
        query.add(query_object);
        request.add("query", query);

        //JsonObject desc = new JsonObject();
        ////desc.addProperty("description", "sample this one");
        url.addProperty("description", "sample this one");

        //JsonArray response = new JsonArray();
        JsonObject responseobject = new JsonObject();
        responseobject.addProperty("response","");
        //response.add(responseobject);
        item.add(name);
        item.add(request);
        item.add(url);
        item.add(responseobject);
        //request.add(desc);

        System.out.println(item.toString());
    }
}
