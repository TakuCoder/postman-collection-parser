package com.thiyagu.postmancollection;

import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws JSONException {
        File file = new File("/home/taku/Desktop/postman.postman_collection.json");
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
            JSONObject info_Object = new JSONObject(json);
            if (info_Object.has("auth-attribute")) {
                System.out.println("auth-attribute");
            }
            if (info_Object.has("auth")) {
                System.out.println("found auth");
            }
            if (info_Object.has("certificate-list")) {
                System.out.println("certificate-list");
            }
            if (info_Object.has("certificate")) {
                System.out.println("certificate");
            }
            if (info_Object.has("cookie-list")) {
                System.out.println("cookie-list");
            }
            if (info_Object.has("cookie")) {
                System.out.println("cookie");
            }
            if (info_Object.has("description")) {
                System.out.println("description");
            }
            if (info_Object.has("event-list")) {
                System.out.println("event-list");
            }
            if (info_Object.has("event")) {
                System.out.println("event");
            }
            if (info_Object.has("header-list")) {
                System.out.println("header-list");
            }
            if (info_Object.has("header")) {
                System.out.println("header");
            }
            if (info_Object.has("info")) {
                PrintLog("found info");

                JSONObject info = info_Object.getJSONObject("info");
                //System.out.println("found info");
                String _postman_id = info.getString("_postman_id");
                String name = info.getString("name");
                String schema = info.getString("schema");
                System.out.println("_postman_id " + _postman_id);
                System.out.println("name " + name);
                System.out.println("schema " + schema);
                PrintLog("found info");
            }
            if (info_Object.has("item-group")) {
                System.out.println("item-group");
            }
            if (info_Object.has("item")) {
                PrintLog("found item");
                //System.out.println("item");
                JSONArray jsonArray = info_Object.getJSONArray("item");
                JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                String item_name = jsonObject1.getString("name");
                System.out.println(item_name);
                JSONObject object_request = jsonObject1.getJSONObject("request");
                // System.out.println(object_request);
                if (object_request.has("auth")) {
                    PrintLog("found auth");

                    JSONObject auth_object = object_request.getJSONObject("auth");
                    switch (auth_object.getString("type")) {
                        case "basic":
                            PrintLog("found basic");
                            JSONArray basic_array = auth_object.getJSONArray("basic");
                            JSONObject basic_username_object = new JSONObject(basic_array.get(1).toString());
                            String basic_username_type = basic_username_object.getString("type");
                            String basic_username_value = basic_username_object.getString("value");
                            String basic_username_key = basic_username_object.getString("key");
                            System.out.println(basic_username_type + "    basic_username_type");
                            System.out.println(basic_username_value + "   basic_username_value");
                            System.out.println(basic_username_key + " basic_username_key");
                            JSONObject basic_password_object = new JSONObject(basic_array.get(0).toString());
                            String basic_password_type = basic_password_object.getString("type");
                            String basic_password_value = basic_password_object.getString("value");
                            String basic_password_key = basic_password_object.getString("key");
                            System.out.println(basic_password_type + "    basic_password_type");
                            System.out.println(basic_password_value + "   basic_password_value");
                            System.out.println(basic_password_key + "     basic_password_key");
                            System.out.println();
                            break;
                        default:
                            System.out.println("this execeuted");
                            break;
                    }
                }
                String request_method = object_request.get("method").toString();
                System.out.println(request_method + " request_method");

                if (object_request.has("header")) {
                    PrintLog("found header");
                    JSONArray request_header_array = object_request.getJSONArray("header");
                    for (int i = 0; i < request_header_array.length(); i++) {
                        JSONObject header_object = request_header_array.getJSONObject(0);

                        {
                            String header_key = header_object.getString("key");
                            String header_value = header_object.getString("value");
                            String header_description = header_object.getString("description");
                            String header_type = header_object.getString("type");
                            System.out.println(header_key + " header_key");
                            System.out.println(header_value + " header_value");
                            System.out.println(header_type + " header_type");
                            if (header_object.has("description")) {
                                System.out.println(header_description + " header_description");

                            } else {
                                System.out.println(header_description + "no header_description");
                            }
                        }
                        System.out.println("");
                    }
                } else {

                    PrintLog("no found header");
                }


                if (object_request.has("body")) {
                    PrintLog("found body");
                    JSONObject object = object_request.getJSONObject("body");
                    String mode = object.getString("mode");
                    System.out.println(mode);

                    switch (mode) {

                        case "formdata":


                            JSONArray formdata_Array = object.getJSONArray("formdata");
                            for (int i = 0; i < formdata_Array.length(); i++)
                            {
                                JSONObject formdata_object = formdata_Array.getJSONObject(i);
                                String formdata_key = formdata_object.getString("key");

                                String formdata_type = formdata_object.getString("type");
                                if(formdata_type.equals("text"))
                                {
                                    String formdata_value = formdata_object.getString("value");
                                    System.out.println(formdata_value + "   formdata_value");
                                }
                                else if(formdata_type.equals("file")){

                                    String formdata_value = formdata_object.getString("src");
                                    System.out.println(formdata_value + "   formdata_value");
                                }
                                if (formdata_object.has("disabled")) {
                                    if (formdata_object.get("disabled").equals(true)) {

                                        System.out.println("Disabled");

                                    }

                                } else {

                                    System.out.println("not Disabled");
                                }
                                System.out.println(formdata_key + "   formdata_key");
                                System.out.println(formdata_type + "   formdata_type");
                                if (formdata_object.has("description")) {

                                    String formdata_description = formdata_object.getString("description");
                                    System.out.println(formdata_description + "   formdata_description");
                                } else {
                                    System.out.println(" no  formdata_description");

                                }


                            }
                            PrintLog("found formdata");
                            break;

                        case "urlencoded":
                            PrintLog("found urlencoded");

                            formdata_Array = object.getJSONArray("urlencoded");
                            for (int i = 0; i < formdata_Array.length(); i++)
                            {
                                JSONObject urlencoded_object = formdata_Array.getJSONObject(i);
                                String urlencoded_key = urlencoded_object.getString("key");
                                String urlencoded_value = urlencoded_object.getString("value");
                                String urlencoded_type = urlencoded_object.getString("type");
                                if (urlencoded_object.has("disabled")) {
                                    System.out.println(urlencoded_object.get("disabled"));

                                } else {

                                    System.out.println("not Disabled");
                                }
                                System.out.println(urlencoded_key + "   urlencoded_key");
                                System.out.println(urlencoded_value + "   urlencoded_value");

                                System.out.println(urlencoded_type + "   urlencoded_type");
                                if (urlencoded_object.has("description")) {

                                    String formdata_description = urlencoded_object.getString("description");
                                    System.out.println(formdata_description + "   urlencoded_description");
                                } else {
                                    System.out.println(" no  urlencoded_description");

                                }
                                System.out.println();

                            }
                            break;

                        case "raw":
                            System.out.println(object.get("raw"));
                            PrintLog("found raw");
                            break;

                        case "file":
                            PrintLog("found file");
                            break;

                        default:
                            break;


                    }

                    System.out.println(mode);
                } else {

                    PrintLog("no body found");
                }
                if (object_request.has("url")) {
                    PrintLog("found url");
                    JSONObject Object_Url = object_request.getJSONObject("url");
                    System.out.println(Object_Url);
                    String raw = Object_Url.getString("raw");
                    JSONArray hostarray = Object_Url.getJSONArray("host");
                    String host1 = hostarray.getString(0);
                    String host2 = hostarray.getString(1);
                    String host3 = hostarray.getString(2);
                    System.out.println(raw);
                    System.out.println(host1 + host2 + host3);

                    if (Object_Url.has("query")) {
                        PrintLog("has Querry");
                        JSONArray query_array = Object_Url.getJSONArray("query");
                        for (int i = 0; i < query_array.length(); i++) {
                            JSONObject jsonObject2 = query_array.getJSONObject(i);
                            String query_key = jsonObject2.getString("key");
                            String query_value = jsonObject2.getString("value");

                            System.out.println("query_key " + query_key);
                            System.out.println("query_value " + query_value);

                            if (jsonObject2.has("description")) {

                                String query_description = jsonObject2.getString("description");
                                System.out.println("query_description " + query_description);
                            } else {
                                String query_description = jsonObject2.getString("description");
                                System.out.println("query_description " + query_description);

                            }


                            if (jsonObject2.has("disabled")) {
                                String disabled = jsonObject2.optString("disabled");
                                System.out.println("disabled " + disabled);
                            } else {
                                System.out.println("disabled " + "false");

                            }
                            System.out.println("");
                        }

                    } else {
                        PrintLog("No Querry");

                    }

                }
                PrintLog("found item");
            }
            if (info_Object.has("protocol-profile-behavior")) {
                System.out.println("protocol-profile-behavior");
            }
            if (info_Object.has("auth")) {
                System.out.println("found auth");
            }
            if (info_Object.has("protocol-profile-behavior")) {
                System.out.println("protocol-profile-behavior");
            }
            if (info_Object.has("protocol-config")) {
                System.out.println("protocol-config");
            }
            if (info_Object.has("request")) {
                System.out.println("request");
            }
            if (info_Object.has("response")) {
                System.out.println("response");
            }
            if (info_Object.has("response")) {
                System.out.println("response");
            }
            if (info_Object.has("script")) {
                System.out.println("script");
            }
            if (info_Object.has("url")) {
                System.out.println("url");
            }
            if (info_Object.has("variable-list")) {
                System.out.println("variable-list");
            }
            if (info_Object.has("variable")) {
                System.out.println("variable");
            }
            if (info_Object.has("version")) {
                System.out.println("version");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

    }


    public static void PrintLog(String s) {

        int value = s.length();
        int total = 100 - value;
        int point = total / 2;

        //System.out.println(value);
        // System.out.println(total);
        //  System.out.println(point);

        for (int i = 0; i < point; i++) {

            System.out.print("=");
        }
        System.out.print(s);

        for (int i = point + value; i < 100; i++) {
            System.out.print("=");
        }
        System.out.println("");
    }
}