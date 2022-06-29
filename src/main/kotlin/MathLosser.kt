import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

// https://programmers.co.kr/learn/courses/30/lessons/42840
// 프래그로머스 코딩테스트 "모의고사"


class MathLosser {
    fun solution2(answers: IntArray): IntArray {
        var answer: IntArray

        var count1: Int = 1
        var index1: Int = 0
        for (i in 0..answers.count() - 1) {
            count1 = i % 5 //1번 수포자의 정답들
            count1++
            if (answers[i] == count1) {
                index1++
            }
        }//for end
        var mathLosser1 = index1

        var count2: Int = 0
        val fixAnswer: Int = 2
        var linearAnswer: Int = 0
        var index2: Int = 0
        for (i in 0..answers.size - 1) {
            //2번 수포자의 정답들
            if (i % 2 == 1) {
                linearAnswer++
                if (linearAnswer > 5) {
                    linearAnswer = 1
                }
                count2 = linearAnswer
            } else {
                count2 = fixAnswer
            }

            if (answers[i] == count2) {

                index2++
            }
        }//for end
        println()
        var mathLosser2 = index2

        var mathLosser3 : Int
        var mathLosser3Answer : IntArray = intArrayOf(3,1,2,4,5)
        var answerRepeatCheck : Boolean = true
        var refIndex : Int
        var index3: Int = 0
        for (i in 0..answers.count() - 1) {
            //3번 수포자의 정답들
            refIndex = i
            if(answerRepeatCheck){

            }
//작성 바람!!!!!!!!!!!!
//            if (answers[i] == count3) {
//                index3++
//            }
        }//for end
        mathLosser3 = index3


        var answerTemp: IntArray = intArrayOf(mathLosser1, mathLosser2, mathLosser3)
        var temp: Int
        var recordIndex: Int = 1

        temp = answerTemp[0]
        for (i in 1..answerTemp.size - 1) { //최댓값 찾기
            if (temp < answerTemp[i]) {
                temp = answerTemp[i] //최대값 저장중
                recordIndex = i + 1 //1등
            }
        }
        println("${recordIndex}")

        var tempMutableList = mutableListOf<Int>()
        tempMutableList.add(recordIndex)
        //1등이랑 같은 값 찾기
        for (i in 0..answerTemp.size - 1) {
            if (i != recordIndex - 1 && temp == answerTemp[i]) {
                tempMutableList.add(i + 1)

            }
        }
        //이렇게 되면 값이 항상 3개 고정인데 아니왜 삭제를 못하게 해 쓰레기 같은 배열 리스트로 만든다음에 배열에 집어넣어
        answer = tempMutableList.toIntArray()


        return answer
    }
}