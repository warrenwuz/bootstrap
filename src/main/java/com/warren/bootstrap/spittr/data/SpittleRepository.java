package com.warren.bootstrap.spittr.data;

import java.util.List;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 10:20
 */
public interface SpittleRepository {
	/**
	 * 查询消息列表
	 * @param max
	 * @param count
	 * @return
	 */
	List<Spittle> findSpittles(long max,int count);

	/**
	 * 查询单个实体
	 * @param id
	 * @return
	 */
	Spittle findOne(long id);

	/**
	 * 保存实体
	 * @param spittle
	 */
	void save(Spittle spittle);

}
