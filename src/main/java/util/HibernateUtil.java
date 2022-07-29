package util;

import entity.Chat;
import entity.ChatType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    static SessionFactory factory = null;   //точка входу в БД
    static {
        Configuration configuration = new Configuration();  //налаштування для SessionFactory (що, як і коли)
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Chat.class);
        configuration.addAnnotatedClass(ChatType.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }

    public static Session getSession() {
        return factory.openSession();
    }   //фізичне з'єднання з БД
}
