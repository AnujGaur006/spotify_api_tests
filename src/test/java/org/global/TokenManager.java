package org.global;

import io.restassured.response.Response;
import org.utils.ConfigLoader;

import java.time.Instant;
import java.util.HashMap;

public class TokenManager {

    private static final ConfigLoader configLoader = ConfigLoader.getInstance();
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken(){

        try{
            if(access_token == null || Instant.now().isAfter(expiry_time)){
                System.out.println("Renewing token .......");
            Response response = renewToken();
            int expiryDurationInSeconds = response.path("expires_in");

            expiry_time = Instant.now().plusSeconds(expiryDurationInSeconds);
            access_token = response.path("access_token");
        }   else System.out.println("Token not yet expired");
        } catch (Exception e){
            throw new RuntimeException("Failed to get token" + e.getMessage());
        }

        return access_token;
    }

    private static Response renewToken(){
        HashMap<String,String> formParam = new HashMap<>();

        formParam.put("client_id", configLoader.prop.getProperty("client_id"));
        formParam.put("client_secret",configLoader.prop.getProperty("client_secret"));
        formParam.put("grant_type",configLoader.prop.getProperty("grant_type"));
        formParam.put("refresh_token",configLoader.prop.getProperty("refresh_token"));

        Response response = ReusableApiMethods.postRefresh(formParam);

        if(response.statusCode() != 200){
            throw new RuntimeException("Failed to refresh accessToken");
        }

        return response;
    }
}
