package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.Book;
import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

//@CrossOrigin(origins = "http://192.168.1.51:8080", maxAge = 3600)
// 解决前端跨域问题
@CrossOrigin(origins = "http://192.168.1.51:8080")

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // Dao 层 也就是数据库访问
    @Autowired
    private BookMapper mBookMapper;


    /**
     * get请求
     * 获取小说详情，参数可选
     * @param bookID 小说ID
     * @param bookName 小说名称
     * @param bookAuthor 小说作者
     * @param bookClassify 小说分类
     *
    * */
    @GetMapping("")
    public Object getBookList(@RequestParam(value = "bookID", required = false) String bookID,
                          @RequestParam(value = "bookName", required = false) String bookName,
                          @RequestParam(value = "bookClassify", required = false) String bookClassify,
                          @RequestParam(value = "bookAuthor", required = false) String bookAuthor){
        // @RequestParam 默认值为null

        // 名称模糊查找
        List<Book> result = bookService.getBookList(bookID, '%' + bookName + '%', bookAuthor, bookClassify);

        if (result.size() > 0) {
            return JsonData.buildSuccess(result, "查询小说成功");
        }
        else {
            return JsonData.buildError("查询小说失败");
        }





    }

    /**
     * put请求
     * 修改小说信息
     * @param bookID 小说ID ，必填
     * @param bookName 小说名称
     * @param bookClassify 小说分类
     * @param bookImageUrl 小说封面图片地址
     * */
    @PutMapping("/")
    public Object putBook(@RequestParam(value = "bookID") String bookID,
                          @RequestParam(value = "bookName", required = false) String bookName,
                          @RequestParam(value = "bookClassify", required = false) String bookClassify,
                          @RequestParam(value = "bookImageUrl", required = false) String bookImageUrl){

        int ret = bookService.putBook(bookID, bookName, bookClassify,bookImageUrl);

        if (ret > 0) {
            return JsonData.buildSuccess("修改成功");
        }
        else {
            return JsonData.buildError("修改失败");
        }
    }

    /**
     * 分类查找书籍
     * @param classify 主分类
     * @param subclassify 子分类
     * @param classify 主要分类
     * @param sortType 排序类型 0 = 点击排行 ， 1 = 收藏排行
     * @param minNumber 字数最小值
     * @param maxNumber 字数最大值
     *
     * */
    @GetMapping("/findBookbySubclassfy")
    public Object findBookbySubclassfy(String classify,
                                       String subclassify,
                                       String sortType,
                                       int minNumber,
                                       int maxNumber,
                                       int pageNum,
                                       int pageSize){


        return JsonData.buildSuccess(bookService.findBookbySubclassfy(classify,subclassify, sortType, minNumber, maxNumber,pageNum,pageSize));

    }


    @GetMapping("/fetchurls")
    public Object fetchurls(String bookID){

        return JsonData.buildSuccess(mBookMapper.getBookUrls(bookID));
    }


    /**
     *  新用户推荐，暂时未使用
     * */
    @GetMapping("/newBaiYuer")
    public Object newBaiYuer() {

        return JsonData.buildSuccess(bookService.newBaiYuer());
    }



    /**
     * 版本控制
     * */
    @GetMapping("/version")
    public Object version(){

        return JsonData.buildSuccess(mBookMapper.vsersion());
    }




    /**
     * 添加热门收索
     * */
    @PostMapping("/addHotSearch")
    public Object addHotSearch(String bookName, String timer){


        mBookMapper.addHotSearch(bookName, timer);

        return JsonData.buildSuccess("添加成功");
    }


    /**
     * 查找小说
     * */
    @GetMapping("/search")
    public Object searchBook(String bookName){


        return JsonData.buildSuccess(bookService.searchBook('%' + bookName + '%'));
    }


    /**
     * 获取热门收索
     * */
    @GetMapping("/gethotSearch")
    public Object getHotSearch(){

        return JsonData.buildSuccess(bookService.getHotSearch());
    }


    /**
     * 根据小说分类和小说推荐主题随机获取 number 个小说
     *
     * @param pageNum
     * */
    @GetMapping("/findbookByPage")
    public Object findbookByPage(int pageNum, int pageSize, String classifyType){
        String fl;

        return null;
    }

    /**
     * 根据小说分类，数量, 随机获取点击排行榜前1000页数据
     *
     * @param number 获取数量
     * @param classifyType 分类： 0 ： 不分类， 1 = 男生 2 = 女生
     * */
    @GetMapping("/randomClickTotalBook")
    public Object randomClickTotalBook(int number, String classifyType){

        String fl;
        switch (classifyType) {
            case "1":
                fl = "男生";
                break;
            case "2":
                fl = "女生";
                break;
            default:
                fl = null;
        }

        int pageNum = 1 + (int)(Math.random()*1000);

        return JsonData.buildSuccess(bookService.findBookByPage(pageNum,
                number,
                fl,
                null,
                "1",
                null,
                "2018-06-01 00:00:00"));
    }

    /**
     * 根据小说分类和小说推荐主题随机获取 number 个小说
     *
     * @param number 获取数量
     * @param classifyType 分类： 0 ： 不分类， 1 = 男生 2 = 女生
     * @param recommendType 推荐主题 0: 获取点击排行总榜， 1：精品小说 2:封面小说
     * */
    @GetMapping("/random")
    public Object randomBook(int number, String classifyType, String recommendType){

        String fl;
        String tj;

        switch (classifyType) {

            case "1":
                fl = "男生";
                    break;
            case "2":
                fl = "女生";
                break;
            default:
                    fl = null;
        }

        switch (recommendType) {

            case "1":
                tj = "精品小说";
                break;
            case "2":
                tj = "封面推荐";
                break;
            default:
                tj = null;
        }


        if (recommendType.equals("0")) {

            return JsonData.buildSuccess(bookService.findBookRandom(number, fl, tj));
        }
        else {

            return JsonData.buildSuccess(bookService.findBookRandom(number, fl, tj));
        }

    }


    /**
     * 主页接口
     *
     * @param homeType  请求类型: 1=书城精选，2=书城女生，3=书城男生
     * */
    @GetMapping("home")
    public Object home(int homeType){

        /***
         *  主页接口部分包括
         *  精选页面
         *      精品汇聚：   从经典小说里面随机获取8条 随机
         *      精品专场：   从封面推荐里面随机获取8条
         *      大家都在看：  从点击排行降序获取5条
         *  女生页面
         *      女生精品： 从经典小说里面随机获取女生分类8条小说
         *      人气最热： 从收藏排行里面获取8条 女生分类小说
         *      热门分类:  女生小说主类下面的 所有子类
         *      完结热推:  从完结小说中获取8条 女生分类小说
         *
         *  男生页面
         *      男生精品： 从经典小说里面随机获取男生分类8条小说
         *      人气最热： 从收藏排行里面获取8条 男生分类小说
         *      热门分类:  男生小说主类下面的 所有子类
         *      完结热推:  从完结小说中获取8条 男生分类小说
         *
         *
         *
         * */

        return JsonData.buildSuccess(bookService.getHome(homeType));
    }








}
