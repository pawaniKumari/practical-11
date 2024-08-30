class Rational(n:Int, d:Int){

  require(d != 0, "Denominator cannot be zero")

  private val x = gcd(n.abs, d.abs)
  val numerator:Int = n/x
  val denominator:Int = d/x

  def neg:Rational = new Rational(-numerator, denominator)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString(): String = s"$numerator/$denominator"
}

object Main extends App{

   try {
    val x = new Rational(10,0)
    val negX = x.neg
    println(negX)
  } catch {
    case e: IllegalArgumentException => println(e.getMessage)
  }
  
}
