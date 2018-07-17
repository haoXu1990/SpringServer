package com.xh.HiXiaoshuoserver.service.imlp;


import com.github.pagehelper.PageHelper;
import com.xh.HiXiaoshuoserver.domain.Book;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicelmlp implements BookService {

    // Dao 层 也就是数据库访问
    @Autowired
    private BookMapper mBookMapper;


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
        List<Book> books = mBookMapper.findByPage(null);

        // 第二步，查询出每个book的url列表
        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            String[] urls = mBookMapper.getBookUrls(book.getBookID());

            book.setBookUrls(urls);
        }

        return books;

    }
}
