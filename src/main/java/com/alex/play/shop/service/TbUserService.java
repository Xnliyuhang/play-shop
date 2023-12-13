package com.alex.play.shop.service;

import com.alex.play.shop.entity.dto.LoginDto;
import com.alex.play.shop.entity.dto.TbUserBaseUpdateDto;
import com.alex.play.shop.entity.dto.TbUserQueryDto;
import com.alex.play.shop.entity.dto.TbUserRegisterDto;
import com.alex.play.shop.utils.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 14:10
 * @Version 1.0
 */
public interface TbUserService {

    BaseResponse add(TbUserRegisterDto userRegisterDto) throws Exception;

    BaseResponse update(TbUserBaseUpdateDto tbUserBaseUpdateDto);

    BaseResponse select(TbUserQueryDto tbUserQueryDto);

    BaseResponse login(LoginDto loginDto);

}
