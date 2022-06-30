import java.lang.Math.floor
import java.util.Stack




//가로 길이가 Wcm, 세로 길이가 Hcm인 직사각형 종이가 있습니다. 종이에는 가로, 세로 방향과 평행하게 격자 형태로 선이 그어져 있으며
//모든 격자칸은 1cm x 1cm 크기입니다. 이 종이를 격자 선을 따라 1cm × 1cm의 정사각형으로 잘라 사용할 예정이었는데,
//누군가가 이 종이를 대각선 꼭지점 2개를 잇는 방향으로 잘라 놓았습니다.
//그러므로 현재 직사각형 종이는 크기가 같은 직각삼각형 2개로 나누어진 상태입니다.
//새로운 종이를 구할 수 없는 상태이기 때문에,
//이 종이에서 원래 종이의 가로, 세로 방향과 평행하게 1cm × 1cm로 잘라 사용할 수 있는 만큼만 사용하기로 하였습니다.
//가로의 길이 W와 세로의 길이 H가 주어질 때, 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.

// 그래프적으로 생각을 해보자 (0,0) , (w,h)를 지나가는 직선이 있다고 가정을하고 자동으로 직선함수를 만든다 y=ax
// 그리고 x에 1값이 더하면서 y 값을 구한다 y가 정수값에 딱맞아 떨어지면 1개 소수값이면 2개씩 더하면 개수를 구할 수 있다.

//소수점 연산 때문에 제대로된 값이 나오지 않게 됨
class NormalRectangle {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        var a : Double = (h.toDouble()/w.toDouble())  // y =ax 의 기울기 a
        var y : Double
        var count : Long = 0
        var dyInt : Long



        for(i in 1..w){
            y= a*i.toDouble()
            dyInt = (floor(a*i.toDouble()) - floor(a*(i-1).toDouble())).toLong()

            if(y == floor(y)){

                if(dyInt>=1.0) {
                    count += dyInt
                }//x'-x =1 일때 만큼 지나간 y의 값을 구해야한다


            }else{
                if(dyInt>=1.0) {
                    count += dyInt

                }//x'-x =1 일때 만큼 지나간 y의 값을 구해야한다
                count++
            }
        }

        answer = (w*h).toLong() - count

        return answer
    }

}

internal class SolutionCunning {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 1
        val w1 = w.toLong()
        val h1 = h.toLong()
        val num = gcd(w1, h1) //최대 공약수 구하기

        // (w/최대공약수) * (h/최대공약수)의 패턴이 (최대 공약수)개 존재
        answer = w1 * h1 - (w1 / num + h1 / num - 1) * num
        return answer
    }

    companion object {
        fun gcd(w: Long, h: Long): Long {
            return if (h == 0L) w else gcd(h, w % h)
        }
    }
}
