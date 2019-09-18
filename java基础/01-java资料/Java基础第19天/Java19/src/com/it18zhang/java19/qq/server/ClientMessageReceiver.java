package com.it18zhang.java19.qq.server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.it18zhang.java19.qq.common.ClientRequestFreshFriendsMessage;
import com.it18zhang.java19.qq.common.ClientSendChatMessage;
import com.it18zhang.java19.qq.common.Message;
import com.it18zhang.java19.qq.common.MessageFactory;
import com.it18zhang.java19.qq.util.Util;

/**
 * Server端:  客户端消息的接受者
 */
public class ClientMessageReceiver extends Thread {
	private Socket sock ;
	private InputStream in ;
	private OutputStream out ;
	private QQServer server ;
	private String userInfo ;
	public ClientMessageReceiver(Socket s,QQServer server){
		try {
			this.server = server ;
			this.sock = s ;
			this.in= sock.getInputStream() ;
			this.out= sock.getOutputStream() ;
			this.userInfo = Util.getUserInfo(sock);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run() {
		try {
			//读取客户端消息
			while(true){
				Message msg = MessageFactory.parseMessageFromInputStream(in);
				//客户端请求刷新好友列表
				if(msg.getClass() == ClientRequestFreshFriendsMessage.class){
					//发送好友列表
					out.write(MessageFactory.popServerFriends(server.getFriendList()));
					out.flush();
				}
				//客户端的聊天信息
				else if(msg.getClass() == ClientSendChatMessage.class){
					//客户聊天信息
					byte[] chat = ((ClientSendChatMessage)msg).getMessageContent();
					//生成服务器端转发的聊天消息
					byte[] serverChat = MessageFactory.popServerChatMessage(userInfo, chat);
					//群发聊天记录
					server.broadcastMessage(serverChat);
				}
			}
		} catch (Exception e) {
			server.removeFriend(userInfo);
			server.broadcastFriendList();
		}
	}
}
