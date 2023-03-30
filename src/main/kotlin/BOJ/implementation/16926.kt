package BOJ.implementation

import java.util.StringTokenizer

fun main(){
    P16926().solution()
}

class P16926 {
    var N = 0
    var M = 0
    var R = 0
    lateinit var map : Array<IntArray>

    val dc = listOf(0,1,0,-1)
    val dr = listOf(1,0,-1,0)

    fun rotate(depth : Int){
        //맨 위의 왼쪽은 내려감
        //아래 오른 위 왼 방향 바뀌는 시점
        //아래나 위로 실행하는 것은 N번 , 옆으로는 M 번 실행됩니다
        val nMax  = N - depth -1
        val mMax = M - depth - 1
        val tmp = map[depth][depth]

        //위쪽 변 이동
        for(i in depth until mMax){
            map[depth][i] = map[depth][i+1]
        }
        //오른쪽 변 : 아래 ->위
        for(i in depth until nMax){
            map[i][mMax] = map[i+1][mMax]
        }
        //이레먄
        for(i in mMax downTo depth + 1){
            map[nMax][i] = map[nMax][i-1]
        }
        //왼쪽변
        for(i in nMax downTo depth + 1){
            map[i][depth] = map[i-1][depth]
        }
        map[depth+1][depth] = tmp

    }

    fun solution() = with(System.`in`.bufferedReader()){
        val input = StringTokenizer(readLine()," ")
        N = input.nextToken().toInt()
        M = input.nextToken().toInt()
        R = input. nextToken().toInt()

        map = Array(N){ IntArray(M){0} }

        repeat(N){it ->
           readLine().split(" ").map { it.toInt() }.toIntArray().let { arr -> map[it] = arr }
        }
        repeat(R){
            repeat(Math.min(N,M)/2){
                rotate(it)
            }
        }

        val buffer = java.lang.StringBuilder()
        repeat(N){
           map[it].forEachIndexed { index , num->
                if(index != M)buffer.append("$num ")
                else buffer.append("$num")
           }
           buffer.append("\n")
        }
        println(buffer)

    }
}