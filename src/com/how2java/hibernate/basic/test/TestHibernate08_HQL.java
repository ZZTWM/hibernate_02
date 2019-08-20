package com.how2java.hibernate.basic.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ��ѯ��HQL
 * 	HQL��Hibernate Query Language����hibernateר�����ڲ�ѯ���ݵ���䣬�б���SQL��HQL ���ӽ�����������˼ά��ʽ�� 
 * 	����ʹ�õ����������Product,���Ǳ�������product_	
 *
 */
public class TestHibernate08_HQL {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * 1�����ȸ���hql����һ��Query����
		 * 2�����ò���(�ͻ�1��PreparedStatement��һ����Query�ǻ�0��)
		 * 3��ͨ��Query�����list()���������ز�ѯ�Ľ����
		 * 
		 * 4��ʹ��hql��ʱ���õ�������Product,�����Ǳ���product_
		 * 5��ʹ��hql��ʱ�򣬲���Ҫ��ǰ��� select *
		 */
		String name = "iphone";
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		List<Product> ps = q.list();
		
		for (Product product : ps) {
			System.out.println(product.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
