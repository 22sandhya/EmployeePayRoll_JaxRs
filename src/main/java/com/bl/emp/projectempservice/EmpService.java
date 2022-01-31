package com.bl.emp.projectempservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bl.emp.projectemp.model.EmpModel;


public class EmpService {
	private String dburl = "jdbc:mysql://localhost:3306/EmpCrud";
	private String dbname = "Sandhya";
	private String dbpassword = "root";

	Connection con = null;
	public void loadDriver(String dbDriver) {
		try {

			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
	
		try {
			con = DriverManager.getConnection(dburl, dbname, dbpassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}
	public ArrayList<EmpModel>  getAllEmployee() throws SQLException {
		ArrayList<EmpModel> data = new ArrayList<EmpModel>();
		String select = "select * from employee_payroll";
		PreparedStatement ps = con.prepareStatement(select);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			EmpModel model = new EmpModel();
			model.setId(rs.getInt("id"));
			model.setPhonenumber(rs.getInt("phonenumber"));
			model.setName(rs.getString("name"));
			model.setAddress(rs.getString("address"));
			model.setDepartment(rs.getString("department"));
			model.setGender(rs.getString("gender"));
			model.setSalary(rs.getInt("salary"));
		
			
			data.add(model);
		}
		return data;
	}

	public EmpModel addEmpModel(EmpModel employee) {
		String insert = "insert into employee_payroll(id,phonenumber,name,address,department,gender,salary) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, employee.getId());
			ps.setInt(1, employee.getPhonenumber());
			ps.setString(1, employee.getName());
			ps.setString(5, employee.getAddress());
			ps.setString(4, employee.getDepartment());
			ps.setString(2, employee.getGender());
			ps.setDouble(3, employee.getSalary());
			
			

			ps.execute();
		} catch (Exception e) {
			System.out.println(e + "insert unsuccessfull.");

		}
		return employee;

	}

	public ArrayList<EmpModel> getEmployeeById(int id) throws SQLException {

		ArrayList<EmpModel> data = new ArrayList<EmpModel>();
		String select = "select * from employee_payroll where id=?";
		PreparedStatement ps = con.prepareStatement(select);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			EmpModel model = new EmpModel();
			model.setId(rs.getInt("id"));
			model.setPhonenumber(rs.getInt("phonenumber"));
			model.setName(rs.getString("name"));
			model.setAddress(rs.getString("address"));
			model.setDepartment(rs.getString("department"));
			model.setGender(rs.getString("gender"));
			model.setSalary(rs.getInt("salary"));
			
			
			data.add(model);
		}
		return data;
	}

	public EmpModel updateEmpModel(EmpModel employee) {
		String update = "update employee_payroll set phonenumber=?,name = ?, address = ?,  department = ? gender = ?, salary = ?, where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(update);
			
			ps.setInt(1, employee.getId());
			ps.setInt(1, employee.getPhonenumber());
			ps.setString(1, employee.getName());
			ps.setString(5, employee.getAddress());
			ps.setString(4, employee.getDepartment());
			ps.setString(2, employee.getGender());
			ps.setDouble(3, employee.getSalary());
			

			ps.setInt(6, employee.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e + "update unsuccessfull.");

		}
		return employee;

	}

	public int deleteEmpModel(int id) {
		String delete = "delete from employee where id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e + "delete unsuccessfull.");

		}
		return id;

	}

}
