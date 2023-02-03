package BOJ.broute_force

import java.util.StringTokenizer

fun main(){
    P2961().solution()
}

class P2961 {

    data class Food(val sour : Long, val bitter : Long)
    val foods = arrayListOf<Food>()
    val checker = arrayListOf<Boolean>()
    var N = 0
    var min = 99999999L


    fun dfs(depth : Int){
        if(depth == N){
            var s = 1L
            var b = 0L
            for (i in foods.indices){
                if(checker[i]){
                    s *=  foods[i].sour
                    b += foods[i].bitter
                }
            }
            if(s!=1L && b!=0L) min = Math.min(min ,Math.abs(s-b))
            return
        }
        checker[depth] = true
        dfs( depth+1)
        checker[depth] = false
        dfs(depth+1)
    }

    fun solution() = with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        repeat(N){
            val st = StringTokenizer(readLine()," ")
            foods.add( Food(st.nextToken().toLong(), st.nextToken().toLong()))
            checker.add(false)
        }
        if(N==1) {
            min = Math.abs(foods.first().sour - foods.first().bitter)
        }else{
            dfs(0)
        }
        println(min)

    }
}