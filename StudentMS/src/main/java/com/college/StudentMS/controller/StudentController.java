package com.college.StudentMS.controller;

import com.college.StudentMS.model.Student;
import com.college.StudentMS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("login")
    public ModelAndView login(@ModelAttribute Student student){
        ModelAndView mvc = new ModelAndView("login");
        mvc.addObject("student",student);
        return mvc;
    }

    @GetMapping("check")
    public ModelAndView checkLogin(@ModelAttribute Student student, HttpSession session){
        //System.out.println(student.getName() +""+ student.getPassword());
        Student entry = studentService.getByNameAndPassword(student.getName(),student.getPassword());
        ModelAndView mav;
        if(entry == null){
            mav = new ModelAndView("login");
            mav.addObject("student",student);

        }else{
            mav = new ModelAndView("redirect:dashboard");
            mav.addObject("student",entry);
            session.setAttribute("user",entry);
        }
        return mav;
    }

    @GetMapping("dashboard")
    public ModelAndView dashboard(HttpSession session){
        return new ModelAndView("dashboard");
    }

    @GetMapping("student")
    public ModelAndView studentDetail(HttpSession session){
        ModelAndView mav = new ModelAndView("student");
        Student user = (Student) session.getAttribute("user");
        Optional<Student> student = studentService.getByStudentId(7);
        mav.addObject("student",user);
        System.out.println(student);
        return mav;
    }

    @GetMapping("table")
    public ModelAndView tableDetail(HttpSession session){
        return new ModelAndView("table");
    }

//marks ===============

    @GetMapping("marks")
    public ModelAndView studentMarks(HttpSession session){
        Student user = (Student) session.getAttribute("user");
        ModelAndView mav = new ModelAndView("marks");
        List list = studentService.getMarks(user.getId());
        mav.addObject("marks",list);
        return mav;
    }

    //================

    @GetMapping("/add")
    public ModelAndView addPage(@ModelAttribute Student student){
        ModelAndView mvc = new ModelAndView("index");
        mvc.addObject("student",student);
        return mvc;
    }

    @PostMapping("/add")
    public ModelAndView addStudents(@ModelAttribute Student student){
        studentService.addStudent(student);
        ModelAndView mvc = new ModelAndView("index");
        mvc.addObject("student",student);
        return mvc;
    }

    @GetMapping("/students/")
    public List getAllStudents(){
        return studentService.getAllStudent();
    }



// Ms Staff Communication ===========================================================================================================

    @GetMapping("getByMs/{course}")
    public List getByCourseMs(@PathVariable int course){return studentService.getByStudentCourseMs(course);}
// Ms Admin ======================================================================================================================= =

    @GetMapping("getAllMs/")
    public List getByCourseMs(){return studentService.getAllStudent();}

    @PostMapping("/addMs")
    public void addStaffByMs(@RequestBody Student student){studentService.addStudent(student);}

    @DeleteMapping("/delete/{id}")
    public void deleteSt(@PathVariable int id){studentService.deleteStudent(id);}
}
