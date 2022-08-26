package com.example.UserMS.Controller;

import com.example.UserMS.Entity.Item;
import com.example.UserMS.Entity.User;
import com.example.UserMS.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;


    @Autowired
    public RestTemplate restTemplate;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user){
        userService.saveUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers(){

        return userService.findAll();
    }

    @DeleteMapping("/delete/{userID}")
    public void deleteUser(@PathVariable("userID") Long userID) {
        userService.deleteUser(userID);
    }


    @RequestMapping("/placeOrder/{itemID}")
    public Item getItems(@PathVariable("itemID") long itemID){
        Item item = new Item();
        item = restTemplate.getForObject("http://localhost:8002/order/" + itemID ,Item.class);
        return item;
    }






}
