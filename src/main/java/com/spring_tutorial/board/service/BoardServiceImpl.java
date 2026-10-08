package com.spring_tutorial.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.BoardDto;
import com.spring_tutorial.board.model.dao.BoardDaoImpl;
import org.springframework.web.util.HtmlUtils;


@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDaoImpl boardDao;
	
	@Override
	public List<BoardDto> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		return boardDao.listAll(start, end, searchOption, keyword);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {

		return boardDao.countArticle(searchOption, keyword);
	}
	
	@Override
	public void create(BoardDto dto) throws Exception {
		// 对用户输入的标题和内容进行转义，防止XSS攻击
		dto.setTitle(HtmlUtils.htmlEscape(dto.getTitle()));
		dto.setContent(HtmlUtils.htmlEscape(dto.getContent()));
		boardDao.create(dto);
	}
	
	@Override
	public BoardDto detail(int bno) throws Exception {
		return boardDao.detail(bno);
	}
	
	@Override
	public void update(BoardDto dto) throws Exception {
		// 对用户输入的标题和内容进行转义，防止XSS攻击
		dto.setTitle(HtmlUtils.htmlEscape(dto.getTitle()));
		dto.setContent(HtmlUtils.htmlEscape(dto.getContent()));
		boardDao.update(dto);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}
	
	@Override
	public void increaseViews(int bno, String userId) throws Exception {
		boardDao.increaseViews(bno, userId);
	}
	
}
