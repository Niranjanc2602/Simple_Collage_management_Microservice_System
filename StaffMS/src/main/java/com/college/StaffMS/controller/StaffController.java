package com.college.StaffMS.controller;

import com.college.StaffMS.model.Marks;
import com.college.StaffMS.model.Staff;
import com.college.StaffMS.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("login")
    public ModelAndView login(@ModelAttribute Staff staff){
        ModelAndView mvc = new ModelAndView("login");
        mvc.addObject("staff",staff);
        return mvc;
    }

    @GetMapping("check")
    public ModelAndView checkLogin(@ModelAttribute Staff staff, HttpSession session){
        Staff entry = staffService.getByNameAndPassword(staff.getName(),staff.getPassword());
        ModelAndView mav;
        if(entry == null){
            mav = new ModelAndView("test");
            mav.addObject("staff",staff);
        }else{
            mav = new ModelAndView("redirect:dashboard");
            session.setAttribute("staff",entry);
            mav.addObject("staff",entry);
        }
        return mav;
    }

    @GetMapping("dashboard")
    public ModelAndView dashboard(HttpSession session){
        //System.out.println(session.getAttribute("staff"));
        return new ModelAndView("dashboard");
    }

    @GetMapping("dashboard/staff")
    public ModelAndView getStaff(HttpSession session){
        ModelAndView mvc = new ModelAndView("staff");
        Staff user = (Staff) session.getAttribute("staff");
        //List staff = staffService.getByStaffIdMs(user.getId());
        //List allStaff = staffService.getAllStaff();
        mvc.addObject("student",user);
        return mvc;
    }

    @GetMapping("dashboard/student")
    public ModelAndView getStudent(HttpSession session){
        Staff user = (Staff) session.getAttribute("staff");
        List list =  staffService.getStudentCourse(user.getCourse());
        ModelAndView mav= new ModelAndView("student");
        mav.addObject("std",list);
        return mav;
    }

//Marks
    @GetMapping("dashboard/marks")
    public ModelAndView addMarksPage(@ModelAttribute Marks staff,HttpSession session){
        ModelAndView mvc = new ModelAndView("marks");
        Staff user = (Staff) session.getAttribute("staff");
        List student = staffService.getStudentCourse(user.getCourse());
        System.out.println(student +"  "+user.getId());
        mvc.addObject("staff",staff);
        //mvc.addObject("user",user);
        mvc.addObject("students",student);
        return mvc;
    }

    @PostMapping("marks")
    public ModelAndView addMarks(@ModelAttribute Marks marks,HttpSession session){
        Staff user = (Staff) session.getAttribute("staff");
        marks.setStaffId(user.getId());
        System.out.println(user.getId() +""+ marks.getStaffId());
        staffService.addMarks(marks);
        ModelAndView mav = new ModelAndView("redirect:dashboard/marks");
        mav.addObject("mark",marks);
        return mav;
    }

    @GetMapping("getMarks")
    public List getStudents(){
        return staffService.getMarks(14);
    }

    @GetMapping("getAllMarks")
    public ModelAndView getAllMarks(HttpSession session){
        Staff user = (Staff) session.getAttribute("staff");
        List list = staffService.getStaffMark(user.getId());
        ModelAndView mav = new ModelAndView("allMarks");
        mav.addObject("marks",list);
        return mav;
    }

// Ms Admin Communication ===================================================================================================
    @GetMapping("getAllMs/")
    public List getStaffMs(){return staffService.getAllStaff();}

    @GetMapping("getByMs/{id}")
    public List getByIdMs(@PathVariable int id){return staffService.getByStaffIdMs(id);}

    @GetMapping("getByNameMs/{name}")
    public List getByNameMs(@PathVariable String name){return staffService.getByStaffNameMs(name);}

    @PostMapping("/addMs")
    public void addStaffByMs(@RequestBody Staff staff){staffService.addStaff(staff);}

    @DeleteMapping("/delete/{id}")
    public void deleteSt(@PathVariable int id){staffService.deleteStaff(id);}
//Ms Student

 }

 /*
 *
 *
 *
 * @GetMapping("/add")
    public ModelAndView addPage(@ModelAttribute Staff staff){
        ModelAndView mvc = new ModelAndView("index");
        mvc.addObject("staff",staff);
        return mvc;
    }

    @PostMapping("/add")
    public ModelAndView addStaff(@ModelAttribute Staff staff,@RequestBody Staff staf){
        if(staff.equals(null)){
             staffService.addStaff(staf);
        }else {
            staffService.addStaff(staff);
        }
        ModelAndView mvc = new ModelAndView("index");
        mvc.addObject("staff",staff);
        return mvc;
    }

    @GetMapping("/staff")
    public List getAllStaff(){
        return staffService.getAllStaff();
    }



    @DeleteMapping()
    public void deleteStaff(){

    }
 *
 *
 * */