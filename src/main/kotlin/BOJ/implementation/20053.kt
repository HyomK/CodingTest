package BOJ.implementation

fun main() {
    P20053().solution()
}

class P20053 {
    fun solution()=with(System.`in`.bufferedReader()){
        val case = readLine().toInt()
        repeat(case){
            val count = readLine().toInt()
            val li = readLine().toString().split(" ").map{it.toInt()}.toIntArray()
            findMinAndMax(li)
        }
    }

    fun findMinAndMax(list : IntArray){
        var MIN = 1_000_000
        var MAX = -1_000_000
        list.forEach { it->
            MIN = Math.min(MIN,it)
            MAX = Math.max(MAX,it)
        }
        println("${MIN} ${MAX}")
    }
}