package BOJ.greedy

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer




fun main(){
    P1931().solution()
}

class P1931 {
    data class Lecture(val start : Long, val end : Long): Comparable<Lecture>{
        override fun compareTo(other : Lecture) : Int{
            return if(end==other.end) (start - other.start).toInt()
            else (end - other.end).toInt()
        }
    }

    fun solution()=with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        val lectures = LinkedList<Lecture>()

        repeat(N){
            val st  = StringTokenizer(readLine() , " ")
            lectures.add(Lecture(st.nextToken().toLong(), st.nextToken().toLong()))
        }
        lectures.sort()

        var now = lectures.pop().end
        var cnt = 1

        for(lecture in lectures){
            if(now<= lecture.start){
                cnt ++
                now=lecture.end
            }
        }
        println(cnt)

    }
}