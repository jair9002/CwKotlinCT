import java.lang.StringBuilder
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var appendAnswer = StringBuilder()
        var printS: String = s
        var alphabetList = listOf<String>("zero","one","two","three","four","five","six","seven","eight","nine")

        if(s.length in 1..50 && s.first()=='0' && s.first() == 'z' ) {//글자수가 50을 넘거나 0으로 시작
            println("조건에 맞지 않음")

        }else{
            while(printS.length>=1) { //확인 필요

                for (i in 0..9) {
                    if (printS.first().toString() == i.toString()) {
                        appendAnswer.append(i.toString())
                        printS = printS.substring(1..printS.length - 1)
                        break
                    }
                }//for end

                for( i in 0..alphabetList.count()-1){
                    if(printS.startsWith(alphabetList[i])){
                        appendAnswer.append(i.toString())
                        printS = printS.substring(alphabetList[i].length..printS.length - 1)

                        break
                    }
                }//for end

            }//while end

        }//else end
        appendAnswer.toString().toInt().also { answer = it }
        print("${s}\t")
        return answer
    }//fun solution end

}//class solution end

suspend fun main(args: Array<String>) {
    var test = Solution2()
    var answers :IntArray = intArrayOf(1,2,3,4,5,1,2,3,4,5)
    runBlocking {
        println(test.solution2(answers).contentToString())
    }
}

class Solution2 {
    suspend fun solution2(answers: IntArray): IntArray {

        var check = CoroutineScope(Dispatchers.Default)

        var mathLosser1 = check.async {
            var count: Int = 1
            var index: Int = 0
            for(i in 0..answers.count()-1){
                count = i%5 //1번 수포자의 정답들
                count++
                if(answers[i] == count){
                    index++
                }
            }//for end
            index
        }//mathLosser2 end

        var mathLosser2 = check.async {
            var count: Int = 0
            val fixAnswer: Int = 2
            var linearAnswer:Int = 0
            var index: Int = 0
            for(i in 0..answers.count()-1){
                //2번 수포자의 정답들
                if(i%2==1){
                    linearAnswer++
                    if(linearAnswer>5){
                        linearAnswer=1
                    }
                    count = linearAnswer
                }else{
                    count = fixAnswer
                }
                print("${count}\t")
                if(answers[i] == count){

                    index++
                }
            }//for end
            index
        }
        var mathLosser3 = check.async {
            var count: Int = 3
            var preCount:Int = count+2
            var index: Int = 0
            for(i in 0..answers.count()-1){
                //3번 수포자의 정답들

                if(count != preCount){ //다르면 preCount 같으면 count를 낮춰서 같은수 2번 반복 유도
                    preCount--
                }else{
                    count--
                    if(count<=0) { //0이 되면 5로 오버플로우
                        count = 5
                        preCount = count+1
                    }
                }

                if(answers[i] == count){
                    index++
                }
            }//for end
            index
        }
        var score1 = mathLosser1.await()
        var score2 = mathLosser2.await()
        var score3 = mathLosser3.await()

        var answer: IntArray = intArrayOf(score1,score2,score3)


        return answer
    }
}