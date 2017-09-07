package com.itheima.web.servlet;

import com.itheima.domain.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 13718 on 2017/9/7.
 */
@Controller
//@RequestMapping("/SpringMVCTest")
public class SpringMVCTest{

    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping(value = "/SpringMVCTest/start.action")
    public String TestSpringMVC(Model model){


        String str4 = "第一个SpringMVC程序,啊";

        model.addAttribute("zzz",str4);
        return "SpringMVCTest";
    }


    @RequestMapping(value = "/item/itemlist.action")
    public ModelAndView itemList(){

        List<Items> list = new ArrayList<Items>();
        list.add(new Items(1, "1华为 荣耀8", 2399f, new Date(), "质量好！1"));
        list.add(new Items(2, "2华为 荣耀8", 2399f, new Date(), "质量好！2"));
        list.add(new Items(3, "3华为 荣耀8", 2399f, new Date(), "质量好！3"));
        list.add(new Items(4, "4华为 荣耀8", 2399f, new Date(), "质量好！4"));
        list.add(new Items(5, "5华为 荣耀8", 2399f, new Date(), "质量好！5"));
        list.add(new Items(6, "6华为 荣耀8", 2399f, new Date(), "质量好！6"));

        ModelAndView mav = new ModelAndView();
        String str = "这是黑马商城";
        mav.addObject("itemList", list);
        mav.addObject("str",str);
        mav.setViewName("itemList");
        return mav;
    }
}
