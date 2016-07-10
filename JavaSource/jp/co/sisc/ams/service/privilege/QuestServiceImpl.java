package jp.co.sisc.ams.service.privilege;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.sisc.ams.dao.privilege.IPrivilegeDao;
import jp.co.sisc.ams.dao.privilege.IQuestionDao;
import jp.co.sisc.ams.domain.privilege.Question;
import jp.co.sisc.frame.core.dao.IBaseDao;
import jp.co.sisc.frame.core.domain.AbstractVo;
import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.frame.core.service.BaseServiceImpl;

@Service
public class QuestServiceImpl extends BaseServiceImpl<AbstractVo> implements IQuestService {
	@Autowired
	private IQuestionDao questionDao;
	
	@Override
	public List<Question> getQuestions() {
		System.out.print(this.getClass().getName() + "^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return questionDao.getQuestions();
	}

	@Override
	protected IBaseDao<BaseEntity> getBaseDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
