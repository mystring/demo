package mybatisTest.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

public class ExampleTypeHandler implements TypeHandler<String> {

	public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
	}

	public String getResult(ResultSet rs, String columnName) throws SQLException {

		return rs.getNString(columnName);
	}

	public String getResult(ResultSet rs, int columnIndex) throws SQLException {
		return rs.getNString(columnIndex);
	}

	public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
		return cs.getString(columnIndex);

	}
}
