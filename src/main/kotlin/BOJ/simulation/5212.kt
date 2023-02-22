package BOJ.simulation

import java.util.StringTokenizer

fun main(){
    P5212().solution()
}

class P5212 {
    lateinit var map : ArrayList<CharArray>

    var R = 0
    var C = 0

    val dr = listOf(-1,0,1,0)
    val dc = listOf(0,1,0,-1)

    var result = ArrayList<CharArray>()
    var minR = 0
    var maxR  = -1

    var minC = 0
    var maxC  = -1

    fun findLand(row : Int,  col : Int){
        var count = 0
//        repeat(R){
//            println(map[it])
//        }
        for(n in 0..3){
            val nc = col + dc[n]
            val nr = row + dr[n]

            if(nc in 0 until C && nr in 0 until R){
                if(map[nr][nc] == '.'){
                    count ++
                }
            }else{
                count ++ //범위밖
            }
        }
        if(count>=3){
            result[row][col] = '.'
        }
        else{
            minR = Math.min(minR, row)
            maxR = Math.max(maxR,row)

            minC = Math.min(minC, col)
            maxC = Math.max(maxC, col)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){
        val st = readLine().toString().split(" ")
        R  = st[0].toInt()
        C = st[1].toInt()
        minR = R
        minC = C

        map = ArrayList()
        repeat(R){
            val line = readLine().toString().toCharArray()
            map.add(line.copyOf())
            result.add(line.copyOf())
        }


        for (r in 0 until R){
            for(c in 0 until C){
                if(map[r][c]!='.') findLand(r,c)
            }
        }

        for (r in minR ..maxR){
            val st = java.lang.StringBuilder()
            for(c in minC..maxC){
                st.append(result[r][c])
            }
            println(st)
        }

    }
}