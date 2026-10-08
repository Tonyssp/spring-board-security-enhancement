package com.spring_tutorial.board.model.dao;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring_tutorial.board.model.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<BoardDto> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("board.listAll", map);
	}
	
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("board.countArticle", map);
	}
	
	@Override
	public void create(BoardDto dto) throws Exception {
		sqlSession.insert("board.create", dto);
	}
	
	@Override
	public BoardDto detail(int bno) throws Exception {
		return sqlSession.selectOne("board.detail", bno);
	}
	
	@Override
	public void update(BoardDto dto) throws Exception {
		sqlSession.update("board.update", dto);
	}
	
	@Override
	public void delete(int bno) throws Exception {
		sqlSession.delete("board.delete", bno);
	}
	
	@Override
	public void increaseViews(int bno, String userId) throws Exception {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("boardId", bno);
//		map.put("userId", userId);
//		String result = sqlSession.selectOne("board.checkViews", map);
//		
//		if(result == null) {
			sqlSession.update("board.updateViews", bno);
//			sqlSession.insert("board.addUserToBoardViews", map);
//		}
	}
}
