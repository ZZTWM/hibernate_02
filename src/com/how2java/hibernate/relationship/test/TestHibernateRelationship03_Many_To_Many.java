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
 * ��Զࣺ
 * 	һ��Product���Ա����User���� 
 * 	һ��User���Թ������Product 
 * 	����Product��User֮��Ĺ�ϵ�Ƕ�Զ� many-to-many 
 * 	Ҫʵ�ֶ�Զ��ϵ��������һ���м�� user_product ����ά�� User��Product֮��Ĺ�ϵ
 *
 */
public class TestHibernateRelationship03_Many_To_Many {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		//����3���û�
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
