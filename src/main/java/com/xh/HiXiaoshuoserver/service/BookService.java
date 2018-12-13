package com.xh.HiXiaoshuoserver.service;


import com.xh.HiXiaoshuoserver.domain.Book;
import com.xh.HiXiaoshuoserver.page.PageInfo;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface BookService {


    /**
     * put请求
     * 修改小说信息
     * @param bookID 小说ID ，必填
     * @param bookName 小说名称
     * @param bookClassify 小说分类
     * @param bookImageUrl 小说封面图片地址
     * */
    int putBook(String bookID,
                    String bookName,
                    String bookClassify,
                    String bookImageUrl,
                    String bookAuthor,
                    String bookSubject);

    /**
     * get请求
     * 获取小说详情，参数可选
     * @param bookID 小说ID
     * @param bookName 小说名称
     * @param bookAuthor 小说作者
     * @param bookClassify 小说分类
     * @param bookSubject 推荐主题
     * */
    PageInfo getBookList(String bookID,
                         String bookName,
                         String bookAuthor,
                         String bookClassify,
                         String bookSubject,
                         int  pageNum,
                         int  pageSize);


    /**
     * 分类查找书籍
     * @param subclassify 子分类
     * @param classify 主分类
     * @param sortType 排序类型 0 = 点击排行 ， 1 = 收藏排行
     * @param minNumber 字数最小值
     * @param maxNumber 字数最大值
     * @param pageNum   页码
     * @param pageSize  每页数据条数
     *
     * */
    List<Book> findBookbySubclassfy(String classify,
                                    String subclassify,
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
