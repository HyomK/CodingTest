package BOJ.structure

import MyBuffer
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
/* 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다*/
fun main(){
    _1620 ().solution()
}
class  _1620  {
    private val br = MyBuffer().br
    fun solution() = with(BufferedReader(InputStreamReader(System.`in`))){
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        val input =br.readLine()!!.toString().split(" ").map{it.toInt()}
        val size = input[0]
        val test = input[1]
        val monsters=  HashMap<Int,String>()
        val monsterStr= HashMap<String,Int>()

        for(i in 1..size){
            val str =  br.readLine().toString()
            monsters[i] = str
            monsterStr[str]=i
        }

        for(i in 0 until test){
            val t = br.readLine().toString()
            if(t.toIntOrNull()==null){
                bw.write("${monsterStr[t]}"+'\n')
            }else{
                val monster =monsters[t.toInt()]
                bw.write("${monster}"+'\n')
            }
        }
        bw.flush()
        bw.close()
    }

}
