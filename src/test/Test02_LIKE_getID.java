package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

/**
 * 测试模糊查询，根据name进行模糊查询，取出id的值
 * @author Administrator
 *
 */
public class Test02_LIKE_getID {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		
		String name = "iphone";
		Query q = s.createQuery("from Product p where p.name like ?");
		q.setString(0, "%"+name+"%");
		List<Product> ps = q.list();
		for (Product product : ps) {
			System.out.println(product.getId());
		}
		
		s.getTransaction().commit();
		s.close();
		sf.close();
	}
}
