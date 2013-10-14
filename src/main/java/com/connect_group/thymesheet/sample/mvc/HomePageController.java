package com.connect_group.thymesheet.sample.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.connect_group.thymesheet.sample.beans.LinkBean;

@Controller
public class HomePageController {

	@RequestMapping(value="/")
	public ModelAndView doHomepage() {
		return new ModelAndView("home");
	}

	@ModelAttribute("links")
	public List<LinkBean> getRelatedLinks() {
		ArrayList<LinkBean> links = new ArrayList<LinkBean>();
		links.add(new LinkBean("https://github.com/connect-group/thymesheet", "Thymesheet on GitHub"));
		links.add(new LinkBean("http://www.thymeleaf.org/", "Thymeleaf Homepage"));
		links.add(new LinkBean("http://www.connect-group.com/", "Connect Group Homepage"));
		return links;
		
	}
}
