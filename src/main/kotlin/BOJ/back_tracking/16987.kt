package BOJ.back_tracking

import java.util.StringTokenizer

fun main(){
    P16987().solution()
}

class P16987 {
    data class Egg (var dur : Int, val weight  : Int )
    var N =0
    val eggs = arrayListOf<Egg>()
    var ans = 0


    fun hitEgg(now : Int){
        if(now == N){
            var cnt = 0
            for(i in eggs){
                if(i.dur <= 0) cnt++
            }
            ans = Math.max(ans, cnt)
            return
        }

        if(eggs[now].dur<0){
            //이미 계란이 깨졌다면 다음 계란을 들도록 한다
            hitEgg(now+1)

        }else{
            var flag = true
            for(i in 0 until N){
                //다음 계란을 집는 과정
                if(i==now || eggs[i].dur < 0) continue
                flag = false
                eggs[now].dur -= eggs[i].weight
                eggs[i].dur -=eggs[now].weight
                hitEgg(now+1)

                eggs[now].dur += eggs[i].weight
                eggs[i].dur +=eggs[now].weight


            }
            if(flag) hitEgg(N)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        repeat(N){
            val st = StringTokenizer(readLine(), " ")
            eggs.add(Egg(st.nextToken().toInt(), st.nextToken().toInt()))
        }
        hitEgg(0)
        println(ans)
    }
}