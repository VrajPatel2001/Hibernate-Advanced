package org.learn.hibernate;


import org.hibernate.Session;
import org.learn.hibernate.dataSource.DataSource;
import org.learn.hibernate.domain.Employee;
import org.learn.hibernate.domain.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HibernateApplication {
    public static void main(String[] args) throws SQLException {

        Session session = DataSource.getSessionFactory().openSession();
        session.getTransaction().begin();

        Store store = new Store("Walmart-Applewood", "Vaughan");
        Employee e1 = new Employee("Smit Patel");
        Employee e2 = new Employee("Akshesh Patel");

        e1.setStore(store);
        e2.setStore(store);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        store.setEmployees(employees);

        session.save(store);


        session.getTransaction().commit();
        session.close();
        DataSource.getSessionFactory().close();
    }
}
