package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;

import kr.kosta.coffeeorder.domain.PreferenceCoffee;

public interface PreferenceCoffeeMapper
{
	public void insertPrefCoffee(PreferenceCoffee prefCoffee);
	
	public List<PreferenceCoffee> selectMemberPreferenceCoffee(long id);

	public void deletePrefCoffee(long id);
}
