package com.clooo.ichat.common.message;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Message implements Serializable {
    public static Class<? extends Message> getMessageClass(int messageType) {
        return messageClasses.get(messageType);
    }

    private int sequenceId;

    private int messageType;

    public abstract int getMessageType();

    private static final Map<Integer, Class<? extends Message>> messageClasses = new HashMap<>();

    public static final int LoginRequestMessage = 10;
    public static final int LoginResponseMessage = 11;
    public static final int GetFriendsRequestMessage = 31;
    public static final int GetFriendsResponseMessage = 32;

    static {
        messageClasses.put(LoginRequestMessage, LoginRequestMessage.class);
        messageClasses.put(LoginResponseMessage, LoginResponseMessage.class);
        messageClasses.put(GetFriendsRequestMessage, GetFriendsRequestMessage.class);
        messageClasses.put(GetFriendsResponseMessage, GetFriendsResponseMessage.class);
    }

    public int getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(int sequenceId) {
        this.sequenceId = sequenceId;
    }
}