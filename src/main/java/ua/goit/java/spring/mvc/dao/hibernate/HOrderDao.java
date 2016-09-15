package ua.goit.java.spring.mvc.dao.hibernate;

import org.hibernate.SessionFactory;
import ua.goit.java.spring.mvc.dao.OrderDao;
import ua.goit.java.spring.mvc.model.Order;

/**
 * Created by Daniel Solo on 15.09.2016.
 */
public class HOrderDao implements OrderDao {

    private SessionFactory sessionFactory;

    @Override
    public void save(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
