package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

/*
* 스택 수열
* */

fun main(){
    _1874().solution()
}

class _1874 {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val size = br.readLine()!!.toInt()
        val nums = Stack<Int>()
        val result = mutableListOf<String>()
        var n = size
        var point = 1
        while(n-->0){
            val k = br.readLine()!!.toInt()
            while(point<=k){
                nums.add(point)
                result.add("+")
                point++
            }
            if(nums.isNotEmpty()&&nums.peek()==k){
                result.add("-")
                nums.pop()
            }else{
                println("NO")
                return@with
            }
        }
        for(s in result) println(s)
    }
}