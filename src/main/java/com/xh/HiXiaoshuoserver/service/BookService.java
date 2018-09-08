package com.xh.HiXiaoshuoserver.service;


import com.xh.HiXiaoshuoserver.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookService {


    List<Book> newBaiYuer();


    /**
     *
     * 组装 经典小说获取8条，男生最爱获取8条，女生最爱获取8条
     * */
    List<Map> getHome(int homeType);


    List<Book> findBookRandom(int number, String classifyType, String recommendType);


    List<Book> findBookByPage(int pageNum,
                           int pageSize,
                           String book_classify,
                              String book_status,
                           String click_total,
                           String collect_total,
                           String time_condition);


    List<Book> getHotSearch();

    List<Book> searchBook(String bookName);

}
