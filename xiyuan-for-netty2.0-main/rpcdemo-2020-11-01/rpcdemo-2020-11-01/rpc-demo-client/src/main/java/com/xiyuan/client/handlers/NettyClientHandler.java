package com.xiyuan.client.handlers;

import com.xiyuan.common.model.ResponseResult;
import com.xiyuan.common.utils.FastJsonUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


/**
 * 客户端处理器
 **/
@Slf4j
@Setter
@Getter
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private ResponseResult responseResult;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端Active .....");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("客户端收到消息: {}", msg.toString());
        this.responseResult = (ResponseResult) FastJsonUtils.convertJsonToObject(msg.toString(),ResponseResult.class);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
