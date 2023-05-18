package BOJ.graph_traversal

import java.util.*


fun main() {
    P7576().solution()
}



class P7576 {
    //대각선을 제외한 영역의 토마토는 영향을 받는다
    //구하고자 하는 것은 며칠이 지난 뒤 모든 토마토가 익는 지이다.
    //즉 몇 번의 전체 탐색을 했을 때 모두 익었는 지를 확인한다
    data class Tomato(val x: Int, val y: Int, val day: Int)

    lateinit var tomato: ArrayList<IntArray>
    val dx = listOf(0, 1, 0, -1) //위 오른쪽 아래 왼쪽
    val dy = listOf(-1, 0, 1, 0)
    var width = 0
    var height = 0
    var minDay = 999_999_999
    val queue = LinkedList<Tomato>()

    fun solution() = with(System.`in`.bufferedReader())  {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        width = x - 1
        height = y - 1

        tomato = ArrayList()

        repeat(y) {
            val line = readLine().split(" ").map { t -> t.toInt() }.toIntArray()
            tomato.add(line)
            line.forEachIndexed { i, t ->
                if (t == 1) {
                    queue.add(Tomato(i, it, 0))
                }
            }
        }
        changeTomato()

        if (checkTomato()) {
            println(minDay)
        } else {
            println(-1)
        }
    }

    fun changeTomato() {
        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            minDay = cur.day
            repeat(4) {
                val nx = cur.x + dx[it]
                val ny = cur.y + dy[it]

                if (nx in 0..width && ny in 0..height) {
                    if (tomato[ny][nx] == 0) {
                        tomato[ny][nx] = 1
                        //새로 익은 토마토를 넣는다
                        queue.add(Tomato(nx, ny, cur.day + 1))
                    }
                }
            }
        }
    }

    fun checkTomato(): Boolean {
        for (i in 0..height) {
            for (j in 0..width) {
                if (tomato[i][j] == 0) return false
                // 덜 익은 토마토가 있다면
            }
        }
        return true
    }

}