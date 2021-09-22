package com.hawk.company_staff_manage.config.shiro;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author hawk
 * @date 2021/9/19
 */
@Configuration
public class ShiroConfig {
    @Bean
    //如果我们在某个注入点需要另一个 bean，我们需要专门指出它。我们可以通过 @Qualifier 注解来做到这一点。
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加过滤器
        Map<String, String> filterMap = new LinkedMap();
        /*
        anon: 无需认证就可以访问
        authc: 必须认证才能访问
        user: 必需拥有记住我功能才能用
        perms: 拥有对某个资源的权限才能访问
        role: 拥有某个角色权限才能访问
        */

        filterMap.put("/*", "authc");
        bean.setFilterChainDefinitionMap(filterMap);
        //设置登录请求
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl("/nonAuth");
        return bean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("staffRealm") StaffRealm staffRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm对象
        securityManager.setRealm(staffRealm);
        return securityManager;
    }

    /**
     * 注入realm对象
     * @return @link{StaffRealm}
     */
    @Bean
    public StaffRealm staffRealm() {
        return new StaffRealm();
    }
}
