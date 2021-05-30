package KodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIO.HRMS.business.abstracts.JobService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        super();
        this.jobService = jobService;
    }

    @GetMapping("/getall")
    public DataResult<List<Job>> getAll(){
        return this.jobService.getAll();
    }

    @PostMapping("/findbyposition")
    public DataResult<List<Job>> findByPosition(@RequestBody String position){
        return this.jobService.findByPosition(position);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Job job) {
        return this.jobService.add(job);
    }

}