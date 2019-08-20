package com.how2java.hibernate.various_concepts;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * �������ݿ�����ʱ�Ƚ�����ʱ��ģ�����ͨ������������ݿ����ӳصļ����������������ݿ����ӣ������ڽ�������ʹ�ã��Ӷ���Լ���������ݿ����ӵ�ʱ�� 
 * 	hibernate�������ṩ�����ݿ����ӳصģ�����hibernate����Ҳ���Ƽ�ʹ�����Դ������ݿ����ӳء� 
 * 	һ�㶼��ʹ�õ����������ݿ����ӳ� 
 * 	C3P0����ѵĵ����������ݿ����ӳأ������в���ı��� 
 * 	�ұ߿�������c3p0��jar�� 
 * 	ע�������д��������ʱ�򣬴�����Ч�����������ǿ���������ġ� ֻ���ڸ߲�����������£��Ż���������
 * 	��֪ʶ��Ҫ���ṩ���������ð취���Թ��Ժ�����Ҫ��ʱ�򣬲�ѯ���޸ķ��㡣 
 * 	
 */
public class TestHibernateVariousConcepts22_c3p0_ConnectionPool {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s1 = sf.openSession();
		s1.beginTransaction();
		
		Query q = s1.createQuery("from Product");
		List<Product> products = q.list();
		for (Product product : products) {
			System.out.println(product);
		}
		
		s1.getTransaction().commit();
		s1.close();
		sf.close();
	}
}	
