package com.xiyuan.common.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@ToString
public class SysHelloReq implements Serializable {
    private static final long serialVersionUID = 1964545025266481064L;

    //消息
    private String msg;


}
