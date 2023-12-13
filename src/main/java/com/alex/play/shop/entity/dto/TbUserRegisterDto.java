package com.alex.play.shop.entity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @ClassName UserRegisterDto
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 13:47
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUserRegisterDto {

    /**
     * 用户账号名
     */
    @NotBlank(message = "用户昵称不能为空")
    private String userAccount;

    /**
     * 用户账号
     */
    @Email(message = "账号输入错误")
    private String userEmail;

    /**
     * 用户密码
     */
    @Length(min = 6, max = 16, message = "密码长度为6-16位")
    private String userPassword;

    /**
     * 用户手机号
     */
    @Pattern(regexp = "0?(13|14|15|17|18|19)[0-9]{9}", message = "手机号格式不正确")
    private String userPhone;

    /**
     * 用户头像地址
     */
    private String userPic;

    /**
     * 用户类型 0:普通买方 1:店铺卖家
     */
    @NotNull(message = "未选择用户类型")
    private Integer userType;
}
