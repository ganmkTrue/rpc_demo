package com.xiyuan.server.service;

import com.xiyuan.common.model.CommandPOJO;
import com.xiyuan.common.model.ResponseResult;

public interface IInvokeService {

    /**
     * 调用方法(带参数)
     * @param commandPOJO
     * @return
     */
    ResponseResult invokeMethod(CommandPOJO commandPOJO);
}
