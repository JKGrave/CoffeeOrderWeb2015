package kr.kosta.coffeeorder.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.kosta.coffeeorder.domain.Admin;
import kr.kosta.coffeeorder.domain.Inventory;
import kr.kosta.coffeeorder.service.AdminService;
import kr.kosta.coffeeorder.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("inventory")
public class InventoryController
{
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("inventoryList")
	public ModelAndView showInventoryList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		long storeId = (long) session.getAttribute("loginStoreId");
		List<Inventory> inventoryList = inventoryService.findInventoryByStoreId(storeId);
		mav.addObject("inventoryList", inventoryList);
		mav.setViewName("/inventory/inventoryList");
		
		return mav;
	}
	
	@RequestMapping("order")
	public ModelAndView inventoryOrder(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		long storeId = (long) session.getAttribute("loginStoreId");
		mav.addObject("loginStoreId", storeId);
		List<Inventory> inventoryList = inventoryService.findInventoryByStoreId(storeId);
		mav.addObject("inventoryList", inventoryList);
		mav.setViewName("/inventory/order");
		
		
		return mav;
	}
	
	@RequestMapping(value="isOrderd", method=RequestMethod.POST)
	public ModelAndView isOrderd
		(
		@RequestParam("item") long id,
		@RequestParam("amount") int amount
		) {		
		ModelAndView mav = new ModelAndView();
		Inventory inventory = inventoryService.findInventory(id);
		int currentAmount = inventory.getAmount();
		inventory.setAmount(currentAmount+amount);
		inventoryService.modifyInventory(inventory);
		mav.setViewName("redirect:/inventory/order.do");
		return mav;
	}
	
}
