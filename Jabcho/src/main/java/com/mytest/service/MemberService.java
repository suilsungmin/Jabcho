package com.mytest.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.DAO.Member;
import com.mytest.DAO.MemberDAOService;

@Service
public class MemberService implements MemberServiceImpl{
	@Autowired
	private MemberDAOService memberDAOService;
	private static final Logger logger = LoggerFactory
			.getLogger(MemberService.class);

	public void insert(Member m) {
		// HttpServletRequest를 이용하여 main.jsp로부터 값을 가져온다 getParameter로는 id값을 가져옴.
		memberDAOService.insertMember(m);
		System.out.println("insert complet");
		// 아래부분은 select값을 result.jsp파일에 보여주기 위해 또사용.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMember();
		result.addObject("result", memberList);
		result.setViewName("main");
	}
	
	public List<Member> getMember() {
		// HttpServletRequest를 이용하여 main.jsp로부터 값을 가져온다 getParameter로는 id값을 가져옴.
		System.out.println("get member");
		// 아래부분은 select값을 result.jsp파일에 보여주기 위해 또사용.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMember();
		result.addObject("result", memberList);
		result.setViewName("main");
		return memberList;
	}
}
