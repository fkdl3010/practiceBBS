package gil.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
	
	
	private SqlSessionFactory factory;
	
	private DBService() {
		try {
			String resource = "gil/config/sqlmap-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static DBService service = new DBService();
	public static DBService getInstance() {
		
		return service;
	}
	
	public SqlSessionFactory getFactory(){
		return factory;
	}
	
	
}
