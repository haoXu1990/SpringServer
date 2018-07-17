package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/")
    public Object home(){
        return "hello";
    }


    /**
     * @Description:  根据小说ID获取小说信息
     * @Param:  bookID
     * @return: 小说详情
     * @Author: Xuhao
     * @Date: 2018/7/16
     */
    @GetMapping("find_by_id")
    public Object findById(String bookID) {

        return JsonData.buildSuccess(bookService.getBook(bookID));
    }

    /**
    * @Description:  获取小说列表，分页显示
    * @Param:  pageNum, pageSize
    * @return: 小说集合
    * @Author: Xuhao
    * @Date: 2018/7/16
    */
    @GetMapping("find_by_page")
    public Object findByPage(int pageNum, int pageSize) {

        return JsonData.buildSuccess(bookService.findeByPage(pageNum, pageSize));
    }

}
