package action

import entity.Emp
import service.impl.EmpServiceImpl
import java.text.SimpleDateFormat
import java.util.*
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:20 2017/9/17 

   @Descripon : 
 
*/

class InsertEmpAction :HttpServlet(){
    override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {

        var name = request!!.getParameter("name")
        var isMarried = java.lang.Boolean.parseBoolean(request.getParameter("isMarried"))
        var salary = java.lang.Double.valueOf(request.getParameter("salary"))

        var time = request.getParameter("hireDate")
        var deptName = request.getParameter("deptName")
        var sdf = SimpleDateFormat("yyyy-MM-dd")
        var hireDate: Date? = null
        try {
            hireDate = sdf.parse(time)
        } catch (e: Exception) {
            throw RuntimeException("日期格式错误")
        }


        var empService =EmpServiceImpl()
        empService.addEmp(Emp(null,name,salary,hireDate,isMarried,deptName))



    }
}
