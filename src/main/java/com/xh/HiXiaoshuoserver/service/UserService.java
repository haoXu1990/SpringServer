package com.xh.HiXiaoshuoserver.service;

import com.xh.HiXiaoshuoserver.domain.User;

import java.util.Date;

/**
 * @program: HiXiaoshuo-server
 * @description: 用户接口类
 * @author: XuHao
 * @create: 2018-07-20 09:58
 **/
public interface UserService {


    String addUser(Long uid,
                        String uname,
                        String nick,
                        String pwd,
                        String salt,
                        Date created,
                        Date pudated);

    User findeUserByName(String uname);

}
