package cn.hiczy.protobuf.utils;



import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Netty的channel管理类
 */
public class SessionUtils {

    private static final Map<Long, Channel> sessionMap = new ConcurrentHashMap();

    private static final AttributeKey<Long> LOGIN = AttributeKey.valueOf("login");


    public static void bindSession(Long userId, Channel channel) {
        sessionMap.put(userId, channel);
        channel.attr(LOGIN).set(userId);
    }

    public static void removeSession(Channel channel) {
        if(isLogin(channel)){
            sessionMap.remove(getUserId(channel));
            channel.attr(LOGIN).set(null);
        }
    }

    public static boolean isLogin(Channel channel){
        return channel.hasAttr(AttributeKey.valueOf("login"));

    }

    public static Long getUserId(Channel channel) {
        return channel.attr(LOGIN).get();
    }

    public static Channel getChannel(Long userId) {
        return sessionMap.get(userId);
    }

}
