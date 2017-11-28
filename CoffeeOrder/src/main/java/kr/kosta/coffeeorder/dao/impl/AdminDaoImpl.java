package kr.kosta.coffeeorder.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.dao.AdminDao;
import kr.kosta.coffeeorder.dao.impl.mapper.AdminMapper;
import kr.kosta.coffeeorder.domain.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private AdminMapper adminMapper;

	public void insertAdmin(Admin admin) {
		this.adminMapper.insertAdmin(admin);
	}

	public void updateAdmin(Admin admin) {
		this.adminMapper.updateAdmin(admin);
	}

	public void deleteAdmin(long id) {
		this.adminMapper.deleteAdmin(id);
	}

	public void deleteAdmins(List<Long> idList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idList", idList);
		this.adminMapper.deleteAdmins(map);
	}

	public Admin selectAdmin(long id) {
		return this.adminMapper.selectAdmin(id);
	}

	public List<Admin> selectAdmins() {
		return this.adminMapper.selectAdmins();
	}

	@Override
	public Admin selectAdminByAccount(String account) {
		return this.adminMapper.selectAdminByAccount(account);
	}

	@Override
	public boolean isEqualPassword(String account, String password) {
		Admin admin = this.selectAdminByAccount(account);
		if (admin == null) return false;

		if(admin.isEqualPassword(password)) {
			return true;
		} else {
			return false;
		}
	}

}
