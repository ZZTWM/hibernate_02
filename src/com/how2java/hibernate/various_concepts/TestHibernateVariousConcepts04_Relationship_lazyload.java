package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;

/**
 * ��ϵ���ӳټ���
 * 	�ӳټ����ֽ�lazyload����one-many many-many��ʱ�򶼿���ʹ�ù�ϵ���ӳټ���
 * 	Category.hbm.xml�����ã�
 * 	lazy="true"
 * @author Administrator
 *
 */
public class TestHibernateVariousConcepts04_Relationship_lazyload {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * ����̨��ӡ���ݣ�
		 * 	Hibernate: select category0_.id as id2_0_, category0_.name as name2_0_ from category_ category0_ where category0_.id=?
		 * 	log1
		 * 	Hibernate: select products0_.cid as cid2_1_, products0_.id as id1_, products0_.id as id0_0_, products0_.name as name0_0_, products0_.price as price0_0_, products0_.cid as cid0_0_ from product_ products0_ where products0_.cid=?
		 * 	Hibernate: select users0_.pid as pid0_1_, users0_.uid as uid1_, user1_.id as id3_0_ from user_product users0_ inner join user_ user1_ on users0_.uid=user1_.id where users0_.pid=?
		 * 	[com.how2java.pojo.Product@5b4bdc]
		 * 	log2
		 */
		
		//get:���Բ��ӳټ��أ�Ҫ����֪���ǲ��ǹ�ϵ���ӳټ��أ�ҪȥCategory.hbm.xml�￴����:
		//lazy="true" : ��ʾ��ϵ�ӳټ���
		//lazy="false"����ʾ��ϵ���ӳټ���
		Category c = (Category) s.get(Category.class, 2);
		
		System.out.println("log1");
		System.out.println(c.getProducts());
		System.out.println("log2");
		
		s.getTransaction();
		s.close();
		sf.close();
	}	
}	
