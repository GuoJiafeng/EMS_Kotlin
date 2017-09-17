package dao.impl

import dao.ManagerDao
import entity.Manager
import util.JdbcUtil
import util.Md5Util
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 19:13 2017/9/16 

   @Descripon : 
 
*/
class ManagerDaoImpl :ManagerDao{
    override fun queryManagerByUsername(name: String): Manager {
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        var rs: ResultSet? = null
        var manager: Manager? = null
        try {
            conn = JdbcUtil.getConnection()
            val sql = "SELECT * FROM EMS_MANAGER WHERE USERNAME = ?"
            pstm = conn!!.prepareStatement(sql)
            pstm!!.setString(1, name)
            rs = pstm.executeQuery()

            while (rs!!.next()) {
                manager = Manager(rs.getString(1), rs.getString(2))
            }
            return manager!!


        } catch (e: Exception) {
            e.message
            throw RuntimeException(e.message)
        } finally {
            JdbcUtil.close(rs, pstm)
            JdbcUtil.close(conn)
        }
    }

    override fun insertManager(manager: Manager) {
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        val rs: ResultSet? = null

        try {
            conn = JdbcUtil.getConnection()
            val sql = "INSERT INTO EMS_MANAGER VALUES (?,?)"
            pstm = conn!!.prepareStatement(sql)

            pstm!!.setString(1, manager.username)
            pstm.setString(2, Md5Util.encryption(manager.password))

            pstm.executeUpdate()


        } catch (e: Exception) {
            e.message
            throw RuntimeException(e.message)
        } finally {
            JdbcUtil.close(rs, pstm)
        }
    }

}