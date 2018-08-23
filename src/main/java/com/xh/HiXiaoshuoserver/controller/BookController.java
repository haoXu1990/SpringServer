package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;





    /**
     * 主页接口
     *
     * @param homeType  请求类型: 1=书城精选，2=书城女生，3=书城男生
     * */
    @GetMapping("home")
    public Object home(int homeType){

        /***
         *  主页接口部分包括
         *  精选页面
         *      精品汇聚：   从经典小说里面随机获取8条 随机
         *      精品专场：   从封面推荐里面随机获取8条
         *      大家都在看：  从点击排行降序获取5条
         *  女生页面
         *      女生精品： 从经典小说里面随机获取女生分类8条小说
         *      人气最热： 从收藏排行里面获取8条 女生分类小说
         *      热门分类:  女生小说主类下面的 所有子类
         *      完结热推:  从完结小说中获取8条 女生分类小说
         *
         *  男生页面
         *      男生精品： 从经典小说里面随机获取男生分类8条小说
         *      人气最热： 从收藏排行里面获取8条 男生分类小说
         *      热门分类:  男生小说主类下面的 所有子类
         *      完结热推:  从完结小说中获取8条 男生分类小说
         *
         *
         *
         * */



        return JsonData.buildSuccess(bookService.getHome(homeType));
    }








}
