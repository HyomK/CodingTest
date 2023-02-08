package BOJ.back_tracking

import kotlin.system.exitProcess

fun main(){
    P2661().solution()
}

class P2661 {
    var N = 0
    
    fun checker (num : String) :Boolean{
        //수열이 연속되면 안된다
       for(i in 1.. num.length/2){
           val left = num.substring( num.length - 2*i,num.length - i)//[len-2~len-1] [len-4~len-2]
           val right = num.substring(num.length-i,num.length) // 비교 길이가 점점 늘어남
           if(left ==right) return false
       }
        return true
    }
    
    fun backTracking( nums : String){
        if(nums.length == N){
              println(nums)
              exitProcess(0)
        }

        for(i in 1..3){
            if(checker(nums+i)) backTracking(nums+i)
        }
    }
    fun solution()=with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        backTracking("")
    }
}