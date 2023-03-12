package web.service;

import org.springframework.stereotype.Component;
import web.entity.Users;
import web.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.List;

@Component
public interface Service {

    void createCars();

    List<Car> getCars(Integer count);


    List<Users> getallUsers();


    }

