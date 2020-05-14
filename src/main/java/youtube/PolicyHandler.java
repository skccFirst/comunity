package youtube;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import youtube.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
    CommunitySystem communitySystem= new CommunitySystem();

    @StreamListener(KafkaProcessor.INPUT)
    public void created_channel(@Payload CreatedChannel createdChannel){
        if(createdChannel.isMe()){
            communitySystem.setId(createdChannel.getChannelId());
                System.out.println("#####[NEW] community 채널 생성 : " + communitySystem.getId());
            }

        }

    @StreamListener(KafkaProcessor.INPUT)
    public void deleted_channel(@Payload DeletedChannel deletedChannel){
        if(deletedChannel.isMe()){
                System.out.println("#####[NEW] community 채널 삭제 ");
        }
    }
}
