/*
 * =============================================================================
 *
 *   Copyright (c) 2013, Connect Group (http://www.connect-group.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.connect_group.thymesheet.sample.mvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.connect_group.thymesheet.sample.beans.LinkBean;
import com.connect_group.thymesheet.sample.beans.ProductBean;
import com.connect_group.thymesheet.sample.beans.UserBean;

@Controller
public class HomePageController {

	@RequestMapping(value="/")
	public ModelAndView doHomepage() {
		return new ModelAndView("/html/home.html");
	}

	@ModelAttribute("links")
	public List<LinkBean> getRelatedLinks() {
		ArrayList<LinkBean> links = new ArrayList<LinkBean>();
		links.add(new LinkBean("https://github.com/connect-group/thymesheet", "Thymesheet on GitHub"));
		links.add(new LinkBean("http://www.thymeleaf.org/", "Thymeleaf Homepage"));
		links.add(new LinkBean("http://www.connect-group.com/", "Connect Group Homepage"));
		return links;
	}
	
	@ModelAttribute("allProducts")
	public List<ProductBean> getAllProducts() {
		
		ProductBean p1 = new ProductBean("Pen", 1.00);
		ProductBean p2 = new ProductBean("Pencil", 0.50);
		ProductBean p3 = new ProductBean("Paper", 0.02);
		ProductBean p4 = new ProductBean("Note Book", 2.00);
		
		return Arrays.asList(p1,p2,p3,p4);
	}
	
	@ModelAttribute("users") 
	public List<UserBean> getUsers() {
		UserBean u1 = new UserBean("adz", "A Perry", "United Kingdom");
		UserBean u2 = new UserBean("rhys", "R Charlton", "Outer Mongolia");
		UserBean u3 = new UserBean("leo", "Leonardo", "New York");
		
		return Arrays.asList(u1,u2,u3);
	}
}
