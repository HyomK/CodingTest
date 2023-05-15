package BOJ.math
import java.util.*
import java.io.*

fun main(){
    P2960().solution()
}

class P2960 {
    fun solution()=with(System.`in`.bufferedReader()){
        val br = readLine().split(" ")
        val N = br[0].toInt()
        val K = br[1].toInt()


        val checker = BooleanArray(N+1){false}
        checker[0] = true

        var cnt = 0
        for(i in 2 ..N){
            if(!checker[i] && isPrime(i)){
               //배수를 제거한다
                for(j in i ..N step i){
                    if(!checker[j]){
                        checker[j] = true
                        cnt ++
                    }
                    if(cnt == K){
                        println(j)
                        return
                    }
                }
            }
        }

    }

    fun isPrime(n : Int) : Boolean{
        for(i in 2 until n){
            if(n%i==0) return false
        }
        return true
    }
}