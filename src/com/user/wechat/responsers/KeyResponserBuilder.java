/**
 * 
 */
package com.user.wechat.responsers;

import java.util.List;

/**
 * @author Junior
 * @date 2015年9月27日 上午11:45:57
 * @version 1.0
 * @since
 * @see
 */
public class KeyResponserBuilder {

	private List<KeyResponser> responsers;

	/**
	 * @return the responsers
	 */
	public List<KeyResponser> getResponsers() {
		return responsers;
	}

	/**
	 * @param responsers
	 *            the responsers to set
	 */
	public void setResponsers(List<KeyResponser> responsers) {
		this.responsers = responsers;
	}

	public KeyResponser buildKeyResponser() throws KeyResponserException {
		KeyResponser responser = null;

		if (null != responsers) {
			for (int i = 0; i < responsers.size(); i++) {
				if ((i + 1) < responsers.size()) {
					responsers.get(i).setNextResponser(responsers.get(i + 1));
				}
			}
			if (responsers.size() > 0) {
				responser = responsers.get(0);
			} else {
				throw new KeyResponserException("There's no responser defined in responsers chain.");
			}
		} else {
			throw new KeyResponserException("responsers chain is null.");
		}

		return responser;
	}
}
