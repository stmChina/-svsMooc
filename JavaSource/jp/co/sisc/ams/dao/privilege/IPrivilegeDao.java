package jp.co.sisc.ams.dao.privilege;

import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.frame.core.dao.IBaseDao;
import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 权限操作类接口
 * @author lnf
 */
public interface IPrivilegeDao extends IBaseDao<BaseEntity>{
	/**
	 * 用户信息取得
	 * @param BaseEntity
	 * @return
	 */
	public Privilege selectUser(BaseEntity query);
}
