package com.connect_group.thymesheet.sample.mvc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.connect_group.thymesheet.sample.beans.ProductBean;

@Controller
public class XmlController {

	@RequestMapping(value="/xml/")
	public ModelAndView doXml() {
		return new ModelAndView("/xml/sample.xml");
	}
	
	@ModelAttribute("allProducts")
	public List<ProductBean> getAllProducts() {
		
		ProductBean p1 = new ProductBean("Pen", 1.00);
		ProductBean p2 = new ProductBean("Pencil", 0.50);
		ProductBean p3 = new ProductBean("Paper", 0.02);
		ProductBean p4 = new ProductBean("Note Book", 2.00);
		
		return Arrays.asList(p1,p2,p3,p4);
	}

}
