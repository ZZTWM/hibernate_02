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
 * 查询：标准sql
 * 通过标准SQL语句进行查询:
 * 	Hibernate依然保留了对标准SQL语句的支持，在一些场合，比如多表联合查询，并且有分组统计函数的情况下，标准SQL语句依然是效率较高的一种选择
 * @author Administrator
 *
 */
public class TestHibernate10_Standard_SQL {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		/**
		 * 使用Session的createSQLQuery方法执行标准SQL语句
		 * 因为标准SQL语句有可能返回各种各样的结果，比如多表查询，分组统计结果等等。 
		 * 不能保证其查询结果能够装进一个Product对象中，所以返回的集合里的每一个元素是一个对象数组。
		 * 然后再通过下标把这个对象数组中的数据取出来。
		 */
		String name = "iphone";
		//sql ： SELECT * FROM product_ p where p.name like '%iphone%'
		String sql = "select * from product_ p where p.name like '%" + name + "%'";
		Query q = s.createSQLQuery(sql);
		List<Object[]> list = q.list();
		
		for (Object[] objects : list) {
			for (Object object : objects) {
				System.out.println(object + "\t");
			}
			System.out.println();
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
