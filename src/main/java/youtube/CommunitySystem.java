package youtube;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="CommunitySystem_table")
public class CommunitySystem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long commentId;
    private String comment;
    private String comunityId;


    public String getComunityId() {
        return comunityId;
    }

    public void setComunityId(String comunityId) {
        this.comunityId = comunityId;
    }


    @PrePersist
    public void onPrePersist(){
        CreatedComment createdComment = new CreatedComment();
        BeanUtils.copyProperties(this, createdComment);
        createdComment.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove(){
        DeletedCommunity deletedCommunity = new DeletedCommunity();
        BeanUtils.copyProperties(this, deletedCommunity);
        deletedCommunity.publishAfterCommit();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }




}
