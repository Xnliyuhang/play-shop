package com.alex.play.shop.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alex.play.shop.constans.RedisConstants;
import com.alex.play.shop.entity.dto.LoginDto;
import com.alex.play.shop.entity.dto.TbUserBaseUpdateDto;
import com.alex.play.shop.entity.dto.TbUserQueryDto;
import com.alex.play.shop.entity.dto.TbUserRegisterDto;
import com.alex.play.shop.entity.po.TbUser;
import com.alex.play.shop.entity.po.TbWallet;
import com.alex.play.shop.jwt.JwtTokenProvider;
import com.alex.play.shop.mapper.TbUserMapper;
import com.alex.play.shop.mapper.TbWalletMapper;
import com.alex.play.shop.service.TbUserService;
import com.alex.play.shop.utils.BaseResponse;
import com.alex.play.shop.utils.RedisUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TbUserServiceImpl
 * @Description TODO
 * @Author Alex
 * @Date 2023/12/13 14:13
 * @Version 1.0
 */
@Service
public class TbUserServiceImpl implements TbUserService {
    @Resource
    TbUserMapper tbUserMapper;

    @Resource
    TbWalletMapper tbWalletMapper;

    @Resource
    RedisUtils redisUtils;

    @Resource
    JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse add(TbUserRegisterDto tbUserRegisterDto) throws Exception {
        TbUser tbUser = new TbUser();
        TbWallet tbWallet = new TbWallet();
        tbUserRegisterDto.setUserPassword(SecureUtil.md5(tbUserRegisterDto.getUserPassword()));
        BeanUtil.copyProperties(tbUserRegisterDto,tbUser);
        try {
            tbUserMapper.insert(tbUser);

            tbWallet.setUserId(tbUser.getId());
            tbWallet.setUserAccount(tbUser.getUserAccount());
            tbWalletMapper.insert(tbWallet);

            String userEmailInfo = String.valueOf(StrBuilder.create().append(RedisConstants.REDIS_USER_INFO_PREFIX).append(tbUser.getUserEmail()));
            boolean cacheValue = redisUtils.cacheValue(userEmailInfo, tbUser.getUserEmail());
            if (StrUtil.isEmpty(tbUser.getId().toString()) || !cacheValue){
                throw new Exception("用户注册失败");
            }
        }catch (Exception e){
            throw new Exception("用户注册失败");
        }
        return BaseResponse.success(tbUser,"用户注册成功");
    }

    @Override
    public BaseResponse update(TbUserBaseUpdateDto tbUserBaseUpdateDto) {
        TbUser tbUser = new TbUser();
        BeanUtil.copyProperties(tbUserBaseUpdateDto,tbUser);
        int i = tbUserMapper.updateById(tbUser);
        if (i!=1){
            return BaseResponse.success("用户修改失败");
        }
        return BaseResponse.success("用户修改成功");
    }

    @Override
    public BaseResponse select(TbUserQueryDto tbUserQueryDto) {
        if (StrUtil.isEmpty(tbUserQueryDto.getPageNum()) || StrUtil.isEmpty(tbUserQueryDto.getPageSize())){
            PageHelper.startPage(1,2);
        }else {
            PageHelper.startPage(Integer.parseInt(tbUserQueryDto.getPageNum()),Integer.parseInt(tbUserQueryDto.getPageSize()));
        }
//        PageHelper.startPage(1,2);
        List<TbUser> userList = tbUserMapper.findByTbUserQueryDto(tbUserQueryDto);

        PageInfo<TbUser> tbUserPageInfo = new PageInfo<>(userList);
        List<TbUser> list = tbUserPageInfo.getList();
        int pageNum = tbUserPageInfo.getPageNum();
        int pageSize = tbUserPageInfo.getPageSize();
        System.out.println("pageNum: " + pageNum);
        System.out.println("pageSize: " + pageSize);

        for (TbUser tbUser : list) {
            System.out.println(tbUser);
        }

        return BaseResponse.success(list,"查询成功");
    }

    @Override
    public BaseResponse login(LoginDto loginDto) {

        TbUser tbUser = tbUserMapper.selectOne(new QueryWrapper<TbUser>().lambda().eq(TbUser::getUserEmail, loginDto.getUserEmail()).eq(TbUser::getUserPassword, SecureUtil.md5(loginDto.getUserPassword())));
        if (BeanUtil.isEmpty(tbUser)){
            return BaseResponse.failure("用户名或密码错误!");
        }

        Map<String,Object> map = new HashMap<>();

        String tokenKey = String.valueOf(StrBuilder.create().append(RedisConstants.REDIS_WEB_ADMIN_TOKEN_PREFIX).append(tbUser.getId()));
        long tokenValues = redisUtils.lGetListSize(tokenKey);
        if (tokenValues >= 3){
            Object o = redisUtils.lGetIndex(tokenKey, 0);
            redisUtils.lRemove(tokenKey,1,redisUtils.lGetIndex(tokenKey, 0));
        }
        String token = jwtTokenProvider.createToken(String.valueOf(tbUser.getId()), tbUser.getUserAccount());
        redisUtils.lSet(tokenKey,token,1000*60*60*24);
        System.out.println("length: " + redisUtils.lGetListSize(tokenKey));
        System.out.println("token: " + token);
        map.put("user",tbUser);
        map.put("access_token",token);
        return BaseResponse.success(map,"登陆成功");
    }


}
