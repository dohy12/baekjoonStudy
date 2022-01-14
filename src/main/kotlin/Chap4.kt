import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

class Chap4 {
    companion object{
        fun test10952(){
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
    }
}