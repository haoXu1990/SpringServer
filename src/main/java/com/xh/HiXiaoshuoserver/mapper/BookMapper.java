package com.xh.HiXiaoshuoserver.mapper;


import com.xh.HiXiaoshuoserver.domain.Book;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;


public interface BookMapper {

    /**
     *  按照BOOKID 查询book
     */
    @Select("SELECT * FROM books WHERE book_id = #{bookID}")
    @Results({
            @Result(column = "book_name", property = "bookName"),
            @Result(column = "book_author", property = "bookAuthor"),
            @Result(column = "book_status", property = "bookStatus"),
            @Result(column = "book_classify", property = "bookClassify"),
            @Result(column = "book_id", property = "bookID"),
            @Result(column = "book_catetime", property = "bookCreatTime"),
            @Result(column = "book_abstract", property = "bookAbstract"),
            @Result(column = "book_imageurl", property = "bookImageUrl")
    })
    Book getBook(String bookID);


    /**
     * 分页查询数据
     * @param classify  小说分类,null查询全部分类
     * @return 查询结果
     */
    List<Book> findByPage(String classify);

    /**
     * 按照BookID查询URL
     * @return url数组
     */
    @Select("SELECT book_url FROM book_source WHERE book_id = #{bookID}")
    String[] getBookUrls(String bookID);

}
