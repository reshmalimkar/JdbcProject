package com.springDemo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	@RequestMapping("/add")
public ModelAndView add(HttpServletRequest request,HttpServletResponse response, @RequestParam(name = "t1") int i, @RequestParam(name = "t2") int j) {
	//	int i=Integer.parseInt(request.getParameter("t1"));
		//int j=Integer.parseInt(request.getParameter("t2"));
		int k=i+j;
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("result", k);
		mv.setViewName("display");
	return mv;
}
}
