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

// inheritance
class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

// overloading methods
class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
  override def log(m: Double, base: Double): Double = {
    super.log(m, math.exp(1))
  }
}


// Abstract Classes
// You can define an abstract class, a class that defines some methods but does not implement them.
// Instead, subclasses that extend the abstract class define these methods. You can’t create an instance of an abstract class.
abstract class Shape {
  def draw
}


// Traits
//    traits are collections of fields and behaviors that you can extend or mixin to your classes.

trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}

class BMW extends Car {
  override val brand: String = "BMW"
}

class BMW2 extends Car with Shiny {
  override val brand: String = "BMW"
  override val shineRefraction: Int = 12
}

/*
When do you want a Trait instead of an Abstract Class?

If you want to define an interface-like type, you might find it difficult to choose between a trait or an abstract class.
Either one lets you define a type with some behavior, asking extenders to define some other behavior. Some rules of thumb:

1. Favor using traits. It’s handy that a class can extend several traits; a class can extend only one class.
2. If you need a constructor parameter, use an abstract class. Abstract class constructors can take parameters; trait
constructors can’t. For example, you can’t say trait t(i: Int) {}; the i parameter is illegal.

 */


// Types
// Functions can also be generic and work on any type. When that occurs, you’ll see a type parameter introduced with the square bracket syntax
trait Cache[K, V] {
  def get(key: K)

  def put(key: K, value: V)

  def delete(key: K)

  // Methods can also have type parameters introduced.
  def remove[A](key: A)
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
  c.func
  // returns the function as a value

  val scalc = new EvenMoreScientificCalculator("HP")
  scalc.log(1, 1)
}
