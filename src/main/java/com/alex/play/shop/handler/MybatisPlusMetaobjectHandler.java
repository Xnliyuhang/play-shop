package com.alex.play.shop.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName MybatisPlusMetaobjectHandler
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 13:11
 * @Version 1.0
 */
@Slf4j
@Component
public class MybatisPlusMetaobjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill.....");
        // setFieldvalByName(String fieldName,object fieldval,Metaobject metaobject)
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("isDel",0,metaObject);
        this.setFieldValByName("userMember",0,metaObject);
        this.setFieldValByName("balance", BigDecimal.valueOf(20.00),metaObject);
        this.setFieldValByName("ratingScore",100,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
