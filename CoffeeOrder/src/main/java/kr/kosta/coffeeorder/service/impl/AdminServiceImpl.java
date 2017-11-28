package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import kr.kosta.coffeeorder.dao.AdminDao;
import kr.kosta.coffeeorder.domain.Admin;
import kr.kosta.coffeeorder.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;
	
	public void registerAdmin(Admin admin) {
		this.adminDao.insertAdmin(admin);
	}

	public void modifyAdmin(Admin admin) {
		this.adminDao.updateAdmin(admin);
		
	}

	public void removeAdmin(long id) {
		this.adminDao.deleteAdmin(id);		
	}

	public void removeAdmin(List<Long> idList) {
		this.adminDao.deleteAdmins(idList);
		
	}

	public List<Admin> findAdmins() {
		return this.adminDao.selectAdmins();
	}

	public Admin findAdmin(long id) {
		return this.adminDao.selectAdmin(id);
	}
	
	@Override
	public Admin findAdminByAccount(String account) {
		return this.adminDao.selectAdminByAccount(account);
	}

	@Override
	public boolean isEqualsPassword(String account, String password) {
		Admin admin = findAdminByAccount(account);
		if(admin==null){
			return false;
		}
		if(admin.isEqualPassword(password)) {
			return true;
		} else {
			return false;			
		}
		
	}


}
