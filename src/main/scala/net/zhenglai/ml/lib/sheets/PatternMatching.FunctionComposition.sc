

def f(s: String) = s"f($s)"

def g(s: String) = s"g($s)"


// compose makes a new function that composes other functions f(g(x))
val fComposeG = f _ compose g _
fComposeG("hello")

// andThen is like compose, but calls the first function and then the second, g(f(x))
val fThenG = f _ andThen g _
fThenG("hello")



// Currying vs Partial Application
// case statements
//So just what are case statements?
//  It’s a subclass of function called a PartialFunction.
//
//What is a collection of multiple case statements?
//  They are multiple PartialFunctions composed together.



// A function works for every argument of the defined type.
//  A Partial Function is only defined for certain values of the defined type. A Partial Function (Int) => String might not accept every Int.
// PartialFunction is unrelated to a partially applied function

val one: PartialFunction[Int, String] = {
  case 1 ⇒ "one"
}

// apply a partial function.
one(1)

one.isDefinedAt(1)
one.isDefinedAt(2)


// PartialFunctions can be composed with something new, called orElse, that reflects whether the PartialFunction is defined over the supplied argument.

val two: PartialFunction[Int, String] = {
  case 2 ⇒ "two"
}

val three: PartialFunction[Int, String] = {
  case 3 ⇒ "three"
}

val wildcard: PartialFunction[Int, String] = {
  case _ ⇒ "something else"
}

val partial = one orElse two orElse three orElse wildcard

partial(4)
partial(2)
partial(10)
partial(0)
partial(1)


// We saw a case statement used where a function is normally used
Map(1 → "one", 2 → "two", 3 → "three") filter {
  case (k, v) ⇒ k > 2
}
// filter takes a function. In this case a predicate function of (Map[Int, String]) => Boolean.
// A PartialFunction is a subtype of Function so filter can also take a PartialFunction!

