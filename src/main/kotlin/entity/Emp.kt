package entity

import java.io.Serializable
import java.util.*

/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 18:47 2017/9/16 

   @Descripon : 
 
*/

 open class  Emp(var id: Int?,
                 var name: String?,
                 var Salary: Double?,
                 var hireDate: Date?,
                 private var married: Boolean?,
                 var deptName: String?)   : Serializable {

     val getIsMarried: String
        get() {
            if (married!!) {
                return "已婚"
            }
            return "未婚"
        }
     var getIsTrue: Boolean
         set(value) {
            getIsTrue = value
         }
         get() {
             return getIsTrue
         }

     override fun toString(): String {
         return "Emp(id=$id, name='$name', Salary=$Salary, hireDate=$hireDate, married=$married, deptName='$deptName')"
     }


 }