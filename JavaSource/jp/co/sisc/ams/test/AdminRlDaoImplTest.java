package jp.co.sisc.ams.test;

import jp.co.sisc.ams.dao.mast1600.IPartnerDao;
import jp.co.sisc.ams.domain.mast1600.Partner;
import jp.co.sisc.ams.service.mast1600.IPartnerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author lnf
 * @date 2014年3月3日下午9:48:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class AdminRlDaoImplTest {

	@Autowired
	private IPartnerDao dao;
	@Autowired
	private IPartnerService service;
//
//	@Test
//	public void testSelectListT() {
//		AdminRlTo query = new AdminRlTo();
//		query.setUserid("142");
//		Assert.assertNotNull(adminRlDao.selectList(query));
//		List<AdminRlVo> dicVoList = adminRlDao.selectList(query);
//		for (int i =0; i< dicVoList.size(); i++) {
//			AdminRlVo a = dicVoList.get(i);
//		}
//	}
	@Test
	public void testAop() {
		Partner p = new Partner();
		p.setPar_cd("1");
		p.setPar_nm("2222");
		p.setPms_i_usr("kk");
		p.setPms_i_class("ss");
		//dao.updateById(p);
		
		service.updateById(p);
	}
	
	public void main(String[] args) {
		
		
		
		
	}

}
