package jp.co.sisc.frame.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import jp.co.sisc.frame.core.dao.IBaseDao;
import jp.co.sisc.frame.core.domain.AbstractVo;
import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 基础Service服务接口实现类
 * @author lnf
 */
public abstract class BaseServiceImpl<T extends AbstractVo> implements IBaseService<T> {

	/**
	 * 获取基础数据库操作类
	 * @return
	 */
	protected abstract IBaseDao<BaseEntity> getBaseDao();

	@Override
	public <V extends T> V queryOne(T query) {
		return null;
	}

	@Override
	public <V extends T> V queryById(String id) {
		return null;
	}

	@Override
	public <V extends T> List<V> queryList(T query) {
		return null;
	}

	@Override
	public <V extends T> List<V> queryAll() {
		return null;
	}

	@Override
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey) {
		return null;
	}

	@Override
	public Long queryCount() {
		return getBaseDao().selectCount();
	}

	@Override
	public Long queryCount(T query) {
		return null;
	}

	@Override
	public void insert(T entity) {
	}

	@Override
	public int delete(T query) {
		return 0;
	}

	@Override
	public int deleteById(String id) {
		return getBaseDao().deleteById(id);
	}

	@Override
	public int deleteAll() {
		return getBaseDao().deleteAll();
	}

	@Override
	public int updateById(T entity) {
		return 0;
	}

	@Override
	public int updateByIdSelective(T entity) {
		return 0;
	}

	@Override
	@Transactional
	public void deleteByIdInBatch(List<String> idList) {
		getBaseDao().deleteByIdInBatch(idList);
	}

	@Override
	@Transactional
	public void insertInBatch(List<T> entityList) {

	}

	@Override
	@Transactional
	public void updateInBatch(List<T> entityList) {

	}
}
