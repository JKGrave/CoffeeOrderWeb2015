package kr.kosta.coffeeorder.service;

import java.util.List;

import kr.kosta.coffeeorder.domain.Menu;

public interface MenuService {
	
	public void registerMenu(Menu menu);
	
	public void modifyMenu(Menu menu);
	
	public void removeMenu(long id);
	
	public void removeMenu(List<Long> idList);
	
	public Menu findMenu(long id);
	
	public List<Menu> findMenus();
}
