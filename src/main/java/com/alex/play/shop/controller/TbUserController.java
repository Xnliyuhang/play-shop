package com.alex.play.shop.controller;

import com.alex.play.shop.entity.dto.TbUserBaseUpdateDto;
import com.alex.play.shop.entity.dto.TbUserQueryDto;
import com.alex.play.shop.entity.dto.TbUserRegisterDto;
import com.alex.play.shop.service.TbUserService;
import com.alex.play.shop.utils.BaseResponse;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 13:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class TbUserController {

    @Resource
    TbUserService tbUserService;

    @PostMapping("/noAuth/add")
    public BaseResponse add(@Valid @RequestBody TbUserRegisterDto tbUserRegisterDto){
        try {
            System.out.println("111");
            return tbUserService.add(tbUserRegisterDto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestHeader("USER_ID") String userId,@Valid @RequestBody TbUserBaseUpdateDto tbUserBaseUpdateDto){
        System.out.println("USER_ID: " + userId);
        return tbUserService.update(tbUserBaseUpdateDto);
    }

    @PostMapping("/select")
    public BaseResponse select(@RequestBody TbUserQueryDto tbUserQueryDto){
        return tbUserService.select(tbUserQueryDto);
    }

    @PostMapping("/page")
    public BaseResponse page(){
        return BaseResponse.success("查询成功");
    }
}
