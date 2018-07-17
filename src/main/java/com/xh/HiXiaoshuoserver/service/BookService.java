package com.xh.HiXiaoshuoserver.service;


import com.xh.HiXiaoshuoserver.domain.Book;

import java.util.List;

public interface BookService {

    public Book getBook(String bookID);


    List<Book> findeByPage(int pageNum, int pageSize);


}
