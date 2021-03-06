package ru.Tyulenev.Hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.Tyulenev.Hibernate.Entity.EmployeesEntity;

import java.util.List;

//Получение данных из БД
public class MainClass2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().
                configure("hibernateMSSQL.cfg.xml")
                .addAnnotatedClass(EmployeesEntity.class)
                .buildSessionFactory();


        try {
            Session session_MS_SQL = factory.getCurrentSession();
            session_MS_SQL.beginTransaction();
            List<EmployeesEntity> emps = session_MS_SQL.createQuery("from EmployeesEntity")
                    .getResultList();   //HQL запрос
            for (EmployeesEntity emp:emps) {
                System.out.println(emp);
            }
            System.out.println("Всего работников в таблице employees_test: " + emps.size());

            session_MS_SQL.getTransaction().commit();

            System.out.println("Done");
        }
        finally {
            factory.close();

        }
    }
}
