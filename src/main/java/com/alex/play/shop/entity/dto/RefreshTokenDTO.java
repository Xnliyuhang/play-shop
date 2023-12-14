package com.alex.play.shop.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName RefreshTokenDTO
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/14 16:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDTO {
    @NotBlank(message = "refreshToken不能为空！")
    private String refreshToken;
}
