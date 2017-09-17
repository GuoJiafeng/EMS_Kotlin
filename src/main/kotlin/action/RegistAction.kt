package action

import entity.Manager
import service.impl.ManagerServiceImpl
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 21:03 2017/9/17 

   @Descripon : 
 
*/

class RegistAction : HttpServlet() {
    override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
        request!!.characterEncoding = "UTF-8"
        response!!.characterEncoding = "UTF-8"
        response.contentType = "text/html; charset=UTF-8 "

        var username = request.getParameter("username")
        var password = request.getParameter("password")
        var manger01 = Manager(username, password)

        var managerService = ManagerServiceImpl()
        managerService.regist(manger01)
    }
}