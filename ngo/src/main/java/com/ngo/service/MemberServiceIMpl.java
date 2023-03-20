package com.ngo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ngo.exception.MemberException;
import com.ngo.model.Member;
import com.ngo.repository.MemberDao;

@Service
public class MemberServiceIMpl implements MemberService{
	@Autowired
	private MemberDao mDao;
	
	@Override
	public Member registerMember(Member member) {
		
	Member sMember  = mDao.save(member);

		return sMember;
	}

	@Override
	public Member getMemberById(Integer id) throws MemberException {
		// TODO Auto-generated method stub
		return mDao.findById(id).orElseThrow(() -> new MemberException("Member does not exist with name :" + id));
	}

	@Override
	public List<Member> getAllMemberDetails() throws MemberException {
		// TODO Auto-generated method stub
		List<Member> members = mDao.findAll();

		if (members.size() == 0)
			throw new MemberException("No Member found..");
		else
			return members;
		}

	@Override
	public Member deleteMemberById(Integer id) throws MemberException {
		Optional<Member> opt = mDao.findById(id);

		if (opt.isPresent()) {

			Member existingMember = opt.get();

			mDao.delete(existingMember);

			return existingMember;

		} else
			throw new MemberException("Member does not exist with name :" + id);
	}

	@Override
	public Member updateMemberDetails(Member member) throws MemberException {
Optional<Member> opt= mDao.findById(member.getMid());
		
		if(opt.isPresent()) {
			
			//this save method perform 2 operation 1. insert 2 merge
			Member updatedMember= mDao.save(member);
			
			return updatedMember;
			
			
		}else
			throw new MemberException("Invalid Member details..");
	}

	

	

}
