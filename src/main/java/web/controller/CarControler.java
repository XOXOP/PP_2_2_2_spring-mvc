package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.Users;
import web.model.Car;
import web.service.Service;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CarControler {

    @Autowired
    Service service;



    @GetMapping("/cars")


  public String getCar(@RequestParam(value = "count", defaultValue = "5") Integer count,
                       Model model) {

        List<Car> cars1 = service.getCars(count);

        model.addAttribute("cars", cars1);
        return "cars";
    }
    @GetMapping("/users")
    public String getUsers(Model model) {

        List<Users> users = service.getallUsers();

        model.addAttribute("users", users);
        return "users";
    }


}




