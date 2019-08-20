package com.how2java.hibernate.various_concepts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Category;

/**
 * 关系的延迟加载
 * 	延迟加载又叫lazyload，在one-many many-many的时候都可以使用关系的延迟加载
 * 	Category.hbm.xml中设置：
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
		 * 控制台打印内容：
		 * 	Hibernate: select category0_.id as id2_0_, category0_.name as name2_0_ from category_ category0_ where category0_.id=?
		 * 	log1
		 * 	Hibernate: select products0_.cid as cid2_1_, products0_.id as id1_, products0_.id as id0_0_, products0_.name as name0_0_, products0_.price as price0_0_, products0_.cid as cid0_0_ from product_ products0_ where products0_.cid=?
		 * 	Hibernate: select users0_.pid as pid0_1_, users0_.uid as uid1_, user1_.id as id3_0_ from user_product users0_ inner join user_ user1_ on users0_.uid=user1_.id where users0_.pid=?
		 * 	[com.how2java.pojo.Product@5b4bdc]
		 * 	log2
		 */
		
		//get:属性不延迟加载，要是想知道是不是关系的延迟加载，要去Category.hbm.xml里看配置:
		//lazy="true" : 表示关系延迟加载
		//lazy="false"：表示关系不延迟加载
		Category c = (Category) s.get(Category.class, 2);
		
		System.out.println("log1");
		System.out.println(c.getProducts());
		System.out.println("log2");
		
		s.getTransaction();
		s.close();
		sf.close();
	}	
}	
