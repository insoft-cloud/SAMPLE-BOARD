package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.BoardDto;
import com.example.app.repository.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;

	/* 작성 */

	@Override
	public void write(BoardDto boardDto)throws Exception {
		boardDao.write(boardDto);

	}

	/* 리스트 */

	@Override
	public List<BoardDto> list()throws Exception {
		System.out.println("리스트 서비스 실행");
		return boardDao.list();

	}

	/* 수정 */

	@Override
	public void update(BoardDto boardDto)throws Exception {
		boardDao.update(boardDto);

	}

	/* 삭제 */

	@Override
	public void delete(BoardDto boardDto) throws Exception{
		boardDao.delete(boardDto);

	}

	@Override
	public BoardDto detail(int board_no)throws Exception {

		return boardDao.detail(board_no);

	}

}
