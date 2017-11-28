package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Menu;

public interface MenuMapper {

	void insertMenu(Menu menu);

	void updateMenu(Menu menu);

	void deleteMenu(long id);

	void deleteMenus(Map<String, Object> map);

	Menu selectMenu(long id);

	List<Menu> selectMenus();
}
