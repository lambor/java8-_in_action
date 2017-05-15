import java.io.InputStream

import ch10.BetterOptional_10_3_3.Person

import scala.io.Source

/**
  * Created by lambor on 17-5-15.
  */
object Dataformat {
  def main(args: Array[String]): Unit = {
    val authorsToAge = Map("Raul"->23,"Mario"->40,"Alan"->53)

    val authors = List("Raul","Mario","Alan")

    val numbers = Set(1,1,2,3,5,8)

    val newNumbers = numbers + 10

    println(numbers)
    println(newNumbers)

    val stream:InputStream = getClass.getResourceAsStream("data.txt")
    val fileLines = Source.fromInputStream(stream).getLines().toList
    val fileLongUpper = fileLines.filter(_.length>10).map(_.toUpperCase())
    println(fileLongUpper)

    val fileLongUpper2 = fileLines.par.filter(_.length>10).map(_.toUpperCase())
    println(fileLongUpper2)

    val raul = ("Raoul","+ 44 887007007")
    val alan = ("Alan","+44 883133700")

    val book = (2014,"Java 8 in Action")
    val numbers2 = (42,1337,0,3,14)

    println(book._1)
    println(numbers2._4)
  }

  def getCarInsuranceName(person:Option[Person],minAge:Int) =
    person.filter(_.getAge>=minAge).flatMap(_.getCar2).flatMap(_.getInsurance2).map(_.getName)
      .getOrElse("Unknown")
}
