package com.ssafy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.domain.BoardDto;
import com.ssafy.domain.BoardParameterDto;
import com.ssafy.service.BoardService;

@RestController
@RequestMapping("/board")
@CrossOrigin("*")
public class BoardController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody BoardDto boardDto) throws Exception {
		if (boardService.writeArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<List<BoardDto>> listArticle(BoardParameterDto boardParameterDto) throws Exception {
		return new ResponseEntity<List<BoardDto>>(boardService.listArticle(boardParameterDto), HttpStatus.OK);
	}
	
	@GetMapping("/{board_id}")
	public ResponseEntity<BoardDto> getArticle(@PathVariable int board_id) throws Exception {
		boardService.updateHit(board_id);
		return new ResponseEntity<BoardDto>(boardService.getArticle(board_id), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<String> modifyArticle(@RequestBody BoardDto boardDto) throws Exception {

		if (boardService.modifyArticle(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@DeleteMapping("/{board_id}")
	public ResponseEntity<String> deleteArticle(@PathVariable int board_id) throws Exception {
		if (boardService.deleteArticle(board_id)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}