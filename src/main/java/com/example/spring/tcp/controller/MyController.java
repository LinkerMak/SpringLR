package com.example.spring.tcp.controller;

import com.example.spring.tcp.entity.Buffer;
import com.example.spring.tcp.entity.Employee;
import com.example.spring.tcp.entity.EmployeeSection;
import com.example.spring.tcp.entity.Section;
import com.example.spring.tcp.service.EmployeeSectionService;
import com.example.spring.tcp.service.EmployeeService;
import com.example.spring.tcp.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private EmployeeSectionService empSectService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps",allEmployees);

        return "allEmployees";
    }

    @RequestMapping("/showSections")
    public String showAllSections(Model model) {

        List<Section> allSections = sectionService.getAllSection();
        model.addAttribute("allSections",allSections);

        return "allSections";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {

        Employee employee = new Employee();
        Buffer buffer = new Buffer();

        buffer.setEmployee(employee);
        List<Section> sectionList = sectionService.getAllSection();
        buffer.setSectionList(sectionList);

        model.addAttribute("buffer",buffer);
        return "employeeInfo";
    }

    @RequestMapping("/addNewSection")
    public String addNewSection(Model model) {

        Section section = new Section();

        model.addAttribute("section",section);
        return "sectionInfo";
    }

    private int [] convertStringSectionsToIntIds(String [] sections) {
        int [] arrId = new int[sections.length];
        int i = 0;
        boolean flag;
        for(String str: sections){
            flag = false;
            for(char ch: str.toCharArray()) {
                if (ch=='=') {
                    flag = true;
                    continue;
                }
                if(flag == true) {
                    arrId[i++] = ch - '0';
                    break;
                }
            }
        }
        return arrId;
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("buffer") Buffer buffer) {

        int [] IDSections = convertStringSectionsToIntIds(buffer.getSections());

        employeeService.saveEmployee(buffer.getEmployee());

        if(buffer.getEmployee().getId() == 0) {
            empSectService.addPairs(employeeService.getLast(), IDSections);
        }
        else empSectService.addPairs(buffer.getEmployee().getId(), IDSections);

        return "redirect:/";
    }

    @RequestMapping("/saveSection")
    public String saveSection(@ModelAttribute("section") Section section) {

        sectionService.save(section);

        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id,Model model) {

        Employee employee = employeeService.getEmployee(id);
        Buffer buffer = new Buffer();
        empSectService.deleteByEmployeeId(id);
        buffer.setEmployee(employee);
        buffer.setSectionList(sectionService.getAllSection());

        model.addAttribute("buffer",buffer);
        return "employeeInfo";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id) {

        employeeService.deleteEmployee(id);
        empSectService.deleteByEmployeeId(id);
        return "redirect:/";
    }

    @RequestMapping("/showSectionById")
    public String showSectionsById(@RequestParam("empId") int id, Model model) {

        List<Section> allSections = sectionService.getAllSectionsByIdS(empSectService.getSectionsByEmployee(id));
        model.addAttribute("allSections",allSections);

        return "allSectionsById";
    }

    @RequestMapping("/showEmployeesById")
    public String showEmployeesById(@RequestParam("sectId") int id, Model model) {

        List<Employee> allEmployees = employeeService.getAllEmployeesByIdS(empSectService.getEmployeesBySection(id));
        model.addAttribute("allEmployees",allEmployees);

        return "allEmployeesById";
    }

    @RequestMapping("/hrInfo")
    public String getInfoOnlyForHR() {
        return "viewForHR";
    }

    @RequestMapping("/managerInfo")
    public String getInfoOnlyForManagers() {
        return "viewForManagers";
    }

}
