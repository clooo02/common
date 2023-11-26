package com.clooo.ichat.common.protocol;

import com.clooo.ichat.common.message.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * 必须与 LengthFieldBasedFrameDecoder 一起使用，以确保接收的消息是完整的
 */

@ChannelHandler.Sharable
@Slf4j
public class MessageCodecSharable extends MessageToMessageCodec<ByteBuf, Message> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, List<Object> list) throws Exception {
        ByteBuf byteBuf = ctx.alloc().buffer();
        // 1. 4字节的魔数
        byteBuf.writeBytes("CHUN".getBytes());
        // 2. 1字节的版本
        byteBuf.writeByte(0);
        // 3. 1字节的序列化方式 假设jdk为0， json为1
        byteBuf.writeByte(0);
        // 4. 1字节的指令类型(与实际的业务类型相关)
        byteBuf.writeByte(message.getMessageType());
        // 5. 4字节的请求序号
        byteBuf.writeInt(message.getSequenceId());

        // 无意义的1字节，目的是使协议的头部对齐填充
        byteBuf.writeByte(0);

        // 6. 消息正文字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(message);
        byte[] msgBytes = bos.toByteArray();
        // 6. 4字节消息正文的长度
        byteBuf.writeInt(msgBytes.length);
        // 7. 消息正文的内容
        byteBuf.writeBytes(msgBytes);

        list.add(byteBuf);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> list) throws Exception {
        int magicNum = byteBuf.readInt();
        byte version = byteBuf.readByte();
        byte serializerAlgorithm = byteBuf.readByte();
        byte messageType = byteBuf.readByte();
        int sequenceId = byteBuf.readInt();
        byteBuf.readByte();
        int length = byteBuf.readInt();
        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes, 0, length);

        System.out.println("why: " + messageType);
        // 具体的消息类型
        Class<? extends Message> messageClass = Message.getMessageClass(messageType);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Message message = messageClass.cast(ois.readObject());

        list.add(message);
    }
}
