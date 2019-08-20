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
public class TestHibernateVariousConcepts17_TwoSession {
	public static void main(String[] args) throws InterruptedException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.getCurrentSession();
		/**
		 * getCurrentSession���в������������������
		 * ����getCurrentSession�������в�����������������У������ڲ�ѯ��get����Ҫ����
		 */
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 5);
		System.out.println("�ֻ�Ʒ�ƣ�"+p.getName() + "\t" + "�ֻ��۸�" + p.getPrice());
		
		s.getTransaction().commit();
		/**
		 * getCurrentSession���Զ��رյ�
		 */
		//s.close();
		sf.close();
		
	}
}	
