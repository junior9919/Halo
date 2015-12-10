package com.user.wechat.mvc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.halo.wechat.mvc.controllers.ControllerException;
import com.user.wechat.mvc.services.ArticleCatalogService;

/**
 * @author zyl
 *
 */
@Controller
public class SearchArticlesController {

	private final int countPerPage = 5;

	@Autowired
	private ArticleCatalogService articleCatalogService;

	@RequestMapping("/searchArticles.do")
	public ModelAndView searchArticles(HttpServletRequest arg0) throws ControllerException {
		int firstRow = 0;
		if (arg0.getMethod().toLowerCase().equals("get")) {
			if (null != arg0.getParameter("firstRow")) {
				try {
					firstRow = Integer.parseInt(arg0.getParameter("firstRow"));
				} catch (NumberFormatException e) {
					throw new ControllerException("Invalid number parameter firstRow");
				}
			}
		}

		List<Map<String, String>> articleList = articleCatalogService.searchArticles(firstRow, countPerPage);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("articles", articleList);

		long articlesCount = articleCatalogService.getArticlesCount();
		resultMap.put("articlesCount", articlesCount);

		resultMap.put("nextRow", firstRow + countPerPage);
		resultMap.put("previousRow", firstRow - countPerPage);

		ModelAndView mav = new ModelAndView("Articles", resultMap);

		return mav;
	}

}
