package service

import entity.Emp
import entity.PageBean

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 20:37 2017/9/16 

   @Descripon : 
 
*/

interface EmpService{

    //添加联系人
    abstract fun addEmp(emp: Emp)

    //删除联系人
    abstract fun deleteEmp(id: Int?)

    //更新联系人
    abstract fun updateEmp(emp: Emp)
    //查询所有联系人

    abstract fun queryAllEmp(pageBean: PageBean): List<Emp>
    //通过id查询联系人
    abstract fun quertyEmpById(id: Int?): Emp

    //通过部门名称查询联系人
    abstract fun queryEmpByDeptname(name: String): List<Emp>

    abstract fun batchDeletePersons(idList: List<Int>)
}