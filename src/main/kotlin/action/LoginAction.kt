package action

import service.impl.EmpServiceImpl
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:27 2017/9/17 

   @Descripon : 
 
*/
class LoginAction :HttpServlet(){
    override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
        request!!.characterEncoding = "UTF-8"
        response!!.characterEncoding = "UTF-8"
        response.contentType = "text/html; charset=UTF-8 "
        var username = request.getParameter("username")
        var password = request.getParameter("password")

        var empService = EmpServiceImpl()

    }
}