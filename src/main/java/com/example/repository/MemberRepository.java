package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Member;

@Repository
public class MemberRepository {
	
	private static final RowMapper<Member> Member_Row_Mapper = (rs,i) -> {
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		
		return member;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Member> findByName(String str) {
		String sql = "select * from members where name like :str";
		SqlParameterSource param = new MapSqlParameterSource().addValue("str","%"+str+"%");
		List<Member> memberList = template.query(sql, param, Member_Row_Mapper);
		System.out.println(memberList);
		return memberList;
	}

}
