package com.example.app.service;

import java.util.List;

import com.example.app.entity.BoardDto;

public interface BoardService {

	// INSERT
	public void write(BoardDto boardDto)throws Exception ;

	// SELECT (LIST)
	public List<BoardDto> list()throws Exception ;

	// UPDATE
	public void update(BoardDto boardDto)throws Exception ;

	// DELETE
	public void delete(BoardDto boardDto)throws Exception ;

	// SELECT (selectone)
	public BoardDto detail(int board_no)throws Exception;

}
