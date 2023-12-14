package com.alex.play.shop.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName TokenVO
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/14 16:33
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenVO {
    private String token;

    private String refreshToken;
}
