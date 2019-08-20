package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ����Session��ʽ��
 * Hibernate�����ַ�ʽ���session,�ֱ��ǣ� 
 * 	openSession��getCurrentSession 
 * 	���ǵ��������� 
 * 	1. ��ȡ���Ƿ���ͬһ��session���� 
 * 		openSessionÿ�ζ���õ�һ���µ�Session���� 
 * 		getCurrentSession��ͬһ���߳��У�ÿ�ζ��ǻ�ȡ��ͬ��Session���󣬵����ڲ�ͬ���߳��л�ȡ���ǲ�ͬ��Session���� 
 * 	2. �����ύ�ı�Ҫ�� 
 * 		openSessionֻ�������ӣ�ɾ�����޸ĵ�ʱ����Ҫ���񣬲�ѯʱ����Ҫ�� 
 * 		getCurrentSession�����в�����������������н��У������ύ�����session���Զ��رգ����ܹ��ٽ��йر� 
 *
 */
public class TestHibernateVariousConcepts16_TwoSession {
	public static void main(String[] args) throws InterruptedException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		/**
		 * openSession��ѯʱ����Ҫ����
		 * 	����������ӣ��޸ģ�ɾ���Ǳ��������������еġ� 
		 * 	��������ǲ�ѯ����get����ô����openSession���ԾͲ���Ҫ���������н���
		 */
		//s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 5);
		System.out.println(p.getName() + p.getPrice());
		
		//s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
