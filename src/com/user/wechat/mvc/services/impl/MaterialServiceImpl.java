/**
 * 
 */
package com.user.wechat.mvc.services.impl;

import java.io.File;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halo.spring.utils.SpringUtils;
import com.halo.wechat.capabilities.CapabilityException;
import com.halo.wechat.capabilities.abilities.MaterialAbility;
import com.halo.wechat.capabilities.beans.MaterialCountBean;
import com.halo.wechat.capabilities.beans.MaterialListBean;
import com.halo.wechat.capabilities.beans.NewsItem;
import com.halo.wechat.mvc.services.ServiceException;
import com.user.wechat.db.daos.ArticleCatalogDao;
import com.user.wechat.db.domains.ArticleCatalog;
import com.user.wechat.mvc.services.MaterialService;

/**
 * @author Junior
 * @date 2015年10月18日 上午9:54:04
 * @version 1.0
 * @since
 * @see
 */
@Service
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	private ArticleCatalogDao articleCatalogDao;

	private final String DEFAULT_THUMB_IMG_URL = "http://115.159.67.204/WeChat/images/dog_eye_on_design_thumb.jpg";

	@Override
	public String saveNewsToLocal(short materialCount) throws ServiceException {
		MaterialAbility materialAbility = (MaterialAbility) SpringUtils.getBean("materialAbility");
		MaterialCountBean materialCountBean = null;
		try {
			materialCountBean = materialAbility.getMaterialCount();
		} catch (CapabilityException e) {
			throw new ServiceException("Get material count error.");
		}

		short count = materialCountBean.getNews_count() > materialCount ? materialCount : materialCountBean.getNews_count();
		short offset = (short) (materialCountBean.getNews_count() > materialCount ? materialCountBean.getNews_count() - materialCount : 0);

		if (0 == count) {
			return "没有永久素材可下载。";
		}

		MaterialListBean materialListBean = null;
		try {
			materialListBean = materialAbility.batchGetMaterial(MaterialAbility.MATERIAL_TYPE_NEWS, offset, count);
		} catch (CapabilityException e) {
			throw new ServiceException("Batch get material error.");
		}

		String savedRecord = "<table><th colspan='4'>共下载" + String.valueOf(count) + "条素材</th>";
		for (MaterialListBean.Item item : materialListBean.getItem()) {
			for (NewsItem newsItem : item.getContent().getNews_item()) {
				File bigPicFile;
				try {
					bigPicFile = materialAbility.downloadMaterial(newsItem.getThumb_media_id());
				} catch (CapabilityException e) {
					throw new ServiceException("Download cover picture error.");
				}
				String saveAsPath = SpringUtils.getWebApplicationContext().getServletContext().getRealPath("image/");
				String saveAsFileName = newsItem.getThumb_media_id() + ".jpg";
				File saveAsFile = new File(saveAsPath + File.separator + saveAsFileName);
				bigPicFile.renameTo(saveAsFile);

				String bigPicUrl = "http://115.159.67.204/WeChat/images/" + saveAsFileName;
				ArticleCatalog articleCatalog = new ArticleCatalog(newsItem.getTitle(), newsItem.getDigest(), bigPicUrl, DEFAULT_THUMB_IMG_URL,
						newsItem.getUrl(), new Date());
				Integer id = articleCatalogDao.save(articleCatalog);

				savedRecord += "<tr>";
				savedRecord += "<td>" + String.valueOf(id) + "</td>";
				savedRecord += "<td>" + newsItem.getTitle() + "</td>";
				savedRecord += "<td>" + bigPicUrl + "</td>";
				savedRecord += "<td>" + newsItem.getUrl() + "</td>";
				savedRecord += "</tr>";
			}
		}
		savedRecord += "</table>";

		return savedRecord;
	}

}
