package programmers.level1.최소직사각형

import java.lang.Integer.min

fun main(){
    val solution = Solution()
    val array = arrayOf<IntArray>(
        arrayOf(60,50).toIntArray(),
        arrayOf(30,70).toIntArray(),
        arrayOf(60,30).toIntArray(),
        arrayOf(80,40).toIntArray()
    )
    println(solution.solution(array))
}

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var xMax= sizes[0][0]
        var yMax = sizes[0][1]

        for(i in 1 until sizes.size){
            if(sizes[i][0] > xMax ){ // 이전 값 유지
                yMax = min(xMax, yMax)
                xMax = sizes[i][0]
            }else if(sizes[i][1] > yMax){ // 앞 변경
                xMax = min(xMax, yMax)
                yMax = sizes[i][1]
            }
        }
        return  xMax * yMax

    }
}