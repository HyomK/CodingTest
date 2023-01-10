package BOJ.`Graph Traversal`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    _1926().solution()
}

class _1926(){

    val map = mutableListOf<IntArray>()
    lateinit var checker : Array<BooleanArray>
    val dy = intArrayOf(0,1,0,-1)
    val dx = intArrayOf(1,0,-1,0)

    var ROW = 0
    var COL = 0

    var area = 0
    var maxArea = 0
    var count = 0


    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val input = readLine().split(" ").map{it.toInt()}
        ROW = input[0]
        COL = input[1]

        repeat(ROW){
            map.add(readLine().split(" ").map{it.toInt()}.toIntArray())
        }

        checker = Array(ROW){BooleanArray(COL ) {false} }
        for( i in 0 until ROW ){
            for( j in 0 until COL){
                if(!checker[i][j] && map[i][j] ==1){
                    count ++
                    area = 0
                    dfs(i,j)
                    maxArea = Math.max(maxArea,area)
                }
            }
        }
        println(count)
        println(maxArea)
    }

    fun dfs (row : Int, col : Int){
       // println("row : $row col $col")
        checker[row][col] = true
        area ++
        for(i in 0 until 4){
            val nx = col+dx[i]
            val ny = row+dy[i]

            if(ny in 0 until ROW && nx in 0 until COL&& checker[ny][nx]) continue
            if( ny in 0 until ROW && nx in 0 until COL && map[ny][nx] ==1 ){
                //println("nx : $nx ny $ny")
                dfs(ny,nx)
            }
        }
    }
}