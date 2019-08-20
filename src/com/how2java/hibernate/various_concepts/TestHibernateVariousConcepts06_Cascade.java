package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;
/**
 * ����:
 * 	ɾ��
 * 	delete������
 * 	Category.hbm.xml���ã�
 * 	<set name="products" cascade="delete" lazy="false">
 *
 */
public class TestHibernateVariousConcepts06_Cascade {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category) s.get(Category.class, 4);
		System.out.println(c.getName());
		
		s.delete(c);
		System.out.println("ɾ���ɹ�");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
