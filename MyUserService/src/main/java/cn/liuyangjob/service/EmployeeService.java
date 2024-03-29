package cn.liuyangjob.service;

import cn.liuyangjob.Mapper.EmployeeMapper;
import cn.liuyangjob.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/get/{id}")
    public Employee getEmployee(@PathVariable long id) {
        Employee employee = employeeMapper.findById(id);

        return employee;
    }

    @RequestMapping("/getport")
    public String getPort() {
        /*int random = new Random().nextInt(3000);
        System.out.println("Time = " + random);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return port;

    }

    @RequestMapping("/getinfo")
    public Object getServerInfo() {
        return port;
    }
}
