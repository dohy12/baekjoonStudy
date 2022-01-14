import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.NumberFormatException
import java.util.StringTokenizer

class Chap4 {
    companion object{
        fun test10951(){
            val br = BufferedReader(InputStreamReader(System.`in`))
            val bw = BufferedWriter(OutputStreamWriter(System.out))

            var line: String
            while(true){
                line = br.readLine()

                val token = StringTokenizer(line)
                val a = token.nextToken().toInt()
                val b = token.nextToken().toInt()

                if(a==0 && b==0)
                    break

                bw.write("${a + b}\n")
            }
            bw.flush()
            bw.close()
        }

        fun test10952(){
            val bw = BufferedWriter(OutputStreamWriter(System.out))
            val br = BufferedReader(InputStreamReader(System.`in`))
            var line: String?
            while(true){
                line = br.readLine()

                if(line==null) break

                val token = StringTokenizer(line)
                val a = token.nextToken().toInt()
                val b = token.nextToken().toInt()

                bw.write("${a+b}\n")
            }
            bw.flush()
            bw.close()
        }

        fun test1110(){
            val n = readLine()!!.toInt()
            var ch = n
            var cnt = 0
            do{
                cnt+=1
                ch = newNum(ch)
            }
            while(n != ch)
            println(cnt)
        }

        fun newNum(num: Int): Int{
            val a = num/10
            val b = num%10

            val sum = a+b

            return b*10 + sum%10
        }
    }
}