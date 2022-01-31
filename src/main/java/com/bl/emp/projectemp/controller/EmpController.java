package com.bl.emp.projectemp.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bl.emp.projectemp.model.EmpModel;
import com.bl.emp.projectempservice.EmpService;
@Path("emp")
public class EmpController {

	EmpService emp = new EmpService();

	@POST
	@Path("/insertion")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpModel addEmployee(EmpModel employee) {
		return emp.addEmpModel(employee);
	}
	
	
	@GET
	@Path("/retrieve")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EmpModel> getAllEmployee() throws SQLException{
		return emp.getAllEmployee();
	}
	
	@GET
	@Path("/retrievebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<EmpModel> getEmployee(@PathParam("id") int id) throws SQLException {
		return emp.getEmployeeById(id);
	}
	
	@PUT
	@Path("/updatebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpModel updateEmpModel(EmpModel empmodel) {
		return emp.updateEmpModel(empmodel);

	}

	@DELETE
	@Path("/deletebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmpModel(@PathParam("id") int id) {
		emp.deleteEmpModel(id);

	}

}
