package com.sde.jobportal.company.service;

import com.sde.jobportal.dto.CompanyDTO;
import com.sde.jobportal.entity.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICompanyService {
    List<CompanyDTO> getAllCompanies();
}
