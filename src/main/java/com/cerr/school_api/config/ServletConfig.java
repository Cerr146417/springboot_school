package com.cerr.school_api.config;

import com.cerr.school_api.listener.SessionListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    /**
     * 注册SessionListener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean sessionListener(){
        ServletListenerRegistrationBean listenerRegistrationBean = new ServletListenerRegistrationBean<SessionListener>(new SessionListener());
        return listenerRegistrationBean;
    }
}
