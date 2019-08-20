package com.how2java.hibernate.various_concepts;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ������������������
 * 	
 */
public class TestHibernateVariousConcepts20_Total_Number {
	public static void main(String[] args) {
		/**
		 * ���Ȼ���׼��һ����ͳ�ƺ��������
		 * 	select count(*) from ....
		 * 	��������SQL��䴴��һ��Query���󣬵���Query�����uniqueResult()����������һ��long�͵����ݣ�����ѯ������
		 */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		
		Query q = s.createQuery("select count(*) from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		
		long total = (Long)q.uniqueResult();
		System.out.println("�����ǣ�" + total);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
