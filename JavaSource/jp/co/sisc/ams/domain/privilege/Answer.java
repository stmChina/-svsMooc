package jp.co.sisc.ams.domain.privilege;

import java.util.List;

import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 权限类实体Bean
 * @author lnf
 */
@SuppressWarnings("serial")
public class Answer extends BaseEntity{
	protected int aid;
	protected String aContent;
	protected String correctf;
	public String getCorrectf() {
		return correctf;
	}

	public void setCorrectf(String correctf) {
		this.correctf = correctf;
	}

	public Answer() {
		super();
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	
}