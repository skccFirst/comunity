package youtube;


import org.springframework.beans.factory.annotation.Autowired;

public class DeletedChannel extends AbstractEvent {

    private String channelName;
    private Long channelId;
    private String clientId;
    private String videoId;

    public DeletedChannel(){
        super();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }
}
