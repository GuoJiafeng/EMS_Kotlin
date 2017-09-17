package service.impl

import dao.impl.EmpDaoImpl
import dao.impl.ManagerDaoImpl
import entity.Emp
import entity.Manager
import service.ManagerService
import util.Md5Util
import util.TransactionManager

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:38 2017/9/16 

   @Descripon : 
 
*/

class ManagerServiceImpl :ManagerService{
    var managerDao = ManagerDaoImpl()

    override fun login(manager: Manager): Manager {
        try {
            //开启事务
            TransactionManager.begin()
            var manager: Manager = managerDao.queryManagerByUsername(manager.username)

            var src = manager.password

           if (Md5Util.checkPassword(src,manager.password)) {
               manager.password = "true"
               return manager
           }
            manager.password = "false"
            return manager
            //提交事务
            TransactionManager.commit()

        } catch (e: Exception) {
            try {
                //回滚事务
                TransactionManager.rollback()
            } catch (ee: Exception) {
            }

            throw RuntimeException(e.message)
        }

    }

    override fun regist(manager: Manager) {

        try {
            //开启事务
            TransactionManager.begin()
            managerDao.insertManager(manager)


            //提交事务
            TransactionManager.commit()

        } catch (e: Exception) {
            try {
                //回滚事务
                TransactionManager.rollback()
            } catch (ee: Exception) {
            }

            throw RuntimeException(e.message)
        }

    }

}