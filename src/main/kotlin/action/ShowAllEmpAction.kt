package action

import com.google.gson.Gson
import dao.impl.EmpDaoImpl
import entity.Emp
import entity.PageBean
import service.impl.EmpServiceImpl
import java.io.PrintWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:21 2017/9/16 

   @Descripon : 
 
*/


class ShowAllEmpAction : HttpServlet() {
    override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
        request!!.characterEncoding = "UTF-8"
        response!!.characterEncoding = "UTF-8"
        response.contentType = "text/html; charset=UTF-8 "

        var pn:String?= request.getParameter("pageNum")
        if(pn==""){
            pn = "1"
        }

        var pageNum :Int = pn!!.toInt()

        var pageBean = PageBean(pageNum , 2, 0)


        var empService = EmpServiceImpl()
        var list: ArrayList<Emp> = empService.queryAllEmp(pageBean)

        var gson = Gson()
        var toStringJson = gson.toJson(list)
        println(toStringJson)
        var out :PrintWriter = response.writer
        out.print(toStringJson)



    }
}