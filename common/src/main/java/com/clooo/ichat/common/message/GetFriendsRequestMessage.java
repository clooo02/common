package com.clooo.ichat.common.message;

import com.clooo.ichat.common.utils.SequenceIdGenerator;


public class GetFriendsRequestMessage extends Message {
    private String username;

    public GetFriendsRequestMessage(String username) {
        this.username = username;
        this.setSequenceId(SequenceIdGenerator.nextId());
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int getMessageType() {
        return GetFriendsRequestMessage;
    }
}
