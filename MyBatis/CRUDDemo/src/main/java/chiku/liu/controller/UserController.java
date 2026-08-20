package chiku.liu.controller;

import chiku.liu.pojo.User;
import chiku.liu.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//组合注解，等于@Controller把这个类交给Spring成为控制器Bean+@ResponseBody方法返回值输出成JSON字符串
@RestController
//给当前控制器下所有接口加统一前缀
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/insert")
    public String insert(User user) {
        userService.insert(user);
        return "success";
    }

    @RequestMapping("/delete")
    public String deleteById(User user) {
        userService.deleteById(user.getId());
        return "success";
    }
}
