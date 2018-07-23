package com.xh.HiXiaoshuoserver.service.imlp;

import com.xh.HiXiaoshuoserver.mapper.MyUIDMapper;
import com.xh.HiXiaoshuoserver.service.uidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UidServicelmlp implements uidService {

    // Dao 层 也就是数据库访问
    @Autowired
    private MyUIDMapper myUidMapper;

    @Override
    public Long getUidForRegister(String usedFor) {
        return myUidMapper.getUidForRegister(usedFor);
    }
}
