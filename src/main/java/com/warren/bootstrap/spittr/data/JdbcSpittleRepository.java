package com.warren.bootstrap.spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/13 10:29
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {

	@Autowired
	private JdbcOperations jdbc;
	@Override
	public List<Spittle> findSpittles(long max, int count) {
		 return jdbc.query(
			"select id, message, created_at, latitude, longitude" +
				" from Spittle" +
				" order by created_at desc limit 20",
			new SpittleRowMapper());
	}

	@Override
	public Spittle findOne(long id) {
		return jdbc.queryForObject(
			"select id, message, created_at, latitude, longitude" +
				" from Spittle" +
				" where id = ?",
			new SpittleRowMapper(), id);
	}

	@Override
	public void save(Spittle spittle) {
		jdbc.update(
			"insert into Spittle (message, created_at, latitude, longitude)" +
				" values (?, ?, ?, ?)",
			spittle.getMessage(),
			spittle.getTime(),
			spittle.getLatitude(),
			spittle.getLongitude());
	}

	private static class SpittleRowMapper implements RowMapper<Spittle> {
		@Override
		public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Spittle(
				rs.getLong("id"),
				rs.getString("message"),
				rs.getDate("created_at"),
				rs.getDouble("longitude"),
				rs.getDouble("latitude"));
		}
	}
}
