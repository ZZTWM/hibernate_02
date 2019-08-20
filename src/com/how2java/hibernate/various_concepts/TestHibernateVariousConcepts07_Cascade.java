package com.how2java.hibernate.various_concepts;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.how2java.pojo.Category;
import com.how2java.pojo.Product;
/**
 * ����:
 * 	����-���£�
 * 	save-update������
 * 	Category.hbm.xml���ã�
 * 	<set name="products" cascade="save-update" lazy="false">
 *
 */
public class TestHibernateVariousConcepts07_Cascade {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Category c = (Category) s.get(Category.class, 5);
		System.out.println(c.getName());
		
		/**
		 * ��������ڲ����ü����� cascade="save-update"�ͻᱨ����Ϊ��
		 * 	new��Product�¶�����δ����֮ǰ�ֽ��������һ����new�Ķ���Category����Ҳ�����ǳ־�̬��
		 */
		
        Product p1 = new Product();
        p1.setName("����4s");
        Product p2 = new Product();
        p2.setName("����5s");
        Product p3 = new Product();
        p3.setName("����6s");
        
        c.getProducts().add(p1);
        c.getProducts().add(p2);
        c.getProducts().add(p3);
		
		s.getTransaction().commit();
		s.close();
		sf.close();
		
	}
}	
