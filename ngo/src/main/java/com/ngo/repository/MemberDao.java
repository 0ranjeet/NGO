package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngo.model.Member;
@Repository
public interface MemberDao extends JpaRepository<Member, Integer>{
   
   
}
