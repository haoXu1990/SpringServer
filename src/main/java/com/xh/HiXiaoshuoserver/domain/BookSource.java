package com.xh.HiXiaoshuoserver.domain;
/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-08-15 15:13
 **/

public class BookSource {

    private String bookID;

    private String bookUrl;

    private String bookDomain;

    private Boolean bookEnable;


    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public String getBookDomain() {
        return bookDomain;
    }

    public void setBookDomain(String bookDomain) {
        this.bookDomain = bookDomain;
    }

    public Boolean getBookEnable() {
        return bookEnable;
    }

    public void setBookEnable(Boolean bookEnable) {
        this.bookEnable = bookEnable;
    }
}