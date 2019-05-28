package com.nt.dao;

import java.util.List;

import com.nt.domain.PersonDetails;

public interface PersonDetailsDAO {
   public int savePersonDetails(PersonDetails details);
   public List<PersonDetails> getAllPersonDetails();
   public List<Object[]> getPersonDetailsByDesg(String desg);
   
}
