package com.xh.HiXiaoshuoserver.mapper;

import com.xh.HiXiaoshuoserver.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface UserMapper {

    @Insert("INSERT `user` (uid, uname, nick, pwd, salt, created, updated) VALUES (#{uid},#{uname},#{nick},#{pwd},#{salt},#{created},#{updated})")
    void addUser(@Param("uid") Long uid,
                   @Param("uname") String uname,
                   @Param("nick") String nick,
                   @Param("pwd") String pwd,
                   @Param("salt") String salt,
                   @Param("created") Date created,
                   @Param("updated") Date updated);

    @Select("SELECT * FROM user WHERE uname = #{uname}")
    User findeUserByName(String uname);
}
