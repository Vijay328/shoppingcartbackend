package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class CategoryTest {
public static void main(String[]args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	CategoryDAO categoryDAO= (CategoryDAO) context.getBean("CategoryDAO");
	Category category=(Category)context.getBean("CategoryDAO");
	category.setID("CG120");
    category.setName("");
    category.setDescription("");
    categoryDAO.saveOrUpdate(category);
    if(categoryDAO.get("sdfsf")==null)
    {
    	System.out.println("category does not exist");
    }
    else
    {
    	System.out.println("category exists..the deatils are...");
    	System.out.println();
    }
    
}
}
