package com.sde.jobportal.company.controller;

import com.sde.jobportal.dto.CompanyDTO;
import com.sde.jobportal.company.service.ICompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
//@CrossOrigin(origins = {"http://localhost:5173/"})
public class CompanyController {

   private final ICompanyService companyService;


    @GetMapping(path = "/public",version = "1.0")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
       return ResponseEntity.ok().body(companyService.getAllCompanies());
    }
}
