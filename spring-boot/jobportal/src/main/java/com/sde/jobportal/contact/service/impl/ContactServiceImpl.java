package com.sde.jobportal.contact.service.impl;


import com.sde.jobportal.contact.service.IContactService;
import com.sde.jobportal.dto.ContactRequestDTO;
import com.sde.jobportal.entity.Contact;
import com.sde.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl  implements IContactService {

    private  final ContactRepository contactRepository;
    @Override
    public boolean saveContact(ContactRequestDTO contactRequestDTO) {
        boolean result = false;
        Contact contact = contactRepository.save(transformToEntity(contactRequestDTO));
        if(contact != null && contact.getId() != null) {
            result = true;
        }
        return result;
    }

    private Contact transformToEntity(ContactRequestDTO contactRequestDTO) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactRequestDTO, contact);
//        contact.setCreatedAt(Instant.now());
//        contact.setCreatedBy("System");
        contact.setStatus("NEW");
        return contact;
    }


}
