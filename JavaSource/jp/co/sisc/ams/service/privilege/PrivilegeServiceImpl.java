package jp.co.sisc.ams.service.privilege;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sisc.ams.dao.privilege.IPrivilegeDao;
import jp.co.sisc.ams.domain.privilege.Privilege;
import jp.co.sisc.ams.domain.privilege.PrivilegeVo;
import jp.co.sisc.frame.core.dao.IBaseDao;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.service.BaseServiceImpl;

/**
 * 权限服务类接口实现
 * @author lnf
 */
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<BaseEntity> implements IPrivilegeService {
	@Autowired
	private IPrivilegeDao privilegeDao;

	@Override
	protected IBaseDao<BaseEntity> getBaseDao() {
		return privilegeDao;
	}

	@Override
	public PrivilegeVo selectUser(BaseEntity query) {
		Privilege privilege = privilegeDao.selectUser(query);
		// 中间转换 以后再加
		PrivilegeVo vo = new PrivilegeVo();
		try {
			BeanUtils.copyProperties(vo, privilege);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
}
