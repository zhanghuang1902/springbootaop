package com.xz.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.awt.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Package: com.xz.client
 * @ClassName: ChatClient
 * @Author: xz
 * @Date: 2020/7/2 13:57
 * @Version: 1.0
 */
public class ChatClient {

    private ChannelFuture channelFuture;

    public void connect(){
        EventLoopGroup worker = null;
        Bootstrap bootstrap;
        try {
            worker = new NioEventLoopGroup();
            bootstrap = new Bootstrap();
            bootstrap.group(worker);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<NioSocketChannel>(){
                @Override
                protected void initChannel(NioSocketChannel ch) {
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            ByteBuf byteBuf = null;
                            try {
                                byteBuf = (ByteBuf) msg;
                                TextArea textArea = ClientFrame.INSTANCE.getTextArea();
                                textArea.setText(textArea.getText()+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) +" "+ byteBuf.toString(CharsetUtil.UTF_8)+"\r\n");
                            }finally {
                                if(byteBuf != null){
                                    if(byteBuf.refCnt() != 0){
                                        ReferenceCountUtil.release(byteBuf);
                                    }
                                }
                            }
                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
                            cause.printStackTrace();
                            ctx.close();
                        }
                    });
                }
            });
            channelFuture = bootstrap.connect("192.168.0.155", 8888).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(worker!=null){
                worker.shutdownGracefully();
            }
        }
    }

    public void send(String text) {
        ByteBuf byteBuf = Unpooled.copiedBuffer(text.getBytes());
        channelFuture.channel().writeAndFlush(byteBuf);
    }
}
