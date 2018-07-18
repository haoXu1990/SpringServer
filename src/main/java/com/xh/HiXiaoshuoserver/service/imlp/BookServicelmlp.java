package com.xh.HiXiaoshuoserver.service.imlp;


import com.github.pagehelper.PageHelper;
import com.xh.HiXiaoshuoserver.domain.Book;
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
    public List<Map> findByFemale() {

        // 查询出 火热推荐内容
        List<Book> huore = findByNvShen();


        // 使用分页插件，在下一条查询语句会分页 这里随机分页
        Random random = new Random();

        PageHelper.startPage(random.nextInt() + 1, 8);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByPage(null,null,"1");

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }


        Map<String, Object> huoreMap = new HashMap<>();
        huoreMap.put("title", "火热推荐");
        huoreMap.put("data", huore);

        Map<String, Object> lianzaiMap = new HashMap<>();
        lianzaiMap.put("title", "连载推荐");
        lianzaiMap.put("data", books);


        List<Map> list = new ArrayList<>();
        list.add(huoreMap);
        list.add(lianzaiMap);

        return list;
    }

    /**
     *
     * 组装 火热推荐(重男生最爱里面随机获取8本), 连载推荐(随机推荐8本男生书籍)
     * */
    @Override
    public List<Map> findByMale() {

        // 查询出 火热推荐内容
        List<Book> huore = findByNanShen();


        // 使用分页插件，在下一条查询语句会分页 这里随机分页
        Random random = new Random();

        PageHelper.startPage(random.nextInt() + 1, 8);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByPage(null,"1",null);

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }


        Map<String, Object> huoreMap = new HashMap<>();
        huoreMap.put("title", "火热推荐");
        huoreMap.put("data", huore);

        Map<String, Object> lianzaiMap = new HashMap<>();
        lianzaiMap.put("title", "连载推荐");
        lianzaiMap.put("data", books);


        List<Map> list = new ArrayList<>();
        list.add(huoreMap);
        list.add(lianzaiMap);

        return list;
    }

    /**
     *
     * 组装 经典小说获取8条，男生最爱获取8条，女生最爱获取8条
     * */
    @Override
    public List<Map> getHome() {

        List<Book> jindian = findByJinDian();
        List<Book> nanshen = findByNanShen();
        List<Book> nvshen = findByNvShen();

        Map<String, Object> jindianMap = new HashMap<>();
        jindianMap.put("title", "经典推荐");
        jindianMap.put("data", jindian);

        Map<String, Object> nanshenMap = new HashMap<>();
        nanshenMap.put("title", "男生最爱");
        nanshenMap.put("data", nanshen);

        Map<String, Object> nvshenMap = new HashMap<>();
        nvshenMap.put("title", "女生最爱");
        nvshenMap.put("data", nvshen);

        List<Map> list = new ArrayList<>();
        list.add(jindianMap);
        list.add(nanshenMap);
        list.add(nvshenMap);

        return list;
    }

    @Override
    public Book getBook(String bookID) {

        Book book = mBookMapper.getBook(bookID);
        String[] urls = mBookMapper.getBookUrls(book.getBookID());
        book.setBookUrls(urls);

        return book;
    }

    @Override
    public List<Book> findeByPage(int pageNum, int pageSize) {

        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByPage(null,null,null);

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;

    }


    @Override
    public List<Book> findByJinDian() {

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByJinDian();

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;
    }


    @Override
    public List<Book> findByJinDianPage(int pageNum, int pageSize) {

        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByJinDianPage();

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;
    }


    @Override
    public List<Book> findByNanShen() {
        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByNanShen();

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;
    }

    @Override
    public List<Book> findByNanShenPage(int pageNum, int pageSize) {
        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByNanShenPage();

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;
    }


    @Override
    public List<Book> findByNvShen() {
        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByNvShen();

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;
    }

    @Override
    public List<Book> findByNvShenPage(int pageNum, int pageSize) {
        // 使用分页插件，在下一条查询语句会分页
        PageHelper.startPage(pageNum, pageSize);

        // 第一步，查询出book列表
        List<Book> books = mBookMapper.findByNvShenPage();

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;
    }
}
