package com.xh.HiXiaoshuoserver.service.imlp;


import com.github.pagehelper.PageHelper;
import com.xh.HiXiaoshuoserver.domain.Book;
import com.xh.HiXiaoshuoserver.domain.BookSource;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.page.PageInfo;
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
    public List<Book> getRecommendList(List<String> rankids, List<String> rankstates) {

        return mBookMapper.getRankBookList(rankids, rankstates);
    }

    @Override
    public int putBook(String bookID,
                       String bookName,
                       String bookClassify,
                       String bookImageUrl,
                       String bookAuthor,
                       String bookSubject) {
        return mBookMapper.putBook(bookID, bookName, bookClassify, bookImageUrl, bookAuthor, bookSubject);
    }

    @Override
    public PageInfo getBookList(String bookID,
                                                             String bookName,
                                                             String bookAuthor,
                                                             String bookClassify,
                                                             String bookSubject,
                                                             int pageNum,
                                                             int pageSize) {

        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        //分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
        // 查询数据库并返回结果
        List<Book> result = mBookMapper.getBookList(bookID,
                bookName,
                bookAuthor,
                bookClassify,
                bookSubject);
        //用PageInfo对结果进行包装
        PageInfo pageInfo = new PageInfo(result);

        return pageInfo;
    }



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
    @Override

    public List<Book> findBookbySubclassfy(String classify,
                                           String subclassify,
                                           String sortType,
                                           int minNumber,
                                           int maxNumber,
                                           int pageNum,
                                           int pageSize) {

        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        String tmpsortType = sortType.equals("0") == true ? "0" : null;

        String tmpSubclassify = subclassify.equals("全部") == true ? null : subclassify;

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findBookbySubclassfy(classify, tmpSubclassify, tmpsortType, minNumber,maxNumber);

        // pageInfo https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md

        // PageInfo pageInfo = new PageInfo(books);

        return wrapUrlWithBooks(books);

    }

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

        if (books.size() == 0) return null;

        // 第二步，查询出每个book的url列表

        List<Book> tmpBooks = new ArrayList<Book>();

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            List<BookSource> urls = mBookMapper.getBookUrls(book.getBookID());


            // 这里需要判断url是否有效
            if (urls.size() > 0){

                book.setBookUrls(urls);

                // 设置当前生效url
                book.setBookurl(fetchDefaultUrl(urls));
                tmpBooks.add(book);
            }

        }


        return tmpBooks;
    }

    /***
    *
    * 设置默认的URL
    * **/
    public String fetchDefaultUrl(List<BookSource> url) {

        for (int i = 0; i < url.size(); i++) {

            BookSource source = url.get(i);

            if (source.getBookDomain().equals("wksw")) {
                return source.getBookUrl();
            }
        }

        return url.get(0).getBookUrl();

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
