package dao;

import model.Expense;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public ExpenseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Expense expense) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(expense);
        session.getTransaction().commit();
        session.close();
    }

    public List<Expense> getAllExpenses() {
        Session session = sessionFactory.openSession();
        List<Expense> expenses = session.createQuery("FROM Expense", Expense.class).list();
        session.close();
        return expenses;
    }
}
