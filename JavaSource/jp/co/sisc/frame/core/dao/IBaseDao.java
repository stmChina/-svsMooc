package jp.co.sisc.frame.core.dao;

import java.util.List;
import java.util.Map;

import jp.co.sisc.frame.core.domain.BaseEntity;

/**
 * Dao层接口,定义基本数据库操作.
 * @author lnf
 */
public interface IBaseDao<T extends BaseEntity> {

	/**
	 * 查询一个对象，如果返回的结果多于一个对象将会抛出TooManyResultsException
	 * @param obj 查询对象，不能为null
	 * @return Mapper中映射的对象，继承自 T对象，一般是Vo对象
	 */
	public <V extends T> V selectOne(T query);

	/**
	 * 通过Id查询一个对象，如果id为null这会抛出IllegalArgumentException异常
	 * @param id 主键，不能为null
	 * @return  结果对象，如果未找到返回null
	 */
	public <V extends T> V selectById(String id);

	/**
	 * 查询对象列表
	 * @param query 查询参数，如果未null则查询所有，相当于调用方法{@selectAll }
	 * @return 结果对象列表
	 */
	public <V extends T> List<V> selectList(T query);

	/**
	  * 查询所有记录列表
	 * @return List 结果列表
	 */
	public <V extends T> List<V> selectAll();

	/**
	 * 根据结果集中的一列作为key，将结果集转换成Map
	 * @param <K> 返回Map的key类型
	 * @param <V> 返回Map的Value类型
	 * @param query 查询参数,如果未null则查询所有对象
	 * @param mapKey 返回结果List中‘mapKey’属性值作为Key
	 * @return Map 包含key属性值的Map对象
	 */
	public <K, V extends T> Map<K, V> selectMap(T query, String mapKey);

	/**
	 * 查询总记录数
	 * @return long 记录总数
	 */
	public Long selectCount();

	/**
	 * 查询记录数
	 * @param query 查询对象，如果为null，则查询对象总数
	 * @return long 记录总数
	 */
	public Long selectCount(T query);

	/**
	 * 添加对象,如果要添加的对象没有设置Id或者Id为空字符串或者是空格，则添加数据之前会调用 generateId()方法设置Id
	 * @param entity 要实例化的实体，不能为null
	 * @return 受影响的结果数
	 */
	public void insert(T entity);

	/**
	 * 删除对象
	 * @param entity 要删除的实体对象，不能为null
	 * @return int 受影响结果数
	 */
	public int delete(T query);

	/**
	 * 根据Id删除对象
	 * @param id 要删除的ID，不能为null
	 * @return int 受影响结果数
	 */
	public int deleteById(String id);

	/**
	 * 删除所有
	 * @return int 受影响结果数
	 */
	public int deleteAll();

	/**
	 * 更新对象，对象必须设置ID
	 * @param entity 实体的Id不能为null
	 * @return int 受影响结果数
	 */
	public int updateById(T entity);

	/**
	 * 更新对象中已设置的字段，未设置的字段不更新
	 * @param entity 要更新的实体对象，不能为null，切ID必须不为null
	 * @return int 受影响结果数
	 */
	public int updateByIdSelective(T entity);

	/**
	 * 根据id，批量删除记录，如果传入的列表为null或为空列表则直接返回
	 * @param idList 批量删除ID列表
	 */
	public void deleteByIdInBatch(List<String> idList);

	/**
	 * 批量插入，如果为空列表则直接返回
	 * @param entityList 需要批量插入的实体对象列表
	 */
	public void insertInBatch(List<T> entityList);

	/**
	 * 批量更新，该方法根据实体ID更新已设置的字段，未设置的字段不更新
	 * @param entityList 批量更新的实体对象列表
	 */
	public void updateInBatch(List<T> entityList);

}
