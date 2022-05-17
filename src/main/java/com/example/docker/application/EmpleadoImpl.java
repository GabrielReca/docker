package com.example.docker.application;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.docker.application.port.EmpleadoService;
import com.example.docker.domain.Empleado;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoImpl implements EmpleadoService {

    public EmpleadoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<Empleado> findAll() {
        return template.query("select * from employee", new EmpleadoRowMapper());
    }
    @Override
    public void insertEmployee(Empleado emp) {
        final String sql = "insert into employee(employeeId, employeeName , employeeAddress,employeeEmail) values(:employeeId,:employeeName,:employeeAddress,:employeeEmail)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employeeId", emp.getId())
                .addValue("employeeName", emp.getName())
                .addValue("employeeEmail", emp.getEmail())
                .addValue("employeeAddress", emp.getAddress());
        template.update(sql,param, holder);

    }

    @Override
    public void updateEmployee(Empleado emp) {
        final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("employeeId", emp.getId())
                .addValue("employeeName", emp.getName())
                .addValue("employeeEmail", emp.getEmail())
                .addValue("employeeAddress", emp.getAddress());
        template.update(sql,param, holder);

    }

    @Override
    public void executeUpdateEmployee(Empleado emp) {
        final String sql = "update employee set employeeName=:employeeName, employeeAddress=:employeeAddress, employeeEmail=:employeeEmail where employeeId=:employeeId";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("employeeId", emp.getId());
        map.put("employeeName", emp.getName());
        map.put("employeeEmail", emp.getEmail());
        map.put("employeeAddress", emp.getAddress());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }

    @Override
    public void deleteEmployee(Empleado emp) {
        final String sql = "delete from employee where employeeId=:employeeId";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("employeeId", emp.getId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


    }

}
