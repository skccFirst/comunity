package youtube;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import youtube.config.kafka.KafkaProcessor;

@Service
public class PolicyHandler{
    @Autowired
    CommunitySystemRepository avertisingSystemRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void created_channel(@Payload CreatedChannel createdChannel){
        if(createdChannel.isMe()){
            CommunitySystem communitySystem = new CommunitySystem();
            communitySystem.setId(createdChannel.getChannelId());
            communitySystem.setComunityId(createdChannel.getChannelName());
            avertisingSystemRepository.save(communitySystem);
            System.out.println("#####[NEW] created communitySystem : " + communitySystem.toString());
            }
        }

    @StreamListener(KafkaProcessor.INPUT)
    public void deleted_channel(@Payload DeletedChannel deletedChannel){
        if(deletedChannel.isMe()){
            avertisingSystemRepository.deleteAll();
                System.out.println("#####[NEW] community 채널 삭제 ");
        }
    }
}
