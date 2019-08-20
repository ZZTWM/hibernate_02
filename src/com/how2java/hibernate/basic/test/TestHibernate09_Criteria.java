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
 * 查询：Criteria
 * Criteria:
 * 	使用Criteria进行数据查询。 
 * 	与HQL和SQL的区别是Criteria 完全是 面向对象的方式在进行数据查询，将不再看到有sql语句的痕迹
 *
 */
public class TestHibernate09_Criteria {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * 	使用Criteria 查询数据:
		 * 		1、通过session的createCriteria创建一个Criteria 对象
		 * 		2、Criteria.add 增加约束。 在本例中增加一个对name的模糊查询(like)
		 * 		3、调用list()方法返回查询结果的集合
		 * 除此之外，Criteria 还可以很方便的进行进行分页查询和获取总数
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
