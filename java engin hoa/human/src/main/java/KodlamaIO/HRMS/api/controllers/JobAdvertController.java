package KodlamaIO.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import KodlamaIO.HRMS.business.abstracts.JobAdvertService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadvert")
public class JobAdvertController {
	private JobAdvertService jobAdvertService;

    @Autowired
    public JobAdvertController(JobAdvertService jobAdvertService) {
        super();
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("getall")
    public DataResult<List<JobAdvert>> getAll(){
        return this.jobAdvertService.getAll();
    }

    @GetMapping("getisactive")
    public DataResult<List<JobAdvert>> getIsActive(){
        return this.jobAdvertService.getByIsActiveTrue();
    }
    
    @GetMapping("getbyisactivetrueorderbypublishdate")
    public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPublishDesc(){
        return this.jobAdvertService.findByIsActiveTrueOrderByPublishDesc();
    }
    
     @GetMapping("findByIsActiveAndEmployerCompany")
    public DataResult<List<JobAdvert>> getByIsActiveAndEmployerCompany(@RequestParam int id){
    	return this.jobAdvertService.getByIsActiveAndEmployerCompany(id);
    }
     
    @PostMapping("add")
    public Result add(@RequestBody JobAdvert jobAdvert) {
    	return this.jobAdvertService.add(jobAdvert);
    }
    
    @PostMapping("update")
    public Result update(@RequestBody JobAdvert jobAdvert) {
    	return this.jobAdvertService.update(jobAdvert);
    }
    
    @DeleteMapping("delete")
    public Result delete(@RequestBody int id) {
    	return this.jobAdvertService.delete(id);
    }
    
    
}
