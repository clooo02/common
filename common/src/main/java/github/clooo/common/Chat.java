package github.clooo.common;

import java.time.LocalDateTime;

public class Chat {

    private int id;

    private int typeId;

    private int senderId;
    private int receiverId;

    private int senderAvatar;
    private String message;

    private LocalDateTime sendTime;

    public Chat(int id, int typeId, int senderId, int receiverId, int senderAvatar, String message, LocalDateTime sendTime) {
        this.id = id;
        this.typeId = typeId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.senderAvatar = senderAvatar;
        this.message = message;
        this.sendTime = sendTime;
    }

    public int getId() {
        return id;
    }

    public int getTypeId() {
        return typeId;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public int getSenderAvatar() {
        return senderAvatar;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }
}
