package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/22/16.
  */
object Adder {

  // Partial application
  // You can partially apply a function with an underscore, which gives you another function
  // You can usually think of it as an unnamed magical wildcard.
  // In the context of { _ + 2 } it means an unnamed parameter
  // You can partially apply any argument in the argument list, not just the last one.

  def add2(n: Int) = add(2, _: Int)

  def add(m: Int, n: Int) = m + n

  def curriedAdd = (add _).curried
}

object Multiplier {
  val times2 = multiply(2) _

  // multiply(2)(3)

  def multiply(m: Int)(n: Int) = m * n
}
