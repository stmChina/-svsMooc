package jp.co.sisc.frame.core.domain;

import java.io.Serializable;

/**
 * 业务实体对象基本接口,继承可序列化类.
 * Id为持久化对象唯一标识
 * @author lnf
 */
public interface IBaseEntity extends Serializable {
	/**
	 * 获取主键
	 * @return
	 */
	//public String getId();

	/**
	 * 设置ID属性
	 * @param id
	 */
	//public void setId(String id);
}
