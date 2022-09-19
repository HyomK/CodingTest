package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
/* 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다*/
fun main(){
    _9012().solution()
}

class _9012 {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val stack = Stack<Char>()
        val size =br.readLine()!!.toInt()
        loop@ for(i in 1..size){
            val st = br.readLine().toString().toCharArray()
            for(char in st){
                when(char){
                    '('->{
                        stack.push(char)
                    }
                    else->{
                        if(stack.isEmpty() || stack.peek()!=='('){
                            println("NO")
                            continue@loop
                        }else{
                            stack.pop()
                        }
                    }
                }
            }
            if(stack.isNotEmpty()) println("NO")
            else   println("YES")
            stack.clear()
        }
    }

}
