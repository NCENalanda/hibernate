package com.nt.dao;

import java.util.List;

import com.nt.domain.Employee;
import com.nt.domain.Person;

public interface InheritenceDAO {
   public  String saveData()throws Exception;
   public List<Person> loadDataUsingPerson()throws Exception;
   public List<Employee> loadDataUsingEmployee()throws Exception;
}
