package com.xiyuan.client.controller;

import com.xiyuan.client.config.NettyClientUtil;
import com.xiyuan.common.annotation.InvokeParameterCheck;
import com.xiyuan.common.annotation.MethodLogPrint;
import com.xiyuan.common.model.CommandPOJO;
import com.xiyuan.common.model.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@Api(value = "远程调用模块")
@RequestMapping("/xiyuanrpc")
public class RPCController {

    @PostMapping("/rpcNettybyInvoke")
    @ApiOperation(value = "rpc远程调用")
    @InvokeParameterCheck
    @MethodLogPrint
    public ResponseResult rpcNettybyInvoke(@Valid @RequestBody CommandPOJO pojo) {
        return NettyClientUtil.rpcNetty(pojo);
    }

}
