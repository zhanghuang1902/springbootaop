package com.xz.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Package: com.xz.server
 * @ClassName: ChatServer
 * @Author: xz
 * @Date: 2020/7/2 14:06
 * @Version: 1.0
 */
public class ChatServer {

    public static void main(String[] args) {
        EventLoopGroup boss = null;
        EventLoopGroup worker = null;
        ServerBootstrap serverBootstrap;
        List<Channel> list;
        ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
        try {
            list = new CopyOnWriteArrayList<>();
            boss = new NioEventLoopGroup(2);
            worker = new NioEventLoopGroup(4);
            serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boss, worker);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) {
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){

                        @Override
                        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
                            channels.add(ctx.channel());
                        }

                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            ByteBuf byteBuf = null;
                            try {
                                byteBuf = (ByteBuf) msg;
                                System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
                                for(Channel item : channels){
                                    if(!item.equals(ctx.channel())){
                                        item.writeAndFlush(byteBuf);
                                    }
                                }
                            }finally {
                                if(byteBuf != null){
                                    ReferenceCountUtil.release(byteBuf);
                                }
                            }
                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                            channels.remove(ctx.channel());
                        }

                        @Override
                        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
                            channels.remove(ctx.channel());
                        }
                    });
                }
            });
            ChannelFuture sync = serverBootstrap.bind("192.168.0.155", 8888).sync();
            sync.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(boss!=null){
                boss.shutdownGracefully();
            }
            if(worker != null){
                worker.shutdownGracefully();
            }
        }

    }
}
