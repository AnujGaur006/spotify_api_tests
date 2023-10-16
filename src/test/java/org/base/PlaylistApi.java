package org.base;

import io.restassured.response.Response;
import org.global.ReusableApiMethods;
import org.spotify.Playlist;
import org.utils.ConfigLoader;

import static org.global.Route.PLAYLISTS;
import static org.global.Route.USERS;
import static org.global.TokenManager.getToken;

public class PlaylistApi {
    private static final ConfigLoader configLoader = ConfigLoader.getInstance();

    public static Response post(Playlist requestPayload){
      return ReusableApiMethods.post(USERS + "/" + configLoader.prop.getProperty("testUserID")
                      + PLAYLISTS, getToken(),requestPayload);
    }

    public static Response post(Playlist requestPayload, String token){
        return ReusableApiMethods.post(USERS + "/" + configLoader.prop.getProperty("testUserID")
                        + PLAYLISTS, token,requestPayload);
    }

    public static Response get(String playlistId){
        return ReusableApiMethods.get(PLAYLISTS + "/" + playlistId,getToken());
    }

    public static Response put(String playlistId, Playlist updatePlayListObj){
        return ReusableApiMethods.put(PLAYLISTS + "/" + playlistId,getToken(),updatePlayListObj);
    }
}
