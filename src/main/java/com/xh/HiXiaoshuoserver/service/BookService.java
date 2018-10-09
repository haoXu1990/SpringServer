package com.xh.HiXiaoshuoserver.service;


import com.xh.HiXiaoshuoserver.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookService {



    /**
     * 分类查找书籍
     * @param subclassify 子分类
     * @param sortType 排序类型 0 = 点击排行 ， 1 = 收藏排行
     * @param minNumber 字数最小值
     * @param maxNumber 字数最大值
     * @param pageNum   页码
     * @param pageSize  每页数据条数
     *
     * */
    List<Book> findBookbySubclassfy(String subclassify,
                                       String sortType,
                                       int minNumber,
                                       int maxNumber,
                                       int pageNum,
                                       int pageSize);



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
