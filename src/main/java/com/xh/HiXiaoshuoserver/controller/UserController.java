package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.domain.User;
import com.xh.HiXiaoshuoserver.service.UserService;
import com.xh.HiXiaoshuoserver.service.MyUIDService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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

    @Autowired
    private MyUIDService MyUIDService;



    @PostMapping("/add")
    public Object add(@RequestBody User user){

        Long uid = Long.valueOf(888888);//MyUIDService.getUidForRegister("common").toString(); //随机生成一个用户ID
        String uname = user.getUname(); //登录用户名
        String nick = user.getNick(); //用户昵称
        String pwd = user.getPwd(); // 加密过后的密码
        String salt = user.getSalt(); // 盐值
        Date created = new Date();
        Date updated = new Date();


        String ret = userService.addUser(uid,uname,nick,pwd,salt,created,updated);


        // 检查是否存在该用户
        User user1 = userService.findeUserByName(uname);
        if (user1!=null){
            return JsonData.buildError("该用户已经存在");
        }


        if (ret != null){
            return JsonData.buildSuccess(null,"注册成功");
        }

        return JsonData.buildError("注册失败");


    }


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


            User user1 = userService.findeUserByName(uname);
            user1.setRoles(user.getRoles());
            user1.setPerms(user.getPerms());

            // 返回登录信息
            return JsonData.buildSuccess(user1);

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
