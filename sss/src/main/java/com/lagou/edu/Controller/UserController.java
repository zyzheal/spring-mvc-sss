package com.lagou.edu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("login")
    public String login() {
        return "loginForm";
    }

    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest req, HttpServletResponse res) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("u: " + username);
        System.out.println("p: " + password);

        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = req.getSession();
            session.setAttribute("uid", "admin");
            return "redirect:/resume/index";
        } else {
            return "redirect:/user/login";
        }
    }

    @RequestMapping("lougout")
    public String loutout(HttpServletRequest req) {
        HttpSession ses = req.getSession();
        ses.removeAttribute("uid");
        return "redirect:/user/login";
    }

}
