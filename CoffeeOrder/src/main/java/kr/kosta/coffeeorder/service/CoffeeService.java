package kr.kosta.coffeeorder.service;

import java.util.List;

import kr.kosta.coffeeorder.domain.Coffee;

public interface CoffeeService {

	public long registerCoffee(Coffee coffee);
	public void modifyCoffee(Coffee coffee);
	public void removeCoffee(long id);
	public void removeCoffee(List<Long> idList);
	
	public List<Coffee> findCoffeeList();
	public Coffee findCoffee(long id);
}
