package com.crep.mapper;

import com.crep.entity.Message;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM message WHERE message_id = #{messageId}")
    Message selectByPrimaryKey(@Param("messageId") Integer messageId);

    @Insert("INSERT INTO message (sender_id, receiver_id, content, timestamp) " +
            "VALUES (#{senderId}, #{receiverId}, #{content}, #{timestamp})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insert(Message message);

    @Update("UPDATE message SET sender_id = #{senderId}, receiver_id = #{receiverId}, " +
            "content = #{content}, timestamp = #{timestamp} " +
            "WHERE message_id = #{messageId}")
    int updateByPrimaryKey(Message message);

    @Delete("DELETE FROM message WHERE message_id = #{messageId}")
    int deleteByPrimaryKey(@Param("messageId") Integer messageId);

    @Select("SELECT * FROM message")
    List<Message> selectAllMessages();

    @Update({
            "UPDATE message",
            "SET sender_id = #{senderId,jdbcType=INTEGER},",
            "receiver_id = #{receiverId,jdbcType=INTEGER},",
            "content = #{content,jdbcType=VARCHAR},",
            "timestamp = #{timestamp,jdbcType=TIMESTAMP}",
            "WHERE message_id = #{messageId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeySelective(Message message);


    // 其他可能的方法...
}