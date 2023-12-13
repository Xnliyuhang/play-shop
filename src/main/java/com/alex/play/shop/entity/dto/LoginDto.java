package com.alex.play.shop.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName LoginDto
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 22:43
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    @NotBlank(message = "登录账号不能为空")
    private String userEmail;

    @NotBlank(message = "密码不能为空")
    private String userPassword;
}
