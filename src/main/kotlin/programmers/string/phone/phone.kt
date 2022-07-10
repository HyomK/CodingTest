package programmers.string.phone

private class Solution {
    fun solution(phone_number: String): String {
        var answer = ""
        answer =phone_number.substring(phone_number.length-4,phone_number.length).padStart(phone_number.length,'*')
        return answer
    }
}
