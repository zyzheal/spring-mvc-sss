package com.lagou.edu.Controller;


import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeDao resumeDao;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletResponse res) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        List<Resume> resumeList = resumeDao.findAll();
        for (Resume r : resumeList ) {
            System.out.println(r.getName());
        }
        modelAndView.addObject("resumeList", resumeList);
        modelAndView.addObject("aa", "bbbb");
        modelAndView.setViewName("resume");
        return modelAndView;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        Optional<Resume> oResume = resumeDao.findById(id.longValue());
        Resume resume = oResume.get();
        mv.addObject("resume", resume);
        mv.setViewName("resumeForm");
        return mv;
    }


    @RequestMapping("/new")
    public ModelAndView newResume() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("resumeForm");
        return mv;
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Resume resume) {
        System.out.println(">> the resume name: " + resume.getName());
        resumeDao.save(resume);
        return "redirect:/resume/index";
    }


    @RequestMapping(value="/remove", method = RequestMethod.POST)
    public String remove(HttpServletRequest req) {
        System.out.println(">> the resume name: " + req.getParameter("id"));
        Long id =  Long.parseLong(req.getParameter("id"));
        resumeDao.deleteById(id);
        return "redirect:/resume/index";
    }

}
