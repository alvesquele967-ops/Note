package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
//相当于往spring容器里面创建了一个spring mvc对象
//@RestController
//@RequestMapping("/index")
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@RequestMapping("/hello")
//	public String hello() {
//		return "Hello World";
//	}
//
////	@GetMapping
////	public String index() {
////		return "GET无参请求Api方法已经实现";
////	}
////	等价于
////	@RequestMapping(method = RequestMethod.GET)
////	public String index() {
////		return "GET无参请求Api方法已经实现";
////	}
//
////	restful传值
//	@GetMapping("/{id}")
//	public String index(@PathVariable Integer id) {
//		System.out.printf("ID=%s\n" , id);
//		return "GET Restful请求传值的方法实现成功";
//	}
////	例如http://localhost:90/api/index?id=1&name=tt
//	@GetMapping
//	public String index2(@RequestParam String id, @RequestParam String name) {
//		System.out.printf("ID=%s\n" , id);
//		System.out.printf("Name=%s\n" , name);
//		return "GET 普通请求方法已经实现";
//	}
//	@PostMapping
//	public String save(@RequestBody Map<String, String> map) {
//		System.out.printf(map.toString());
//		return "POST 请求接收成功";
//	}
//	@PutMapping("/{id}")
//	public String update(@PathVariable Integer id, @RequestBody Map<String, String> map) {
//		System.out.printf("ID=%s\n" , id);
//		System.out.printf("Name=%s\n" , map.get("name"));
//		System.out.printf("Age=%s\n" , map.get("age"));
//		System.out.printf("Map=%s\n" , map);
//		return "PUT 请求接收成功";
//	}
//	@DeleteMapping("/{id}")
//	public String delete(@PathVariable Long id) {
//		System.out.printf("ID=%s\n" , id);
//		return "DELETE 请求接收成功";
//	}
//
////	@SpringBootApplication：SpringBoot项目启动核心注解，自动开启自动配置、组件扫描，标记当前类为启动类
////	@RestController：组合注解，等价@Controller+@ResponseBody，所有方法返回值直接作为HTTP响应正文，不跳转页面
////	@RequestMapping：定义接口请求基础访问路径，可标注类或方法，支持限定请求方式
////	@GetMapping：@RequestMapping限定GET请求方式的简写，只接收GET类型请求
////	@PostMapping：@RequestMapping限定POST请求方式的简写，只接收POST类型请求
////	@PutMapping：@RequestMapping限定PUT请求方式的简写，只接收PUT类型请求
////	@DeleteMapping：@RequestMapping限定DELETE请求方式的简写，只接收DELETE类型请求
////	@PathVariable：获取URL路径上restful风格占位参数，绑定到方法入参
////	@RequestParam：获取URL问号后面拼接的query查询参数，绑定到方法入参
////	@RequestBody：读取请求体JSON数据，自动封装为指定Java对象/Map，常用于POST、PUT请求
//


}
