package kr.kosta.coffeeorder.service;

import java.util.List;

import kr.kosta.coffeeorder.domain.Admin;

public interface AdminService {
	
	public void registerAdmin(Admin admin);
	public void modifyAdmin(Admin admin);
	public void removeAdmin(long id);
	public void removeAdmin(List<Long> idList);
	public List<Admin> findAdmins();
	public Admin findAdmin(long id);
	public Admin findAdminByAccount(String account);
	
	public boolean isEqualsPassword(String account, String password);
}
