package KodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIO.HRMS.business.abstracts.EmployeeUserService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.entities.concretes.EmployeeUser;

@RestController
@RequestMapping("/api/employeeusers")
public class EmployeeUserController {

    private EmployeeUserService employeeUserService;

    @Autowired
    public EmployeeUserController(EmployeeUserService employeeUserService) {
        super();
        this.employeeUserService = employeeUserService;
    }

    @GetMapping
    public DataResult<List<EmployeeUser>> getAll(){
        return this.employeeUserService.getAll();
    }


}