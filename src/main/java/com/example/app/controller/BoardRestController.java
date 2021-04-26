package com.example.app.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.BoardDto;
import com.example.app.repository.BoardDao;
import com.example.app.service.BoardService;

@CrossOrigin("*") // 아무나 들어와도 데이터를 주겠다는 뜻
@RequestMapping("/board")
@RestController
public class BoardRestController {

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private BoardService boardService;

	@Autowired
	private SqlSession sqlSession;

	private static final String mapper = "com.example.app.repository.BoardDao";
	// 작성

//	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
//	public void write(@RequestBody BoardDto boardDto) {
//
//		boardDao.write(boardDto);
//
//	}

	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> write(@RequestBody BoardDto boardDto) throws Exception {	//ResponseEntity 결과 데이터와 응답코드 반환가능.
		ResponseEntity<String> entity = null; //@RequestBody : 리턴 값을 HTTP 응답 데이터로 사용.
		try {								
			boardDao.write(boardDto);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// 리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET })
	public List<BoardDto> list() throws Exception {

		List<BoardDto> list = sqlSession.selectList(mapper+".list");
		
		return list;

	}

	// 수정
	@RequestMapping(value = "/put/{board_no}", method = { RequestMethod.GET, RequestMethod.PUT })
	public void update(@RequestBody BoardDto boardDto) throws Exception  {
		
		
		boardService.update(boardDto);
		

	}

	// 삭제
	@RequestMapping(value = "/delete/{board_no}", method = { RequestMethod.GET, RequestMethod.DELETE })
	public void delete(BoardDto boardDto) throws Exception {

		boardDao.delete(boardDto);

	}

	@RequestMapping(value = "/detail/{board_no}", method = { RequestMethod.GET, RequestMethod.POST })
	public BoardDto detail(@PathVariable int board_no) throws Exception {

		return boardDao.detail(board_no);

	}
}
