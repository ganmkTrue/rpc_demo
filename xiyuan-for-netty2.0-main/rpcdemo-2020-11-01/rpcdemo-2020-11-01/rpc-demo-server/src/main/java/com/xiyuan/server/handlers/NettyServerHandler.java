package com.xiyuan.server.handlers;

import com.xiyuan.common.model.CommandPOJO;
import com.xiyuan.common.model.ResponseResult;
import com.xiyuan.common.utils.FastJsonUtils;
import com.xiyuan.common.utils.SpringUtil;
import com.xiyuan.server.service.IInvokeService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * netty服务端处理器
 **/
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 用于获取SpringBean
     */
    private static ApplicationContext context  = SpringUtil.getApplicationContext();

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("Channel active......");
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("服务器收到消息: {}", msg.toString());
        CommandPOJO commandPOJO = (CommandPOJO) FastJsonUtils.convertJsonToObject(msg.toString(),CommandPOJO.class);
        IInvokeService invokeService =context.getBean(IInvokeService.class);
        ResponseResult responseResult =invokeService.invokeMethod(commandPOJO);
        ctx.write(FastJsonUtils.convertObjectToJSON(responseResult));
        ctx.flush();
    }

    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}