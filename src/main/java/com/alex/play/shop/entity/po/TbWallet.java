package com.alex.play.shop.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbWallet implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 账户余额
     */
    @TableField(fill = FieldFill.INSERT)
    private BigDecimal balance;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 信誉积分
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer ratingScore;

    /**
     * 用户id
     */
    private Long userId;
}