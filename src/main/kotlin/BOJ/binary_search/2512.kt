package BOJ.binary_search

fun main(){
    P2512().solution()
}

class P2512 {
    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val money = readLine().split(" ").map{it.toInt()}.toMutableList()
        money.sort()

        val total = readLine().toInt()
        var left = total/N
        var right = money.last()
        var mid = (left+right)/2
        var max = 0

        var sum = 0
        for(m in money){
            sum += if(m <= mid) m
            else mid
        }

        while(left <= right){
            mid = (left+right)/2
            sum = 0
            for(m in money){
                sum += if(m <= mid) m
                else mid
            }
            if(sum == total){
                max = mid
                break
            }

            if(sum <  total){
                left = mid + 1
            }else {
                right = mid - 1
            }

            if(sum < total) max = mid

            if(left > right) break
        }
        if(max < money.last()) println(max)
        else println(money.last())
    }
}