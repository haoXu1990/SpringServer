package com.xh.HiXiaoshuoserver.controller;

import com.xh.HiXiaoshuoserver.domain.JsonData;
import com.xh.HiXiaoshuoserver.mapper.BookMapper;
import com.xh.HiXiaoshuoserver.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    // Dao 层 也就是数据库访问
    @Autowired
    private BookMapper mBookMapper;


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


        return JsonData.buildSuccess(bookService.searchBook(bookName + '%'));
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
