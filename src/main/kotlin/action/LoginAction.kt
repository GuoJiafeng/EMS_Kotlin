package action

import com.google.gson.Gson
import entity.Manager
import service.impl.EmpServiceImpl
import service.impl.ManagerServiceImpl
import java.io.PrintWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:27 2017/9/17 

   @Descripon : 
 
*/
class LoginAction : HttpServlet() {
    override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
        request!!.characterEncoding = "UTF-8"
        response!!.characterEncoding = "UTF-8"
        response.contentType = "text/html; charset=UTF-8 "
        var username = request.getParameter("username")
        var password = request.getParameter("password")
        var manger01 = Manager(username, password)

        var managerService = ManagerServiceImpl()
        var manger: Manager = managerService.login(manger01)

        var gson = Gson()
        var result = gson.toJson(manger)
        var out: PrintWriter = response.writer
        out.print(result)


    }
}