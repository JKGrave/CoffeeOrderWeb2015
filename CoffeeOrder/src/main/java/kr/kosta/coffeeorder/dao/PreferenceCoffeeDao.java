package kr.kosta.coffeeorder.dao;

import java.util.List;

import kr.kosta.coffeeorder.domain.PreferenceCoffee;

public interface PreferenceCoffeeDao
{
	public void insertPrefCoffee(PreferenceCoffee prefCoffee);

	public List<PreferenceCoffee> selectPrefCoffees(long memberId);

	public void deletePrefCoffee(long id);
}
