package jp.co.sisc.ams.dao.privilege;

import org.springframework.stereotype.Repository;

import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.frame.core.dao.BaseDaoImpl;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.exception.DaoException;

/**
 * 权限操作类
 * @author lnf
 */
@Repository
public class PrivilegeDaoImpl extends BaseDaoImpl<BaseEntity> implements IPrivilegeDao {

	@Override
	protected String getDefaultSqlNamespace() {
		return Privilege.class.getCanonicalName();
	}

	@Override
	public Privilege selectUser(BaseEntity query) {
		try {
			return sqlSessionTemplate.selectOne(getSqlName("selectOne"), query);
		} catch (Exception e) {
			throw new DaoException(String.format("查询一条记录出错！语句：%s", getSqlName("selectOne")), e);
		}
	}
}
