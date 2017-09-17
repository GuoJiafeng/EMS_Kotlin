package entity


/*
   @Author :Create by Guo Jiafeng

   @Date : Created in 19:08 2017/9/16 

   @Descripon : 
 
*/
class PageBean(
        var pageNum: Int,
        var pageCount: Int,
        var totalCount: Int
) {

    fun getTotalPage():Int{
        if (totalCount % pageCount == 0)
            return totalCount / pageCount
        else
            return totalCount / pageCount + 1
    }
}