package youtube;

public class DeletedCommunity extends AbstractEvent {

    private Long id;
    private Long commentId;
    private Long chnnelId;

    public Long getId() {
        return id;
    }

    public Long getChnnelId() {
        return chnnelId;
    }

    public void setChnnelId(Long chnnelId) {
        this.chnnelId = chnnelId;
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
}
