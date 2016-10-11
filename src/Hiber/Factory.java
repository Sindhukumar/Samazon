package Hiber;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {

	public static SessionFactory factory;

	public static SessionFactory getFactory() {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		return factory;
	}

	public static String getGravatarURL(String email, Integer size) {
		String url = "http://www.gravatar.com/avatar/" + MD5Util.md5Hex(email) + "?s=" + size.toString();
		return url;
	}
}
