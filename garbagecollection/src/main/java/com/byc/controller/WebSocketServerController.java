package com.byc.controller;

import com.alibaba.fastjson.JSONObject;
import com.byc.bean.User;
import com.byc.mapper.UserMapper;
import com.byc.utils.ApplicationContextUtil;
import com.byc.vo.MsgVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@ServerEndpoint("/groupChat/{sid}/{userId}")
public class WebSocketServerController {

    /**
     * 房间号 -> 组成员信息
     */
    private static ConcurrentHashMap<String, List<Session>> groupMemberInfoMap = new ConcurrentHashMap<>();
    /**
     * 房间号 -> 在线人数
     */
    private static ConcurrentHashMap<String, Set<String>> onlineUserMap = new ConcurrentHashMap<>();

    /**
     * 收到消息调用的方法，群成员发送消息
     *
     * @param sid:房间号
     * @param userId：用户id
     * @param message：发送消息
     */
    @OnMessage
    public void onMessage(@PathParam("sid") String sid, @PathParam("userId") String userId, String message) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        Set<String> onlineUserList = onlineUserMap.get(sid);
        // 先一个群组内的成员发送消息
        sessionList.forEach(item -> {
            try {
                // json字符串转对象
                MsgVO msg = JSONObject.parseObject(message, MsgVO.class);
                msg.setCount(onlineUserList.size());
                // json对象转字符串
                String text = JSONObject.toJSONString(msg);
                item.getBasicRemote().sendText(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * 建立连接调用的方法，群成员加入
     *
     * @param session
     * @param sid
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid, @PathParam("userId") String userId) {
        List<Session> sessionList = groupMemberInfoMap.computeIfAbsent(sid, k -> new ArrayList<>());
        Set<String> onlineUserList = onlineUserMap.computeIfAbsent(sid, k -> new HashSet<>());
        onlineUserList.add(userId);
        sessionList.add(session);
        // 发送上线通知
        sendInfo(sid, userId, onlineUserList.size(), "上线了~");
    }


    public void sendInfo(String sid, String userId, Integer onlineSum, String info) {
        // 获取该连接用户信息
        User currentUser = ApplicationContextUtil.getApplicationContext().getBean(UserMapper.class).getUserInfoById(userId);
        // 发送通知
        MsgVO msg = new MsgVO();
        msg.setCount(onlineSum);
        msg.setUserId(userId);
        // json对象转字符串
        String text = JSONObject.toJSONString(msg);
        onMessage(sid, userId, text);
    }

    /**
     * 关闭连接调用的方法，群成员退出
     *
     * @param session
     * @param sid
     */
    @OnClose
    public void onClose(Session session, @PathParam("sid") String sid, @PathParam("userId") String userId) {
        List<Session> sessionList = groupMemberInfoMap.get(sid);
        sessionList.remove(session);
        Set<String> onlineUserList = onlineUserMap.get(sid);
        onlineUserList.remove(userId);
        // 发送离线通知
        sendInfo(sid, userId, onlineUserList.size(), "下线了~");
    }

    /**
     * 传输消息错误调用的方法
     *
     * @param error
     */
    @OnError
    public void OnError(Throwable error) {
        log.info("Connection error");
    }
}
