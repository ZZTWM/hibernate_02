package com.how2java.hibernate.relationship.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/**
 * 多对一
 * 	一个Product对应一个Category 
 * 	一个Category对应多个Product
 * 	所以Product和Category是多对一的关系 
 * @author Administrator
 *
 */
public class TestHibernateRelationship01_Many_To_One {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("苹果手机");
		s.save(c);
		/**
		 * 在这个测试例子中，增加了一个新的Category对象"苹果手机" 
		 * 并将其设置为id=8的product的category
		 */
		Product p = (Product) s.get(Product.class, 8);
		p.setCategory(c);
		s.update(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
