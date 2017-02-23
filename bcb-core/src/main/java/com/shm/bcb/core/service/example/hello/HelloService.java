package com.shm.bcb.core.service.example.hello;

import cn.fanciers.sth.infrastructure.biz.BaseService;

/**
 * Created by sherman on 2017/2/23.
 */
public interface HelloService extends BaseService {
    HelloDto getById(long id);
}
