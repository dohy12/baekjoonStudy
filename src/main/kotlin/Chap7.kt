class Chap7 {
    companion object{
        fun test11654(){
            val ch: String = readLine().toString()
            println(ch[0].code)
        }

        fun test11720(){
            val n = readLine()!!.toInt()
            val list: List<Int> = readLine()!!.toList().map { it - '0' }
            var sum: Int = 0

            for(i in 0 until n){
                sum += list[i]
            }

            println(sum)
        }

        fun test10809(){
            val str = readLine().toString()
            val map: MutableMap<Char, Int> = mutableMapOf()

            for(i in str.indices){
                val ch = str[i]
                if (map.containsKey(ch))
                    continue
                else
                    map[ch] = i
            }

            var rs = ""
            for(ch in 'a'..'z'){
                if(map.containsKey(ch))
                    rs = "$rs${map[ch]} "
                else
                    rs = "$rs-1 "
            }
            println(rs)
        }

        fun test2675(){
            val n = readLine()!!.toInt()

            repeat(n){
                val line = readLine().toString().split(' ')
                val times: Int = line[0]!!.toInt()
                val str: String = line[1]
                var rs = ""

                for(ch in str){
                    repeat(times){
                        rs = "$rs$ch"
                    }
                }
                println(rs)
            }
        }

        fun test1157(){
            val str = readLine().toString()
            val map: MutableMap<Char, Int> = mutableMapOf()

            for(ch in str){
                map[ch.uppercaseChar()] = (map[ch.uppercaseChar()]?:0) + 1
            }

            var maxN = -1
            var maxCh = 'A'
            var maxCnt = 0
            for(ch in 'A' .. 'Z'){
                if((map[ch]?:0) > maxN){
                    maxN = map[ch]?:0
                    maxCh = ch
                    maxCnt = 0
                }
                else if ((map[ch]?:0) == maxN) maxCnt = 1
            }

            if(maxCnt == 0)
                println(maxCh)
            else
                println("?")
        }

        fun test1152(){
            val strList = readLine()!!.split(' ')
            var size = strList.size
            if (strList[0]=="") size--
            if (strList[strList.size-1]=="") size--
            println(size)
        }

        fun test2908(){
            var (a,b) = readLine()!!.split(' ').map { it.toInt() }
            a = reverse(a)
            b = reverse(b)

            if(a>b) println(a)
            else println(b)
        }

        fun reverse(n: Int): Int{
            return n - (n/100*100) - n%10 + (n%10*100) + (n/100)
        }

        fun test5622(){
            val str: String = readLine().toString()
            var rs: Int = 0

            for(ch in str){
                rs += convert(ch)
            }
            println(rs)
        }

        fun convert(ch: Char): Int{
            when (ch){
                in 'A'..'C' -> return 3
                in 'D'..'F' -> return 4
                in 'G'..'I' -> return 5
                in 'J'..'L' -> return 6
                in 'M'..'O' -> return 7
                in 'P'..'S' -> return 8
                in 'T'..'V' -> return 9
                in 'W'..'Z' -> return 10
            }
            return 0
        }

        fun test2941(){
            val str: String = readLine().toString()
            var idx: Int = 0
            var cnt: Int = 0

            while(idx<str.length){
                if(check(str, idx, 3))
                    idx+=3
                else if(check(str, idx, 2))
                    idx+=2
                else
                    idx++

                cnt++
            }

            println(cnt)
        }

        fun check(str: String, idx: Int, size: Int): Boolean{
            if(str.length < idx + size) return false

            when(str.substring(idx,idx+size)){
                "dz=","c=","c-","d-","lj","nj","s=","z=" -> return true
            }
            return false
        }

        fun test1316(){
            val c: Int = readLine()!!.toInt()
            var rs: Int = 0
            repeat(c){
                rs += checkGroupWord(readLine().toString())
            }
            println(rs)
        }

        fun checkGroupWord(word: String): Int{
            val map: MutableMap<Char, Int> = mutableMapOf()
            var prev: Char = ' '

            for(ch in word){
                if(ch != prev){
                    prev = ch
                    if(map.containsKey(ch)) return 0
                    else map[ch] = 1
                }
            }

            return 1
        }

    }
}