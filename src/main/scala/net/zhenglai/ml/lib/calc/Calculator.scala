package net.zhenglai.ml.lib.calc

/**
  * Created by Zhenglai on 7/22/16.
  */
class Calculator(brand: String) {
  // Contained are examples defining methods with def and fields with val. Methods are just functions that can access the state of the class.

  // Constructors aren’t special methods, they are the code outside of method definitions in your class.
  // TODO constructor?
  // Scala is expression-oriented. The value color was bound based on an if/else expression
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  // instance method
  def add(m: Int, n: Int) = m + n


}


//Functions and methods are largely interchangeable.
class funcvsmethod {
  val func = { () ⇒ acc += 1 }
  var acc = 0

  def minc = {
    acc += 1
  }
}

object test {
  val calc = new Calculator("HP")
  calc.color

  val c = new funcvsmethod
  c.minc // calls c.minc()
  c.func // returns the function as a value
}
