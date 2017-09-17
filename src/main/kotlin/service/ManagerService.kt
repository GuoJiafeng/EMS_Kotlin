package service

import entity.Manager

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:37 2017/9/16 

   @Descripon : 
 
*/

interface ManagerService{

    abstract fun login(usernmae: String): Manager
    abstract fun regist(manager: Manager)
}