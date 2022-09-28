package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
/* 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다*/
fun main(){
    _10799().solution()
}

class _10799 {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val input =br.readLine()!!.toString().toCharArray()
        val stack = Stack<Char>()
        var ans = 0
        for(i in 0 until input.size){
            if(input[i]=='('){
                stack.push(input[i])
            }else{
                stack.pop()
                if(input[i-1]=='('){
                    //레이저일 경우 stack(막대기)의 수 만큼 더한다
                    ans+=stack.size
                }else{
                    //막대기의 시작일 경우 +1 자르면 하나가 더 생성되니까
                    ans++
                }
            }
        }
        println(ans)
    }

}
