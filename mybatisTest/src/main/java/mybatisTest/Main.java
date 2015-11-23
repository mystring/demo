package mybatisTest;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import mybatisTest.domain.Person;
import mybatisTest.mapper.PersonMapper;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;

public class Main {
	static String url = "jdbc:mysql://192.168.126.11:3306/test?useUnicode=true&characterEncoding=utf8";
	static String username = "root";
	static String password = "199077";
	static String driver = "com.mysql.jdbc.Driver";
	static DataSource dataSource = new PooledDataSource(driver, url, username, password);

	/**
	 * 
	 */
	@Test
	public void test1() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(PersonMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		PersonMapper pm = session.getMapper(PersonMapper.class);
		Person p = pm.selectPerson("tom");
		System.out.println(p);
	}

	@Test
	public void test2() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(PersonMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		Person p = new Person();
		p.setName("tom or 1=1");
		List<Person> ps = session.selectList("mybatisTest.mapper.PersonMapper.selectPerson1", p);
		System.out.println(ps.size());
	}

	@Test
	public void test3() {
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(PersonMapper.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession session = sqlSessionFactory.openSession();
		Person p = new Person();
		p.setId(1);
		List<Person> ps = session.selectList("mybatisTest.mapper.PersonMapper.selectPerson3", p);
		System.out.println(ps.size());
	}

	/**
	 * 用xml构建
	 * 
	 * @throws IOException
	 */
	@Test
	public void testXml() throws IOException {
		String resource = "config/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSerssionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSerssionFactory.openSession();
		Person p = new Person();
		p.setId(1);
		 List<Person> ps = session.selectList("mybatisTest.mapper.PersonMapper.selectPerson4", p);
		for (Person tmp : ps) {
			System.out.println(tmp);
		} 
		System.out.println("----------------------------------------");
		List<Person> ps1 = session.selectList("mybatisTest.mapper.PersonMapper.selectPerson5", p);
		for (Person tmp : ps1) {
			System.out.println(tmp);
		}
	}
	/**
	 * 用xml构建
	 * 
	 * @throws IOException
	 */
	@Test
	public void testPlugin() throws IOException {
		String resource = "config/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSerssionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSerssionFactory.openSession();
		Person p = new Person();
		p.setId(1);
		p.setName("zhangshan");
		PersonMapper pm=session.getMapper(PersonMapper.class);
		pm.updatePerson(p);
 		 
	}
	/**
	 * 用xml构建
	 * 
	 * @throws IOException
	 */
	@Test
	public void testInsert() throws IOException {
		String resource = "config/configuration.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactory sqlSerssionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sqlSerssionFactory.openSession();
		Person p = new Person();
		p.setName("lise");
		p.setAge(22);
		PersonMapper pm=session.getMapper(PersonMapper.class);
		pm.insertPerson(p);
 		 
	}
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName(Main.driver);
		Connection c = DriverManager.getConnection(Main.url, Main.username, Main.password);
		System.out.println(c);
	}
}
