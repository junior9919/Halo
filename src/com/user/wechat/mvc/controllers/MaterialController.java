/**
 * 
 */
package com.user.wechat.mvc.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.wechat.mvc.controllers.ControllerException;
import com.halo.wechat.mvc.services.ServiceException;
import com.user.wechat.mvc.services.MaterialService;

/**
 * @author Junior
 * @date 2015年10月17日 下午8:19:35
 * @version 1.0
 * @since
 * @see
 */
@Controller
public class MaterialController {

	@Autowired
	private MaterialService materialService;

	@RequestMapping("/getMaterial.do")
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ControllerException {
		short materialCount;
		try {
			materialCount = Short.parseShort(arg0.getParameter("materialCount"));
		} catch (NumberFormatException e) {
			throw new ControllerException("Need a number parameter named materialCount.");
		}

		String result = "";
		try {
			result = materialService.saveNewsToLocal(materialCount);
		} catch (ServiceException e) {
			throw new ControllerException("Save news failed.");
		}

		try {
			arg1.getWriter().write(result);
		} catch (IOException e) {
			throw new ControllerException("Error write response.");
		}
	}
}
