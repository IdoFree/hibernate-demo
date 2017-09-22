import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Ido on 2017/9/22.
 */
public class MainApp {

    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();

            Tag person = new Tag();
            person.setName("Mike Lewis");
            session.save(person);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        HibernateUtil.shutdown();
    }
}
