package BOJ.back_tracking

fun main(){
    P9663().solution()
}

class P9663 {
    data class Pos(val row : Int, val col : Int)

    var N = 0
    var result = 0
    var col = Array(15){0}

    fun checker(cur : Pos) : Boolean{
        //행탐색
        for(i in 0 until cur.row){
            if((col[i] == col[cur.row] || Math.abs(i-cur.row) == Math.abs(col[i]-cur.col))){
                return false
            }
        }
        return true
    }

    fun backTracking( level : Int){
        //대각선과 각 row col에 놓아서는 안 된다
        if(level == N ){
            result ++
            return
        }
        if(level>=N) return
        for(j in 0 until N){
            col[level] = j //level번째 행 j열 에 퀸을 놓는다.
            if(checker(Pos(level,j))) {
                //유망한 노드
                backTracking(level+1)
            }
        }
    }

    fun solution()=with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        backTracking(0)
        println(result)
    }
}