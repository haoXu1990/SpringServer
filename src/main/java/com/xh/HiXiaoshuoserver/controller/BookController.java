package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;


    @GetMapping("/")
    public Object hello(){
        return "hello";
    }
    /**
     * 女频接口
     *
     * 组装  火热推荐(重女生最爱里面随机获取8本), 连载推荐(随机推荐8本女生书籍)
     *
     * */
    @GetMapping("findByFemale")
    public Object findByFemale(){

        return JsonData.buildSuccess(bookService.findByFemale());
    }

    /**
     * 男频接口
     *
     * 组装  火热推荐(重男生最爱里面随机获取8本), 连载推荐(随机推荐8本男生书籍)
     *
     * */
    @GetMapping("findByMale")
    public Object findByMale(){

        return JsonData.buildSuccess(bookService.findByMale());
    }


    /**
     * 主页接口
     *
     * 组装 经典小说获取8条，男生最爱获取8条，女生最爱获取8条
     *
     * */
    @GetMapping("home")
    public Object home(){

        return JsonData.buildSuccess(bookService.getHome());
    }

    /**
     * @Description:  获取小说列表，分页显示
     * @Param:  pageNum, pageSize
     * @return: 小说集合
     * @Author: Xuhao
     * @Date: 2018/7/16
     */
    @GetMapping("find_by_page")
    public Object findByPage(int pageNum, int pageSize) {

        return JsonData.buildSuccess(bookService.findeByPage(pageNum, pageSize));
    }

    /**
     * 获取精品小说 随机获取
     * */
    @GetMapping("find_by_jindian")
    public Object findByJinDian() {
        return JsonData.buildSuccess(bookService.findByJinDian());
    }

    /**
     * 获取精品小说 分页获取
     * */
    @GetMapping("find_by_jindian_page")
    public Object findByJinDianPage(int pageNum, int pageSize) {
        return JsonData.buildSuccess(bookService.findByJinDianPage(pageNum,pageSize));
    }

    /**
     * 获取男频小说 随机获取
     * */
    @GetMapping("find_by_nanshen")
    public Object findByNanShen() {
        return JsonData.buildSuccess(bookService.findByNanShen());
    }

    /**
     * 获取男频小说 分页获取
     * */
    @GetMapping("find_by_nanshen_page")
    public Object findByNanShenPage(int pageNum, int pageSize) {
        return JsonData.buildSuccess(bookService.findByNanShenPage(pageNum,pageSize));
    }


    /**
     * 获取女频 随机获取
     * */
    @GetMapping("find_by_nvshen")
    public Object findByNvShen() {
        return JsonData.buildSuccess(bookService.findByNvShen());
    }

    /**
     * 获取女频 分页获取
     * */
    @GetMapping("find_by_nvshen_page")
    public Object findByNvShenPage(int pageNum, int pageSize) {
        return JsonData.buildSuccess(bookService.findByNvShenPage(pageNum,pageSize));
    }


    /**
     * @Description:  根据小说ID获取小说信息
     * @Param:  bookID
     * @return: 小说详情
     * @Author: Xuhao
     * @Date: 2018/7/16
     */
    @GetMapping("find_by_id")
    public Object findById(String bookID) {

        return JsonData.buildSuccess(bookService.getBook(bookID));
    }



}
