package programmers.level1.나머지가1이되는수찾기

fun main(){
    val solution = Solution()
    println(solution.solution(10))
}

class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 3
        for(i in 2..n){
            if(n % i == 1 ){
                answer=i
                break
            }
        }

        return answer
    }
}