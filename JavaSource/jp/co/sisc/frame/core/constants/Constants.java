package jp.co.sisc.frame.core.constants;

/**
 * 常量
 * @author lnf
 */
public interface Constants {
	// 校验部分
	public final String DUPLICATE_KEY = "DUPLICATE_KEY";
	public final String OTHER_EXCEPTION = "OTHER_EXCEPTION";
	public final String SUCCESS = "SUCCESS";
	public final String FAILURE = "FAILURE";
	// 权限部分
	public final String PRIVILEGE_TYPE_SEARCH = "0";	// 查询权限
	public final String PRIVILEGE_TYPE_ADD = "1"; 		// 增权限
	public final String PRIVILEGE_TYPE_DELETE = "2";	// 删权限
	public final String PRIVILEGE_TYPE_UPDATE = "3";	// 改权限
	public final String PRIVILEGE_TYPE_EXCEL = "4";		// excel出力权限
	public final String PRIVILEGE_TYPE_PDF = "5";		// PDF出力权限
}
