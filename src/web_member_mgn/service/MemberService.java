package web_member_mgn.service;

import web_member_mgn.dao.impl.MemberDaoImpl;
import web_member_mgn.ds.JndiDS;
import web_member_mgn.dto.Member;

public class MemberService {
	
	private MemberDaoImpl dao;

	
	public MemberService() {		
		dao = MemberDaoImpl.getInstance();
		dao.setCon(JndiDS.getConnection());
		
		
	}
	
	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	public void joinMember(Member member) {
		dao.insertMember(member);
	}
	

}
