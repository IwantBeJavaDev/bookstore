package pl.learn.bookstore.common;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;

public class TestUtil {
    static Logger logger = LoggerFactory.getLogger(TestUtil.class);
    public static void clearAllTables(EntityManager entityManager) {
        Session session = entityManager.unwrap(Session.class);
        SessionFactory currentSession = session.getSessionFactory();

        currentSession.getCache().evictAllRegions();

    }
}
