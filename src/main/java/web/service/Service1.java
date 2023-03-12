package web.service;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import web.config.AppConfig;
import web.entity.Users;
import web.model.Car;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;



@Repository
public class Service1 implements Service{

    //Service service;


    static List<Car> cars = new ArrayList<>();

    public Service1() {
        createCars();
    }

    public void createCars() {



        Car car1 = new Car("Зил", "130", 1962);
        Car car2 = new Car("Lorraine-Dietrich", "CR-2", 1905);
        Car car3 = new Car("RAF", "2203", 1976);
        Car car4 = new Car("Plymout", "Fury", 1957);
        Car car5 = new Car("Plymout", "Superbird", 1970);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car>  cars1 = new ArrayList<>();
        if (count >= 5) {

            cars1 = cars.stream().toList();
        } else if (count < 0) {
            cars1 = null;

        } else cars1 = cars.stream().limit(count).toList();

        return cars1;
    }
    @PersistenceContext
    private EntityManager entityManager;
    private LocalContainerEntityManagerFactoryBean entityManagerFactory;
    @Autowired
    public void setEntityManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    private void prepareEntityManager() {
        entityManager = entityManagerFactory
                .getNativeEntityManagerFactory()
                .createEntityManager();
    }

    @Override
    //@Transactional
    @SuppressWarnings("uncheked")
    public List<Users> getallUsers() {

        prepareEntityManager();
        List<Users> users = (List<Users>) entityManager.createQuery("SELECT c FROM Users c").getResultList();
        entityManager.close();
        return users;

        //List<Users> users = new ArrayList<>();
        //return entityManager.createQuery("SELECT c FROM Users  c",Users.class).getResultList();
        //return query.getResultList();

    }







}



