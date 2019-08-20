package com.how2java.hibernate.relationship.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;

/**
 * һ�Զࣺ
 * 	һ��Product��Ӧһ��Category 
 * 	һ��Category��Ӧ���Product 
 * 	����Category��Product��һ�Զ�Ĺ�ϵ 
 * 	�����������ʹ��Hibernateʵ��һ�Զ��ϵ
 *
 */
public class TestHibernateRelationship02_One_To_Many {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category) s.get(Category.class, 2);
		Set<Product> ps = c.getProducts();
		for (Product product : ps) {
			System.out.println(product.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
