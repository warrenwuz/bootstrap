package com.warren.bootstrap.profile;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wuzhe1159@163.com
 * @date 2018/11/1 20:26
 */
public class DataSourceConfigTest {
	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = DataSourceConfig.class)
	@ActiveProfiles("dev")
	public static class DevDataSourceTest {
		@Autowired
		private DataSource dataSource;

		@Test
		public void shouldBeEmbeddedDatasource() {
			Assert.assertNotNull(dataSource);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			List<String> results = jdbcTemplate.query("select id, name from Things", new RowMapper<String>() {
				@Override
				public String mapRow(ResultSet rs, int rowNum) throws SQLException {
					return rs.getLong("id") + ":" + rs.getString("name");
				}
			});
			Assert.assertEquals(1, results.size());
			Assert.assertEquals("1:A", results.get(0));
		}
	}

	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(classes = DataSourceConfig.class)
	@ActiveProfiles("prod")
	public static class ProductionDataSourceTest {
		@Autowired
		private DataSource dataSource;
		@Test
		public void shouldBeEmbeddedDatasource(){
			Assert.assertNull(dataSource);
		}
	}
}
