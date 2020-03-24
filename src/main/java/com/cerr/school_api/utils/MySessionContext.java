package com.cerr.school_api.utils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class MySessionContext {
    public static Map<String,Object> map = new HashMap<>();

    /**
     * 根据sessionId获取Session对象
     * @param sessionId
     * @return  session对象
     */
    public static synchronized HttpSession getSessionById(String sessionId){
        HttpSession session = null;
        if (sessionId != null){
            session = (HttpSession) map.get(sessionId);
        }
        return session;
    }

    /**
     * 添加session
     * @param session
     */
    public static synchronized void addSession(HttpSession session){
        if (session != null){
            map.put(session.getId(),session);
        }
    }

    /**
     * 删除session
     * @param session
     */
    public static synchronized void deleteSession(HttpSession session){
        if (session != null){
            map.remove(session.getId());
        }
    }
}
