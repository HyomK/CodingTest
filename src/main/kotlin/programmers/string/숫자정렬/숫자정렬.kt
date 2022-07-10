package programmers.string.숫자정렬

private class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        val i = 0;
        val len = n.toString().length
        val str= n.toString()
        var array = arrayListOf<Char>()
        for(i in i..len-1){
            array.add(str.get(i))
        }
        var result = ""
        array.sorted().reversed().forEach {
            result+=it.toString()
        }

        println(  result.toLong())

        return answer
    }
}


fun main(){
    val sol = Solution()
    sol.solution( 118372)
}