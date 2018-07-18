package com.xh.HiXiaoshuoserver.service;


import com.xh.HiXiaoshuoserver.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    /**
     *
     * 组装 火热推荐(重男生最爱里面随机获取8本), 连载推荐(随机推荐8本男生书籍)
     * */
    List<Map> findByFemale();

    /**
     *
     * 组装 火热推荐(重男生最爱里面随机获取8本), 连载推荐(随机推荐8本男生书籍)
     * */
    List<Map> findByMale();


    /**
     *
     * 组装 经典小说获取8条，男生最爱获取8条，女生最爱获取8条
     * */
    List<Map> getHome();

    Book getBook(String bookID);


    List<Book> findeByPage(int pageNum, int pageSize);

    /**
     * 获取经典小说 随机获取
     * @return 查询结果
     */
    List<Book> findByJinDian();

    /**
     * 获取经典小说 分页获取
     * @return 查询结果
     */
    List<Book> findByJinDianPage(int pageNum, int pageSize);


    /**
     * 获取男生小说 随机获取
     * @return 查询结果
     */
    List<Book> findByNanShen();

    /**
     * 获取男生小说 分页获取
     * @return 查询结果
     */
    List<Book> findByNanShenPage(int pageNum, int pageSize);


    /**
     * 获取女生小说 随机获取
     * @return 查询结果
     */
    List<Book> findByNvShen();

    /**
     * 获取女生小说 分页获取
     * @return 查询结果
     */
    List<Book> findByNvShenPage(int pageNum, int pageSize);

}
