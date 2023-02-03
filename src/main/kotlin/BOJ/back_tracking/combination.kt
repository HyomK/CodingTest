package BOJ.back_tracking

fun main(){
    Combination().solve()
}
class Combination {
    lateinit var nums : ArrayList<Int>
    fun solve(){
        nums = arrayListOf(1,2,3)
        val r = 2
        val result = ArrayList<ArrayList<Int>>()
        backTracking( nums.size, r, 0 ,result, arrayListOf())
        println(result)
    }
    fun backTracking(n : Int, r : Int , start: Int, result: ArrayList<ArrayList<Int>> ,tempList : ArrayList<Int>){
        println( "start : $start  ${tempList}")
        if(tempList.size == r){
            result.add(tempList.clone() as ArrayList<Int>)
            return
        }else if(tempList.size > r) return
        for (i in start until nums.size){
            if(tempList.contains(nums[i]) ) continue
            tempList.add(nums[i])
            backTracking(n,r, i+1, result,tempList)
            tempList.removeLast()
        }
    }
}