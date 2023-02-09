package BOJ.back_tracking

import java.util.StringTokenizer

fun main(){
    P14712().solution()
}

class P14712 {
    var N = 0
    var M = 9
    lateinit var map : Array<BooleanArray>

    val dc = listOf(-1,0,-1)
    val dr = listOf(-1,-1,0)

    var cnt = 0

    fun checker (row : Int, col : Int) : Boolean{
        var count  = 0
        for(i in 0 until 3){
            val nc = col + dc[i]
            val nr = row + dr[i]

            if( !((nc in 0 until M) && (nr in 0 until N))) continue

            if(map[nr][nc]){
                count ++
            }
        }
        if(count==3) return false

        return true
    }

    fun backTracking(row: Int,  col : Int){
        if(row == N-1 && col == M){
            cnt ++
            return
        }
        var nc = col
        var nr = row

        if(nc==M){
            nc=0
            nr++ //행증가
        }

        map[nr][nc] = true
        if(checker(nr,nc)) backTracking(nr, nc+1) // 네모가 안될때 넣는다
        map[nr][nc] = false
        backTracking(nr, nc+1)

    }

    fun solution() = with(System.`in`.bufferedReader()){
        val st = StringTokenizer(readLine() , " ")
        N = st.nextToken().toInt()
        M = st.nextToken().toInt()

        map = Array(N){ BooleanArray(M){false} }

        backTracking(0 , 0)

        println(cnt)
    }
}