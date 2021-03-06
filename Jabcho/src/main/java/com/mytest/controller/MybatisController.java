package com.mytest.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mytest.DAO.Member;
import com.mytest.DAO.MemberDAOService;

@Controller
public class MybatisController {
	@Autowired
	private MemberDAOService memberDAOService;
	private static final Logger logger = LoggerFactory
			.getLogger(MybatisController.class);

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request) {
		// HttpServletRequest를 이용하여 main.jsp로부터 값을 가져온다 getParameter로는 id값을 가져옴.
		Member member = new Member();
		member.set_name((String) request.getParameter("name"));
		member.set_email((String) request.getParameter("email"));
		member.set_gender((String) request.getParameter("gender"));
		if (((String) request.getParameter("name")).equals(member.get_name())
				&& ((String) request.getParameter("email")).equals(member
						.get_email())) {
			System.out.println("Duplication name & email!!");
			memberDAOService.getMember();
			ModelAndView result = new ModelAndView();
			List<Member> memberList = memberDAOService.getMember();
			result.addObject("result", memberList);
			result.setViewName("main");
			return result;
		} else {
			memberDAOService.insertMember(member);
			System.out.println("insert complet");
			ModelAndView result = new ModelAndView();
			List<Member> memberList = memberDAOService.getMember();
			result.addObject("result", memberList);
			result.setViewName("main");
			return result;
		}
		// 아래부분은 select값을 result.jsp파일에 보여주기 위해 또사용.

	}

}