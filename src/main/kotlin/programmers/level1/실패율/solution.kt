package programmers.level1.실패율
fun main(){
    val sol = Solution()
    sol.solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)	)
}
class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        val tot = stages.size
        var rate = mutableMapOf<Int,Double>()

       val count =  stages.map{it.toString()}
            .groupingBy {it}
            .eachCount()
            .toSortedMap()

        var player= 0
        for (i in 1..N+1){
           if(! count.containsKey(i.toString()))
               rate[i] = 0.0
           else{
               count.getOrDefault(i.toString() , 0).toDouble().apply {
                   rate[i]= this / (tot-player)
                   player+=this.toInt()
               }
           }
        }

        answer= rate
            .toList()
            /*.sortedWith( comparator = Comparator { o1, o2 ->
                if(o1.second != o2.second){
                    if (o1.second < o2.second ) 1
                    else -1
                }
                else o1.first.toInt() -o2.first.toInt()} )*/
            .sortedByDescending { (_, value) ->value }
            .map { it.first.toInt() }
            .filter { it <= N }
            .toIntArray()

        println(answer.toList())
        return answer
    }
}