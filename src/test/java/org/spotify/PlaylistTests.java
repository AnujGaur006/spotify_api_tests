package org.spotify;

import io.restassured.response.Response;
import org.base.PlaylistApi;
import org.testng.annotations.Test;

import static org.global.StatusCodes.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PlaylistTests {

    private Playlist playlistBuilder(String name, String description, Boolean _public){
        return Playlist.builder()
                .name(name)
                .description(description)
                ._public(_public).build();
    }

    @Test
    public void createPlayList(){
        Playlist playlist = playlistBuilder("Test Playlist","My new test playlist",false);

        Response response = PlaylistApi.post(playlist);
        assertThat(response.statusCode(),equalTo(STATUS_CODE_200.code));

        Playlist responsePlaylist = response.as(Playlist.class);
        assertThat(responsePlaylist.getName(),equalTo(playlist.getName()));
    }

    @Test
    public void retrievePlayList(){

        Response response = PlaylistApi.get("0a0Gv3MeFjGAVu6tdvSGf7");
        assertThat(response.statusCode(),equalTo(STATUS_CODE_200.code));

        Playlist responsePlaylist = response.as(Playlist.class);

        assertThat(responsePlaylist.getName(),equalTo("Test Playlist"));
        assertThat(responsePlaylist.getDescription(),equalTo("My new test playlist"));
        assertThat(responsePlaylist.getType(),equalTo("playlist"));
        assertThat(responsePlaylist.get_public(),equalTo(false));
    }

    @Test
    public void updatePlayList(){
        Playlist updatePlayListObj = playlistBuilder("Rock Music","Updated playlist description",
                false);

        Response response = PlaylistApi.put("0a0Gv3MeFjGAVu6tdvSGf7",updatePlayListObj);
        assertThat(response.statusCode(),equalTo(STATUS_CODE_200.code));
    }

    @Test
    public void should_not_be_able_to_create_playlist_with_no_name(){
        Playlist playlist = playlistBuilder("","My new test playlist",false);

        Response response = PlaylistApi.post(playlist);
        assertThat(response.statusCode(),equalTo(STATUS_CODE_400.code));

        ErrorRoot error = response.as(ErrorRoot.class);
        assertThat(error.getError().getStatus(),equalTo(STATUS_CODE_400.code));
        assertThat(error.getError().getMessage(),equalTo(STATUS_CODE_400.message));
    }

    @Test
    public void should_not_be_able_to_create_playlist_with_expired_token(){
        Playlist playlist = playlistBuilder("My Playlist","My new test playlist",true);

        Response response = PlaylistApi.post(playlist,"1232323");
        assertThat(response.statusCode(),equalTo(STATUS_CODE_401.code));

        ErrorRoot error = response.as(ErrorRoot.class);
        assertThat(error.getError().getStatus(),equalTo(STATUS_CODE_401.code));
        assertThat(error.getError().getMessage(),equalTo(STATUS_CODE_401.message));
    }
}
