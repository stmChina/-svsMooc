package jp.co.sisc.ams.domain.privilege;

import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 权限类实体Bean
 * @author lnf
 */
@SuppressWarnings("serial")
public class TestResultDDtl extends BaseEntity{
	protected Answer answer;

	protected String disorder;
	protected String selected;

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public String getDisorder() {
		return disorder;
	}

	public void setDisorder(String disorder) {
		this.disorder = disorder;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	public TestResultDDtl() {
		super();
	}
	
}