package com.lmelgz.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lmelgz.crud.bean.Department;
import com.lmelgz.crud.bean.Employee;
import com.lmelgz.crud.dao.DepartmentMapper;
import com.lmelgz.crud.dao.EmployeeMapper;
/**
 * 测试dao层的工作
 * @author lgz
 *推荐Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位置
 *3、直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeMapper employeeMapper;
	@Autowired
	private SqlSession sqlSession;
	@Test
	public void testCRUD() {
		
//		//1.创建SpringIOC容器
//		ApplicationContext ioc= new ClassPathXmlApplicationContext("applicationContext.xml");
//		//2.从容器中获取mapper
//		ioc.getBean(EmployeeMapper.class);
		System.out.println(departmentMapper);
//		departmentMapper.selectByPrimaryKey(1);
//		departmentMapper.insertSelective(new Department(null,"������"));
//		departmentMapper.insertSelective(new Department(null,"���Բ�"));
		
//		employeeMapper.insert(new Employee(null,"Jerry","M","Jerry@lmelgz",1));
		
		EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
//		for(int i=0;i<1000;i++) {
//			String uid=UUID.randomUUID().toString().substring(0, 5)+i;
//			mapper.insertSelective(new Employee(null,uid,"M",uid+"@lmelgz.com",1));
//		}
		mapper.deleteByPrimaryKey(1001);
	}
}
