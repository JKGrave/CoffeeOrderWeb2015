package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kosta.coffeeorder.dao.PreferenceCoffeeDao;
import kr.kosta.coffeeorder.domain.PreferenceCoffee;
import kr.kosta.coffeeorder.service.PreferenceCoffeeService;

@Service
public class PreferenceCoffeeServiceImpl implements PreferenceCoffeeService
{
	@Autowired
	private PreferenceCoffeeDao prefCoffeeDao;

	@Override
	public void registerPrefCoffee(PreferenceCoffee prefCoffee)
	{
		this.prefCoffeeDao.insertPrefCoffee(prefCoffee);
	}
	
	@Override
	public List<PreferenceCoffee> findCoffees(long memberId)
	{
		return this.prefCoffeeDao.selectPrefCoffees(memberId);
	}

	@Override
	public void removePrefCoffee(long id)
	{
		this.prefCoffeeDao.deletePrefCoffee(id);
	}

}
