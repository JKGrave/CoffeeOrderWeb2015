package kr.kosta.coffeeorder.service;

import java.util.List;

//import kr.kosta.coffeeorder.domain.Coupon;
import kr.kosta.coffeeorder.domain.DiscountCard;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.dto.MemberSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;

public interface MemberService
{
	public List<Member> findMembers();

	public Member findMember(String phoneNumber);

	public void registerMember(Member member);

	public void modifyMember(Member member);
	
	public void modifyMileage(Member member);
	
	public void modifyPoint(Member member);

	public void removeMember(String phoneNumber);

	public boolean isEqualsPassword(String phoneNumber, String password);
	
//	public List<Coupon> findCoupons(long memberId);
	
	public Member findMemberById(Long id);

	public DiscountCard findDiscountCard(Long id);
	
	public int findTotalMember();
	
	public PageResult fintMembersBySearchCond(MemberSearchCond search);
}
