package jp.co.sisc.frame.core.domain;

import jp.co.sisc.frame.core.utils.ArmUtil;

/**
 * 持久化对象抽象类
 * @author lnf
 */
public abstract class BaseEntity implements IBaseEntity {

	private static final long serialVersionUID = 1L;
	
	public BaseEntity() {
		super();
	}
	/**
	 * NK字段
	 * Y=被删除，N=正常数据
	 */
	private String del_flag;
	
	private String pms_i_ymd;
	
	private String pms_i_usr;
	
	private String pms_i_class;
	
	private String pms_u_ymd;
	
	private String pms_u_usr;
	
	private String pms_u_class;
	
	// DataBase分页查询起点( limit 5 offset 0),起点0开始查询,返回5条数据
	private int offset;
	// DataBase一页查询多少数据
	private int limit;
	// 前台一页多少条数据,由request自动装配
	private String rows;
	// 前台当前页号,由request自动装配
	private String page;
	// 页面操作的返回结果
	private String result;
	// 页面操作的返回消息
	private String message;
	// 页面操作的被删除行
	private String deleted;
	// 页面操作的被更新行
	private String updated;
	// 页面操作的被插入行
	private String inserted;
	
	// 根据前台分页参数构造DataBase分页
	public void setPageable() {
		String pageSize = getRows();
		String pageNum = getPage();
		// 分页设置
		if (!armUtil.isEmpty(pageSize) && !armUtil.isEmpty(pageNum)) {
			int num = Integer.parseInt(pageNum);
			setLimit(Integer.parseInt(pageSize));
			setOffset((num - 1) * Integer.parseInt(pageSize));
		}
	}
	
	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDeleted() {
		return deleted;
	}

	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getInserted() {
		return inserted;
	}

	public void setInserted(String inserted) {
		this.inserted = inserted;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	public String getPms_i_ymd() {
		return pms_i_ymd;
	}

	public void setPms_i_ymd(String pms_i_ymd) {
		this.pms_i_ymd = pms_i_ymd;
	}

	public String getPms_i_usr() {
		return pms_i_usr;
	}

	public void setPms_i_usr(String pms_i_usr) {
		this.pms_i_usr = pms_i_usr;
	}

	public String getPms_i_class() {
		return pms_i_class;
	}

	public void setPms_i_class(String pms_i_class) {
		this.pms_i_class = pms_i_class;
	}

	public String getPms_u_ymd() {
		return pms_u_ymd;
	}

	public void setPms_u_ymd(String pms_u_ymd) {
		this.pms_u_ymd = pms_u_ymd;
	}

	public String getPms_u_usr() {
		return pms_u_usr;
	}

	public void setPms_u_usr(String pms_u_usr) {
		this.pms_u_usr = pms_u_usr;
	}

	public String getPms_u_class() {
		return pms_u_class;
	}

	public void setPms_u_class(String pms_u_class) {
		this.pms_u_class = pms_u_class;
	}
}
