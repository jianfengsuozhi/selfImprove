package com.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
	public List<Test> list() throws Exception{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			conn = DBUtil.getConnection();
			String sql = "select * from Test";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Test> list = new ArrayList<Test>();
			while(rs.next()){
				Test test = new Test();
				test.setId(rs.getString("id"));
				test.setName(rs.getString("name"));
				list.add(test);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			if(conn!=null){
				DBUtil.closeConnection(conn);
			}
		}			
	}
	
	public Integer count() throws Exception{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) sum from Test";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
           if(rs.next()){
        	   return rs.getInt("sum");
           }
           return null;
		} catch (Exception e) {
			throw e;
		}finally{
			if(conn!=null){
				DBUtil.closeConnection(conn);
			}
		}	    	
	}
	
    public void deleteTest(String id) throws Exception{
		 Connection conn = null;
		 PreparedStatement ps = null;
		 try {
			conn = DBUtil.getConnection();
			String sql = "delete from Test where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
            ps.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally{
			if(conn!=null){
				DBUtil.closeConnection(conn);
			}
		}	    	
    }
    
	public List<Test> onePageInfo(int start,int end) throws Exception{
		 List<Test> list = new ArrayList<Test>();
		 Connection conn = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 try {
			conn = DBUtil.getConnection();
			String sql = "select t.* from(select rownum rn,v.* "+
			             "from(select * from Test order by id desc) v) t " +
					     "where  t.rn between ? and ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			
			while(rs.next()){
				Test t = new Test();
				t.setId(rs.getString("id"));
				t.setName(rs.getString("name"));
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally{
			if(conn!=null){
				DBUtil.closeConnection(conn);
			}
		}
	}
    

}
