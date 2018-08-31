package com.xh.HiXiaoshuoserver.mapper;


import com.xh.HiXiaoshuoserver.domain.Book;

import com.xh.HiXiaoshuoserver.domain.BookSource;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;


public interface BookMapper {


    /**
     * 分页查询数据
     * @param book_classify  小说分类 男生， 女生， 或则单个分类
     * @param book_recommend_tag 推荐频道 经典小说,封面推荐
     * @param click_total 点击排行
     * @param collect_total 收藏排行
     * @param time_condition 查询排行时间条件
     * @return 查询结果
     */
    List<Book> findBooks(@Param("book_classify") String book_classify,
                         @Param("book_recommend_tag") String book_recommend_tag,
                         @Param("random_number") int random_number,
                         @Param("book_status") String book_status,
                         @Param("click_total") String click_total,
                         @Param("collect_total") String collect_total,
                         @Param("time_condition") String time_condition);





    /**
     * 按照BookID查询URL
     * @return url数组
     */
    @Select("SELECT book_id,book_url, book_domain,book_enable  FROM book_source WHERE book_id = #{bookID}")
    @Results({
            @Result(column = "book_id", property = "bookID"),
            @Result(column = "book_url", property = "bookUrl"),
            @Result(column = "book_domain", property = "bookDomain"),
            @Result(column = "book_enable", property = "bookEnable")
    })
    List<BookSource> getBookUrls(String bookID);



    /**
     * 获取热门搜索小说
     * @return url数组
     */
    List<Book> getHotSearch();

    /**
     * 搜小说
     * @return url数组
     */
    List<Book> searching(@Param("bookName") String bookName);


}
