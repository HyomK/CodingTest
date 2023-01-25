package BOJ.binary_search

import java.util.StringTokenizer

fun main(){
    P2805().solution()
}

class P2805{
    fun solution() = with(System.`in`.bufferedReader()){
        //종료조건 자른 나무의 양 >= M
        //절단기 최소 : 가장 작은 나무의 높이
        //최대 : 가장 높은 나무의 높이

        val st = StringTokenizer(readLine()," ")
        val N = st.nextToken().toInt()
        val M = st.nextToken().toLong()
        val trees = readLine().split(" ").map{it.toLong()}.toMutableList()
        trees.sort()

        var left = 0L
        var right = trees.last()
        var mid = (left+right)/2
        var sum : Long = 0
        var result = Long.MAX_VALUE

        while(left<=right){
            //println("left $left / right $right")
            mid = (left+right)/2
            sum = 0


            for(tree in trees){
                if(tree>mid){
                    //나무가 더 크기 때문에 자르기 가능
                    sum += (tree-mid)
                }
            }
            //println("mid $mid / sum $sum")
            if(sum == M){
                result = mid
                break
            }

            if(sum>M){
                left = mid + 1
                result = mid
            }
            else{
                right = mid - 1
            }
        }

        if(result!=Long.MAX_VALUE)println(result)
        else println(0)

    }
}