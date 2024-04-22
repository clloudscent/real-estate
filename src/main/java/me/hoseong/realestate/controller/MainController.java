package me.hoseong.realestate.controller;

import lombok.extern.slf4j.Slf4j;
import me.hoseong.realestate.entity.Property;
import me.hoseong.realestate.entity.User;
import me.hoseong.realestate.repository.PropertyRepository;
import me.hoseong.realestate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
public class MainController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PropertyRepository propertyRepository;


    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");

        return mv;
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/registerProcess")
    public ModelAndView registerProcess(@ModelAttribute User userToInsert){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login");
        try {
            userRepository.save(userToInsert);
        }catch (Exception e){
            mv.setViewName("redirect:/register");
        }
        return mv;
    }


    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/loginProcess")
    public ModelAndView loginProcess(HttpServletRequest request,
                                     HttpServletResponse response,
                                     @ModelAttribute User userToLogin){
        log.info("Login Process Called From Login Id : {}, Password : {}", userToLogin.getId(), userToLogin.getPassword());
//        User user = userRepository.findById()
        User user = userRepository.findByIdAndPassword(userToLogin.getId(), userToLogin.getPassword());
        ModelAndView mv = new ModelAndView();
        if(user != null) {
            request.getSession().setAttribute("user", user);
            mv.setViewName("redirect:/list");
        }else{
            mv.setViewName("redirect:/login");
        }
        return mv;
    }

    @RequestMapping(value = "logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/login");
        return mv;
    }

    @RequestMapping(value = "/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/list");
        List<Property> propertyList = propertyRepository.findAll();
        mv.addObject("propertyList", propertyList);
        return mv;
    }

    @RequestMapping(value = "/propertyRegistration")
    public ModelAndView propertyRegistration(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        if(user == null){
            mv.setViewName("redirect:/login");
            return mv;
        }
        mv.setViewName("/property-registration");
        return mv;
    }

    @RequestMapping(value = "/registrationProcess")
    public ModelAndView registrationProcess(@ModelAttribute Property propertyToInsert){
        ModelAndView mv = new ModelAndView();
        log.info(propertyToInsert.toString());
        propertyRepository.save(propertyToInsert);
        mv.setViewName("redirect:/list");
        return mv;
    }

    @RequestMapping(value = "/propertyDetail")
    public ModelAndView propertyDetail(@RequestParam("id") int id){

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/property-detail");
        Property propertyToView = propertyRepository.findById(id);
        User owner = userRepository.findById(propertyToView.getOwnerId());
        mv.addObject("propertyToView", propertyToView);
        mv.addObject("propertyOwner", owner);
        return mv;
    }

    @RequestMapping(value = "/propertyDetail2")
    public ModelAndView propertyDetail2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/property-detail2");
        Property propertyToView = propertyRepository.findById(3);
        mv.addObject("propertyToView", propertyToView);
        return mv;
    }
}
