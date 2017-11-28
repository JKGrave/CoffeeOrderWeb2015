package kr.kosta.coffeeorder.dao.impl;

import java.util.List;

import kr.kosta.coffeeorder.dao.PreferenceCoffeeDao;
import kr.kosta.coffeeorder.dao.impl.mapper.PreferenceCoffeeMapper;
import kr.kosta.coffeeorder.domain.PreferenceCoffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PreferenceCoffeeDaoImpl implements PreferenceCoffeeDao
{
	@Autowired
	private PreferenceCoffeeMapper prefCoffeeMapper;

	@Override
	public void insertPrefCoffee(PreferenceCoffee prefCoffee)
	{
		this.prefCoffeeMapper.insertPrefCoffee(prefCoffee);
	}
	
	@Override
	public List<PreferenceCoffee> selectPrefCoffees(long memberId)
	{
		return this.prefCoffeeMapper.selectMemberPreferenceCoffee(memberId);
	}

	@Override
	public void deletePrefCoffee(long id)
	{
		this.prefCoffeeMapper.deletePrefCoffee(id);
	}

}
