package BOJ.structure

import java.util.*

fun main(){
    P1863().solution()
}


class P1863 {

    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val map = DoubleArray(1_000_000)
        val stack = Stack<Int>()
        var cnt = 0

        for(i in 1..N){
            val (x,y) = readLine().split(" ")
            val height = y.toInt()

            if(height == 0){
                cnt += stack.size
                stack.clear()
                continue
            } // 0이 들어가면 건물을 떨어져있는 것이다. 스택을 비운다

            if(stack.isEmpty()){
                stack.push(height)
                continue
            } //비어있으면 무조건 추가

            if(height > stack.peek()){
                stack.push(height)
            }
            else{
                while(stack.isNotEmpty()&&stack.peek()>height){
                    stack.pop()
                    cnt++
                }//높이가 낮아지면 그 높이보다 높은 건물들을 스택에서 꺼냄
                if((!stack.isEmpty() && stack.peek()<height)|| stack.isEmpty()) //중복으로 넣지 않는다
                    stack.push(height)

            }
        }

        cnt += stack.size //남아 있는 경우 더해줌

        println(cnt)
    }
}