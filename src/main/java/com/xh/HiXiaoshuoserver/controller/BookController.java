package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/")
    public Object home(){
        return "hello";
    }

    @GetMapping("find_by_id")
    public Object findById(String bookID) {

        return JsonData.buildSuccess(bookService.getBook(bookID));
    }

    @GetMapping("find_by_page")
    public Object findByPage(int pageNum, int pageSize) {

        return JsonData.buildSuccess(bookService.findeByPage(pageNum, pageSize));
    }

}
