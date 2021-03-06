package com.xh.HiXiaoshuoserver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Array;
import java.util.Date;
import java.util.List;

public class Book {


    private String bookName;

    private String bookAuthor;

    private String bookStatus;

    private String bookClassify;

    private String bookID;

    @JsonIgnore
    private Date  bookCreatTime;

    private String bookAbstract;

    private String bookImageUrl;

    private List<BookSource> bookUrls;

    private String bookNumber;

    private String bookurl;

    private String bookSubClassify;

    private String bookSubject;

    public String getBookSubject() {
        return bookSubject;
    }

    public void setBookSubject(String bookSubject) {
        this.bookSubject = bookSubject;
    }

    public String getBookSubClassify() {
        return bookSubClassify;
    }

    public void setBookSubClassify(String bookSubClassify) {
        this.bookSubClassify = bookSubClassify;
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookClassify() {
        return bookClassify;
    }

    public void setBookClassify(String bookClassify) {
        this.bookClassify = bookClassify;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public Date getBookCreatTime() {
        return bookCreatTime;
    }

    public void setBookCreatTime(Date bookCreatTime) {
        this.bookCreatTime = bookCreatTime;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }

    public String getBookImageUrl() {
        return bookImageUrl;
    }

    public void setBookImageUrl(String bookImageUrl) {
        this.bookImageUrl = bookImageUrl;
    }


    public List<BookSource> getBookUrls() {
        return bookUrls;
    }

    public void setBookUrls(List<BookSource> bookUrls) {
        this.bookUrls = bookUrls;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }
}
