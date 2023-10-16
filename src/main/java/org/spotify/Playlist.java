
package org.spotify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Setter @Getter @Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "collaborative",
    "description",
    "external_urls",
    "followers",
    "href",
    "id",
    "images",
    "name",
    "owner",
    "primary_color",
    "public",
    "snapshot_id",
    "tracks",
    "type",
    "uri"
})
public class Playlist {

    @JsonProperty("collaborative")
    private Boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;
    @JsonProperty("followers")
    private Followers followers;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Object> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("primary_color")
    private Object primaryColor;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("snapshot_id")
    private String snapshotId;
    @JsonProperty("tracks")
    private Tracks tracks;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;

    Playlist(Boolean collaborative, String description, ExternalUrls externalUrls, Followers followers, String href, String id, List<Object> images, String name, Owner owner, Object primaryColor, Boolean _public, String snapshotId, Tracks tracks, String type, String uri) {
        this.collaborative = collaborative;
        this.description = description;
        this.externalUrls = externalUrls;
        this.followers = followers;
        this.href = href;
        this.id = id;
        this.images = images;
        this.name = name;
        this.owner = owner;
        this.primaryColor = primaryColor;
        this._public = _public;
        this.snapshotId = snapshotId;
        this.tracks = tracks;
        this.type = type;
        this.uri = uri;
    }

    public static PlaylistBuilder builder() {
        return new PlaylistBuilder();
    }

    public static class PlaylistBuilder {
        private Boolean collaborative;
        private String description;
        private ExternalUrls externalUrls;
        private Followers followers;
        private String href;
        private String id;
        private List<Object> images;
        private String name;
        private Owner owner;
        private Object primaryColor;
        private Boolean _public;
        private String snapshotId;
        private Tracks tracks;
        private String type;
        private String uri;

        PlaylistBuilder() {
        }

        public PlaylistBuilder collaborative(Boolean collaborative) {
            this.collaborative = collaborative;
            return this;
        }

        public PlaylistBuilder description(String description) {
            this.description = description;
            return this;
        }

        public PlaylistBuilder externalUrls(ExternalUrls externalUrls) {
            this.externalUrls = externalUrls;
            return this;
        }

        public PlaylistBuilder followers(Followers followers) {
            this.followers = followers;
            return this;
        }

        public PlaylistBuilder href(String href) {
            this.href = href;
            return this;
        }

        public PlaylistBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PlaylistBuilder images(List<Object> images) {
            this.images = images;
            return this;
        }

        public PlaylistBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlaylistBuilder owner(Owner owner) {
            this.owner = owner;
            return this;
        }

        public PlaylistBuilder primaryColor(Object primaryColor) {
            this.primaryColor = primaryColor;
            return this;
        }

        public PlaylistBuilder _public(Boolean _public) {
            this._public = _public;
            return this;
        }

        public PlaylistBuilder snapshotId(String snapshotId) {
            this.snapshotId = snapshotId;
            return this;
        }

        public PlaylistBuilder tracks(Tracks tracks) {
            this.tracks = tracks;
            return this;
        }

        public PlaylistBuilder type(String type) {
            this.type = type;
            return this;
        }

        public PlaylistBuilder uri(String uri) {
            this.uri = uri;
            return this;
        }

        public Playlist build() {
            return new Playlist(collaborative, description, externalUrls, followers, href, id, images, name, owner, primaryColor, _public, snapshotId, tracks, type, uri);
        }

        public String toString() {
            return "Playlist.PlaylistBuilder(collaborative=" + this.collaborative + ", description=" + this.description + ", externalUrls=" + this.externalUrls + ", followers=" + this.followers + ", href=" + this.href + ", id=" + this.id + ", images=" + this.images + ", name=" + this.name + ", owner=" + this.owner + ", primaryColor=" + this.primaryColor + ", _public=" + this._public + ", snapshotId=" + this.snapshotId + ", tracks=" + this.tracks + ", type=" + this.type + ", uri=" + this.uri + ")";
        }
    }
}
