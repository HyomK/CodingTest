package BOJ.structure

import java.util.*

fun main(){
    P2164().solution()
}

class P2164 {
    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val cards = LinkedList<Int>()

        for(i in 1..N) cards.add(i)

        var i = 0
        while(cards.size!=1){
            if(i%2==0){
                cards.pop()
            }else{
                val top =  cards.pop()
                cards.add(top)
            }
            i++
        }
        println(cards.pop())
    }
}