package com.example.app.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.entity.BoardDto;


public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;

	private static final String mapper = "com.example.app.repository.BoardDao";

	/* 작성 */

	@Override
	public void write(BoardDto boardDto)throws Exception {

		sqlSession.insert(mapper+".insert", boardDto);
		System.out.println("dao실행후");

	}

	/* 리스트 */

	@Override
	public List<BoardDto> list()throws Exception {
		System.out.println("Dao실행");
		return sqlSession.selectList(mapper+".list");

	}

	/* 수정 */
	@Override
	public void update(BoardDto boardDto)throws Exception {

		sqlSession.update(mapper+".update", boardDto);

	}

	/* 삭제 */
	@Override
	public void delete(BoardDto boardDto) throws Exception{
		System.out.println("?");
		sqlSession.delete(mapper+".delete", boardDto);

	}
	@Override
	public BoardDto detail(int board_no)throws Exception {

		return sqlSession.selectOne(mapper+".detail", board_no);
	}

}
