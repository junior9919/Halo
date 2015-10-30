package com.user.wechat.mvc.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.json.utils.JSONUtils;
import com.halo.wechat.capabilities.beans.ResultBean;
import com.halo.wechat.mvc.controllers.ControllerException;
import com.user.wechat.mvc.services.DeveloperInfoService;

/**
 * @author Junior
 * @date 2015年9月15日 下午10:37:53
 * @version 1.0
 * @since
 * @see
 */
@Controller
public class DeveloperInfoController {

	@Autowired
	private DeveloperInfoService developerInfoService;

	@RequestMapping("/isSubscriber.do")
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ControllerException {
		String developerId = arg0.getParameter("from_user_name");
		String openId = arg0.getParameter("to_user_name");
		ResultBean resultBean = new ResultBean();
		resultBean.setErrcode(-1);
		resultBean.setErrmsg("Uninitialized");
		if (developerInfoService.isSubscriber(developerId, openId)) {
			resultBean.setErrcode(1);
			resultBean.setErrmsg("Registed developer");
		}

		if (!developerInfoService.isTemporaryDeveloperExist(developerId, openId)) {
			developerInfoService.preRegistDeveloperInfo(developerId, openId);
		}

		JSONUtils<ResultBean> jsonUtils = new JSONUtils<ResultBean>(ResultBean.class);
		String jsonStr = jsonUtils.getJsonStr(resultBean);

		try {
			arg1.getWriter().write(jsonStr);
		} catch (IOException e) {
			throw new ControllerException("Error write response.");
		}
	}

}
