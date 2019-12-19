package com.yjlc.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.yjlc.api.HttpKit;
import com.yjlc.api.Tip;
import com.yjlc.base.IndustrySMS;
import com.yjlc.base.RandomNum;
import com.yjlc.vo.VerificationCodeVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dashang001 on 2018/7/27.
 */
@RestController
@RequestMapping("/SendSMS")
public class SendSMSController {
//    private static final long serialVersionUID = 1L;
    @RequestMapping(value = "/SendVerification",method = RequestMethod.POST)
    public Tip SendVerification(String phone){
        // TODO Auto-generated method stub
        RandomNum randomNum=new RandomNum();
        RandomNum.num=randomNum.getRandom();
        System.out.println("send"+RandomNum.num);
        String json= IndustrySMS.execute(phone, RandomNum.num);
//        request.setAttribute("phone",phone);
        HttpKit.success(phone);
        JsonObject obj = new JsonParser().parse(json).getAsJsonObject();
        String result=obj.get("respCode").getAsString();
        if(result.equals("00000")){
//            request.setAttribute("msg", "验证码发送成功");
            return HttpKit.success("验证码发送成功");
        }else if(result.equals("00126")){
//            request.setAttribute("msg", "手机号格式不正确");
            return HttpKit.failed("手机号格式不正确");
        }else{
//            request.setAttribute("msg", "错误状态码：<a href='http://www.miaodiyun.com/doc/status_code.html'>"+result+"</a>");
            return HttpKit.failed("错误状态码：<a href='http://www.miaodiyun.com/doc/status_code.html'>\"+result+\"</a>");
        }
    }
    @RequestMapping(value = "/VerificationCode",method = RequestMethod.POST)
   public Tip VerificationCode(String phone,String code){
//        String error="";
        System.out.println("input"+code);
        System.out.println("check"+RandomNum.num);
        if(code.equals(RandomNum.num)){
            return HttpKit.success("验证成功");
        }else {
            VerificationCodeVO codeVO=new VerificationCodeVO();
            codeVO.setPhone(phone);
            codeVO.setCode(code);
            codeVO.setError("验证码错误");
            return HttpKit.success(codeVO);
        }
    }
}