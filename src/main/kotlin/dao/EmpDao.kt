package dao

import entity.Emp
import entity.PageBean

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 19:12 2017/9/16 

   @Descripon : 
 
*/
interface EmpDao {
    fun queryEmpById(id: Int): Emp
    fun queryAll(on: PageBean): ArrayList<Emp>
    fun queryEmpByDeptName(deptName: String): ArrayList<Emp>
    fun insertEmp(emo: Emp)
    fun deleteEmp(id: Int)
    fun updateEmp(emo: Emp)
}