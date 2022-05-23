package ru.Tyulenev.Hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.Tyulenev.Hibernate.Entity.EmployeesEntity;

public class MainClass2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernateMSSQL.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();

        EmployeesEntity emp = new EmployeesEntity("Helen", "Demtyeva" , "\n" +
                "accounting", 470);

        try {
            Session session_MS_SQL = factory.getCurrentSession();
            session_MS_SQL.beginTransaction();
            session_MS_SQL.save(emp);
            session_MS_SQL.getTransaction().commit(); //Подтверждение изменений
        }
        finally {
            factory.close();
            System.out.println("Done");
        }
    }
}
