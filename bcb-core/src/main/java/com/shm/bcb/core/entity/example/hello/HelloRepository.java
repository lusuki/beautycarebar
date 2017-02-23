package com.shm.bcb.core.entity.example.hello;

import cn.fanciers.sth.infrastructure.persist.jpa.springdatajpa.SthJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sherman on 2017/2/23.
 */
@Repository
public interface HelloRepository extends SthJpaRepository<Hello, Long> {
}
