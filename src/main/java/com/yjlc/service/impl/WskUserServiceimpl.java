package com.yjlc.service.impl;

import com.yjlc.dao.WskUserMapper;
import com.yjlc.entity.WskUser;
import com.yjlc.service.WskUserService;
import com.yjlc.utill.AuthUtil;
import com.yjlc.utill.JsonUtil;
import com.yjlc.utill.MD5Util;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by dashang001 on 2018/7/26.
 */
@Service
public class WskUserServiceimpl implements WskUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(WskUserServiceimpl.class);
    @Resource
    WskUserMapper wskUserMapper;

    @Override
    public WskUser getByPhone(String phone) {
        LOGGER.info("开始获取数据");
        WskUser wskUser= wskUserMapper.selectByPrimaryKey(phone);
        if (wskUser!=null){
//            LOGGER.info(JsonUtil.objStringPretty(wskUser));
            LOGGER.info("获取数据结束");
            return wskUser;
        }
        LOGGER.debug("获取的数据为null，请换个手机号试试");
        return null;
    }
    @Override
    public boolean updatebyId(WskUser wskUser){
        int count=wskUserMapper.updateByPrimaryKeyWithBLOBs(wskUser);
        if (count>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insertSelective(WskUser wskUser) {
        try {
            if(wskUser.getPhone()!=null&&wskUser.getPhone()!="") {
                String phone = MD5Util.md5Encode( wskUser.getPhone() );
                wskUser.setPhone( phone );
            }
            int count=wskUserMapper.insertSelective(wskUser);
            if (count>0){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void getWechat()  {
        String  back_url="https://dujun.tunnel.qydev.com";
        String url="https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + AuthUtil.APPID+
                "&redirect_uri=" +back_url+
                "&response_type=code" +
                "&scope=snsapi_userinfo " +
                "&state=STATE#wechat_redirect";
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject=AuthUtil.DoGet(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code= (String)jsonObject.get( "code" );
        LOGGER.info( code );
    }
}