package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;
/**
 * 属性延迟加载：
 * 	load方式：
 * 	当使用load的方式来获取对象的时候，只有访问了这个对象的属性，
 * 	hibernate才会到数据库中进行查询。
 * 	否则不会访问数据库
 *
 */
public class TestHibernateVariousConcepts02_Property_lazyload {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * 在打印log1之前，是不会打印出sql语句的，只有在访问属性“getName()"的时候，才会访问数据库
		 * 控制台输出的内容：
		 * 	log1
		 * 	Hibernate: select product0_.id as id0_0_, product0_.name as name0_0_, product0_.price as price0_0_, product0_.cid as cid0_0_ from product_ product0_ where product0_.id=?
		 * 	Hibernate: select users0_.pid as pid0_1_, users0_.uid as uid1_, user1_.id as id3_0_ from user_product users0_ inner join user_ user1_ on users0_.uid=user1_.id where users0_.pid=?
		 * 	iphone1
		 * 	log2
		 */
		Product p = (Product) s.load(Product.class, 3);
		
		System.out.println("log1");
		System.out.println(p.getName());
		System.out.println("log2");
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}	
