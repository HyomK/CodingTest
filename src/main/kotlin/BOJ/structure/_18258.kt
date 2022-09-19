package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


/*정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
명령은 총 여섯 가지이다.
push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

fun main(){
    _18258().solution()
}

class _18258 {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val queue = ArrayDeque<String>()
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        repeat(br.readLine()!!.toInt()){
            val k =br.readLine()!!.toString().split(" ")
            when(k[0]){
                "push"->{
                    queue.add(k[1])
                }
                "pop"->{
                    if(queue.isNotEmpty()) {
                        bw.write(queue.pop()+"\n")
                    }else bw.write("-1"+"\n")
                }
                "size"->{
                    bw.write(queue.size.toString()+"\n")
                }
                "empty"->{
                    if(queue.isEmpty())bw.write("1"+"\n")
                    else bw.write("0"+"\n")
                }
                "front"->{
                    if(queue.isEmpty()) bw.write("-1"+"\n")
                    else{
                        bw.write(queue.peekFirst()+"\n")
                    }
                }
                "back"->{
                    if(queue.isEmpty()) bw.write("-1"+"\n")
                    else{
                       bw.write(queue.peekLast()+"\n")
                    }
                }
            }
        }
        bw.flush()
        bw.close()
    }
}