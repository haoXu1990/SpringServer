package com.xh.HiXiaoshuoserver.service;


/**
 * @program: HiXiaoshuo-server
 * @description:
 * @author: XuHao
 * @create: 2018-07-23 15:15
 **/
public interface MyUIDService {
    /**
     * 通过uid区间标识（usedfor）得到一个编号。
     * @param usedFor
     * @return
     */
    Long getUidForRegister(String usedFor);

}