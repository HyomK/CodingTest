package programmers

fun main(){
    val sol = Solution()
    println( sol.solution(13,17))
}

class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for(i in left..right){
            val n = divisor(i)
            if(n==0) continue
            else if(n%2==0) answer+=i
            else answer-=i
        }
        return answer
    }
}

fun divisor(n: Int):Int{
    var count =0
    for(i in 1 until n+1){
        if(n%i==0){
            count++;
        }
    }
    return count
}