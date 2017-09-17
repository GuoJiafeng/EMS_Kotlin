package dao.impl

import dao.EmpDao
import entity.Emp
import entity.PageBean
import util.EntityUtil
import util.JdbcUtil
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement


/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 19:13 2017/9/16 

   @Descripon : 
 
*/
class EmpDaoImpl : EmpDao {
    override fun queryEmpById(id: Int): Emp{
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        var rs: ResultSet? = null
        var emp :Emp?  = null
        try {
            conn = JdbcUtil.getConnection()
            val sql: String = "SELECT * FROM EMS_EMP WHERE ID = ?"
            pstm = conn.prepareStatement(sql)
            pstm.setInt(1, id)
            rs = pstm.executeQuery()
            while (rs.next()) {
                emp = Emp(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        java.util.Date(rs.getDate(5).time),
                        EntityUtil.toBooleanMarried(rs.getString(4)),
                        rs.getString(6))

            }
            return emp!!

        } catch (e: Exception) {
            throw RuntimeException(e.message)

        } finally {

            JdbcUtil.close(rs, pstm)
            JdbcUtil.close(conn)
        }

    }


    private fun getTotalCount(): Int {
        var conn: Connection? = null
        var stm: Statement? = null
        var rs: ResultSet? = null
        try {
            conn = JdbcUtil.getConnection()
            val sql = "select count(*) from ems_emp"
            stm = conn!!.createStatement()
            rs = stm!!.executeQuery(sql)
            var count = 0
            if (rs!!.next()) {
                count = rs.getInt(1)
            }
            return count
        } catch (e: Exception) {
            e.printStackTrace()
            throw RuntimeException(e.message)
        } finally {
            JdbcUtil.close(rs, stm)
        }

    }

    override fun queryAll(pageBean: PageBean): ArrayList<Emp> {
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        var rs: ResultSet? = null
        var emp: Emp
        var list  =ArrayList<Emp>()

        try {
            conn = JdbcUtil.getConnection()
            val pageCount = pageBean.pageCount


            val begin = (pageBean.pageNum - 1) * pageCount + 1
            val end = pageBean.pageNum * pageCount
            pageBean.totalCount = this.getTotalCount()

            val sql = "SELECT * FROM (SELECT e.*,ROWNUM rn FROM EMS_EMP e WHERE ROWNUM <=?) WHERE rn BETWEEN ? AND ?"
            pstm = conn.prepareStatement(sql)
            pstm.setInt(1,end)
            pstm.setInt(2,begin)
            pstm.setInt(3,end)

            rs = pstm.executeQuery()

            while (rs.next()) {
                emp = Emp(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        java.util.Date(rs.getDate(5).time),
                        EntityUtil.toBooleanMarried(rs.getString(4)),
                        rs.getString(6))
                list.add(emp)
            }

            return list

        }catch (e:Exception){
            throw RuntimeException(e.message)

        }finally {
            JdbcUtil.close(rs, pstm)
            JdbcUtil.close(conn)
        }
    }

    override fun queryEmpByDeptName(deptName: String): ArrayList<Emp>{
         println("数据库连接")
         var conn: Connection? = null
         var pstm: PreparedStatement? = null
         var rs: ResultSet? = null
         var list = ArrayList<Emp>()
         var emp:Emp ? = null

        try {
             conn = JdbcUtil.getConnection()
 
             val sql = "SELECT * FROM EMS_EMP WHERE DEPATNAME = ?"
             println("sql语句")
             pstm = conn.prepareStatement(sql)
             println(3)
             pstm.setString(1, deptName)
             println(4)
             rs = pstm.executeQuery()
             println(4)
             while (rs.next()) {
                 emp = Emp(
 
                         rs.getInt(1),
                         rs.getString(2),
                         rs.getDouble(3),
                         java.util.Date(rs.getDate(5).time),
                         EntityUtil.toBooleanMarried(rs.getString(4)),
                         rs.getString(6))
                 println(6)
                 list.add(emp)
                 println(7)
             }
             println(8)
             return list

            

         


        }catch (e:Exception){
            e.printStackTrace()
            throw RuntimeException(e.message)
        }finally {
             JdbcUtil.close(rs, pstm)
             JdbcUtil.close(conn)
        }
    }

    override fun insertEmp(emp: Emp) {
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        var rs: ResultSet? = null

        var id :Int? = null

        try {
            conn = JdbcUtil.getConnection()
            var seq_sql :String  = "SELECT  EMS_EMP_SEQ.nextval FROM dual"
            pstm =conn.prepareStatement(seq_sql)
            rs = pstm.executeQuery()
            while (rs.next()){
                id = rs.getInt(1)
            }

            var sql = "INSERT INTO EMS_EMP VALUES (?,?,?,?,?,?)"

            pstm = conn.prepareStatement(sql)
            pstm.setInt(1, id!!)
            pstm.setString(2, emp.name)
            pstm.setDouble(3, emp.Salary!!)
            pstm.setString(4, emp.getIsMarried)
            pstm.setDate(5, java.sql.Date(emp.hireDate!!.time))
            pstm.setString(6, emp.deptName)
            pstm.executeUpdate()

        }catch (e:Exception){
            e.printStackTrace()
            throw RuntimeException(e.message)
        }finally {

        }
    }

    override fun deleteEmp(id: Int) {
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        var rs: ResultSet? = null
        var emp: Emp? =null

        try {
            conn = JdbcUtil.getConnection()
            var sql :String  = "DELETE  FROM EMS_EMP WHERE ID = ?"
            pstm = conn.prepareStatement(sql)
            pstm.setInt(1, id)
            pstm.executeUpdate()



        }catch (e:Exception){

            e.printStackTrace()
            throw RuntimeException(e.message)
        }finally {

            JdbcUtil.close(rs, pstm)
        }
    }

    override fun updateEmp(emp: Emp) {
        var conn: Connection? = null
        var pstm: PreparedStatement? = null
        var rs: ResultSet? = null


        try {
            conn = JdbcUtil.getConnection()
            val sql = "UPDATE EMS_EMP SET NAME=?,SALARY=?,MARRIED=?,HIREDATE=?,DEPATNAME=? WHERE ID = ?"
            pstm = conn.prepareStatement(sql)
            pstm.setString(1, emp.name)
            pstm.setDouble(2, emp.Salary!!)
            pstm.setString(3, emp.getIsMarried)
            pstm.setDate(4, java.sql.Date(emp.hireDate!!.time))
            pstm.setString(5, emp.deptName)
            pstm.setInt(6, emp.id!!)
            pstm.executeUpdate()

        }catch (e:Exception){

            e.printStackTrace()
            throw RuntimeException(e.message)
        }finally {

            JdbcUtil.close(rs, pstm)
        }
    }

}