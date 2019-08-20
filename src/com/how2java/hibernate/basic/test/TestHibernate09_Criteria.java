package com.how2java.hibernate.basic.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Product;

/**
 * ��ѯ��Criteria
 * Criteria:
 * 	ʹ��Criteria�������ݲ�ѯ�� 
 * 	��HQL��SQL��������Criteria ��ȫ�� �������ķ�ʽ�ڽ������ݲ�ѯ�������ٿ�����sql���ĺۼ�
 *
 */
public class TestHibernate09_Criteria {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * 	ʹ��Criteria ��ѯ����:
		 * 		1��ͨ��session��createCriteria����һ��Criteria ����
		 * 		2��Criteria.add ����Լ���� �ڱ���������һ����name��ģ����ѯ(like)
		 * 		3������list()�������ز�ѯ����ļ���
		 * ����֮�⣬Criteria �����Ժܷ���Ľ��н��з�ҳ��ѯ�ͻ�ȡ����
		 */
		
		String name = "iphone";
		Criteria c = s.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%" + name + "%"));
		List<Product> ps = c.list();
		for (Product product : ps) {
			System.out.println(product.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
