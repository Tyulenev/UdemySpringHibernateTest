package ru.Tyulenev.Hibernate2.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.Tyulenev.Hibernate2.Entity.Detail;
import ru.Tyulenev.Hibernate2.Entity.EmployeesEntity;

//One to One
public class Hib2_MainTest1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernateMSSQL.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session_MS_SQL = factory.getCurrentSession();

        try {

//            EmployeesEntity emp = new EmployeesEntity("Ivan", "Urgant", "Actor", 5004);
//            Detail detail = new Detail("Izril", "77777", "Urgant@gmail.com");
//            emp.setEmpDetail(detail);
            session_MS_SQL.beginTransaction();
//            session_MS_SQL.save(emp);
            session_MS_SQL.createQuery();

            session_MS_SQL.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            session_MS_SQL.close();
            factory.close();

        }
    }
}
