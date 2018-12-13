package com.xh.HiXiaoshuoserver.vo;


import lombok.Data;

import java.util.List;

/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-12-13 11:18
 **/
@Data
public class PageSimpleVO<T> {

    // 总数
    private Long total;

    // 列表
    private List<T> list;
}