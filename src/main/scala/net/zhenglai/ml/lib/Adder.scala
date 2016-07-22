package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/22/16.
  */

// TODO method vs function in scala
object Adder {

  // Partial application
  // You can partially apply a function with an underscore, which gives you another function
  // You can usually think of it as an unnamed magical wildcard.
  // In the context of { _ + 2 } it means an unnamed parameter
  // You can partially apply any argument in the argument list, not just the last one.

  def add2(n: Int) = add(2, _: Int)

//  def add2_2(n: Int) = add(2, _)

  // pure function
  //    each value of mxn maps to *exactly* only one value of (m+n)
  //    no side effects
  //    referential transparency
  //  predictability
  //     for a given input, you always get the same outpu
  def add(m: Int, n: Int) = m + n


  def curriedAdd = (add _).curried
}

// Curried functions
//    Sometimes it makes sense to let people apply some arguments to your function now and others later.
//    At one call site, you’ll decide which is the multiplier and at a later call site, you’ll choose a multiplicand.
object Multiplier {
  // You can fill in the first parameter and partially apply the second.
  val times2 = multiply(2)(_: Int)
  val times2_2 = multiply(2) _

  multiply(2)(3)

  def multiply(m: Int)(n: Int) = m * n

  //  You can take any function of multiple arguments and curry it. Let’s try with our earlier adder

}
