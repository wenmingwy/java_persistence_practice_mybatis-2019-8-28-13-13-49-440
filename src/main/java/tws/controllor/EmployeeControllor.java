package tws.controllor;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

 
import tws.Employee;
import tws.mapper.EmployeeMapper;
@RestController
@RequestMapping("/employees")
public class EmployeeControllor {
    List<Employee> employees = new ArrayList<Employee>();
    
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getEmployees() {
    	return employeeMapper.select();
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postEmployees(@RequestBody Employee employee) {
    	employeeMapper.insert(employee);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void putEmployees(@RequestBody Employee employee,@PathVariable String id) {
    	employeeMapper.update(employee,id);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployees(@PathVariable String id) {
    	employeeMapper.delete(id);
    }
    
    
    
    
    
    
//    public List<Employee> putEmployees(@PathVariable String id) {
//    	EmployeeControllor employeeControllor = new EmployeeControllor();
//    	List<Employee> employees = new ArrayList<Employee>();
//    	employees= employeeControllor.getEmployees();
//    	System.out.println(employees.get(0).getName());
//    	for(Employee e:employees) {
//    		if(e.getId().equals(id)) {
//    			e.setName("wenming");
//    		}
//    	}
//    	return employees;
//    }


}
