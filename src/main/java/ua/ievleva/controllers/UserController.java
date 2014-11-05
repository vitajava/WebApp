package ua.ievleva.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.ievleva.dao.UserDao;
import ua.ievleva.entity.User;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value="/index.html",method = RequestMethod.GET)
    public ModelAndView getUsers(WebRequest request) {

        String login = request.getParameter("login");
        String phone = request.getParameter("phone");
        List<User> users;

        if(login != null) {
            LOGGER.info("Finding user by login = " + login);
            users = userDao.findByLogin(login);

        }
        else if(phone != null) {
            LOGGER.info("Finding user by phone = " + phone);
            users = userDao.findByPhone(phone);

        } else {
            LOGGER.info("Finding all users");
            users = userDao.findAllUsers();

        }
        return new ModelAndView("index", "list", users);
    }

    @RequestMapping(value = "/add.html", method = RequestMethod.POST)
    public String add() {
        LOGGER.info("Adding user page is opened");

        return "add";
    }

    @RequestMapping(value = "/addU.html", method = RequestMethod.POST)
    public ModelAndView addU(WebRequest request) {
        LOGGER.info("Adding User to DB");

        List<String> userData = new ArrayList<>();
        String login = request.getParameter("login");

        userData.add(login);
        userData.add(request.getParameter("password"));
        userData.add(request.getParameter("firstname"));
        userData.add(request.getParameter("lastname"));
        userData.add(request.getParameter("sex"));
        userData.add(request.getParameter("phone"));
        userData.add(request.getParameter("email"));
        userData.add(request.getParameter("address"));

        userDao.add(userData);
        LOGGER.info("User is added to DB");

        return new ModelAndView("index", "list", userDao.findByLogin(login));
    }

    @RequestMapping(value = "/deleted.html", method = RequestMethod.POST)
    public String delete(WebRequest request) {

        String login = request.getParameter("login");
        LOGGER.info("Deleting user = " + login);

        userDao.delete(login);

        return "deleted";
    }

    @RequestMapping(value = "/edit.html", method = RequestMethod.POST)
    public ModelAndView edit(WebRequest request) {
        String login = request.getParameter("login");
        LOGGER.info("Editing user = " + login);

        return new ModelAndView("edit", "login", login);
    }

    @RequestMapping(value = "/edited.html", method = RequestMethod.GET)
    public ModelAndView editU(WebRequest request) {
        String login = request.getParameter("login");
        LOGGER.info("Editing user = " + login);

        List<String> userData = new ArrayList<>();

        userData.add(login);
        userData.add(request.getParameter("password"));
        userData.add(request.getParameter("firstname"));
        userData.add(request.getParameter("lastname"));
        userData.add(request.getParameter("sex"));
        userData.add(request.getParameter("phone"));
        userData.add(request.getParameter("email"));
        userData.add(request.getParameter("address"));

        userDao.edit(userData);

        return new ModelAndView("index", "list", userDao.findByLogin(login));
    }

}
