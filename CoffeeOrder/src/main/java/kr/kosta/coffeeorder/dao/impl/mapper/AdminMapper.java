package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;
import java.util.Map;

import kr.kosta.coffeeorder.domain.Admin;

public interface AdminMapper {
	public void insertAdmin(Admin admin);
	public void updateAdmin(Admin admin);
	public void deleteAdmin(long id);
	public void deleteAdmins(Map<String, Object> map);
	public Admin selectAdmin(long id);
	public List<Admin> selectAdmins();
	public Admin selectAdminByAccount(String account);
}
