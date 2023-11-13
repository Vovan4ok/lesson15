import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static Session session;
    private static Session buildSession() {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.configure();

        Session session = configuration.buildSessionFactory().openSession();

        return session;
    }

    public static Session getSession() {
        if(session == null) {
            session = buildSession();
        }
        return session;
    }
}
