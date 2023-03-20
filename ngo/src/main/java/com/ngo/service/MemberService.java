package com.ngo.service;

import java.util.List;

import com.ngo.exception.MemberException;
import com.ngo.model.Member;

public interface MemberService {

    public Member registerMember(Member member);
	
	public Member getMemberById(Integer id)throws MemberException;
	
	public List<Member> getAllMemberDetails()throws MemberException;
	
	public Member deleteMemberById(Integer id)throws MemberException;
	
	public Member updateMemberDetails(Member member)throws MemberException;
	
}
