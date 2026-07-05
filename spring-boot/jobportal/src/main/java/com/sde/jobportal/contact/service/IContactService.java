package com.sde.jobportal.contact.service;


import com.sde.jobportal.dto.ContactRequestDTO;

public interface IContactService {

    public boolean saveContact(ContactRequestDTO contactRequestDTO);
}
