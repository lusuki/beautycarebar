package com.shm.bcb.core.service.example.hello;

import cn.fanciers.sth.infrastructure.biz.BaseServiceImpl;
import com.shm.bcb.core.entity.example.hello.Hello;
import com.shm.bcb.core.entity.example.hello.HelloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sherman on 2017/2/23.
 */
@Slf4j
@Service
public class HelloServiceImpl extends BaseServiceImpl<Hello> implements HelloService {
    @Autowired
    private HelloRepository helloRepository;

    public HelloDto getById(long id) {
        log.debug("get hello record by id {}.", id);
        Hello hello = helloRepository.findOne(id);
        if (hello == null) {
            log.error("get failed! {} not existed", id);
            return null;
        }
        return new HelloDto(hello);
    }
}
