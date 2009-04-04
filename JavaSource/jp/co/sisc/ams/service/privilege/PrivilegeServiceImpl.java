package jp.co.sisc.ams.service.privilege;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sisc.ams.dao.privilege.IPrivilegeDao;
import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.ams.domain.privilege.PrivilegeVo;
import jp.co.sisc.frame.core.dao.IBaseDao;
import jp.co.sisc.frame.core.domain.AbstractVo;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.service.BaseServiceImpl;
import jp.co.sisc.frame.core.utils.BeanConvertUtil;

/**
 * 权限服务类接口实现
 * @author lnf
 */
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<AbstractVo> implements IPrivilegeService {
	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	protected IBaseDao<BaseEntity> getBaseDao() {
		return privilegeDao;
	}

	@Override
	public PrivilegeVo selectUser(AbstractVo query) {
		Privilege user = privilegeDao.selectUser((BaseEntity) BeanConvertUtil.copyProperties(new Privilege(), query));
		return (PrivilegeVo)BeanConvertUtil.copyProperties(new PrivilegeVo(), user);
	}

}
