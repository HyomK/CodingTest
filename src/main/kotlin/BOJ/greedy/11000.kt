package BOJ.greedy

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer


fun main(){
    P11000().solution()
}

class P11000 {
    data class Lecture(val start  : Long, val end : Long) : Comparable<Lecture>{
        override fun compareTo(other: Lecture): Int {
            return (start - other.start).toInt()
        }
    }
    val lecture = LinkedList<Lecture>()
    val pq = PriorityQueue<Long>()

    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        repeat(N){
            val input = StringTokenizer(readLine()," ")
            lecture.add(Lecture(input.nextToken().toLong(), input.nextToken().toLong()))
        }
        lecture.sort()

        pq.add(lecture.poll().end)
        for(l in lecture){
            if(l.start >=pq.first()){
                //만약 새 강의가 기존 강의보다 늦게 시작하면 더 늦게 끝난것 즉 다음 강의이다
                pq.poll()
                pq.add(l.end)
            }else{
                //새 강의는 일찍 시작하거나 중간이기에 새 강의실 배정
                pq.add(l.end)
            }
        }
        println(pq.size)

    }
}