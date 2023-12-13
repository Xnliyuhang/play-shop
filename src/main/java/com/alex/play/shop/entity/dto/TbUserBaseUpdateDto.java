package com.alex.play.shop.entity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName TbuserUpdateDto
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 17:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUserBaseUpdateDto {

    /**
     * 用户id
     */
    @NotNull(message = "账号不能为空")
    private Long id;

    /**
     * 用户昵称
     */
    private String userAccount;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户生日
     */
    private Date userBirthday;

    /**
     * 是否为会员
     */
    private Integer userMember;

    /**
     * 用户头像地址
     */
    private String userPic;

    /**
     * 用户类型 0:普通买方 1:店铺卖家
     */
    private Integer userType;
}
