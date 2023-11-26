package com.clooo.ichat.common.message;

import com.clooo.ichat.common.utils.SequenceIdGenerator;


public class GetFriendsResponseMessage extends AbstractResponseMessage {

    public GetFriendsResponseMessage(boolean success, String body, String reason) {
        super(success, body, reason);
        this.setSequenceId(SequenceIdGenerator.nextId());
    }
    @Override
    public int getMessageType() {
        return GetFriendsResponseMessage;
    }
}
