/*------------------------------------------------*/
/* THis class implements interface MessageLogger  */
/* This class provides a method called            */
/*            logMsg(String msg)                  */
/* to write a message into a file called log.txt  */
/*------------------------------------------------*/

import java.sql.SQLException;
import java.util.*;

public class DBWriter implements MessageWriter {
	private String lastName;
	private String firstName;
	private String codeNum;

	private static final String DBDRIVER = "org.sqlite.JDBC";
	private static final String DBCONNSTR = "jdbc:sqlite:infod.db";

	public void logMsg(String lastNm, String firstNm, String code) {
		firstName = firstNm;
		lastName = lastNm;
		codeNum = code;

		String sql = "INSERT INTO Agent " + "values(" + "'" + lastName + "','" + firstName + "','" + codeNum + "')";
		System.out.println(sql);
		DBApplication db;
		db = new DBApplication(DBDRIVER, DBCONNSTR);
		db.executeInsert(sql);
	}
}
