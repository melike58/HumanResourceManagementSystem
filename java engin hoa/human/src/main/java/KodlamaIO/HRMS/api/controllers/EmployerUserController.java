package KodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIO.HRMS.business.abstracts.EmployerUserService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;

@RestController
@RequestMapping("/api/employerusers")
public class EmployerUserController {

    private EmployerUserService employerUserService;

    public EmployerUserController(EmployerUserService employerUserService) {
        super();
        this.employerUserService = employerUserService;
    }

    @GetMapping("/getall")
    public DataResult<List<EmployerUser>> getAll(){
        return this.employerUserService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerUser employerUser) {
        return this.employerUserService.add(employerUser);
    }
}