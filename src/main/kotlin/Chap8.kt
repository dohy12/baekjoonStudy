import java.math.BigDecimal
import kotlin.math.ceil
import kotlin.math.sqrt

class Chap8 {
    companion object{
        fun test1712(){
            val (a,b,c) = readLine()!!.split(' ').map{it.toInt()}

            if (b>=c) println("-1")
            else println("${a/(c-b) + 1}")
        }

        fun test2292(){
            val n = readLine()!!.toInt()
            var cnt = getStartHex(n)
            var cal = getHex(cnt)
            while(true){
                cnt++
                if(n <= cal) break
                cal = getHex(cnt)
            }

            println(cnt-1)
        }

        fun getHex(n: Int): Int{
            return 3*(n-1)*(n-1) + 3*(n-1) + 1
        }

        fun getStartHex(n: Int): Int{
            if(n == 1) return 1
            return sqrt((n-1)/3.0).toInt()
        }

        fun test1193(){
            val n = readLine()!!.toInt()
            var cnt = getStart1193(n)
            var cal = get1193(cnt)
            while(true){
                cnt++
                if(n <= cal) break
                cal = get1193(cnt)
            }

            val num = n - get1193(cnt-2)
            if((cnt-1)%2==0)
                println("${num}/${cnt-num}")
            else
                println("${cnt-num}/${num}")
        }

        fun get1193(n: Int): Int{
            return n * (n+1)/2
        }

        fun getStart1193(n: Int): Int{
            return sqrt(2.0 * n).toInt()
        }


        fun test2869(){
            val (a,b,c) = readLine()!!.split(' ').map{it.toInt()}
            val day: Int
            val h = c-a
            if(h<=0) day = 1
            else day = ceil(h/(a-b).toDouble()).toInt() + 1

            println(day)
        }

        fun test10250(){
            val c: Int = readLine()!!.toInt()

            repeat(c){
                val arr: List<Int> = readLine()!!.split(' ').map { it.toInt() }
                println(getRoom(arr[0], arr[1], arr[2]))
            }
        }

        fun getRoom(h: Int, w: Int, n: Int): Int{
            val dis = (n - 1) / h + 1
            val height = n - (dis - 1) * h
            return String.format("%d%02d",height,dis).toInt()
        }

        fun test2775(){
            val n = readLine()!!.toInt()

            repeat(n){
                val k = readLine()!!.toInt()
                val n = readLine()!!.toInt()

                println(fun2775(k, n))
            }
        }

        fun fun2775(k: Int, n: Int): Int{
            var arr = Array<Int>(n){i -> i+1}

            repeat(k){
                val arr2 = Array<Int>(n){0}

                for(i in arr2.indices){
                    arr2[i] = sumArr(arr, i+1)
                }
                arr = arr2.clone()
            }

            return arr[n-1]
        }

        fun sumArr(arr: Array<Int>, cnt: Int): Int{
            var sum: Int = 0

            for(i in 0 until cnt){
                sum += arr[i]
            }
            return sum
        }

        fun test2839(){
            val n = readLine()!!.toInt()

            for(i in n/5 downTo 0){
                val remain = n - i * 5
                if (remain%3 == 0){
                    println("${i + remain/3}")
                    return
                }
            }

            println("-1")
        }

        fun test10757(){
            var (a: String,b: String) = readLine()!!.split(" ")
            var sum: String = ""
            if(b.length > a.length){
                val tmp = b
                b = a
                a = tmp
            }

            a = a.reversed()
            b = b.reversed()

            var up: Int = 0
            for(i in a.indices){
                var c: Int = (a[i] - '0') + up
                if(i<b.length) c += (b[i] - '0')
                up = c/10
                c %= 10
            sum = "$sum$c"
            }

            if(up == 1) sum = "${sum}1"

            println(sum.reversed())
        }

        fun test10757_2(){
            var (a: String,b: String) = readLine()!!.split(" ")
            val big1 = BigDecimal(a)
            val big2 = BigDecimal(b)
            println(big1+big2)
        }

        fun test1011(){
            var c: Int = readLine()!!.toInt()

            repeat(c){
                var (x,y) = readLine()!!.split(' ').map{it.toInt()}
                println(fun1011(y-x))
            }
        }

        fun fun1011(len: Int): Int{
            var idx: Int = sqrt(len.toDouble()).toInt()
            var boundary = getBoundary(idx)

            while(true){
                if(boundary>=len) break
                idx++
                boundary = getBoundary(idx)
            }

            return idx
        }

        fun getBoundary(times: Int): Long{
            val n: Long = (times+1).toLong()/2
            return if(times%2==1) n * n
            else (n+1) * n
        }
    }
}