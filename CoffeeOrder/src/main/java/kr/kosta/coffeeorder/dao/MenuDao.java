package kr.kosta.coffeeorder.dao;

import java.util.List;

import kr.kosta.coffeeorder.domain.Menu;

public interface MenuDao {

	public void insertMenu(Menu menu);
	
	public void updateMenu(Menu menu);
	
	public void deleteMenu(long id);
	
	public void deleteMenus(List<Long> idList);
	
	public Menu selectMenu(long id);
	
	public List<Menu> selectMenus();
}
