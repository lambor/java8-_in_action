/**
  * Created by lambor on 17-5-15.
  */
object Beer {
  def main(args: Array[String]): Unit = {
    var n:Int = 2
    while (n<=6) {
      println(s"Hello $n bottles of beer")
      n += 1
    }

    2 to 6 foreach(n=>println(s"Hello $n bottles of beer"))
  }
}
