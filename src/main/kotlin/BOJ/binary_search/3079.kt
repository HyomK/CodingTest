package BOJ.binary_search

import java.util.StringTokenizer

fun main(){
    P3079().solution()
}

class P3079 {
    fun solution ()= with(System.`in`.bufferedReader()){
        val st = StringTokenizer(readLine()," ")
        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()
        val terminal = IntArray(N){0}
        repeat(N){
            terminal[it] = readLine().toInt()
        }
        terminal.sort()

        var left = 0L
        var right = terminal.last().toLong()*1000000
        var mid = (left+right)/2
        var cnt = 0L
        var result = 0L
        //mid 는 소요시간을
        while(left<=right){
            cnt=0
            mid = (left+right)/2
            for(t in terminal){
                //비어있는 곳이 있는 지 확인한다
                cnt += mid/t
            }

            if(cnt >=M){
                result = mid
                right = mid - 1
            }else{
                left = mid + 1
            }

        }

        println(result)

    }
}