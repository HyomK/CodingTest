package BOJ.short_path

import java.util.*

fun main(){
    _1956().solution()
}

class _1956 {
    lateinit var map : MutableList<IntArray>
    val MAX= 999_999_999

    fun solution() = with(System.`in`.bufferedReader()){
        val st = StringTokenizer(readLine(), " ")
        val V = st.nextToken().toInt()
        val E = st.nextToken().toInt()

        map = MutableList(V+1, { IntArray(V+1,{ MAX})} )

        for(i in 1..E){
            val input  = readLine().split(" ").map{it.toInt()}
            map[input[0]][input[1]]= input[2]
        }


        for( k in 1.. V){
            for( i in 1 ..V){
                for( j in 1 ..V){
                    if(i==j) continue
                    map[i][j] = Math.min(map[i][k]+map[k][j] , map[i][j])
                }
            }
        }

        var answer = MAX
        for( i in 1.. V){
            for( j in 1.. V){
                if(i==j) continue
                if(map[i][j] != MAX && map[j][i]!=MAX)
                    answer = Math.min(answer, map[i][j]+map[j][i])
            }
        }


        if(answer == MAX) println(-1)
        else println(answer)
    }
}