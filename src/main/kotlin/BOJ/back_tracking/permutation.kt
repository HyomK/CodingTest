package BOJ.back_tracking

fun main(){
    Permutation().solve()
}
class Permutation {
    lateinit var nums : ArrayList<Int>

    fun solve(){
        nums = arrayListOf(1,2,3)
        val tempList = arrayListOf<Int>()
        val result = ArrayList<MutableList<Int>>()
        backTracking(result,tempList)
        println(result)
    }

    fun backTracking(result : ArrayList<MutableList<Int>>, tempList: ArrayList<Int> ) {
        if(tempList.isNotEmpty() &&  tempList.size == nums.size){
            val tmp = tempList.clone()
            result.add(tmp as ArrayList<Int>)
            return
        }
        for(i in 0 until nums.size){
            if(tempList.contains(nums[i])) continue
            tempList.add(nums[i])
            backTracking(result, tempList)
            tempList.removeLast()
        }
        return
    }

}