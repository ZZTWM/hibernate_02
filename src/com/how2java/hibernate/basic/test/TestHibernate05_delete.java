package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ɾ����
 * 	����id�Ѷ���ӱ���ɾ���� 
 * 	ע��:hibernate��ɾ��һ������֮ǰ����Ҫͨ��id��������¼ȡ����
 * @author Administrator
 *
 */
public class TestHibernate05_delete {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 5);
		s.delete(p);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
