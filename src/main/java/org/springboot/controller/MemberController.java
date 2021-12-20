package org.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springboot.entity.Member;
import org.springboot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberRepository mRpo;
	
	@GetMapping("/memberSignUp")
	public String memberSignUp() {
		 
		System.out.println("회원가입페이지 이동");
		
		return "/member/memberSignUp";
	}
	
	@GetMapping("/memberList")
	public String memberList(Model model) {
		 
		System.out.println("회원목록페이지 이동");
		
		List<Member> memberList = mRpo.findAll();
		
		model.addAttribute("memberList", memberList);
		
		System.out.println("?????????????");
		
		return "/member/memberList";
	}
	
	@GetMapping("/memberinfo")
	public String memberinfo(Member member, Model model) {
		 
		System.out.println("회원개인페이지 이동");
		
		Optional<Member> selectByOne = mRpo.findById(member.getMNo());
		System.out.println(selectByOne);
		model.addAttribute("selectByOne", selectByOne.get());
		
		
		System.out.println("회원개인페이지 끝");
		
		return "/member/memberinfo";
	}
	
	@PostMapping("/insert")
	   public String insert(Member member) {
	      
	      System.out.println("회원가입 시작");
	       
	      mRpo.save(member);
	      System.out.println(member);
	      System.out.println("회원가입 완료"); 
	      
	      return "redirect:/";
	   }
	
	@GetMapping("/delete")
	   public String delete(Member member) {
	      
	      System.out.println("회원 삭제 시작");
	       
	      mRpo.deleteById(member.getMNo());
	      System.out.println("회원 삭제 완료"); 
	      
	      return "redirect:/member/memberList";
	   }
	
	@PostMapping("/update")
	   public String update(Member member, Model model) {
	      
	      System.out.println("회원 수정 시작");
	       
	      mRpo.save(member);
	      System.out.println(member);
	     
	      Long mNo=member.getMNo();
	      
	      System.out.println("회원 수정 완료"); 
	      
	      return "redirect:/member/memberinfo?mNo="+mNo;
	   }
}
