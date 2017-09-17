package service.impl

import dao.impl.EmpDaoImpl
import entity.Emp
import entity.PageBean
import service.EmpService
import util.TransactionManager

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:38 2017/9/16 

   @Descripon : 
 
*/
class EmpServiceImpl : EmpService {
    var empDao  = EmpDaoImpl()
    override fun addEmp(emp: Emp) {
        try {
            //开启事务
            TransactionManager.begin()

            empDao.insertEmp(emp)

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

    override fun deleteEmp(id: Int?) {
        try {
            //开启事务
            TransactionManager.begin()

            empDao!!.deleteEmp(id!!)

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

    override fun updateEmp(emp: Emp) {
        try {
            //开启事务
            TransactionManager.begin()

            empDao!!.updateEmp(emp)

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

    override fun queryAllEmp(pageBean: PageBean): ArrayList<Emp> {
        try {
            //开启事务
            TransactionManager.begin()

            var list :ArrayList<Emp>

            list = empDao.queryAll(pageBean)

            //提交事务
            TransactionManager.commit()

            return list

        } catch (e: Exception) {
            try {
                //回滚事务
                TransactionManager.rollback()
            } catch (ee: Exception) {
            }

            throw RuntimeException(e.message)
        }
    }

    override fun quertyEmpById(id: Int?): Emp {
        try {
            //开启事务
            TransactionManager.begin()

            var emp: Emp? = null

            emp = empDao!!.queryEmpById(id!!)

            //提交事务
            TransactionManager.commit()

            return emp!!

        } catch (e: Exception) {
            try {
                //回滚事务
                TransactionManager.rollback()
            } catch (ee: Exception) {
            }

            throw RuntimeException(e.message)
        }
    }

    override fun queryEmpByDeptname(name: String): List<Emp> {
        try {
            //开启事务
            TransactionManager.begin()

            var list: ArrayList<Emp>? = null

            list = empDao!!.queryEmpByDeptName(name)

            //提交事务
            TransactionManager.commit()

            return list!!

        } catch (e: Exception) {
            try {
                //回滚事务
                TransactionManager.rollback()
            } catch (ee: Exception) {
            }

            throw RuntimeException(e.message)
        }    }

    override fun batchDeletePersons(idList: List<Int>) {
        try {
            //开启事务
            TransactionManager.begin()
            if (idList==null) throw RuntimeException("并不能删除！")

            for (id in idList){
                empDao!!.deleteEmp(id)
            }
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