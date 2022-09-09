package BOJ.math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(){
    val sol =_2960().solution()

}

class _2960 {
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val st = StringTokenizer(readLine())
        val N = st.nextToken().toInt()
        val K = st.nextToken().toInt()
        val numbers  = IntArray(N+1)
        for (i in 0..N){
            numbers[i]=i
        }
        var result = 0
        loop@ for (i in 2..N){
            if(numbers[i]==-1) continue
            if(isPrime(i)){
                var cnt = 1
                while(i*cnt <= N){
                    if(numbers[i*cnt] ==-1){
                        cnt++
                        continue
                    }
                    numbers[i * cnt] = -1
                    result++
                    if(result == K) {
                        println(i*cnt)
                        break@loop
                    }
                    cnt ++
                }
            }
        }
    }

    fun isPrime(n : Int) : Boolean{
        for (i in 2 until n){
            if (n % i == 0) return false
        }
        return true
    }
}