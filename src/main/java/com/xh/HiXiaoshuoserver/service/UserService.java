package com.xh.HiXiaoshuoserver.service;

import com.xh.HiXiaoshuoserver.domain.User;

/**
 * @program: HiXiaoshuo-server
 * @description: 用户接口类
 * @author: XuHao
 * @create: 2018-07-20 09:58
 **/
public interface UserService {


    public User findeUserByName(String uname);

}
