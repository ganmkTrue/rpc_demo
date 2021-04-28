package com.xiyuan.server.service.rpcimpl;

import com.xiyuan.common.api.IRpcInvokeService;
import com.xiyuan.common.model.request.SysHelloReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RpcInvokeServiceImpl implements IRpcInvokeService {

    /**
     * 用于测试远程调用
     * @param helloReq
     * @return
     */
    @Override
    public String sysHello(SysHelloReq helloReq) {
        return helloReq.getMsg()+",你也好哇";
    }
}
