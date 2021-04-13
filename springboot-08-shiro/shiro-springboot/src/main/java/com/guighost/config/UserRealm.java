package com.guighost.config;

import com.guighost.entity.User;
import com.guighost.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author GuiGhost
 * @date 2021/03/28
 * @className UserRealm()
 * 描述：自定义的Realm  extends AuthorizingRealm(继承该类即可)
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权：doGetAuthorizationInfo");
        //给用户授予权限——>SimpleAuthorizationInfo
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermission("user:add");//给所有请求授予该权限

        //拿到当前登录的这个对象
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();//拿到User对象；通过认证方法的返回值传递
        //设置当前用户的权限
        info.addStringPermission(currentUser.getPerms());
        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了=>认证：doGetAuthenticationInfo");
        //绑定Token
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
//        //记住我
//        userToken.setRememberMe(true);
        //连接真实数据库
        User user = userService.queryUserByName(userToken.getUsername());
        //用户名认证
        if (user == null){
            return null;//抛出一个异常  UnknownAccountException
        }
        //将认证之后的用户存入session
        Subject currentSubject = SecurityUtils.getSubject();
        Session session = currentSubject.getSession();
        session.setAttribute("loginUser",user);
        //可以加密： MD5加密，MD5盐值加密
        //密码认证，shiro来做，不需要我们    密码也加密了
        return new SimpleAuthenticationInfo(user,user.getPwd(),"");
    }
}
