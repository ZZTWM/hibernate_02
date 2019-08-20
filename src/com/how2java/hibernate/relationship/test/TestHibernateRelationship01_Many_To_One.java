package com.how2java.hibernate.relationship.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/**
 * ���һ
 * 	һ��Product��Ӧһ��Category 
 * 	һ��Category��Ӧ���Product
 * 	����Product��Category�Ƕ��һ�Ĺ�ϵ 
 * @author Administrator
 *
 */
public class TestHibernateRelationship01_Many_To_One {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = new Category();
		c.setName("ƻ���ֻ�");
		s.save(c);
		/**
		 * ��������������У�������һ���µ�Category����"ƻ���ֻ�" 
		 * ����������Ϊid=8��product��category
		 */
		Product p = (Product) s.get(Product.class, 8);
		p.setCategory(c);
		s.update(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
