package jp.co.sisc.ams.domain.privilege;


/**
 * 返回给页面的对象,在controller里面转成Json对象
 * @author lnf
 */
@SuppressWarnings("serial")
public class PrivilegeVo extends Privilege{
	protected String user_id;
	protected String user_nm;
	protected String pwd;
	
	public PrivilegeVo() {
		super();
	}
	public PrivilegeVo(String user_id, String pwd) {
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