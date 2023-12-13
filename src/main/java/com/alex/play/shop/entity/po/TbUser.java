package com.alex.play.shop.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbUser implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.ASSIGN_ID)
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
     * 用户账号
     */
    private String userEmail;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 是否为会员
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer userMember;

    /**
     * 用户头像地址
     */
    private String userPic;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 是否删除 0:未删除  1:删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer isDel;

    /**
     * 用户类型 0:管理员 1:买家 2:卖家 3:作者
     */
    private Integer userType;

}