package com.yjlc.base;

import com.yjlc.config.MaoDiConfig;
import com.yjlc.utill.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";
	private static String accountSid = MaoDiConfig.ACCOUNT_SID;

	/**
	 * 验证码通知短信
	 */
	public static String execute(String to,String code)
	{
		String url = MaoDiConfig.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" 
					+ "【逆时空科技】尊敬的用户，您的验证码为"+code
					+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
		return result;
	}
}
