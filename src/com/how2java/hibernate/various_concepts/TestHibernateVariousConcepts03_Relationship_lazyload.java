package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ���Բ��ӳټ��أ�ʹ��get��ʽ�����Բ����ӳټ���
 * 	get��ʽ��ֱ�ӷ������ݿ�
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts03_Relationship_lazyload {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * ����̨������ݣ�
		 * 	Hibernate: select product0_.id as id0_0_, product0_.name as name0_0_, product0_.price as price0_0_, product0_.cid as cid0_0_ from product_ product0_ where product0_.id=?
		 * 	Hibernate: select users0_.pid as pid0_1_, users0_.uid as uid1_, user1_.id as id3_0_ from user_product users0_ inner join user_ user1_ on users0_.uid=user1_.id where users0_.pid=?
		 * 	log1
		 * 	iphone2
		 * 	log2
		 */
		
		Product p = (Product) s.get(Product.class, 4);
		
		System.out.println("log1");
		System.out.println(p.getName());
		System.out.println("log2");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}	
