package ru.Tyulenev.Hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.Tyulenev.Hibernate.Entity.EmployeesEntity;

import java.util.List;

//Обновление данных
public class MainClass3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernateMSSQL.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();


        try {
            Session session_MS_SQL = factory.getCurrentSession();
            session_MS_SQL.beginTransaction();

//            EmployeesEntity emp = session_MS_SQL.get(EmployeesEntity.class, 1);
//            emp.setSalary(emp.getSalary()+20);

            session_MS_SQL.createQuery("update EmployeesEntity set salary=2223" +
                    "where name = 'Ivan'").executeUpdate();
            session_MS_SQL.getTransaction().commit();
            System.out.println("Done");
        }
        finally {
            factory.close();

        }
    }
}
