package BOJ.greedy

import java.util.*

fun main(){
    P1541().solution()
}

class P1541 {
    fun solution() = with(System.`in`.bufferedReader()){
     //연산자 뒤에서 괄호를 연다
        // 숫자가 끝나면 닫는다 .. 확인한다
        var arr = readLine().split("-").toMutableList()
        var result =0

       if(arr[0].contains("+")) {
           var plus = arr[0].split("+")
           for(p in plus){
               if(p!="+"){
                   result+=p.toInt()
               }
           }
       }
        else result = arr[0].toInt()

        arr.removeFirst()

        for(i in arr){
            //println("i ${i} / result ${result}")
            var sum = 0
            if(i.contains("+")){
                var plus = i.split("+")
                for(p in plus){
                    if(p!="+"){
                        sum+=p.toInt()
                    }
                }
                //println("sum : $sum")
            }else sum = i.toInt()
            result -= sum
        }
        println(result)
    }
}