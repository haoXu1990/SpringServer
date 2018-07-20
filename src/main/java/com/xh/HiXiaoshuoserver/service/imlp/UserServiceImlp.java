package com.xh.HiXiaoshuoserver.service.imlp;


import com.xh.HiXiaoshuoserver.domain.User;
import com.xh.HiXiaoshuoserver.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-07-20 09:59
 **/

@Service
public class UserServiceImlp implements UserService {

    @Override
    public User findeUserByName(String uname) {

        User user = new User();
        user.setUname(uname);
        user.setNick(uname+"NICK");
        user.setPwd("J/ms7qTJtqmysekuY8/v1TAS+VKqXdH5sB7ulXZOWho=");//密码明文是123456
        user.setSalt("wxKYXuTPST5SG0jMQzVPsg==");//加密密码的盐值
        user.setUid(new Random().nextLong());//随机分配一个id
        user.setCreated(new Date());
        return user;
    }


}