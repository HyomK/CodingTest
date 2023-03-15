package BOJ.implementation

import java.util.Deque
import java.util.Queue
import java.util.StringTokenizer

fun main(){
    P1913().solution()
}
class P1913 {

    val dr = listOf(-1,0,1,0)
    val dc= listOf(0,1,0,-1)

    fun solution () = with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val M = readLine().toInt()

        val map = Array(N) { IntArray(N) { 0 } }
        var r = N/2
        var c = r
        var num = 1
        var cnt =1
        var posR = r+1
        var posC = c+1

        val arrow = ArrayDeque<Int>()

        map[r][c] = num++
        arrow.add(0)
        arrow.add(1)
        cnt++

        while(num<=N*N){
            //2
            if(arrow.isEmpty()){
                if(cnt%2==0){
                    repeat(cnt){
                        arrow.add(2)
                    }
                    repeat(cnt){
                        arrow.add(3)
                    }
                }else{
                    repeat(cnt){
                        arrow.add(0)
                    }
                    repeat(cnt){
                        arrow.add(1)
                    }
                }
                cnt++
            }else{
                val cur = arrow.removeFirst()
                val nr = r+dr[cur]
                val nc= c+dc[cur]
                if(nr in 0 until N &&nc in 0 until N){
                    if(num == M){
                       posR = nr+1
                       posC = nc+1
                    }
                    map[nr][nc] = num++
                    r = nr
                    c = nc
                }
            }
        }
        val st = java.lang.StringBuilder()

        for(line in map){
            line.forEach { it -> st.append("$it ") }
            st.append("\n")
        }
        print(st)
        print("$posR $posC")

    }
}