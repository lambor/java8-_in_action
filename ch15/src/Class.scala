/**
  * Created by lambor on 17-5-15.
  */
object Class {

  class Hello {
    def sayThankYou(): Unit = {
      println("Thanks for our book")
    }
  }

  def main(args: Array[String]): Unit = {
    var h = new Hello
    h.sayThankYou()

    class Student(var name:String,var id:Int)
    val s = new Student("Raoul",1)
    println(s.name)
    s.id = 1337
    println(s.id)
  }
}
