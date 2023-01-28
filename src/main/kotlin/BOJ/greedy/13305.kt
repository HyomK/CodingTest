package BOJ.greedy

fun main(){
    P11305().solution()
}
class P11305 {
    fun solution() = with(System.`in`.bufferedReader()){
        val num = readLine().toInt()
        val road = readLine().split(" ").map{it.toLong()}
        val city = readLine().split(" ").map{it.toLong()}
        var result = 0L

        //오일값이 싸지면 무조건 교체하는 것이 이득
        var now = city[0]

        for(i in 0 until city.size-1 ){
            now = Math.min(now,city[i])
            result += now * road[i]
        }

        println(result)
    }
}
