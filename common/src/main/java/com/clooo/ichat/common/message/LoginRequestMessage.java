package com.clooo.ichat.common.message;

import com.clooo.ichat.common.entity.User;
import com.clooo.ichat.common.utils.SequenceIdGenerator;


public class LoginRequestMessage extends Message {

    private User user;

    public LoginRequestMessage(User user) {
        this.user = user;
        this.setSequenceId(SequenceIdGenerator.nextId());
    }

    public User getUser() {
        return user;
    }

    @Override
    public int getMessageType() {
        return LoginRequestMessage;
    }
}
