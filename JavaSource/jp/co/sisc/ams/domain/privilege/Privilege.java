package jp.co.sisc.ams.domain.privilege;

import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * 权限类实体Bean
 * @author lnf
 */
@SuppressWarnings("serial")
public class Privilege extends BaseEntity{
	protected String user_id;
	protected String user_nm;
	protected String pwd;
	
	public Privilege() {
		super();
	}
	public Privilege(String user_id, String pwd) {
		super();
		this.user_id = user_id;
		this.pwd = pwd;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}