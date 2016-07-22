//package net.zhenglai.ml.lib.sheets
// Package at the top of a file will declare everything in the file to be in that package.


object BasicCont {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // apply methods
  class Foo {}

  object FooMaker {
    def apply() = new Foo
  }

  // apply methods give you a nice syntactic sugar for when a class or object has one main use.
  val newFoo = FooMaker()                         //> newFoo  : net.zhenglai.ml.lib.sheets.BasicCont.Foo = net.zhenglai.ml.lib.she
                                                  //| ets.BasicCont$$anonfun$main$1$Foo$1@566776ad

  // Here our instance object looks like we’re calling a method. More on that later!
  class Bar {
    def apply() = 0
  }

  val bar = new Bar                               //> bar  : net.zhenglai.ml.lib.sheets.BasicCont.Bar = net.zhenglai.ml.lib.sheets
                                                  //| .BasicCont$$anonfun$main$1$Bar$1@6108b2d7
  bar()                                           //> res0: Int = 0

  // Objects
  //
  // Objects are used to hold single instances of a class. Often used for factories.

  object Timer {
    var count = 0

    def currentCount(): Long = {
      count += 1
      count
    }
  }

  Timer.currentCount()                            //> res1: Long = 1
  Timer.currentCount()                            //> res2: Long = 2
  Timer.currentCount()                            //> res3: Long = 3

  // Classes and Objects can have the same name. The object is called a ‘Companion Object’. We commonly use Companion Objects for Factories.
  class Meow(foo: String)
  object Meow {
    def apply(foo: String) = new Meow(foo)
  }

  Meow("test")                                    //> res4: net.zhenglai.ml.lib.sheets.BasicCont.Meow = net.zhenglai.ml.lib.sheet
                                                  //| s.BasicCont$$anonfun$main$1$Meow$2@1554909b

  // Functions are Objects
  object addOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
  }

  addOne(1)                                       //> res5: Int = 2
  // A Function is a set of traits. Specifically, a function that takes one argument is an instance of a Function1 trait. This trait defines the apply() syntactic sugar we learned earlier, allowing you to call an object like you would a function.

  // There is Function0 through 22. Why 22? It’s an arbitrary magic number.

  // The syntactic sugar of apply helps unify the duality of object and functional programming. You can pass classes around and use them as functions and functions are just instances of classes under the covers.

  // Does this mean that every time you define a method in your class, you’re actually getting an instance of Function*?
  // No, methods in classes are methods. Methods defined standalone in the repl are Function* instances.

  // Classes can also extend Function and those instances can be called with ().
  class AddOne extends Function1[Int, Int] {
    def apply(m: Int): Int = m + 1
  }

  val plusOne = new AddOne()                      //> plusOne  : net.zhenglai.ml.lib.sheets.BasicCont.AddOne = <function1>
  plusOne(1)                                      //> res6: Int = 2

  // A nice short-hand for extends Function1[Int, Int] is extends (Int => Int)
  class AddOne2 extends (Int => Int) {
    def apply(m: Int): Int = m + 1
  }


	// Values and functions cannot be outside of a class or object. Objects are a useful tool for organizing static functions.
	object colorHolder {
		val BLUE = "Blue"

		val RED = "Red"
	}
	// defined module colorHolder
	// This gives you a small hint that the designers of Scala designed objects to be part of Scala’s module system.

	println(s"The color is: ${colorHolder.BLUE}")
                                                  //> The color is: Blue


  // pattern matching
  val times = 1

  // matching on values
  times match {
    case 1 ⇒ "One"
    case 2 ⇒ "Two"
    case _ ⇒ "Some other number"
  }

  // matching with guard
  times match {
    case i if i == 1 ⇒ "One"
    case i if i == 2 ⇒ "Two"
    case _ ⇒ "Some other number"
  }
  // The _ in the last case statement is a wildcard; it ensures that we can handle any statement. Otherwise you will suffer a runtime error if you pass in a number that doesn’t match.

  // Matching on type
  def bigger(o: Any): Any = {
    o match {
      case i: Int if i < 0 ⇒ i - 1
      case i: Int ⇒ i + 1
      case d: Double if d < 0.0 ⇒ d - 0.1
      case d: Double ⇒ d + 0.1
      case text: String ⇒ text + "s"
    }
  }


  class CalculatorFoo(brand: String, model: String) {}

  def calType2(calc: CalculatorFoo) = calc match {
    case _ if calc.brand == "HP" && calc.model == "20B" ⇒ "finiancial"
    case _ if calc.brand == "HP" && calc.model == "48G" ⇒ "scientific"
    case _ if calc.brand == "HP" && calc.model == "30B" ⇒ "business"
    case _ ⇒ "unknown"
  }


  // Case class
  // case classes are used to conveniently store and match on the contents of a class. You can construct them without using new.

  case class Calculator(brand: String, model: String)
  val hp20b = Calculator("HP", "20b")

  // case classes automatically have equality and nice toString methods based on the constructor arguments.
  hp20b == Calculator("HP", "20b")    // true
  hp20b eq Calculator("HP", "20b")

  //  case classes are designed to be used with pattern matching.
  def calcType(calc: Calculator) = calc match {
    case Calculator("HP", "20B") => "financial"
    case Calculator("HP", "48G") => "scientific"
    case Calculator("HP", "30B") => "business"
    case Calculator(ourBrand, ourModel) => "Calculator: %s %s is of unknown type".format(ourBrand, ourModel)
      // or   case Calculator(_, _) => "Calculator of unknown type"
      // or   case _ => "Calculator of unknown type"
      //  re-bind the matched value with another name as below
      // or   case c@Calculator(_, _) => "Calculator: %s of unknown type".format(c)

  }


  // Exceptions
  // Exceptions are available in Scala via a try-catch-finally syntax that uses pattern matching.
  val result: Int = try {
    // ...
    0
  } catch {
    case e: IllegalStateException ⇒
      println(e)
      0
  } finally {
    // ...
  }
  // trys are also expression-oriented
  // Finally will be called after an exception has been handled and is not part of the expression.
}