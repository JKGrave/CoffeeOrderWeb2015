package kr.kosta.coffeeorder.service;

import java.util.List;

import kr.kosta.coffeeorder.domain.PreferenceCoffee;

public interface PreferenceCoffeeService
{
	public void registerPrefCoffee(PreferenceCoffee prefCoffee);
	
	public List<PreferenceCoffee> findCoffees(long memberId);

	public void removePrefCoffee(long id);
}
