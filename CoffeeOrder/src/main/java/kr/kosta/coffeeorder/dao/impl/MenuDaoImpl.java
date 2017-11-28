package kr.kosta.coffeeorder.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.dao.MenuDao;
import kr.kosta.coffeeorder.dao.impl.mapper.MenuMapper;
import kr.kosta.coffeeorder.domain.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDaoImpl implements MenuDao {

	@Autowired
	private MenuMapper menuMapper;
	
	public void insertMenu(Menu menu) {
		this.menuMapper.insertMenu(menu);
	}

	public void updateMenu(Menu menu) {
		this.menuMapper.updateMenu(menu);
	}

	public void deleteMenu(long id) {
		this.menuMapper.deleteMenu(id);
	}

	public void deleteMenus(List<Long> idList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idList", idList);
		this.menuMapper.deleteMenus(map);
	}

	public Menu selectMenu(long id) {
		return menuMapper.selectMenu(id);
	}

	public List<Menu> selectMenus() {
		return menuMapper.selectMenus();
	}

}
