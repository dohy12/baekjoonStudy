class Chap5 {
    companion object{
        fun test10818(){
            val n = readLine()!!.toInt()
            val arr = readLine()!!.split(' ').map{ it.toInt() }
            var min: Int = 1000000
            var max: Int = -1000000

            for(i in 0 until n){
                if(arr[i]<min) min = arr[i]
                if(arr[i]>max) max = arr[i]
            }

            println("$min $max")
        }

        fun test2562(){
            var ch: Int = 1
            var max: Int = -1

            for(i in 1..9){
                val num = readLine()!!.toInt()
                if(num>max){
                    max = num
                    ch = i
                }
            }

            println("$max\n$ch")
        }

        fun test2577(){
            val numStrs: String = (readLine()!!.toInt() * readLine()!!.toInt() * readLine()!!.toInt()).toString()
            var arr: Array<Int> = Array<Int>(10){0}

            for(numStr in numStrs){
                val n = (numStr - '0').toInt()
                arr[n] += 1
            }

            for(i in 0..9){
                println(arr[i])
            }
        }

        fun test3052(){
            var s:MutableSet<Int> = mutableSetOf()

            repeat(10){
                val n = readLine()!!.toInt()%42
                s.add(n)
            }

            println("${s.size}")
        }

        fun test1546(){
            val n: Int = readLine()!!.toInt()
            val nums = readLine()!!.split(' ').map { it.toDouble() }
            val max = nums.maxOrNull()
            var sum: Double = 0.0

            for(num in nums){
                sum += (num/ max!! *100.0)
            }
            println("${sum/n}")
        }

        fun test8958(){
            val n: Int = readLine()!!.toInt()

            repeat(n){
                val str = readLine().toString()

                println(getScore(str))
            }
        }

        fun getScore(line: String): Int{
            var sum: Int = 0
            var pre: Int = 0
            for(ch in line){
                if(ch == 'O') sum += ++pre
                else pre = 0
            }

            return sum
        }

        fun test4344(){
            var c = readLine()!!.toInt()

            repeat(c){
                val str = readLine().toString()
                println(String.format("%.3f%%",count(str)))
            }

        }

        fun count(line: String): Double{
            val arr = line.split(' ').map {it.toInt()}
            val arr2 = arr.subList(1,arr.size)
            var avg: Double = arr2.average()

            var cnt = 0
            for(n in arr2){
                if(n>avg) cnt+=1
            }

            return cnt/arr2.size.toDouble()*100
        }


    }
}