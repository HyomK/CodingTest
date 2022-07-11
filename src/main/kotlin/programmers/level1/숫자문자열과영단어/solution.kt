package programmers.level1.숫자문자열과영단어
import java.lang.Integer.parseInt

fun main(){
    val sol = Solution()
    sol.solution("2three45sixseven")
}
class Solution {
    fun solution(s: String): Int {
        var answer = s
        val dict = mapOf(
            "zero" to 0,
            "one" to 1,
            "two" to 2,
            "three" to 3,
            "four" to 4,
            "five" to 5,
            "six" to 6,
            "seven" to 7,
            "eight" to 8,
            "nine" to 9
        )

        for((k, v) in dict){
            answer = answer.replace(k,v.toString())
        }
        return answer.toInt()
    }
}