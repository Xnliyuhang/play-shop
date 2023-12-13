package com.alex.play.shop.controller;

import com.alex.play.shop.entity.dto.LoginDto;
import com.alex.play.shop.service.TbUserService;
import com.alex.play.shop.utils.BaseResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 22:40
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Resource
    TbUserService tbUserService;

    @PostMapping("/noAuth/login")
    public BaseResponse login(@Valid @RequestBody LoginDto loginDto){
        return tbUserService.login(loginDto);
    }

}
