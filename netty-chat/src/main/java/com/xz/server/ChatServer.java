package com.xz.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
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
                            list.add(ctx.channel());
                        }

                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            ByteBuf byteBuf = (ByteBuf) msg;
                            System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
                            list.forEach(item->{
                                if(!item.equals(ctx.channel())){
                                    item.writeAndFlush(byteBuf);
                                }
                            });
                            byteBuf.release();
                        }

                        @Override
                        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                            list.remove(ctx.channel());
                        }

                        @Override
                        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
                            list.remove(ctx.channel());
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
