package kr.kosta.coffeeorder.service.impl;

import java.util.List;

import kr.kosta.coffeeorder.dao.MemberDao;
import kr.kosta.coffeeorder.dao.PreferenceCoffeeDao;
//import kr.kosta.coffeeorder.domain.Coupon;
import kr.kosta.coffeeorder.domain.DiscountCard;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.dto.MemberSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;
import kr.kosta.coffeeorder.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService
{

	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PreferenceCoffeeDao prefCoffeeDao;

	@Override
	public List<Member> findMembers()
	{
		return this.memberDao.selectMembers();
	}

	@Override
	public Member findMember(String phoneNumber)
	{
		return this.memberDao.selectMember(phoneNumber);
	}

	@Override
	public void registerMember(Member member)
	{
		this.memberDao.insertMember(member);
	}

	@Override
	public void modifyMember(Member member)
	{
		this.memberDao.updateMember(member);
	}
	
	
	@Override
	public void modifyMileage(Member member) {
		this.memberDao.updateMileage(member);
	}

	@Override
	public void modifyPoint(Member member) {
		this.memberDao.updatePoint(member);
	}


	@Override
	public void removeMember(String phoneNumber)
	{
		this.memberDao.deleteMember(phoneNumber);
	}

	@Override
	public boolean isEqualsPassword(String phoneNumber, String password)
	{
		Member member = findMember(phoneNumber);
		if (member == null)
		{
			return false;
		}
		if (member.isEqualPassword(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
//
//	@Override
//	public List<Coupon> findCoupons(long memberId)
//	{
//		return this.memberDao.selectCoupons(memberId);
//	}

	@Override
	public Member findMemberById(Long id) {
		// TODO Auto-generated method stub
		return this.memberDao.selectMemberById(id);
	}

	@Override
	public DiscountCard findDiscountCard(Long id) {
		return this.memberDao.selectDiscountCard(id);
	}

	@Override
	public int findTotalMember() {
		return this.memberDao.selectTotalMember();
	}

	@Override
	public PageResult fintMembersBySearchCond(MemberSearchCond search) {
		return this.memberDao.selectMembersBySearcyCond(search);
	}

	
}
