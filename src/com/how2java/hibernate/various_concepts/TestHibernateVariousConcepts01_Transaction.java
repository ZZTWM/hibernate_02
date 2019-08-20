package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ����
 * 	Hibernate���κζ������иĶ��Ĳ�������Ӧ�ñ������������� 
 * 	�������еĶ��������Ϊ��Ҫô���ɹ���Ҫô��ʧ��
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts01_Transaction {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p1 = (Product) s.get(Product.class, 1);
		s.delete(p1);
		
		Product p2 = (Product) s.get(Product.class, 2);
		p2.setName("���ȳ���30���ַ�����Ϊ��Ʒ");
		s.update(p2);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
