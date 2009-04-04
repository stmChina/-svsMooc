package jp.co.sisc.ams.service.privilege;

import jp.co.sisc.ams.domain.privilege.PrivilegeVo;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.service.IBaseService;

/**
 * 权限服务类
 * @author lnf
 */
public interface IPrivilegeService extends IBaseService<BaseEntity>{
	/**
	 * 用户信息取得
	 * @param BaseEntity
	 * @return
	 */
	public PrivilegeVo selectUser(BaseEntity query);
}
