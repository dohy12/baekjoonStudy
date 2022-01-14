class Chap6 {
    companion object{

        fun test4673(){
            val size: Int = 100
            var arr: Array<Int> = Array(size){0}

            for(i in 0 until size){
                val n = d(i)
                if(n<size){
                    arr[n] += 1
                }
            }

            for(i in 0 until size){
                if(arr[i]==0) println(i)
            }
        }

        fun d(n: Int): Int{
            val arr: List<Int> = n.toString().toList().map{(it - '0')}
            return n + arr.sum()
        }

        fun test1065(){
            val n = readLine()!!.toInt()
            var sum = 0

            if(n<100){
                sum = n
            }
            else{
                sum = 99
                for(i in 100..n){
                    sum += han(i)
                }
            }

            println(sum)
        }

        fun han(n: Int): Int{
            if(n == 1000) return 0

            val arr: List<Int> = n.toString().toList().map{it - '0'}

            return if(arr[0]-arr[1] == arr[1]-arr[2])
                1
            else
                0
        }


    }
}