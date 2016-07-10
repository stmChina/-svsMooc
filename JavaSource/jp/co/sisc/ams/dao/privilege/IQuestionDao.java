package jp.co.sisc.ams.dao.privilege;

import java.util.List;

import jp.co.sisc.ams.domain.privilege.Question;

public interface IQuestionDao {
	public List<Question> getQuestions();
}
