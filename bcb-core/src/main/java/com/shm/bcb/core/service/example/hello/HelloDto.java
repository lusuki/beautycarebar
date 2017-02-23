package com.shm.bcb.core.service.example.hello;

import cn.fanciers.sth.infrastructure.biz.BaseDto;
import com.shm.bcb.core.entity.example.hello.Hello;
import lombok.Data;

import java.util.Date;

/**
 * Created by sherman on 2017/2/23.
 */
@Data
public class HelloDto extends BaseDto {
    private String name;
    private Date created;
    private Date modified;

    public HelloDto() {

    }

    public HelloDto(Hello hello) {
        hello.toDto(this);
    }
}
