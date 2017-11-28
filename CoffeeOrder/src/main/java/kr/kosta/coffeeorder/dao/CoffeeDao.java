package kr.kosta.coffeeorder.dao;

import java.util.List;

import kr.kosta.coffeeorder.domain.Coffee;

public interface CoffeeDao {

	public long insertCoffee(Coffee coffee);
	public void updateCoffee(Coffee coffee);
	
	public void deleteCoffee(long id);
	public void deleteCoffee(List<Long> idList);
	
	public List<Coffee> selectCoffeeList();
	public Coffee selectCoffee(long id);
}
