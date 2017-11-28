package kr.kosta.coffeeorder.dao;

import java.util.List;

import kr.kosta.coffeeorder.domain.DiscountCard;
import kr.kosta.coffeeorder.domain.Member;
import kr.kosta.coffeeorder.dto.MemberSearchCond;
import kr.kosta.coffeeorder.dto.PageResult;

public interface MemberDao
{
	public Member selectMember(String phoneNumber);
	
	public List<Member> selectMembers();
	
	public void insertMember(Member member);

	public void updateMember(Member member);
	
	public void updateMileage(Member member);
	
	public void updatePoint(Member member);

	public void deleteMember(String phoneNumber);


	public Member selectMemberById(Long id);

	public DiscountCard selectDiscountCard(Long id);

	public int selectTotalMember();
	
	public PageResult selectMembersBySearcyCond(MemberSearchCond search);
}
