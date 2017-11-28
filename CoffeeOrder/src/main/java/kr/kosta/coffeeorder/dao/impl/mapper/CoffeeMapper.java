package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Coffee;

public interface CoffeeMapper {


	public long insertCoffee(Coffee coffee);

	public void updateCoffee(Coffee coffee);
	
	public void deleteCoffee(long id);
	
	public void deleteCoffeeList(Map<String,Object> idList);

	public List<Coffee> selectCoffeeList();
	
	public Coffee selectCoffee(long id);
}
