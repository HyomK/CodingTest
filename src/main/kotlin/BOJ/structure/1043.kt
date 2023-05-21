package BOJ.structure

import java.util.*
import kotlin.collections.ArrayList

fun main(){
    P1043().solution()
}

class P1043 {
    lateinit var group : Array<ArrayList<Int>>

    fun solution()= with(System.`in`.bufferedReader()){
        // 아는 사람이 한명이라도 포함된 파티는 거짓말을 할 수 가 없다
        var result = 0
        val (N,M) = readLine().split(" ").map{it.toInt()}
        val knows = readLine().split(" ").map{it.toInt()} //진실을 아는 사람

        val people =  Stack<Int>()
        knows.forEachIndexed{ idx, p ->
            if(idx>0) people.push(p)
        }

        group = Array(N+1){ArrayList<Int>()}
        var partys = Array(M){ArrayList<Int>()}
        //knows[0] = size

        repeat(M){
            val input = readLine().split(" ").map{it.toInt()}
            partys[it].addAll(input.slice(1 until input.size)) // 파티원만 배열에 넣어줌

            for(i in 1..input[0]){
                for(j in 1.. input[0]){
                    if(i!=j) group[input[i]].add(input[j]) //양방향
                }
            }
        }

        val units = ArrayList<ArrayList<Int>>()

        while(people.isNotEmpty()){
           val cur = people.pop()
           val list = arrayListOf(cur)
           val unit = findRoot(cur, list)
           units.add(unit)
        }

        for(party in partys){
            var isContain = false
            loop@ for(unit in units){
                for(people in party){
                    if(unit.contains(people)){
                        isContain = true
                        break@loop; //다른 unit 볼 필요 없음
                    }
                }
            }
            if(!isContain)  result ++
        }
        println(result)
    }

    fun findRoot( p : Int, arr : ArrayList<Int>) : ArrayList<Int> {
        for(g in group[p]){
            if( !arr.contains(g)){
                arr.add(g)
                findRoot(g,arr)
            }
        }
        return arr
    }
}