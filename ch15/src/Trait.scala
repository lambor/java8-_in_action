/**
  * Created by lambor on 17-5-15.
  */
object Trait {
  trait Sized {
    var size:Int = 0
    def isEmpty() = size == 0
  }

  class Empty extends Sized

  def main(args: Array[String]): Unit = {
    println(new Empty().isEmpty())

    class Box;
    val b1 = new Box() with Sized;
    println(b1.isEmpty())
  }
}
