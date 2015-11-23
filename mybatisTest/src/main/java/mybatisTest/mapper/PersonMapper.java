package mybatisTest.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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
}
