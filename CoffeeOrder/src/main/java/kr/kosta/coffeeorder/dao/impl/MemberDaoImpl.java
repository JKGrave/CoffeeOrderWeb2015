package kr.kosta.coffeeorder.dao.impl;

import java.util.List;

import kr.kosta.coffeeorder.dao.MemberDao;
import kr.kosta.coffeeorder.dao.impl.mapper.MemberMapper;
import kr.kosta.coffeeorder.dao.impl.mapper.PreferenceCoffeeMapper;
//import kr.kosta.coffeeorder.domain.Coupon;
import kr.kosta.coffeeorder.domain.DiscountCard;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.dto.MemberSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao
{

	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PreferenceCoffeeMapper prefCoffeeMapper;

	@Override
	public Member selectMember(String phoneNumber)
	{
		Member member = this.memberMapper.selectMember(phoneNumber);
		if (member != null)
		{
			member.setPreferenceCoffee(prefCoffeeMapper.selectMemberPreferenceCoffee(member.getId()));
//			member.setCoupon(selectCoupons(member.getId()));
			return member;
		}
		else
		{
			return null;
		}
	}

	@Override
	public void insertMember(Member member)
	{
		this.memberMapper.insertMember(member);
	}

	@Override
	public void updateMember(Member member)
	{
		this.memberMapper.updateMember(member);
	}

	@Override
	public void updateMileage(Member member)
	{
		this.memberMapper.updateMileage(member);
	}

	@Override
	public void updatePoint(Member member)
	{
		this.memberMapper.updatePoint(member);
	}

	@Override
	public void deleteMember(String phoneNumber)
	{
		this.memberMapper.deleteMember(phoneNumber);
	}

	@Override
	public List<Member> selectMembers()
	{
		List<Member> members = this.memberMapper.selectMembers();
		for (int i = 0; i < members.size(); i++)
		{
			Member member = members.get(i);
			member.setPreferenceCoffee(prefCoffeeMapper.selectMemberPreferenceCoffee(member.getId()));
//			member.setCoupon(selectCoupons(member.getId()));
			members.set(i, member);
		}
		return members;
	}

//	@Override
//	public List<Coupon> selectCoupons(long memberId)
//	{
//		return this.memberMapper.selectMemberCoupon(memberId);
//	}

	@Override
	public Member selectMemberById(Long id)
	{
		return this.memberMapper.selectMemberById(id);
	}

	@Override
	public DiscountCard selectDiscountCard(Long id) {
		DiscountCard discountCard = this.memberMapper.selectDiscountCard(id);
		return discountCard;
	}

	@Override
	public int selectTotalMember() {
		int totalMember = this.memberMapper.selectTotalMember();
		return totalMember;
	}

	@Override
	public PageResult selectMembersBySearcyCond(MemberSearchCond search) {
		int totalCount = this.memberMapper.selectTotalMember();
		List<Member> list = this.memberMapper.selectMembersBySearcyCond(search);
		
		PageResult pageResult = new PageResult();
		pageResult.setResults(list);
		pageResult.setSearch(search);
		pageResult.setTotalCount(totalCount);
		
		return pageResult;
	}

}
