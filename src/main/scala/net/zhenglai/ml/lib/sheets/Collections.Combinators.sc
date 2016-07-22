val numbers = 1 to 10 toList


// map
// Evaluates a function over each element in the list, returning a list with the same number of elements.

numbers map (_ * 2)

// or pass in a function (the Scala compiler automatically converts our method to a function)
def times2(i: Int): Int = i * 2
numbers map times2





// foreach
// foreach is like map but returns nothing. foreach is intended for side-effects only.
numbers foreach println
val nothing = numbers foreach (_ * 2) // returned Nothing - ()




// filter
// removes any elements where the function you pass in evaluates to false. Functions that return a Boolean are often called predicate functions.
numbers filter (_ % 2 == 0)

def isEven(i: Int) = i % 2 == 0
numbers filter isEven



// zip
//  zip aggregates the contents of two lists into a single list of pairs.
//  returned pairs number is determined by least number of that
List(1, 2, 3) zip List("a", "b", "c", "d")
List(1, 2, 3) zip List("a", "b")


// partition
// partition splits a list based on where it falls with respect to a predicate function.
// TODO order?
numbers partition (_ % 2 == 0)
numbers partition (_ > 4)




// find
//  find returns the first element of a collection that matches a predicate function.
numbers find (_ > 4)
// returned Some(t) or None




// drop & dropWhile
//  drop drops the first i elements
//  dropWhile removes the first elements that match a predicate function.
numbers drop 5
numbers dropWhile (_ % 2 != 0)
// 1 gets dropped (but not 3 which is “shielded” by 2).





// foldLeft
// 0 is the starting value (Remember that numbers is a List[Int]), and m acts as an accumulator.
numbers.foldLeft(100)((m: Int, n: Int) ⇒ m + n)

numbers.foldLeft(0) {
  (m: Int, n: Int) ⇒ println(s"m: $m n: $n"); m + n
}


// foldRight
//  Is the same as foldLeft except it runs in the opposite direction.
// n is the accumulator
numbers.foldRight(0) {(m: Int, n: Int) ⇒
  println(s"m $m n: $n")
  m + n
}


// flatten
//  flatten collapses one level of nested structure.
Seq(Seq(1, 2, 3), Seq(1, 2, 3, Seq(1, 2,3))) flatten




// flatMap
//  flatMap is a frequently used combinator that combines mapping and flattening. flatMap takes a function that works on the nested lists and then concatenates the results back together.
val nestedNumbers = List(List(1, 2), List(3, 4))
nestedNumbers flatMap (x ⇒ x map (_ * 2))

// Think of it as short-hand for mapping and then flattening:
nestedNumbers map (x ⇒ x map (_ * 2)) flatten

val words = Seq("hello", "scala")
words.map(x ⇒ x.toCharArray).flatten
words.flatMap(_.toCharArray)



// Generalized functional combinators
def ourMap(numbers: List[Int], f: Int ⇒ Int): List[Int] = {
  numbers.foldRight(List[Int]()){(x: Int, xs: List[Int]) ⇒
    f(x) :: xs
  }
}
// Why List[Int]()? Scala wasn’t smart enough to realize that you wanted an empty list of Ints to accumulate into.
// So we cannot use Nil here

ourMap(numbers, times2(_))
ourMap(numbers, times2)



// Map?
//    All of the functional combinators shown work on Maps, too. Maps can be thought of as a list of pairs

val extensions = Map("Zhenglai" → 26, "Junlai" → 25)
extensions.filter((nameAge: (String, Int)) ⇒ nameAge._2 <= 25)
// Because it gives you a tuple, you have to pull out the keys and values with their positional accessors

//  partial pattern match also rocks!
extensions filter {
  case (name, age) ⇒ age <= 25
}








