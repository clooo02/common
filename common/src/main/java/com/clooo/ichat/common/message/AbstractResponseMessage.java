package com.clooo.ichat.common.message;

public abstract class AbstractResponseMessage extends Message {
    private boolean success;

    private String body;
    private String reason;

    public AbstractResponseMessage() {
    }

    public AbstractResponseMessage(boolean success, String body, String reason) {
        this.success = success;
        this.body = body;
        this.reason = reason;

    }


    public boolean isSuccess() {
        return success;
    }

    public String getBody() {
        return body;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "AbstractResponseMessage{" +
                "success=" + success +
                ", body=" + body +
                ", reason='" + reason + '\'' +
                '}';
    }
}
