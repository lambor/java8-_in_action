/**
  * Created by lambor on 17-5-15.
  */
object Function {
  def isJavaMentioned(tweet:String) : Boolean = tweet.contains("Java")

  def isShortTweet(tweet:String) : Boolean = tweet.length < 20

  def main(args: Array[String]): Unit = {
    val tweets = List(
      "I love the new features in Java 8",
      "How's it going?",
      "An SQL query walks into a bar, sees two tables and says 'Can I join you'"
    )

    tweets.filter(isJavaMentioned).foreach(println)
    tweets.filter(isShortTweet).foreach(println)

    val isLongTweet
    : String => Boolean //not necessary
    = (tweets: String) => tweets.length > 60

    val isLongTweet2
    : String => Boolean //not necessary
    = new Function[String, Boolean] {
      override def apply(v1: String): Boolean = tweets.length > 60
    }

    isLongTweet("scala function grammar sugar")
    isLongTweet.apply("scala function no sugar")

    //closure
    var count = 0;
    val inc = () => count += 1
    inc()
    println(count)
    inc()
    println(count)

    //curry
    multiplyCurry(2)(10)
  }

  def multiplyCurry(x:Int)(y:Int) = x*y
}
