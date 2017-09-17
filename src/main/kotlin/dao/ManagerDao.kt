package dao

import entity.Manager

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 19:12 2017/9/16 

   @Descripon : 
 
*/
interface ManagerDao{
     fun queryManagerByUsername(name: String): Manager
     fun insertManager(manager: Manager)
}