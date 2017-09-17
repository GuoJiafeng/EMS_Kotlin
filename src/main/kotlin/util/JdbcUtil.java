package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
    private final static ThreadLocal<Connection> tol = new ThreadLocal<Connection>();

    public static Connection getConnection() {

        Connection conn = tol.get();

        if (conn == null) {
            try {

                Context context = new InitialContext();
                DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
                conn = ds.getConnection();
                tol.set(conn);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
        return conn;
    }

    public static void close(ResultSet rs, Statement stm) {
        if (rs != null) try {
            rs.close();
        } catch (Exception e) {
        }
        if (stm != null) try {
            stm.close();
        } catch (Exception e) {
        }
    }

    public static void close(Connection conn) {
        if (conn != null) try {
            conn.close();
            tol.remove();
        } catch (Exception e) {
        }
    }


}





