package com.how2java.hibernate.basic.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * ����״̬��˲ʱ���־á��й�
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
		System.out.println("��ʱp��˲ʱ״̬��ָ����û�к�hibernate�����κι�ϵ�������ݿ���Ҳû�ж�Ӧ�ļ�¼��һ��JVM�������������Ҳ����ʧ��");
		System.out.println("----------------------------------------");
		
		s.save(p);
		System.out.println("��ʱp�ǳ־�״̬��ָ����һ�������hibernate������ϵ���ж�Ӧ��session,���������ݿ����ж�Ӧ��һ����¼");
		System.out.println("���ݲ���ɹ���");
		System.out.println("-----------------------------------------");
		
		
		s.getTransaction().commit();
		s.close();
		System.out.println("��ʱp���й�״̬��ָ����һ��������Ȼ�����ݿ����ж�Ӧ��һ����¼������������Ӧ��session�Ѿ��ر���");
		System.out.println("------------------------------------------");
		
		sf.close();
		System.out.println("�ɹ��ر�����");
	}
}
