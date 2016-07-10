package jp.co.sisc.ams.domain.privilege;

import java.util.List;

import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 权限类实体Bean
 * @author lnf
 */
@SuppressWarnings("serial")
public class Question extends BaseEntity{
	protected int qid;
	protected String qContent;
	protected int schTime;
	protected List<Answer> answers;
	protected float score;
	protected String multiSelect;
	public String getMultiSelect() {
		return multiSelect;
	}
	public void setMultiSelect(String multiSelect) {
		this.multiSelect = multiSelect;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Question() {
		super();
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	public int getSchTime() {
		return schTime;
	}
	public void setSchTime(int schTime) {
		this.schTime = schTime;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
}