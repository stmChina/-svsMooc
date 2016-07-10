package jp.co.sisc.ams.service.privilege;

import java.util.List;

import jp.co.sisc.ams.domain.privilege.Question;
import jp.co.sisc.frame.core.domain.AbstractVo;
import jp.co.sisc.frame.core.service.IBaseService;

public interface IQuestService extends IBaseService<AbstractVo>  {
	public List<Question> getQuestions();
}
