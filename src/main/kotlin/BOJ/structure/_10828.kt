package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.InputStreamReader


fun main(){
    _10828().solution()
}

class _10828 {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val size = br.readLine()!!.toInt()
        val stack = mutableListOf<String>()
        for ( i in 0 until size ){
            val method = br.readLine()
            when(method.split(" ")[0]){
               "push" ->{
                   if(method.split(" ").size >1 )
                       stack.add(method.split(" ")[1])
               }
               "top"->{
                   if(stack.isEmpty()){
                       println(-1)
                   }else println(stack[stack.size-1])
               }
               "size"->{
                   println(stack.size)
               }
               "pop"->{
                   if(stack.isEmpty()) println(-1)
                   else{
                       println(stack[stack.size-1])
                       stack.removeAt(stack.size-1)
                   }
               }
               "empty"->{
                   if(stack.isEmpty()) println(1)
                   else println(0)
               }
           }
        }
    }
}