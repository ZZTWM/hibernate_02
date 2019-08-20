package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 对象状态：瞬时、持久、托管
 * @author Administrator
 *
 */
public class TestHibernate04_Object_State {
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		Product p = new Product();
		p.setName("p1");
		p.setPrice(6000);
		System.out.println("此时p是瞬时状态：指的是没有和hibernate发生任何关系，在数据库中也没有对应的记录，一旦JVM结束，这个对象也就消失了");
		System.out.println("----------------------------------------");
		
		s.save(p);
		System.out.println("此时p是持久状态：指得是一个对象和hibernate发生联系，有对应的session,并且在数据库中有对应的一条记录");
		System.out.println("数据插入成功！");
		System.out.println("-----------------------------------------");
		
		
		s.getTransaction().commit();
		s.close();
		System.out.println("此时p是托管状态：指的是一个对象虽然在数据库中有对应的一条记录，但是它所对应的session已经关闭了");
		System.out.println("------------------------------------------");
		
		sf.close();
		System.out.println("成功关闭连接");
	}
}
