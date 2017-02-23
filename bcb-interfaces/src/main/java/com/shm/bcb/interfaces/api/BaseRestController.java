package com.shm.bcb.interfaces.api;

import cn.fanciers.sth.infrastructure.biz.BaseService;
import cn.fanciers.sth.infrastructure.biz.query.QueryCondition;
import cn.fanciers.sth.infrastructure.util.SthStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sherman on 15/10/17.
 */
@RestController
public abstract class BaseRestController {

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Object query(QueryCondition queryCondition) throws Exception {
        BaseService service = getService();
        if (service == null) {
            return null;
        }
        if (SthStringUtils.isNotEmpty(queryCondition.getFields())) {
            return service.query(queryCondition);
        } else {
            return service.queryForObjects(queryCondition);
        }
    }

    @RequestMapping(value = "/pagination", method = RequestMethod.GET)
    public Object pagination(QueryCondition queryCondition) throws Exception {
        BaseService service = getService();
        if (service == null) {
            return null;
        }
        if (SthStringUtils.isNotEmpty(queryCondition.getFields())) {
            return service.pagination(queryCondition);
        } else {
            return service.paginationForObjects(queryCondition);
        }
    }

    protected abstract BaseService getService();
}
