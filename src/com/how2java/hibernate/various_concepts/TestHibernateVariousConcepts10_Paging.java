package com.how2java.hibernate.various_concepts;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.how2java.pojo.Product;

/**
 * 
 * ��ҳ��
 * 	ʹ��Criteria���з�ҳ��ѯ 
 * 	������ʹ�õ���Oracle,Mysql,NoSQL����DB2����ҳ��ѯ�Ĵ���д������һ����
 * 
 *
 */
public class TestHibernateVariousConcepts10_Paging {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		Criteria c = s.createCriteria(Product.class);
		c.add(Restrictions.like("name", "%"+name+"%"));
		c.setFirstResult(2);//�ӵ�3�����ݿ�ʼ
		c.setMaxResults(5);//��ʾһ����ѯ5������
		
		List<Product> ps = c.list();
		for (Product product : ps) {
			System.out.println(product.getName());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}	
