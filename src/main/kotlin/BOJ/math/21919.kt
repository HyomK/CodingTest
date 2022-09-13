package BOJ.math

import java.io.*
import kotlin.math.sqrt

fun main(){
    val sol = _21919().solution()
}

class _21919 {
   private val br = BufferedReader( InputStreamReader( FileInputStream("/Users/hyomin/Desktop/hyomin/codingTest/src/main/kotlin/file.txt"), "UTF-8"));

    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val size = br.readLine()!!.toInt()
        val numbers = br.readLine().toString().split(" ").map { it ->it.toLong() }.sorted()
        var lcm = -1L
        var prev = -1L
        for(num in numbers){
            if(prev == num) continue
            if(fastIsPrime(num)) {
                if(lcm==-1L){
                    lcm = 1L
                    prev = num
                }
                lcm *= num
            }
        }
        println(lcm)

    }
    //시간 복잡도: O(n)
    fun isPrime (num : Long) :  Boolean {
        for(i in num-1 downTo 2){
            if(num % i == 0L ) return false
        }
        return true
    }
    // 에라토스테네스의 체
    fun fastIsPrime(num : Long) : Boolean{
        //2부터 제곱근까지의 모든 수를 확인한다
        for(i in 2..sqrt(num.toDouble()).toInt()){
            //만약 그 사이의 수 중 소수가 아닌 수가 있다면 해당 num은 소수가 아니다
            if(num % i == 0L ) return false
        }
        return true
    }

}