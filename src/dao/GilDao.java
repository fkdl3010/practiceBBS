package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.PageVo;
import dto.GilDto;
import gil.config.DBService;

public class GilDao {
	
	private SqlSessionFactory factory;
	
	private GilDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static GilDao gilDao = new GilDao();
	public static GilDao getInstance() {
		
		return gilDao;
	}
	
	// 메소드
	
	// 한 페이지의 게시물만 가져오는 메소드
	public List<GilDto> gilBBSList(PageVo pageVo){
		SqlSession ss = factory.openSession();
		List<GilDto> list = ss.selectList("gil.mapper.gil.selectList", pageVo);
		
		ss.close();
		
		return list;
	}
	
	public int gilCountRecord() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("gil.mapper.gil.selectCount");
		
		ss.close();
		return count;
	}
	
}
