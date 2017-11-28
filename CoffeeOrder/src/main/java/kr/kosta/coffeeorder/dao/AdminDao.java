package kr.kosta.coffeeorder.dao;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Admin;

public interface AdminDao {
	
	public void insertAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(long id);
	public void deleteAdmins(List<Long> idList);
	public Admin selectAdmin(long id);
	public Admin selectAdminByAccount(String account);
	public boolean isEqualPassword(String account, String password);
	public List<Admin> selectAdmins();
}
