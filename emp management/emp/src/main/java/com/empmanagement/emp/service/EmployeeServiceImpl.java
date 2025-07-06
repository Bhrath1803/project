package com.empmanagement.emp.service;

import com.empmanagement.emp.model.Employee;
import com.empmanagement.emp.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public abstract class EmployeeServiceImpl implements EmployeeService{
@Autowired
   private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllemployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee saveemployee(Employee employee) {
       return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
       Optional<Employee> byId = employeeRepository.findById();
       if(byId.isPresent()){
          return byId.get();
       }else {
          throw new RuntimeException("Employee not found"+id);
       }
    }

    @Override
    public void updateEmployee(Long id, Employee updatedemp) {
       Optional<Employee> existId = employeeRepository.findById(id);
       if (existId.isPresent()){
          Employee existemp=existId.get();
          existemp.setFirstname(updatedemp.getFirstname);
          existemp.setLastname(updatedemp.getLastname);
          existemp.setEmail(updatedemp.getEmail());
          employeeRepository.save(existemp);
       }else {
          throw new RuntimeException("Employee not exist with id"+id);
       }
    }

    @Override
    public void deleteEmployee(Long id) {
       employeeRepository.deleteById(id);

    }
}


