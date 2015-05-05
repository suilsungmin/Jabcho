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
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´� getParameter�δ� id���� ������.
		memberDAOService.insertMember(m);
		System.out.println("insert complet");
		// �Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMember();
		result.addObject("result", memberList);
		result.setViewName("main");
	}
	
	public List<Member> getMember() {
		// HttpServletRequest�� �̿��Ͽ� main.jsp�κ��� ���� �����´� getParameter�δ� id���� ������.
		System.out.println("get member");
		// �Ʒ��κ��� select���� result.jsp���Ͽ� �����ֱ� ���� �ǻ��.
		ModelAndView result = new ModelAndView();
		List<Member> memberList = memberDAOService.getMember();
		result.addObject("result", memberList);
		result.setViewName("main");
		return memberList;
	}
}