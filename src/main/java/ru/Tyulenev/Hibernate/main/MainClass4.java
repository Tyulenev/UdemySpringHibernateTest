package ru.Tyulenev.Hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.Tyulenev.Hibernate.Entity.EmployeesEntity;

//Удаление объектов из базы
public class MainClass4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernateMSSQL.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();


        try {
            Session session_MS_SQL = factory.getCurrentSession();
            session_MS_SQL.beginTransaction();

//            EmployeesEntity emp = session_MS_SQL.get(EmployeesEntity.class, 5);
//            session_MS_SQL.delete(emp);

            session_MS_SQL.createQuery("delete EmployeesEntity " +
                    "where name = 'Helen'").executeUpdate();

            session_MS_SQL.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();

        }
    }
}
