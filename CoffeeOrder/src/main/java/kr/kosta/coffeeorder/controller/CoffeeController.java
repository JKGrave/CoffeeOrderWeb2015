package kr.kosta.coffeeorder.controller;

import java.util.ArrayList;
import java.util.List;

import kr.kosta.coffeeorder.domain.Coffee;
import kr.kosta.coffeeorder.service.CoffeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("coffee")
public class CoffeeController {

	@Autowired
	private CoffeeService coffeeService;
	
	@RequestMapping("coffeeList")
	public ModelAndView showCoffeeList(){
		
		ModelAndView mav = new ModelAndView();
		
		List<Coffee> coffeeList = coffeeService.findCoffeeList();
		
		mav.setViewName("/coffee/coffeeList");
		mav.addObject("coffeeList",coffeeList);
				
		return mav;
	}
	
	@RequestMapping(value="register",method=RequestMethod.GET)
	public ModelAndView registerCoffeeForm(){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/coffee/register_form");
		
		return mav;
	}
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public ModelAndView registerCoffee(
			@RequestParam("name")String name,
			@RequestParam("price")int price,
			@RequestParam("productInfo")String productInfo
			){
		ModelAndView mav = new ModelAndView();
		
		Coffee coffee = new Coffee();
		coffee.setName(name);
		coffee.setPrice(price);
		coffee.setProductInfo(productInfo);
		coffeeService.registerCoffee(coffee);
		
		mav.setViewName("redirect:/coffee/coffeeList.do");
		
		return mav;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteCoffee(
			@RequestParam("no")String[] idStrList 
			){
		List<Long> idList = new ArrayList<Long>();
		for(String id : idStrList){
			idList.add(Long.parseLong(id));
		}
		coffeeService.removeCoffee(idList);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:/coffee/coffeeList.do");
		
		return mav;
	}
	
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public ModelAndView modifyCoffeeForm(
			@RequestParam("id")long id
			){
	
		ModelAndView mav = new ModelAndView();
		Coffee coffee = coffeeService.findCoffee(id);
		mav.addObject("coffee",coffee);
		mav.setViewName("/coffee/modify_form");
		
		return mav;
	}

	@RequestMapping(value="modify", method=RequestMethod.POST)
	public ModelAndView modifyCoffee(
			@RequestParam("id")long id,
			@RequestParam("name")String name,
			@RequestParam("price")int price,
			@RequestParam("productInfo")String productInfo
			){
	
		ModelAndView mav = new ModelAndView();
		Coffee coffee = coffeeService.findCoffee(id);
		coffee.setName(name);
		coffee.setPrice(price);
		coffee.setProductInfo(productInfo);
		
		coffeeService.modifyCoffee(coffee);
		
		mav.setViewName("redirect:/coffee/coffeeList.do");
		
		return mav;
	}

}
