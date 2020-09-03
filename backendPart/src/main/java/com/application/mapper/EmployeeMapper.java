package com.application.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.application.model.*;

public class EmployeeMapper implements RowMapper<Employee> {
   public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
      Employee emp = new Employee();
      emp.setEmp_id(rs.getInt("emp_id"));	
      emp.setEmp_name(rs.getString("emp_name"));
      emp.setLog_role(rs.getInt("log_role"));
      emp.setDesignation(rs.getString("designation"));
      emp.setSv_emp_id(rs.getInt("sv_emp_id"));
      emp.setEmp_password(rs.getString("emp_password"));
      emp.setProject_id(rs.getInt("project_id"));
      emp.setPhone_no((rs.getLong("phone_no"))+"");
      emp.setMail_id(rs.getString("mail_id"));
      return emp;
   }
}
