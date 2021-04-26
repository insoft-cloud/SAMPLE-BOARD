package com.example.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.app.entity.BoardDto;

//BoardDao를 mapper로 정의
@Mapper
@Repository
public interface BoardDao {

	// INSERT
	@Insert("insert into board_oh values(0,#{board_name},#{board_title},#{board_text})")
	public void write(BoardDto boardDto)throws Exception;

	
	@Select("select * from board_oh order by board_no desc")
	public List<BoardDto> list()throws Exception;

	
	// UPDATE
	@Update("update board_oh set BOARD_title=#{board_title}\r\n" + 
			"		,board_text=#{board_text}\r\n" + 
			"		where board_no=#{board_no}")
	public void update(BoardDto boardDto)throws Exception;

	
	// DELETE
	@Delete("delete from board_oh where\r\n" + 
			"		board_no =#{board_no}")
	public void delete(BoardDto boardDto)throws Exception;

	
	@Select("select * from board_oh where board_no = #{board_no}")
	// SELECT (selectone)
	public BoardDto detail(int board_no)throws Exception;
}
