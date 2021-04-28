package com.xiyuan.common.api;


import com.xiyuan.common.model.request.SysHelloReq;

/**
 * 对外提供的RPC远程调用的服务
 */
public interface IRpcInvokeService {

    /**
     * 用于测试远程调用
     * @param helloReq
     * @return
     */
    String sysHello (SysHelloReq helloReq);
}
