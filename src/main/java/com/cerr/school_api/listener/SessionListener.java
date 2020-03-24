package com.cerr.school_api.listener;

import com.cerr.school_api.utils.MySessionContext;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

    /**
     * 创建session时被调用
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        MySessionContext.addSession(se.getSession());
        System.out.println("获取："+ MySessionContext.getSessionById(se.getSession().getId()));
    }

    /**
     * 销毁session时被销毁
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        MySessionContext.deleteSession(se.getSession());
    }
}
