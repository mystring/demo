package mybatisTest.objectfactory;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

 
public class ExampleObjectFactory extends DefaultObjectFactory {

	@Override
	public <T> T create(Class<T> type) {
		// TODO Auto-generated method stub
		return super.create(type);
	}

	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		// TODO Auto-generated method stub
		return super.create(type, constructorArgTypes, constructorArgs);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		super.setProperties(properties);
	} 
	
}
