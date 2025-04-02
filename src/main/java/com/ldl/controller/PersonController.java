package com.ldl.controller;

import com.ldl.Service.PersonService;
import com.ldl.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Map;

@Controller
public class PersonController {
    @Autowired //用@Resource注解也可以，注入serivce层
    private PersonService ps;

    //显示首页
    @RequestMapping("jsp")
    public String callJsp(){
        return "index";
    }

    //显示所有人员信息
    @RequestMapping(value = "/person/all")
    public String findAll(Map<String,Object> model){
// 声明 model 用来传递数据
        List<Person> personList = ps.findAll();
        // 通过这一步，JSP 页面就可以访问 personList
        model.put("personList",personList);
        return "/person/personList";// 跳转到 personList 页面
    }

    //增加新人员信息
    @RequestMapping(value ="/person/create")
    public String toCteatePersonInfo(){  // 跳转新增页面
        return "/person/personCreate";
    }

    // 跳转修改页面
    @RequestMapping(value = "/person/update")
    public String toUpdatePersonInfo(Integer id, Model model) {
        Person pp = ps.get(id);
// 获得要修改的记录，重新设置页面的值
        model.addAttribute("p", pp);// 将数据放到model
        return "/person/personUpdate";
    }

    // 对修改或新增数据进行相应操作
    @RequestMapping(value ="/person/updateList")
    public String updatePersonList(Person p) {
        if (p.getId() == null) {
            ps.insert(p);   // 调用 Service 层方法，插入数据
        } else {
            ps.update(p);   // 调用 Service 层方法，更新数据
        }
        //下面一个语句可以不要
        //ModelAndView modelAndView = new ModelAndView();

//返回值类型改为ModelAndView
        //return new ModelAndView("redirect:/person/all");
        //return "forward:/person/all";//forward 转发
        return "redirect:/person/all";//redirect 定向
    }


    @RequestMapping(value = "/person/deleteById")
    public ModelAndView deleteById(Integer id){
        ps.deleteById(id);
        //ModelAndView modelAndView = new ModelAndView();
        return new  ModelAndView("redirect:/person/all");
    }
}
