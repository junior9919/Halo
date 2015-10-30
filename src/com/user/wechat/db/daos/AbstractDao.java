/**
 * 
 */
package com.user.wechat.db.daos;

/**
 * @author Junior
 * @date 2015年9月21日 下午10:17:51
 * @version 1.0
 * @since
 * @see
 */
public interface AbstractDao<T> {

	public T get(Class<T> clazz, Integer id);

	public Integer save(T obj);

	public void update(T obj);

	public void delete(Class<T> clazz, Integer id);

	public void delete(T obj);

}
