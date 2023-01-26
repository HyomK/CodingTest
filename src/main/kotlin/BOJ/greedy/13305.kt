package BOJ.greedy

fun main(){
    P11305().solution()
}
class P11305 {
    fun solution() = with(System.`in`.bufferedReader()){
        val num = readLine().toInt()
        val road = readLine().split(" ").map{it.toLong()}
        val city = readLine().split(" ").map{it.toLong()}
        val dp = LongArray(num){ Long.MAX_VALUE.toLong()}
        val total = road.sum()
        var sum = 0L
        for(c in 0 until city.size -1){
            sum = 0

            for (i in c until road.size){
                sum+=road[i]
                if( c==0 ) dp[i] = sum * city[c]
                else  dp[i] = Math.min(dp[i],sum * city[c]+dp[c-1])
            }

        }
        println(dp[road.size-1])
    }
}