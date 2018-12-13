package com.xh.HiXiaoshuoserver.vo;


import lombok.Data;

/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-12-13 11:07
 **/
@Data
public class ResultVO<T> {

    // 数据列表
    private T data;

    // 总数
    private Long total;

}