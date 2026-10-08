package com.spring_tutorial.board.service;

import java.util.List;

import com.spring_tutorial.board.model.dto.BoardDto;


public interface BoardService {
	
public List<BoardDto> listAll(int start, int end, String searchOption, String keyword) throws Exception;
	
	public int countArticle(String searchOption, String keyword) throws Exception;
	
	public void create(BoardDto dto) throws Exception;
	
	public BoardDto detail(int bno) throws Exception;
	
	public void update(BoardDto dto) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public void increaseViews(int bno, String userId) throws Exception;
	
}
