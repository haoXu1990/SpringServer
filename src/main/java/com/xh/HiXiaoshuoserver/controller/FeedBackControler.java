package com.xh.HiXiaoshuoserver.controller;


import com.xh.HiXiaoshuoserver.domain.JsonData;

import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-09-07 14:24
 **/

@RestController
@RequestMapping("/api/feedback")
public class FeedBackControler {

    // Dao 层 也就是数据库访问
    @Autowired
    private BookMapper mBookMapper;


    /**
     * 获取热门收索
     * */
    @PostMapping("/add")
    public Object searchBook(String content, String qq,String timer){

        mBookMapper.addFeedBack(content, qq, timer);

       return JsonData.buildSuccess("添加成功");
    }


}