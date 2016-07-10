package jp.co.sisc.ams.domain.privilege;

import java.util.List;

import jp.co.sisc.frame.core.domain.BaseEntity;
import jp.co.sisc.ams.domain.privilege.TestResultDtl;

/**
 * 权限类实体Bean
 * @author lnf
 */
@SuppressWarnings("serial")
public class TestResult extends BaseEntity{
	protected int rid;
	
	protected int schTime;
	protected int castTime;
	protected float score;
	protected List<TestResultDtl> dtls;
	public List<TestResultDtl> getDtls() {
		return dtls;
	}

	public void setDtls(List<TestResultDtl> dtls) {
		this.dtls = dtls;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getSchTime() {
		return schTime;
	}

	public void setSchTime(int schTime) {
		this.schTime = schTime;
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

	public List<TestResultDtl> getTestResultDtls() {
		return testResultDtls;
	}

	public void setTestResultDtls(List<TestResultDtl> testResultDtls) {
		this.testResultDtls = testResultDtls;
	}

	protected List<TestResultDtl> testResultDtls;
	
	public TestResult() {
		super();
	}
	
}