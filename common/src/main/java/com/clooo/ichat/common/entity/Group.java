package com.clooo.ichat.common.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_group")
public class Group {
    private String id;
    private String groupName;
}
