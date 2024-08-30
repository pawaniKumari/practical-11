class Rational(n:Int, d:Int){

  require(d != 0, "Denominator cannot be zero")

  private val x = gcd(n.abs, d.abs)
  val numerator:Int = n/x
  val denominator:Int = d/x

  def sub(that:Rational):Rational = {
    val newNumerator = this.numerator * that.denominator - that.numerator * this.denominator
    val newDenominator = this.denominator * that.denominator
    new  Rational(newNumerator, newDenominator)
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString(): String = s"$numerator/$denominator"
}

object Main extends App{

   try {

    val x = new Rational(3,4)
    val y = new Rational(5,8)
    val z = new Rational(2,7)

    val result = x.sub(y).sub(z)
    println(result)

  } catch {
    case e: IllegalArgumentException => println(e.getMessage)
  }
  
}
