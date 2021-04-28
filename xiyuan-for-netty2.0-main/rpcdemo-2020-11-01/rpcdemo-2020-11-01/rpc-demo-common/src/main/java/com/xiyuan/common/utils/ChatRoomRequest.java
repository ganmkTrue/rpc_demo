package com.xiyuan.common.utils;

import lombok.Data;

/**
 * @ClassName : ChatRoomRequest  //类名
 * @Description : 聊天交互对象  //描述
 * @Author : JavaAlliance  //作者
 * @Date: 2020-05-23 17:43  //时间
 */

@Data
public class ChatRoomRequest {
    private String to;
    private String from;
    private String content ;
}
