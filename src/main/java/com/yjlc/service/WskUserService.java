package com.yjlc.service;

import com.yjlc.entity.WskUser;

import java.io.IOException;

/**
 * Created by dashang001 on 2018/7/26.
 */
public interface WskUserService {
    WskUser getByPhone(String phone);
    boolean updatebyId(WskUser wskUser);
    boolean insertSelective(WskUser wskUser);
    void getWechat ();
}