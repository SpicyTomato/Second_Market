package com.alliance.second_used_translation.controller;

import com.alliance.second_used_translation.domain.User;
import com.alliance.second_used_translation.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alliance.second_used_translation.utils.Content;

import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class UserController {
    @Autowired
    UserMapper userMapper;

    private int userNumber;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @ResponseBody
    @GetMapping("/users")
    public List<User> getUsers() {
        return userMapper.getAllUsers();
    }

    @RequestMapping("/userCount")
    @ResponseBody
    public int getUserCount() {

        log.info("有人正在查询....");
        return userMapper.getUsersCount();
    }

    @PostMapping("/loginUp")
    @ResponseBody
    public int loginUp(@RequestBody User user) {
        log.info(user.getName() + " 在尝试登录..... " + user.getPassword());
        if (userMapper.selectByName(user.getName()).getPassword().equals(user.getPassword())) {
            return 107;
        }

        return 108;
    }


    @ResponseBody
    @RequestMapping("/findUser")
    public String findUserI(@RequestParam(value = "id") int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user.getName();
    }

    @RequestMapping("/findUserN")
    @ResponseBody
    public String findUserN(@RequestParam(value = "name") String name) {
        User user = userMapper.selectByName(name);
        return user.getEmail();
    }

    //创建一个用户
    @PostMapping("/addUser")
    @ResponseBody
    public int addUser(@RequestParam(value = "name", defaultValue = Content.DEFAULT_NAME) String name,
                       @RequestParam(value = "phone") String phone,
                       @RequestParam(value = "email") String email,
                       @RequestParam(value = "bank_account") String bank_account,
                       @RequestParam(value = "gender") String gender,
                       @RequestParam(value = "password") String password) {


        userNumber = userMapper.getUsersCount();

        User user = new User();
        while (true) {
            if (userMapper.selectByPrimaryKey(userNumber + 1) == null) {
                if (userMapper.selectByName(name) == null) {
                    user.setId(userNumber + 1);
                    break;
                } else {
                    //用户名重复
                    return 101;
                }
            } else {
                userNumber++;
                continue;
            }
        }


        user.setName(name);
        user.setPassword(password);

        user.setPhone(phone);
        user.setEmail(email);
        user.setGender(gender);
        user.setBankAccount(bank_account);

        user.setIsAdministrator(0);
        user.setUpdateAt(new Date());
        user.setInsertAt(new Date());
        user.setUpdateBy(name);
        user.setInsertBy(name);
        user.setIsValid(1);


        //100创建成功
        //102插入失败
        return userMapper.insert(user) == 1 ? 100 : 102;
    }


    @PostMapping(value = "/addUserB")
    @ResponseBody
    public int addUser(@RequestBody User user) {
        log.info("有人正在插入....");

        userNumber = userMapper.getUsersCount();

        while (true) {
            if (userMapper.selectByPrimaryKey(userNumber + 1) == null) {
                if (userMapper.selectByName(user.getName()) == null) {
                    user.setId(userNumber + 1);
                    break;
                } else {
                    //用户名重复
                    return 101;
                }
            } else {
                userNumber++;
                continue;
            }
        }


        user.setIsAdministrator(0);
        user.setUpdateAt(new Date());
        user.setInsertAt(new Date());
        user.setInsertBy(user.getName());
        user.setUpdateBy(user.getName());

        user.setIsValid(1);


        //100创建成功
        //102插入失败
        return userMapper.insert(user) == 1 ? 100 : 102;
    }

    //创建一个管理员
    @RequestMapping("/addAdministrator")
    @ResponseBody
    public int addUser(@RequestParam(value = "name", defaultValue = Content.DEFAULT_NAME) String name,
                       @RequestParam(value = "password") String password) {

        userNumber = userMapper.getUsersCount();

        User user = new User();
        while (true) {
            if (userMapper.selectByPrimaryKey(userNumber + 1) == null) {
                if (userMapper.selectByName(name) == null) {
                    user.setId(userNumber + 1);
                    break;
                } else {
                    //用户名重复
                    return 101;
                }
            } else {
                userNumber++;
                continue;
            }
        }

        user.setName(name);
        user.setPassword(password);

        user.setPhone(Content.DEFAULT_PHONE);
        user.setEmail(Content.DEFAULT_EMAIL);
        user.setGender(Content.DEFAULT_GENDER);
        user.setBankAccount(Content.DEFAULT_BANKACCOUNT);

        user.setIsAdministrator(1);
        user.setUpdateAt(new Date());
        user.setInsertAt(new Date());
        user.setUpdateBy(name);
        user.setInsertBy(name);
        user.setIsValid(1);


        return userMapper.insert(user) == 1 ? 100 : 102;
    }

    @DeleteMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(@RequestParam(value = "id") int id) {
        User user = userMapper.selectByPrimaryKey(id);

        if (user == null) {
            return 104;
        }

        user.setIsValid(0);

        return userMapper.updateByPrimaryKey(user) == 1 ? 103 : 104;
    }

    @PostMapping("updateUser")
    @ResponseBody
    public int updateUser(@RequestParam(value = "name", defaultValue = Content.DEFAULT_NAME) String name,
                          @RequestParam(value = "phone") String phone,
                          @RequestParam(value = "email") String email,
                          @RequestParam(value = "bank_account") String bank_account,
                          @RequestParam(value = "gender") String gender,
                          @RequestParam(value = "password") String password) {

        User user = new User();

        user.setId(userMapper.selectByName(name).getId());
        user.setName(name);
        user.setName(name);
        user.setPassword(password);

        user.setPhone(phone);
        user.setEmail(email);
        user.setGender(gender);
        user.setBankAccount(bank_account);

        user.setIsAdministrator(0);
        user.setUpdateAt(new Date());
        user.setUpdateBy("name");
        user.setIsValid(1);


        return userMapper.updateByPrimaryKeySelective(user) == 1 ? 105 : 106;
    }


}
