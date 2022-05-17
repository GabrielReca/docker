package com.example.docker.application.port;

import java.util.List;

import com.example.docker.domain.Empleado;

public interface EmpleadoService {

    List<Empleado> findAll();

    void insertEmployee(Empleado emp);

    void updateEmployee(Empleado emp);

    void executeUpdateEmployee(Empleado emp);

    public void deleteEmployee(Empleado emp);
}
