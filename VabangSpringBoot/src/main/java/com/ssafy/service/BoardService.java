package com.ssafy.service;

import com.ssafy.util.PageNavigation;
import com.ssafy.domain.BoardDto;
import com.ssafy.domain.BoardParameterDto;
import java.util.List;

public interface BoardService {
	public boolean writeArticle(BoardDto boardDto) throws Exception;
	public List<BoardDto> listArticle(BoardParameterDto boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDto boardParameterDto) throws Exception;
	
	public BoardDto getArticle(int board_id) throws Exception;
	public void updateHit(int board_id) throws Exception;
	public boolean modifyArticle(BoardDto boardDto) throws Exception;
	public boolean deleteArticle(int board_id) throws Exception;
}
