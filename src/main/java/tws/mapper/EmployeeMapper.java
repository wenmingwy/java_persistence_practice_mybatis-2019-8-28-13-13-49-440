package tws.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import tws.Employee;

@Mapper
public interface EmployeeMapper {
	@Insert("insert into employee values(#{employee.id},#{employee.name},#{employee.age})")
	void insert(@Param(value = "employee")Employee employee);
	
	@Select("select * from employee")
	List<Employee> select() ;
	
	@Update("update employee set name = #{employee.name}, age = #{employee.age} where id = #{id}" )
 	void update(@Param(value = "employee")Employee employee,@Param (value = "id" ) String id);
	
	@Delete("delete from employee where id = #{id}")
	void delete(@Param (value = "id") String id) ;
	
}
