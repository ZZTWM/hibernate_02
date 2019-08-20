package com.how2java.hibernate.relationship.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
import com.how2java.pojo.User;

/**
 * 多对多：
 * 	一种Product可以被多个User购买 
 * 	一个User可以购买多种Product 
 * 	所以Product和User之间的关系是多对多 many-to-many 
 * 	要实现多对多关系，必须有一张中间表 user_product 用于维护 User和Product之间的关系
 *
 */
public class TestHibernateRelationship03_Many_To_Many {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		//增加3个用户
		Set<User> users = new HashSet<>();
		for (int i = 0; i < 3; i++) {
			User u = new User();
			u.setName("user" + i);
			users.add(u);
			s.save(u);
		}
		
		Product p1 = (Product) s.get(Product.class, 1);
		p1.setUsers(users);
		s.save(p1);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
