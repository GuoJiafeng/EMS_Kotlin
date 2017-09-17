package action

import com.google.gson.Gson
import entity.Emp
import service.impl.EmpServiceImpl
import java.io.PrintWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:12 2017/9/17 

   @Descripon : 
 
*/
class DeleteEmpAction : HttpServlet() {
    override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
        request!!.characterEncoding = "UTF-8"
        response!!.characterEncoding = "UTF-8"
        response.contentType = "text/html; charset=UTF-8 "


        //从客户端获取该员工的id
        var id: Int = request.getParameter("id").toInt()


        var empService = EmpServiceImpl()

        empService.deleteEmp(id)

    }
}
