package dao;

import org.apache.ibatis.session.SqlSessionFactory;

import dto.GilDto;
import gil.config.DBService;

public class GilDao {
	
	private SqlSessionFactory factory;
	
	private GilDao() {
		factory = DBService.getInstance().getFactory();
	}
	private static GilDao gilDao = new GilDao();
	private static GilDao getInstance() {
		
		return gilDao;
	}
	
	// 메소드
}
