package com.college.AdminMS.controller;

import com.college.AdminMS.model.AdminEntity;
import com.college.AdminMS.model.Course;
import com.college.AdminMS.model.Staff;
import com.college.AdminMS.model.Student;
import com.college.AdminMS.repository.AdminRepo;
import com.college.AdminMS.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    AdminService service;

    @GetMapping({"","/"})
    public ModelAndView index(){return new ModelAndView("index");}

    @GetMapping("login")
    public ModelAndView login(@ModelAttribute AdminEntity adminEntity){
        ModelAndView mvc = new ModelAndView("login");
        mvc.addObject("adminEntity",adminEntity);
        return mvc;
    }

    @GetMapping("check")
    public ModelAndView checkLogin(@ModelAttribute AdminEntity adminEntity){
        AdminEntity entry = adminRepo.getByNameAndPassword(adminEntity.getName(),adminEntity.getPassword());
        ModelAndView mav;
        if(entry == null){
            mav = new ModelAndView("test");
            mav.addObject("adminEntity",adminEntity);

        }else{
            mav = new ModelAndView("redirect:dashboard");
            mav.addObject("adminEntity",entry);
        }
        return mav;
    }

    @GetMapping("dashboard")
    public ModelAndView dashboard(){
        return new ModelAndView("dashboard");
    }

    @GetMapping("dashboard/admin")
    public ModelAndView getAllAdmin(){
        ModelAndView mav = new ModelAndView("admin");
        List adminEntities = service.getAll();
        mav.addObject("adminEntity",adminEntities);
        return mav;
    }

    @GetMapping("dashboard/admin/add")
    public ModelAndView addAdminPage(@ModelAttribute AdminEntity adminEntity){
        ModelAndView mav = new ModelAndView("adminAdd");
        mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @PostMapping("dashboard/admin/add")
    public ModelAndView addAdmin(@ModelAttribute AdminEntity adminEntity){
        service.addAdmin(adminEntity);
        ModelAndView mav = new ModelAndView("redirect:add/");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @GetMapping("dashboard/admin/delete")
    public ModelAndView deleteAdminPage(@ModelAttribute AdminEntity adminEntity){
        List list = service.getAll();
        ModelAndView mav = new ModelAndView("adminDelete");
        mav.addObject("list",list);
        return mav;
    }

    @GetMapping("dashboard/admin/delete/{id}")
    public ModelAndView deleteAdmin(@ModelAttribute AdminEntity adminEntity,@PathVariable int id){
        service.deleteAdmin(id);
        ModelAndView mav = new ModelAndView("redirect:/dashboard/admin/delete");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }
//Ms Course===================================================================================================================

    @GetMapping("course")
    public ModelAndView addCoursePage(@ModelAttribute Course adminEntity){
        ModelAndView mav = new ModelAndView("courseAdd");
        mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @PostMapping("courseAdd")
    public ModelAndView addCourse(@ModelAttribute Course adminEntity){
        service.addCourse(adminEntity);
        System.out.println(adminEntity.getName());
        ModelAndView mav = new ModelAndView("redirect:/course");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @GetMapping("getCourse")
    public ModelAndView getCourse() {
        ModelAndView mav = new ModelAndView("course");
        List list = service.getCourse();
        mav.addObject("course",list);
        return mav;
    }

    @GetMapping("getCourse/{id}")
    public Course getCourseById(@PathVariable int id){ return  service.getCourseById(id);}

    @GetMapping("dashboard/course/delete")
    public ModelAndView deleteCoursePage(@ModelAttribute Course course){
        List list = service.getCourse();
        ModelAndView mav = new ModelAndView("courseDetele");
        mav.addObject("list",list);
        return mav;
    }

    @GetMapping("dashboard/course/delete/{id}")
    public ModelAndView deleteCourse(@ModelAttribute Course course,@PathVariable int id){
        System.out.println("called he");
        service.deleteCourse(id);
        ModelAndView mav = new ModelAndView("redirect:/dashboard/course/delete");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    //Ms Staff===================================================================================================================
    @GetMapping("dashboard/staff/add")
    public ModelAndView addStaffPage(@ModelAttribute Staff adminEntity){
        ModelAndView mav = new ModelAndView("staffAdd");
        List course = service.getCourse();
        mav.addObject("adminEntity",adminEntity);
        mav.addObject("courses",course);
        return mav;
    }

    @PostMapping("dashboard/staff/add")
    public ModelAndView addStaff(@ModelAttribute Staff adminEntity){
        service.addStaff(adminEntity);
        System.out.println(adminEntity.getCourse());
        ModelAndView mav = new ModelAndView("redirect:add/");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @GetMapping("staff")
    public ModelAndView staff(){
        ModelAndView mav = new ModelAndView();
        List staff = service.getAllStaff();
        System.out.println(staff);
        mav.addObject("staff",staff);
        return mav;
    }

    @GetMapping("/resu")
    public ModelAndView result(@ModelAttribute AdminEntity adminEntity){
        ModelAndView mav = new ModelAndView("result");
        mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @GetMapping("/getStaffId/{id}")
    public List course(@PathVariable int id){return service.getStaffById(id);}

    @GetMapping("/getStaffName/{name}")
    public List getStaffByName(@PathVariable String name){return service.getStaffByName(name);}

    @GetMapping("dashboard/staff/delete")
    public ModelAndView deleteStuffPage(@ModelAttribute Staff staff){
        List list = service.getAllStaff();
        ModelAndView mav = new ModelAndView("staffDetele");
        mav.addObject("list",list);
        return mav;
    }

    @GetMapping("dashboard/staff/delete/{id}")
    public ModelAndView deleteStaff(@ModelAttribute Staff staff,@PathVariable int id){
        System.out.println("called he");
        service.deleteStuff(id);
        ModelAndView mav = new ModelAndView("redirect:/dashboard/staff/delete");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    //Ms Student===================================================================================================================
    @GetMapping("/student")
    public ModelAndView getAllStudent(){
        ModelAndView mav = new ModelAndView("student");
        List list =  service.getAllStudent();
        mav.addObject("student",list);
        return mav;
    }

    @GetMapping("dashboard/student/add")
    public ModelAndView addStudentPage(@ModelAttribute Student student){
        ModelAndView mav = new ModelAndView("studentAdd");
        List course = service.getCourse();
        mav.addObject("student",student);
        mav.addObject("courses",course);
        return mav;
    }

    @PostMapping("dashboard/student/add")
    public ModelAndView addStudent(@ModelAttribute Student student){
        System.out.println("entry here");
        service.addStudent(student);
        ModelAndView mav = new ModelAndView("redirect:add/");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @GetMapping("dashboard/student/delete")
    public ModelAndView deleteStudentPage(@ModelAttribute Student student){
        List list = service.getAllStudent();
        ModelAndView mav = new ModelAndView("studentDetele");
        mav.addObject("list",list);
        return mav;
    }

    @GetMapping("dashboard/student/delete/{id}")
    public ModelAndView deleteStudent(@ModelAttribute Student student,@PathVariable int id){
        System.out.println("called he");
        service.deleteStudent(id);
        ModelAndView mav = new ModelAndView("redirect:/dashboard/student/delete");
        //mav.addObject("adminEntity",adminEntity);
        return mav;
    }
}

/*
*
*
*
* @GetMapping("start")
    public ModelAndView getLogin(){
        ModelAndView mav = new ModelAndView("test");

        return mav;
    }
*
*
* @GetMapping("/admin")
    public ModelAndView getAll(){
        List<AdminEntity> list= (List<AdminEntity>) adminRepo.findAll();
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("adminEntity",list);
        return mav;
    }

    @PostMapping("/start")
    public ModelAndView login(@ModelAttribute AdminEntity adminEntity){
        AdminEntity entry = adminRepo.getByNameAndPassword(adminEntity.getName(),adminEntity.getPassword());

        ModelAndView mav;
        if(entry == null){
            mav = new ModelAndView("test");
            mav.addObject("adminEntity",adminEntity);
        }else {
            mav = new ModelAndView("redirect:/resu");
            mav.addObject("adminEntity",entry);
        }
        return mav;
    }

    @GetMapping("/test")
    public ModelAndView testAdmin(){
        ModelAndView mav = new ModelAndView("test");
        AdminEntity adminEntity = new AdminEntity();
        mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @GetMapping("/admin/{id}")
    public AdminEntity getById(@PathVariable int id){

        return adminRepo.findById(id).get();
    }

    @GetMapping("/add")
    public ModelAndView addAdmin(){
        ModelAndView mav = new ModelAndView("register_form");
        AdminEntity adminEntity = new AdminEntity();
        mav.addObject("adminEntity",adminEntity);
        return mav;
    }

    @PostMapping("/save")
    public String saveAdmin(@ModelAttribute AdminEntity adminEntity){
        //model.addAttribute("adminEntity",adminEntity);
        adminRepo.save(adminEntity);
        return "redirect : resu";
    }

    @GetMapping("/resu")
    public ModelAndView result(){
        ModelAndView mav = new ModelAndView("result");
        return mav;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable int id){
        adminRepo.deleteById(id);
    }

*
* */