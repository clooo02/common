package com.clooo.ichat.common.message;

import com.clooo.ichat.common.utils.SequenceIdGenerator;

public class LoginResponseMessage extends AbstractResponseMessage {

    @Override
    public int getMessageType() {
        return LoginResponseMessage;
    }

    public LoginResponseMessage(boolean success, String body, String reason) {
        super(success, body, reason);
        this.setSequenceId(SequenceIdGenerator.nextId());
    }
}
