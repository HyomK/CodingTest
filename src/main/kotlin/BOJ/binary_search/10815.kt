package BOJ.binary_search

import java.util.LinkedList

fun main(){
    _10815().solution()
}

class _10815 {
    fun solution()=with(System.`in`.bufferedReader()){
        val aNum = readLine().toInt()
        val arrayA= readLine().split(" ").map{it.toLong()}.toMutableList()
        arrayA.sort()

        val bNum = readLine().toInt()
        val arrayB = readLine().split(" ").map{it.toLong()}

        val result = IntArray(bNum){0}

        val st = java.lang.StringBuilder()
        var cnt = 0
        var mid = aNum/2


        for(b in arrayB.indices){
            val cur = arrayB[b]

            var left = 0
            var right = arrayA.size -1

            while(left <= right){
                mid = (left+right)/2
                //println("cur : $cur -> $left / $right")

                if(arrayA[mid]==cur){
                    result[b] = 1
                    break
                }
                else if(arrayA[mid]> cur){
                    right = mid -1
                }else{
                    left = mid + 1
                }

            }
        }

        for(res in result){
            st.append("$res ")
        }
        println(st)
    }
}