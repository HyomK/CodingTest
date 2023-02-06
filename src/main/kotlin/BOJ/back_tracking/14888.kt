package BOJ.back_tracking

fun main(){
    P14888().solution()
}

class P14888 {
    data class OP(val id : Int, val operator : Int)

    var N = 0
    var tot = 0

    lateinit var nums : LongArray
    lateinit var operator : IntArray
    var ops = arrayListOf<OP>()

    var min = 1e9.toLong()
    var max = (-1e9).toLong()

    fun fastBackTracking(depth : Int, tmp : Long){
        if(depth == N){
            min = Math.min(min,tmp)
            max = Math.max(max,tmp)
            return
        }

        for(i in 0 until 4){
            if(operator[i]<=0) continue
            operator[i]--
            when(i){
                0 ->{ fastBackTracking(depth+1, tmp + nums[depth])}
                1 ->{ fastBackTracking(depth+1, tmp - nums[depth])}
                2 ->{ fastBackTracking(depth+1, tmp * nums[depth])}
                3 ->{
                    fastBackTracking(depth+1, tmp / nums[depth])
                }
            }
            operator[i]++
        }
    }

    //+ - x %
    fun backTracking( tmpOp : ArrayList<OP>){
        //유망하지 않다는 것은?
        if(tmpOp.size == tot){
            var result = nums[0]
            for(i in 0 until tmpOp.size){
                when(tmpOp[i].operator){
                    0 ->{ result += nums[i+1]}
                    1 ->{ result -= nums[i+1]}
                    2 ->{ result *= nums[i+1] }
                    3 ->{
                        if( result < 0 && nums[i+1] >= 0){
                            val divider = Math.abs(result)
                            result = divider / nums[i+1]
                        }else{
                            result /= nums[i + 1]
                        }
                    }
                }
            }
            min = Math.min(min, result)
            max = Math.max(max, result)
        }

        //순열로 해결
        // 1 1 0 2 2 1
        for(i in 0 until ops.size){
            if(tmpOp.map{it.id}.contains(ops[i].id)) continue
            //이미 소진한 연산자
            tmpOp.add(ops[i])
            backTracking(tmpOp)
            tmpOp.removeLast()
        }

    }

    fun solution()= with(System.`in`.bufferedReader()){
        N = readLine().toInt()
        nums = readLine().split(" ").map{it.toLong()}.toLongArray()
        operator = readLine().split(" ").map{it.toInt()}.toIntArray()
//        tot = operator.sum()
//        var id = 0
//        for(i in operator.indices){
//            if(operator[i]>0)
//                repeat(operator[i]) {ops.add(OP (id++, i))}
//        }
//        ops.sortWith(){a,b -> a.operator - b.operator}

//        backTracking(arrayListOf())
        fastBackTracking(1,nums[0])
        println(max)
        println(min)
    }
}