package me.hoseong.realestate.controller;

import me.hoseong.realestate.entity.Property;
import me.hoseong.realestate.repository.UserRepository;
import me.hoseong.realestate.entity.User;
import me.hoseong.realestate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String test(){
        return "Hello World";
    }


    @RequestMapping("/insertProperty")
    public String insertProperty(){
        Property property = new Property();
        property.setOwnerId("jinwoo");
        property.setName("good product");
        property.setPrice(5000000.0);
        property.setPropertyType("rental");
        property.setSaleStatus("on_sale");
        property.setStructureType("wooden");
        propertyRepository.save(property);
        return "Hello World";
    }

    @RequestMapping("/insertUser")
    public String insertUser(){
        User user = new User();
        user.setId("jinwoo");
        user.setPhoneNumber("01041324136");
        user.setEmail("jinwoo");
        user.setPassword("1234");
        userRepository.save(user);

        return "hello";
    }

    @RequestMapping("/findUserById")
    public String findUserById(@RequestParam("id")String id){
        User user = userRepository.findById(id);

        return user.toString();
    }


}
