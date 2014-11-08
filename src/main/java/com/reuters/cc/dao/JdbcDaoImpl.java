package com.reuters.cc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.reuters.cc.model.Circle;


@Component
public class JdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	/*
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
*/

	/*public Circle getCircle(int circleId){

		
		Connection conn = null;
		
		try{

		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from circle where id = ?");
		ps.setInt(1, circleId);
		
		Circle circle = null;
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			circle = new Circle(circleId,rs.getString("name"));
		}
		rs.close();
		ps.close();
		
		return circle;
		}
		catch(Exception exception){
			throw new RuntimeException(exception);
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	*/
	public int getCircleCount(){
		
		String SQL = "select count(*) from circle";
		
		
		return jdbcTemplate.queryForInt(SQL);
	}
	
	public String getCircleName(int circleId){
		String SQL = "select name from circle where id = ?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {circleId},String.class);
	}
	
	public Circle getCirclForId(int circleId){
		
		String sql = "select * from circle where id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{circleId} , new CircleMapper());
	}
	
	public List<Circle> getAllCircles(){
		
		String sql = "select * from circle";
		
		return jdbcTemplate.query(sql, new CircleMapper());
		
	}
	
/*	public void insertCircle(Circle circle){
		
		String sql = "insert into circle (id, name) values (?,?) ";
		
		jdbcTemplate.update(sql, new Object[]{circle.getId(),circle.getName()});
	}
	*/
	public void insertCircle(Circle circle){
		
		String sql = "insert into circle (id, name) values (:id, :name) ";
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("id",circle.getId())
											.addValue("name", circle.getName());
		
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	
	
	public void createTriangleTable(){
		String sql = "create table triangle (id integer,name varchar(50))";
		jdbcTemplate.execute(sql);
		
	}
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {

			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			
			return circle;
		}
		
	}
}
