package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.kosta.coffeeorder.dao.MenuDao;
import kr.kosta.coffeeorder.domain.Menu;
import kr.kosta.coffeeorder.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;
	
	@Transactional
	public void registerMenu(Menu menu) {
		this.menuDao.insertMenu(menu);
	}

	@Transactional
	public void modifyMenu(Menu menu) {
		this.menuDao.updateMenu(menu);
	}

	@Transactional
	public void removeMenu(long id) {
		this.menuDao.deleteMenu(id);
	}

	@Transactional
	public void removeMenu(List<Long> idList) {
		this.menuDao.deleteMenus(idList);
	}

	public Menu findMenu(long id) {
		return this.menuDao.selectMenu(id);
	}

	public List<Menu> findMenus() {
		return this.menuDao.selectMenus();
	}

}
