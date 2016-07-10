package jp.co.sisc.ams.dao.privilege;

import java.util.List;

import org.springframework.stereotype.Repository;

import jp.co.sisc.ams.domain.privilege.Question;
import jp.co.sisc.frame.core.dao.BaseDaoImpl;
import jp.co.sisc.frame.core.domain.BaseEntity;
@Repository
public class QuestionDaoImpl extends BaseDaoImpl<BaseEntity>  implements IQuestionDao {

	@Override
	public List<Question> getQuestions() {
		System.out.print(this.getClass().getName() + "^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return sqlSessionTemplate.selectList("jp.co.sisc.ams.domain.privilege.Question.getQuestions");
	}

}
