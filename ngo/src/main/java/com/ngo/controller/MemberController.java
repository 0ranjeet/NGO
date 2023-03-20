package com.ngo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.ngo.model.Member;
import com.ngo.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;


@CrossOrigin(origins ="*" )
@RestController
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@GetMapping("/token")
    public String getToken() {
        String secretKey = "mySecretKey"; // replace with your own secret key
        String token = Jwts.builder()
                .setSubject("myUser") // replace with your own user subject
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
        return token;
    }
	@PostMapping("/members")
	@Operation(summary = "Save File to the disk", operationId = "1", description = "Save the file to the disk y passing json value")
	public ResponseEntity<Member> registerMemberHandler(
			@RequestBody Member member){
//		System.out.println(member.toString());
		Member registerdMember= mService.registerMember(member); 
		HttpHeaders hh = new HttpHeaders();
		hh.add("Content-Type"," application/json");
		hh.add("Access-Control-Allow-Origin", "*");
		return new ResponseEntity<Member>(registerdMember,hh,HttpStatus.ACCEPTED);
		
		
	}
	@GetMapping("/members/{id}")
	public ResponseEntity<Member> getMemberByIdHandler(@PathVariable("id") Integer id){
		
		Member member= mService.getMemberById(id);
		HttpHeaders hh = new HttpHeaders();
		hh.add("Access-Control-Allow-Origin", "*");
		 hh.add("connection" ,"keep-alive");
		 hh.add("content-type", "application/json" );
		return new ResponseEntity<Member>(member, hh,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/members")
	public ResponseEntity<List<Member>> getAllMemberHandler(){
		
		List<Member> members= mService.getAllMemberDetails();
		HttpHeaders hh = new HttpHeaders();
		hh.add("Access-Control-Allow-Origin", "*");
		 hh.add("connection" ,"keep-alive");
		 hh.add("content-type", "application/json" );
		 

		
		return new ResponseEntity<List<Member>>(members,hh,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Member> deleteMemberByIdHandler(@PathVariable("id") Integer id){
		
		Member deletedMember= mService.deleteMemberById(id);
		HttpHeaders hh = new HttpHeaders();
		hh.add("Access-Control-Allow-Origin", "*");
		 hh.add("connection" ,"keep-alive");
		 hh.add("content-type", "application/json" );
		return new ResponseEntity<Member>(deletedMember,hh, HttpStatus.OK);
		
		
	}
	
	
	@PutMapping("/members")
	public ResponseEntity<Member> updateMemberHandler(@RequestBody Member member){
		
		Member updatedMember= mService.updateMemberDetails(member);
		
		return new ResponseEntity<Member>(updatedMember,HttpStatus.ACCEPTED);
		
	}

}
