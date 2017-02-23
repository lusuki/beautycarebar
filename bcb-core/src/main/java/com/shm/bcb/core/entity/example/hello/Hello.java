package com.shm.bcb.core.entity.example.hello;

import cn.fanciers.sth.infrastructure.biz.BaseModel;
import cn.fanciers.sth.infrastructure.util.modemapper.SkipMapperEnable;
import com.shm.bcb.core.entity.Creatable;
import com.shm.bcb.core.entity.CreatableListener;
import com.shm.bcb.core.entity.Modifiable;
import com.shm.bcb.core.entity.ModifiableListener;
import com.shm.bcb.core.service.example.hello.HelloDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by sherman on 2017/2/23.
 */

@Entity
@EntityListeners({ CreatableListener.class, ModifiableListener.class })
@Table(name = "sth_account")
@Data
public class Hello extends BaseModel<HelloDto> implements Creatable, Modifiable {
    @Column
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    @SkipMapperEnable
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modified")
    @SkipMapperEnable
    private Date modified;
}
