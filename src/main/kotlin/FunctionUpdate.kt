
//progresse는 작업률이 적혀있는 Array이다.
//speeds는 작업률마다 하루에 진행할 수 있는 양이다 모든 작업은 동시에 병렬적으로 증가한다.
// 완성 다 하더라도 앞에 있는 기능이 완성 안되면 기다려야 한다.

class FunctionUpdate {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = intArrayOf()
        var needDayList = mutableListOf<Int>(progresses.size)
        var deployList = mutableListOf<Int>()
        // 먼저 소요시간 전부 계산
        for( i in 0.. progresses.size-1){
            var needDay = 0
            var addProgress = progresses[i]

            while(addProgress>=100){
                addProgress += speeds[i]
                needDay++
            }
            needDayList.add(needDay)

        }//for end

        var count = 1
        var compare =0
        // 이 반복문 마지막 처리가 애매하다
        for( i in 0 .. progresses.size-1){

            if(needDayList.get(compare) > needDayList.get(i+1)){
                count++
            }else{
                deployList.add(count)
                count=1
                compare = i
            }
        }

        return answer
    }


}