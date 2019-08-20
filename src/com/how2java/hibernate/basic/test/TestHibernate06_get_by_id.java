package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ��ȡ��ͨ��id��ȡһ������
 * 	����Session��get����������id��ȡ����
 * @author Administrator
 *
 */
public class TestHibernate06_get_by_id {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = (Product)s.get(Product.class, 6);
		System.out.println("id=6�Ĳ�Ʒ�����ǣ�" + p.getName());
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
