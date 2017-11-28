package kr.kosta.coffeeorder.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.kosta.coffeeorder.dao.CoffeeDao;
import kr.kosta.coffeeorder.dao.impl.mapper.CoffeeMapper;
import kr.kosta.coffeeorder.domain.Coffee;

@Repository
public class CoffeeDaoImpl implements CoffeeDao {

	@Autowired
	private CoffeeMapper coffeeMapper;
	
	
	public long insertCoffee(Coffee coffee) {
		this.coffeeMapper.insertCoffee(coffee);
		return coffee.getId();
	}

	public void updateCoffee(Coffee coffee) {
		this.coffeeMapper.updateCoffee(coffee);
	}

	public void deleteCoffee(long id) {
		this.coffeeMapper.deleteCoffee(id);
	}

	public void deleteCoffee(List<Long> idList) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("idList",idList);
		this.coffeeMapper.deleteCoffeeList(map);
	}

	public List<Coffee> selectCoffeeList() {
		List<Coffee> coffeeList = coffeeMapper.selectCoffeeList();
		return coffeeList;
	}

	public Coffee selectCoffee(long id) {
		Coffee coffee = coffeeMapper.selectCoffee(id);
		return coffee;
	}

	
}
