package web_member_mgn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.ior.iiop.RequestPartitioningComponent;

import web_member_mgn.dao.MemberDao;
import web_member_mgn.dto.Member;

public class MemberDaoImpl implements MemberDao {
	private static final  MemberDaoImpl instance = new MemberDaoImpl();
	
	
	public static  MemberDaoImpl getInstance() {
		return instance; 
		
		
	}
	private Connection con;
	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public Member selectMemberById(Member member) {	
		String sql = "select id, name, age, gender,email " 
				 + 	 " from member "  
				 +   " where id = ? and passwd = password(?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			
			System.out.println(pstmt);
				try(ResultSet rs = pstmt.executeQuery();){
					if(rs.next()) {
						return getMember(rs);
				}
				}catch(SQLException e) {
					e.printStackTrace();
					}
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				
		
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		int age = rs.getInt("age");
		String gender = rs.getString("gender");
		String email = rs.getString("email");
		
		return new Member(id, name, age, gender, email);
	}

	@Override
	public int insertMember(Member member) {
		String sql = "insert into member values " 
				+ 	 "(?, password(?), ? , ? , ?, ?)";
		try( PreparedStatement pstmt = con.prepareStatement(sql)){
			//id,passwd,name,age,gender,email
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setInt(3, member.getAge());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getEmail());
	
			return pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
