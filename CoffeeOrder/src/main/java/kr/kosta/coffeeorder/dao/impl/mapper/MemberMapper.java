package kr.kosta.coffeeorder.dao.impl.mapper;

import java.util.List;

//import kr.kosta.coffeeorder.domain.Coupon;
import kr.kosta.coffeeorder.domain.DiscountCard;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.dto.MemberSearchCond;

public interface MemberMapper
{
	public Member selectMember(String phoneNumber);

	public void insertMember(Member member);

	public void updateMember(Member member);

	public void updatePoint(Member member);

	public void updateMileage(Member member);

	public void deleteMember(String phoneNumber);

	public List<Member> selectMembers();

//	public List<Coupon> selectMemberCoupon(long id);

	public Member selectMemberById(Long id);

	public DiscountCard selectDiscountCard(Long id);
	
	public int selectTotalMember();
	
	public List<Member> selectMembersBySearcyCond(MemberSearchCond search);
}
