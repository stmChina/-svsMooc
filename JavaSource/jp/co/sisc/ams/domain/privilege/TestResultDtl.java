package jp.co.sisc.ams.domain.privilege;

import java.util.List;

import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 权限类实体Bean
 * @author lnf
 */
@SuppressWarnings("serial")
public class TestResultDtl extends BaseEntity{
	protected int rdid;

	protected int castTime;
	protected float score;
	protected String correct;
	protected Question question;
	protected int disOrder;
	protected List<TestResultDDtl> dDtls;
	
	public List<TestResultDDtl> getdDtls() {
		return dDtls;
	}

	public void setdDtls(List<TestResultDDtl> dDtls) {
		this.dDtls = dDtls;
	}

	public int getDisOrder() {
		return disOrder;
	}

	public void setDisOrder(int disOrder) {
		this.disOrder = disOrder;
	}

	public int getRdid() {
		return rdid;
	}

	public void setRdid(int rdid) {
		this.rdid = rdid;
	}

	public int getCastTime() {
		return castTime;
	}

	public void setCastTime(int castTime) {
		this.castTime = castTime;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public String isCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<TestResultDDtl> getTestResultDtls() {
		return testResultDtls;
	}

	public void setTestResultDtls(List<TestResultDDtl> testResultDtls) {
		this.testResultDtls = testResultDtls;
	}

	protected List<TestResultDDtl> testResultDtls;
	
	public TestResultDtl() {
		super();
	}
	
}