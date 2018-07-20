package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.domain.User;
import com.xh.HiXiaoshuoserver.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-07-20 10:58
 **/
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Object login(String uname, String pwd){

        if (StringUtils.isEmpty(uname)){
            return JsonData.buildError("用户名不能为空");
        }
        if (StringUtils.isEmpty(pwd)){
            return JsonData.buildError("密码不能为空");
        }


        Subject currentUser = SecurityUtils.getSubject();

        try {

            // 登录
            currentUser.login(new UsernamePasswordToken(uname, pwd));

            // 从session取出用户信息
            User user = (User) currentUser.getPrincipal();
            if (user == null) throw new AuthenticationException();

            // 返回登录信息
            return JsonData.buildSuccess(userService.findeUserByName(uname));

        }catch ( UnknownAccountException uae ) {
            return JsonData.buildError("用户帐号或密码不正确");


        } catch (IncorrectCredentialsException ice ) {

            return JsonData.buildError("用户帐号或密码不正确");

        } catch ( LockedAccountException lae ) {
            return JsonData.buildError("用户帐号被锁定不可用");

        } catch ( AuthenticationException ae ) {

            return JsonData.buildError("登录失败：" + ae.getMessage());

        }

    }

}
