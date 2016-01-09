package projet_01_01;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	static {
		try {
			Configuration conf = new Configuration();
			conf.configure("hibernate.cgf.xml");
			ServiceRegistry serviceReg = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties()).build();
			sessionFactory = conf.buildSessionFactory(serviceReg);

		} catch (HibernateException ex) {
			throw new RuntimeException("Problème de configuration : "
					+ ex.getMessage(), ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
