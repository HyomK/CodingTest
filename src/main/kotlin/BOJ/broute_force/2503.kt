package BOJ.broute_force

import java.util.StringTokenizer

fun main(){
    P2503().solution()
}

class P2503 {
    fun solution()=with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val checker = BooleanArray(988){false}
        val result  = arrayListOf<String>()
        var cnt = 0

        repeat(N){

            val st = StringTokenizer(readLine()," ")
            val number = st.nextToken().toString()
            val strike = st.nextToken().toInt()
            val ball = st.nextToken().toInt()


            for(i in 123..987){
                var strikeCnt=0
                var ballCnt=0

                if(i.toString().contains("0") ||(i%10 == i%100/10) || (i%1000/100 == i%10) ||(i%1000/100 == i%100/10)){
                    continue
                }
                val tmp = i.toString()
                for(j in 0..2){
                    if(tmp[j]==(number[j])){
                        strikeCnt++
                    }
                    if(tmp.contains(number[j]) && tmp[j]!=number[j]){
                        ballCnt++
                    }
                }

                if(strikeCnt == strike && ball == ballCnt){
                    //println("$number @ $i : strikeCnt: $strikeCnt -> $strike ballCnt : $ballCnt -> $ball")
                    if(it==0)checker[i] = true
                }else{
                    if(checker[i]) checker[i] = false
                }
            }
        }

        for(i in checker.indices){
           if(checker[i]) {
              cnt++
           }
        }
        println(cnt)
    }
}