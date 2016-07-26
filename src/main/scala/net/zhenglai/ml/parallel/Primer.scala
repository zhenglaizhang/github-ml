package net.zhenglai.ml.parallel

/**
  * Created by Zhenglai on 7/26/16.
  */
object Primer {

  def countPrimesInRange(lower: Int, upper: Int): Int = {
    (lower to upper).count(isPrime)
  }

  def isPrime(number: Int): Boolean = {
    if (number <= 1) {
      false
    } else {
      val result = for (i ← 2 to Math.sqrt(number).toInt
                        if number % i == 0) yield i
      result.length == 0
    }
  }

  -2 to 20 foreach { i ⇒
    println(s"$i => ${isPrime(i)}")
  }
  countPrimesInRange(2, 10)
}
