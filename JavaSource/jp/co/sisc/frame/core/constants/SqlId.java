package jp.co.sisc.frame.core.constants;

/**
 * Mybatis Sql脚本的ID名称
 * @author lnf
 */
public interface SqlId {
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_SELECT_ONE = "selectOne";
	public String SQL_SELECT_BY_ID = "selectById";
	public String SQL_UPDATE_BY_ID = "updateById";
	public String SQL_UPDATE_BY_ID_SELECTIVE = "updateByIdSelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_BY_ID = "deleteById";
	public String SQL_INSERT = "insert";
}
