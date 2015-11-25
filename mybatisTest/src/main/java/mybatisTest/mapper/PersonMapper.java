package mybatisTest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import mybatisTest.domain.Group;
import mybatisTest.domain.Person;

public interface PersonMapper {
	@Select("select * from person where name=#{name}")
	Person selectPerson(String name);
	@Select("select * from person where name=${name}")
	Person selectPerson1(String name);
	@Select("select * from person where id=${id}")
	Person selectPerson3(Person p);
	Person selectPerson4(Person p);
	void updatePerson(Person p);
	void insertPerson(Person p);
	void insertPerson1(Person p);
	
	void insertGroup(Group g);
	List<Person> selectPersonGroup(Person p);
}
