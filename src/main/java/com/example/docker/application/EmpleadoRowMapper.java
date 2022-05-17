package com.example.docker.application;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.docker.domain.Empleado;
import org.springframework.jdbc.core.RowMapper;

public class EmpleadoRowMapper implements RowMapper<Empleado> {

    @Override
    public Empleado mapRow(ResultSet rs, int arg1) throws SQLException {
        Empleado emp = new Empleado();
        emp.setId(rs.getString("employeeId"));
        emp.setName(rs.getString("employeeName"));
        emp.setEmail(rs.getString("employeeEmail"));

        return emp;
    }


}
