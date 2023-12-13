package com.alex.play.shop.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PageDto
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 18:20
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUserQueryDto {
    /**
     * 用户昵称
     */
    private String userAccount;

    /**
     * 用户账号
     */
    private String userEmail;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 用户类型 0:管理员 1:买家 2:卖家 3:作者
     */
    private Integer userType;

    /**
     * 页码
     */
    private String pageNum;

    /**
     * 数量
     */
    private String pageSize;
}
