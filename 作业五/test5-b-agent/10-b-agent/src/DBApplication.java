
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBApplication {
	public static Connection conn = null;
	public ResultSet rs = null;

	private String databaseDriver;
	private String databaseConnStr;

	public DBApplication(String dBDriver, String dBConnStr) {
		databaseDriver = dBDriver;
		databaseConnStr = dBConnStr;
		try {
			Class.forName(databaseDriver);
			conn = DriverManager.getConnection(databaseConnStr);
		} catch (java.lang.ClassNotFoundException | SQLException e) {
			System.err.println("加载驱动器有错误:" + e.getMessage());
			System.out.print("执行插入有错误:" + e.getMessage()); // 输出到客户端
		}
	}

	public int executeInsert(String sql) {
		int num = 0;
		try {
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(30);
			System.out.println(sql + ";;;;");
			num = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println("执行插入有错误:" + ex.getMessage());
			System.out.print("执行插入有错误:" + ex.getMessage()); // 输出到客户端
		}

//       closeDataBase();
		return num;
	}

	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println("执行查询有错误:" + ex.getMessage() + sql);
			System.out.print("执行查询有错误:" + ex.getMessage()); // 输出到客户端
		}

		return rs;
	}

	public int executeDelete(String sql) {
		int num = 0;
		try {
			Statement stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println("执行删除有错误:" + ex.getMessage());
			System.out.print("执行删除有错误:" + ex.getMessage()); // 输出到客户端
		}

//       closeDataBase();
		return num;
	}

	public void closeDataBase() {
		try {
			conn.close();
		} catch (Exception end) {
			System.err.println("执行关闭Connection对象有错误：" + end.getMessage());
			System.out.print("执行执行关闭Connection对象有错误：有错误:" + end.getMessage()); // 输出到客户端
		}
	}
}
