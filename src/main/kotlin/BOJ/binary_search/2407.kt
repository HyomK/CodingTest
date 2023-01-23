package BOJ.binary_search

import java.util.LinkedList
import kotlin.math.abs

fun main(){
    P2407().solution()
}

class P2407 {
    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val drinks = readLine().split(" ").map { it.toLong() }.toMutableList()

        drinks.sort()

        var left = 0
        var right = drinks.size -1
        var mid  = (left+right)/2
        var sum : Long = 2_000_000_001

        var result = LinkedList<Int>()

        while(left<right && left>=0 && right < drinks.size){
            mid  = (left+right)/2
          //  println("left : $left , right : $right")

            if(drinks[left] + drinks[right]  == 0L){
                result.clear()
                result.add(left)
                result.add(right)
                break
            }
            else if(drinks[left] + drinks[right] <0){
                if(abs(sum) > abs( drinks[left] + drinks[right] ) ){
                    if(abs(sum) > abs( drinks[left] + drinks[right] ) ){
                        sum = drinks[left] + drinks[right]
                        result.clear()
                        result.add(left)
                        result.add(right)
                    }
                }
                left ++
            }else {
                if(abs(sum) > abs( drinks[left] + drinks[right] ) ){
                    if(abs(sum) > abs( drinks[left] + drinks[right] ) ){
                        sum = drinks[left] + drinks[right]
                        result.clear()
                        result.add(left)
                        result.add(right)
                    }
                }

                right--
            }

        }
        //println(sum)
        result.forEach { r -> print("${drinks[r]} ") }
    }
}