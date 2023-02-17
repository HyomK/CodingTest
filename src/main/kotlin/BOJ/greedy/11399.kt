package BOJ.greedy

fun main(){
    P11399().solution()
}
class P11399 {
    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val people = readLine().split(" ").map{it.toInt()}.toMutableList()
        people.sort()
        var sum = 0
        var result = 0
        for(p in people){
            sum +=p
            result+=sum

        }
        println(result)
    }
}