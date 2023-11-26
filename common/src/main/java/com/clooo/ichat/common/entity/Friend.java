package com.clooo.ichat.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_friend")
public class Friend implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String userId;
    private String friendId;
    private String friendName;

}
