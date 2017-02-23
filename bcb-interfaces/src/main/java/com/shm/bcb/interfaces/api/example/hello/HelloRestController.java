package com.shm.bcb.interfaces.api.example.hello;

import cn.fanciers.sth.infrastructure.biz.BaseService;
import com.shm.bcb.core.service.example.hello.HelloDto;
import com.shm.bcb.core.service.example.hello.HelloService;
import com.shm.bcb.interfaces.api.BaseRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sherman on 2017/2/23.
 */
@RestController
@RequestMapping("hello")
public class HelloRestController extends BaseRestController {
    @Autowired
    private HelloService helloService;

    protected BaseService getService() {
        return helloService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public HelloDto getHello(@PathVariable long id) {
        return helloService.getById(id);
    }
}
