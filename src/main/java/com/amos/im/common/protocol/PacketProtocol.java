package com.amos.im.common.protocol;

import com.amos.im.common.BasePacket;
import com.amos.im.core.command.CommandFactory;
import com.amos.im.common.serializer.Serializer;
import com.amos.im.common.serializer.SerializerAlgorithm;
import io.netty.buffer.ByteBuf;

/**
 * PROJECT: im
 * DESCRIPTION: 通讯协议算法
 *
 * @author Daoyuan
 * @date 2019/3/19
 */
public class PacketProtocol {

    /**
     * 魔数
     */
    static final int MAGIC_NUMBER = 0x12345678;

    private static volatile PacketProtocol instance;

    public static PacketProtocol getInstance() {
        if (instance == null) {
            instance = new PacketProtocol();
        }
        return instance;
    }

    /**
     * 序列化BasePacket并根据协议编码
     *
     * @param basePacket BasePacket
     * @return ByteBuf
     */
    public ByteBuf encode(ByteBuf byteBuf, BasePacket basePacket) {
        // 序列化 Java 对象
        Serializer serializer = SerializerAlgorithm.DEFAULT;
        byte[] bytes = serializer.serialize(basePacket);

        // 实际编码过程
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(basePacket.getVersion());
        byteBuf.writeByte(serializer.getSerializerAlgorithm());
        byteBuf.writeByte(basePacket.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }

    /**
     * 根据协议解码并反序列化为BasePacket
     *
     * @param byteBuf ByteBuf
     * @return BasePacket
     */
    public BasePacket decode(ByteBuf byteBuf) {
        // 跳过 魔数
        byteBuf.skipBytes(4);
        // 跳过版本号
        byteBuf.skipBytes(1);

        // 序列化算法标识
        byte serializeAlgorithm = byteBuf.readByte();
        // 指令
        byte command = byteBuf.readByte();
        // 数据包长度
        int length = byteBuf.readInt();

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends BasePacket> requestType = CommandFactory.getRequestType(command);
        Serializer serializer = SerializerAlgorithm.getSerializer(serializeAlgorithm);

        if (requestType != null) {
            return serializer.deserialize(requestType, bytes);
        }

        return null;
    }

}
