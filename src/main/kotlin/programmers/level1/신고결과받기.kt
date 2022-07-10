package programmers.level1

/**
문제 설명
각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
 */

class Solution {
    val max = 1000
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val result = IntArray(id_list.size)
        var table = Array(max) { Array(id_list.size, { false }) }

        report.forEach { it ->
            it.split(" ").let {
                //
                val send = id_list.indexOf(it[0])
                val recv = id_list.indexOf(it[1])
                table[recv][send] = true
            }
        }
        var reported = arrayListOf<Int>()

        //필터링
        table.forEachIndexed { index, booleans ->
            var cnt = 0
            booleans.forEach {
                if (it) cnt++
            }
            if (cnt >= k) {
                reported.add(index)
            }
        }

        for (i in 0 until table[0].size) {
            var cnt = 0
            for (j in 0 until max) {
                if (table[j][i] && (reported.contains(j))) cnt++
            }
            result[i] = cnt
        }

        answer = result
        return answer
    }
}




