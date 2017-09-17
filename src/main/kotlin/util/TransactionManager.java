package util;

import java.sql.Connection;

public class TransactionManager {
   
	public static void begin() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		conn.setAutoCommit(false);
	}
	
	public static void commit() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		conn.commit();
		JdbcUtil.close(conn);
	}
	
	public static void rollback() throws Exception{
		Connection conn = JdbcUtil.getConnection();
		conn.rollback();
		JdbcUtil.close(conn);
	}
	
}
