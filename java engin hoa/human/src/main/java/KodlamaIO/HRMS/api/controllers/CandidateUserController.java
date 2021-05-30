package KodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIO.HRMS.business.abstracts.CandidateUserService;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.CandidateUser;

@RestController
@RequestMapping("/api/candidateusers")
public class CandidateUserController {

    private CandidateUserService candidateUserService;

    @Autowired
    public CandidateUserController(CandidateUserService candidateUserService) {
        super();
        this.candidateUserService = candidateUserService;
    }

    @GetMapping("/getall")
    public DataResult<List<CandidateUser>> getAll(){
        return this.candidateUserService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateUser candidateUser) {
        return this.candidateUserService.add(candidateUser);
    }

}