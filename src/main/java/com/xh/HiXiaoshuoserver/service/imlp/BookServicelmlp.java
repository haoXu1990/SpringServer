package com.xh.HiXiaoshuoserver.service.imlp;


import com.github.pagehelper.PageHelper;
import com.xh.HiXiaoshuoserver.domain.Book;
import com.xh.HiXiaoshuoserver.domain.BookSource;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class BookServicelmlp implements BookService {

    // Dao 层 也就是数据库访问
    @Autowired
    private BookMapper mBookMapper;


    @Override
    public List<Book> newBaiYuer() {

        return findBookWithRandom("3",null,"新手推荐");
    }

    @Override
    public List<Book> searchBook(String bookName) {

        return wrapUrlWithBooks(mBookMapper.searching(bookName));
    }

    @Override
    public List<Book> getHotSearch() {

        return wrapUrlWithBooks(mBookMapper.getHotSearch());
    }

    @Override
    public List<Book> findBookRandom(int number, String classifyType, String recommendType) {


        List<Book> booksOne = findBookWithRandom(String.valueOf(number),classifyType,recommendType);

        return booksOne;
    }


    @Override
    public List<Map> getHome(int homeType) {

        if (homeType == 1){

            return bookMallGoods();
        }

        return null;
    }


    public List<Map> bookMallGoods(){
//           精选页面
//           精品汇聚：   从经典小说里面随机获取8条 随机
//           精品专场：   从封面推荐里面随机获取8条
//           大家都在看：  从点击排行降序获取5条
//
        List<Book> booksOne = findBookWithRandom("8",null,"精品小说");

        List<Book> booksTwo = findBookWithRandom("8",null,"封面推荐");

        List<Book> booksTree = findBookByPage(1,
                8,
                null,
                null,
                "1",
                null,
                getTimerStrWithType(0));

        Map<String, Object> bookMap = new HashMap<String, Object>();
        bookMap.put("title", "精品汇聚");
        bookMap.put("data", booksOne);

        Map<String, Object> bookMapOne = new HashMap<String, Object>();
        bookMapOne.put("title", "精品专场");
        bookMapOne.put("data", booksTwo);

        Map<String, Object> bookMapTwo = new HashMap<String, Object>();
        bookMapTwo.put("title", "大家都在看");
        bookMapTwo.put("data", booksTree);


        List<Map> list = new ArrayList<Map>();
        list.add(bookMap);
        list.add(bookMapOne);
        list.add(bookMapTwo);

        return list;
    }



    @Override
    public List<Book> findBookByPage(int pageNum,
                                     int pageSize,
                                     String book_classify,
                                     String book_status,
                                     String click_total,
                                     String collect_total,
                                     String time_condition) {

        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findBooks(book_classify,
                null,
                0,
                book_status,
                click_total,
                collect_total,
                time_condition);

        return wrapUrlWithBooks(books);
    }


    /**
     * 随机获取N条指定的分类、推荐分类下面的小说
     * @param random_number 获取条数
     * @param book_classify 分类  男生，女生， 或则单独分类
     * @param book_recommend 推荐主题 精品， 封面推荐
     * */
    public List<Book> findBookWithRandom(String random_number,String book_classify, String book_recommend){

        // 查询数据库
        List<Book> books =

        mBookMapper.findBooks(book_classify,
                book_recommend,
                Integer.valueOf(random_number),
                null,null,null,null);

        // 包装URL 后返回
        return wrapUrlWithBooks(books);
    }




    /**
     * 获取排行 时间
     * */
    public String getTimerStrWithType(int type) {

        if (type == 0) {
            // 总点击
            return "2018-06-01 00:00:00";
        }
        else if (type == 1){
            // 月点击
            return "2018-08-01 00:00:00";
        }
        else if (type == 2){
            // 周点击
            return "2018-08-19 00:00:00";
        }

        return  "2018-06-01 00:00:00";
    }


    /**
     *
     * 为小说模型包装小说url模型
     * */
    public List<Book> wrapUrlWithBooks(List<Book> books){

        // 第二步，查询出每个book的url列表

        List<Book> tmpBooks = new ArrayList<Book>();

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            List<BookSource> urls = mBookMapper.getBookUrls(book.getBookID());


            // 这里需要判断url是否有效
            if (urls.size() > 0){

                book.setBookUrls(urls);

                // 设置当前生效url
                book.setBookurl(urls.get(0).getBookUrl());

                tmpBooks.add(book);
            }

        }


        return tmpBooks;
    }

//    public List<Book> findBook(String book_classify,
//                               String book_recommend_tag,
//                               String random_number,
//                               String click_total,
//                               String collect_total,
//                               String time_condition){
//
//        List<Book> books = mBookMapper.findBooks(book_classify,
//                book_recommend_tag,
//                Integer.valueOf(random_number),
//                null,
//                click_total,
//                collect_total,
//                time_condition);
//        return books;
//    }






}
