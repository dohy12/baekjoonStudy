import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.sqrt
import kotlin.system.measureTimeMillis

class Chap9 {
    companion object{
        fun test1978(){
            val n = readLine()
            val arr = readLine()!!.split(' ').map { it.toInt() }
            var rs = 0
            for(num in arr){
                rs += isPrime(num)
            }
            println(rs)
        }

        fun isPrime(n: Int): Int{
            val maxV = sqrt(n.toDouble()).toInt()
            if(n==1) return 0
            for(i in 2..maxV)
                if(n%i==0) return 0
            return 1
        }

        fun isPrime2(n: Int): Boolean{
            val maxV = sqrt(n.toDouble()).toInt()
            if(n==1) return false
            for(i in 2..maxV)
                if(n%i==0) return false
            return true
        }


        fun test2581(){
            val m = readLine()!!.toInt()
            val n = readLine()!!.toInt()

            var min = -1
            var sum = 0
            for(i in m..n){
                if(isPrime2(i)){
                    if(min==-1) min = i
                    sum += i
                }
            }
            if(min==-1)
                println(-1)
            else{
                println(sum)
                println(min)
            }

        }

        fun test11653(){
            val n = readLine()!!.toInt()
            var ch = n
            var prime = 2
            var primeList: MutableList<Int> = mutableListOf()
            var maxPrime: Int = sqrt(n.toDouble()).toInt()

            while(ch!=1){
                if(ch%prime==0){
                    ch /= prime
                    println("$prime\n")
                }
                else prime = getNextPrime(prime, primeList)

                if(ch==n && prime>maxPrime) {
                    println("$n\n")
                    break
                }
            }

        }


        fun getNextPrime(num: Int, primeList: MutableList<Int>): Int{
            var n = num + 2
            while(true){
                if(isPrime3(n, primeList)){
                    primeList.add(n)
                    return n
                }
                n++
            }
        }

        fun isPrime3(n: Int, primeList: MutableList<Int>): Boolean{
            val maxV = sqrt(n.toDouble()).toInt()
            if(n==1) return false
            for(i in primeList){
                if(maxV<i) return true
                if(n%i==0) return false
            }
            return true
        }

        fun test11653_2(){
            val bw = BufferedWriter(OutputStreamWriter(System.out))
            val n = readLine()!!.toInt()
            var ch = n
            var maxPrime = sqrt(n.toDouble()).toInt()
            var prime_ch = 2

            while(ch!=1){
                if (ch == n && prime_ch>maxPrime) {
                    bw.write("$n\n")
                    break
                }

                if(ch%prime_ch==0){
                    bw.write("$prime_ch\n")
                    ch /= prime_ch
                }
                else{
                    if (prime_ch==2)
                        prime_ch++
                    else
                        prime_ch+=2
                }
            }

            bw.flush()
            bw.close()
        }


        fun test1929(){
            val bw = BufferedWriter(OutputStreamWriter(System.out))
            var (a,b) = readLine()!!.split(' ').map { it.toInt() }

            for(i in a..b){
                if (isPrime2(i)){
                    bw.write("$i\n")
                }
            }

            bw.flush()
            bw.close()
        }

        fun getNextPrime(num: Int): Int{
            var n = num+1
            while(true){
                if(isPrime2(n)){
                    return n
                }
                n++
            }
        }

        fun test4948(){
            val bw = BufferedWriter(OutputStreamWriter(System.out))
            while(true){
                val n = readLine()!!.toInt()
                if(n==0) break

                bw.write("${fun4948(n)}\n")
            }
            bw.flush()
            bw.close()
        }

        fun fun4948(n: Int): Int{
            var rs = 0
            for(i in (n+1)..n*2){
                if (isPrime2(i)){
                    rs+=1
                }
            }
            return rs
        }

        fun test9020(){
            val c = readLine()!!.toInt()

            repeat(c){
                val n = readLine()!!.toInt()

                var a = n/2
                var b = n/2

                while(true){
                    if(isPrime2(a) && isPrime2(b)){
                        println("$a $b")
                        break
                    }
                    a--
                    b++
                }
            }
        }

        fun test1085(){
            val (x,y,w,h) = readLine()!!.split(' ').map { it.toInt() }
            val arr = arrayOf(x,y,w-x,h-y)
            val minDis = arr.minOrNull()

            println(minDis)
        }

        fun test3009(){
            val map_x: MutableMap<Int, Int> = mutableMapOf()
            val map_y: MutableMap<Int, Int> = mutableMapOf()
            repeat(3){
                val (x,y) = readLine()!!.split(' ').map { it.toInt() }
                map_x[x] = (map_x[x] ?: 0) + 1
                map_y[y] = (map_y[y] ?: 0) + 1
            }

            var rs_x=0
            var rs_y=0
            for((x,cnt) in map_x){
                if(cnt==1)
                    rs_x = x
            }

            for((y,cnt) in map_y){
                if(cnt==1)
                    rs_y = y
            }

            println("$rs_x $rs_y")
        }

        fun test4153(){
            while(true){
                val line = readLine().toString()
                if(line == "0 0 0") break

                var arr = line.split(' ').map { it.toInt() }
                arr = arr.sorted()

                if(isTriangle(arr[0],arr[1],arr[2]))
                    println("right")
                else
                    println("wrong")
            }
        }

        fun isTriangle(a: Int, b: Int, c: Int): Boolean{
            if(a*a + b*b == c*c)
                return true
            return false
        }

        fun test3053(){
            val n = readLine()!!.toInt()

            val o1 = n * n * Math.PI
            val o2 = n * n * 2

            println("$o1\n$o2")
        }

        fun test1002(){
            val n = readLine()!!.toInt()

            repeat(n){
                //x1:list[0] y1:list[1] r1:list[2] , x2:list[3] y2:list[4] r2:list[5]
                val list: List<Int> = readLine()!!.split(' ').map { it.toInt() }
                val x1 = list[0]
                val y1 = list[1]
                val r1 = list[2]
                val x2 = list[3]
                val y2 = list[4]
                val r2 = list[5]

                val dis = sqrt((list[0]-list[3]) * (list[0]-list[3]) + (list[1]-list[4]) * (list[1]-list[4]).toDouble())
                if (x1==x2 && y1==y2 && r1 == r2)
                    println(-1)
                else if ((r1+r2).toDouble() == dis)
                    println(1)
                else if ((r1+r2).toDouble() < dis)
                    println(0)
                else if ((r2.toDouble()+dis) == r1.toDouble() || (r1.toDouble()+dis) == r2.toDouble())
                    println(1)
                else if ((r2.toDouble()+dis) < r1.toDouble() || (r1.toDouble()+dis) < r2.toDouble())
                    println(0)
                else
                    println(2)
            }


        }
    }
}

