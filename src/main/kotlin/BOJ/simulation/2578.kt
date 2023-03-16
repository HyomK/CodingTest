package BOJ.simulation

import kotlin.system.exitProcess

fun main(){
    P2578().solution()
}

class P2578 {
    val map = Array(5){BooleanArray(5){false} }
    var count = 0
    var bingo = 0

    fun check (x : Int, y : Int) : Int{
        var Xcnt = 0
        var Ycnt = 0
        var crossX = 0
        var crossY = 0
        var flagX = false
        var flagY = false

        var result = 0

        for(i in 0 until 5){
            if(map[y][i]) Xcnt++
            if(map[i][x]) Ycnt++
            if(map[i][i]){
                crossX++
            }
            if(x==i && y==i) flagX=true
            if(map[i][4-i]){
                crossY++
            }
            if(x==4-i && y==i) flagY=true
        }

        if(Xcnt==4 ) result++
        if(Ycnt==4 ) result++
        if( flagY && crossY==4)result++
        if( flagX && crossX==4)result++

        return result
    }

    fun solution () = with(System.`in`.bufferedReader()){
        val bingoMap = HashMap<Int,Pair<Int,Int>>()
        repeat(5){
            readLine().toString().split(" ").mapIndexed { index, i ->
                bingoMap.put(i.toInt(),Pair(it,index))
            }
        }


        repeat(5){
           readLine().toString().split(" ").mapIndexed { index, i->
               bingoMap.get(i.toInt())?.run {
                   bingo+=check(this.second, this.first)
                   map[this.first][this.second] = true

                   if(bingo >= 3){
                       println(5*it + index+1)
                       exitProcess(0)
                   }
               }
           }
        }
    }
}