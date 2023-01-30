package BOJ.broute_force

import java.util.LinkedList

fun main (){
    P5568().solution()
}

class P5568 {
    lateinit var card  : IntArray
    var N = 0
    var K = 0
    var result = LinkedList<String>()

    fun perm ( start : Int,  depth : Int, visited : BooleanArray , number : String){

        if(depth == K){
            if(!result.contains(number)) result.add(number)
            return
        }
        for(i in 0 until N){
            if(!visited[i]){
                visited[i]=true
                var result = number
                result +=card[i].toString()
                perm(i,depth+1,visited,result)
                visited[i]=false
            }
        }
    }

    fun solution()=with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        K = readLine().toInt()
        card = IntArray(N){0}
        repeat(N){
            card[it]=readLine().toInt()
        }
        perm(card[0],0,BooleanArray(N){false},"")
        println(result.size)
    }
}