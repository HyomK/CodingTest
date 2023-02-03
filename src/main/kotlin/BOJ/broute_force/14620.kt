package BOJ.broute_force


fun main(){
    P14620().solution()
}

class P14620 {

    lateinit var map : Array<IntArray>
    lateinit var checker : Array<BooleanArray>
    var N = 0

    var dr = intArrayOf(-1, 1, 0, 0)
    var dc = intArrayOf(0, 0, -1, 1)
    var min = Int.MAX_VALUE

    fun check(r : Int, c: Int, flag : Boolean){
        for(i in dr.indices){
            val nc = c + dc[i]
            val nr = r + dr[i]
            checker[nr][nc] = flag
        }
    }

    fun dfs(cnt : Int, sum : Int){
        if(cnt == 0){
            min = Math.min(sum,min)
            return
        }
        for(i in 1..N-2){
            loop@ for(j in 1.. N-2){
                if(checker[i][j]) continue
                var tmp = 0
                for(k in dr.indices){
                    val nr = i + dr[k]
                    val nc = j + dc[k]
                    if(checker[nr][nc]) continue@loop
                    tmp += map[nr][nc]
                }
                checker[i][j] = true
                check(i,j,true)
                dfs(cnt-1, sum+tmp+map[i][j])
                check(i,j,false)
                checker[i][j] = false
            }
        }
    }

    fun solution()=with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        map = Array(N){IntArray(N){0}}
        checker = Array(N){BooleanArray(N){false}}
        repeat(N){
            map[it] = readLine().split(" ").map{it.toInt()}.toIntArray()
        }
        dfs(3,0)
        println(min)

    }
}