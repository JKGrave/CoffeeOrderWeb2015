package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosta.coffeeorder.dao.CoffeeDao;
import kr.kosta.coffeeorder.domain.Coffee;
import kr.kosta.coffeeorder.service.CoffeeService;

@Service
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeDao coffeeDao;
	
	public long registerCoffee(Coffee coffee) {
		return this.coffeeDao.insertCoffee(coffee);
	}

	public void modifyCoffee(Coffee coffee) {
		this.coffeeDao.updateCoffee(coffee);		
	}

	public void removeCoffee(long id) {
		this.coffeeDao.deleteCoffee(id);
	}

	public void removeCoffee(List<Long> idList) {
		this.coffeeDao.deleteCoffee(idList);
	}

	public List<Coffee> findCoffeeList() {
		List<Coffee> coffeeList = this.coffeeDao.selectCoffeeList();
		return coffeeList;
	}

	public Coffee findCoffee(long id) {
		Coffee coffee = this.coffeeDao.selectCoffee(id);
		return coffee;
	}

}
