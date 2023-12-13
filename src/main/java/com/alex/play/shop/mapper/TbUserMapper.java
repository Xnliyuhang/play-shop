package com.alex.play.shop.mapper;

import com.alex.play.shop.entity.dto.TbUserQueryDto;
import com.alex.play.shop.entity.po.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 14:11
 * @Version 1.0
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

    List<TbUser> findByTbUserQueryDto(TbUserQueryDto tbUserQueryDto);
}
