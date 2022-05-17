package com.example.docker.infrastructure.controller;

import java.util.List;

import javax.annotation.Resource;

import com.example.docker.application.port.EmpleadoService;
import com.example.docker.domain.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postgressApp")
public class EmpleadoController {

    @Autowired
    EmpleadoService employeeService;

    @GetMapping(value = "/employeeList")
    public List<Empleado> getEmployees() {
        return employeeService.findAll();

    }

    @PostMapping(value = "/createEmp")
    public void createEmployee(@RequestBody Empleado emp) {
        employeeService.insertEmployee(emp);

    }
    @PutMapping(value = "/updateEmp")
    public void updateEmployee(@RequestBody Empleado emp) {
        employeeService.updateEmployee(emp);

    }
    @PutMapping(value = "/executeUpdateEmp")
    public void executeUpdateEmployee(@RequestBody Empleado emp) {
        employeeService.executeUpdateEmployee(emp);

    }

    @DeleteMapping(value = "/deleteEmpById")
    public void deleteEmployee(@RequestBody Empleado emp) {
        employeeService.deleteEmployee(emp);

    }


}
