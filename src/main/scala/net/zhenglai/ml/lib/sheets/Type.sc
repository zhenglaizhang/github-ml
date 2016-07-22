// “A type system is a syntactic method for automatically checking the absence of certain erroneous behaviors by classifying program phrases according to the kinds of values they compute

// Types allow you to denote function domain & codomains
//  f: R -> N
//  function “f” maps values from the set of real numbers to values of the set of natural numbers.
//  In the abstract, this is exactly what concrete types are.


// Given these annotations, the compiler can now *statically* (at compile time) verify that the program is sound. That is, compilation will fail if values (at runtime) will not comply to the constraints imposed by the program.

// Note that all type information is removed at compile time. It is no longer needed. This is called erasure.


// Types in Scala
//parametric polymorphism roughly, generic programming
//(local) type inference roughly, why you needn’t say val i: Int = 12: Int
//existential quantification roughly, defining something for some unnamed type
//views we’ll learn these next week; roughly, “castability” of values of one type to another


// Parametric polymorphism
val list = 2 :: 1 :: "bar" :: "foo" :: Nil
// List[Any]

// Polymorphism is used in order to write generic code (for values of different types) without compromising static typing richness.

// Now we cannot recover any type information about the individual members.
list.head // Any = 2
list.tail

// And so our application would devolve into a series of casts (“asInstanceOf[]”) and we would lack type safety (because these are all dynamic).

// Polymorphism is achieved through specifying type variables.
def drop1[A](seq: Seq[A]) = seq.tail
drop1(Seq(1, 2, 3))


// Scala has rank-1 polymorphism
//  TODO: what's rank-1?
def toList[A](a: A) = List(a)
//def foo[A, B](f: A => List[A], b: B) = f(b)
// def foo[A](f: A => List[A], i: Int) = f(i)



// Type inference
// Scala’s type inference system works a little differently with ML, but it’s similar in spirit: infer constraints, and attempt to unify a type.

//{ x ⇒ x}
// missing type parameter

// In scala all type inference is local. Scala considers one expression at a time. For example:
def id[T](x: T) = x
val x = id(32)
val y = id("hey")

val z = id(Array(1, 2, 3, 4))



// Variance
//  Class hierarchies allow the expression of subtype relationships.

//  if T’ is a subclass of T, is Container[T’] considered a subclass of Container[T]
// covariant      [+T]  => C[T’] is a subclass of C[T]
// contravariant  [-T]  => C[T] is a subclass of C[T’]
// invariant      [T]   => C[T] and C[T’] are not related

// The subtype relationship really means: for a given type T, if T’ is a subtype, can you substitute it?

class Covariant[+A]

val cv: Covariant[AnyRef] = new Covariant[String]

//val error: Covariant[String] = new Covariant[AnyRef]


class Contravariant[-A]

val ctv: Contravariant[String] = new Contravariant[AnyRef]

//val error: Contravariant[AnyRef] = new Contravariant[String]


trait Function1 [-T1, +R] extends AnyRef


// Let's think about this from the point of view of substitution

class Animal { val sound = "rustle" }
class Bird extends Animal {
  override val sound: String = "call"
}

class Chicken extends Bird {
  override val sound: String = "cluck"
}

class Duck extends Bird {
  override val sound: String = "duck"
}

// If you need a function that takes a Bird and you have a function that takes a Chicken, that function would choke on a Duck. But a function that takes an Animal is OK
val getTweet: (Bird ⇒ String) = ((a: Animal) ⇒ a.sound)
// If you need a function that returns a Bird but have a function that returns a Chicken, that’s great.
val hatch: (() ⇒ Bird) = (() ⇒ new Chicken)



// Bounds
// Scala allows you to restrict polymorphic variables using bounds

//def foo[T](things: Seq[T]) = things map (_.sound)
//  Cannot resolve symbol sound

def bar[T <: Animal](things: Seq[T]) = things map (_.sound)
bar(Seq(new Chicken, new Bird))

// List defines an operator ::(elem T) that returns a new List with elem prepended
val flock = List(new Bird, new Bird)
new Chicken :: flock

//   def ::[B >: A] (x: B): List[B] = new scala.collection.immutable.::(x, this)
// List also defines ::[B >: T](x: B) which returns a List[B]. Notice the B >: T. That specifies type B as a superclass of T. That lets us do the right thing when prepending an Animal to a List[Bird]:
new Animal :: flock
// now the return type is List[Animal]


// Quantification
// Sometimes you do not care to be able to name a type variable
def count_[A](list: List[A]) = list.size

// instead you can use "wildcards"
def count(l: List[_]) = l.size

// this is shorthand for
def count__(l: List[T forSome { type T }]) = l.size

def drop1(l: List[_]) = l.tail
// return type: List[Any]
//  Suddenly we lost type information!
// this is shorthand for
def drop1_(l: List[T forSome { type T }]) = l.tail



// You may also apply bounds to wildcard type variables:
def hashCodes(l: Seq[_ <: AnyRef]) = l map (_.hashCode)
//hashCodes(Seq(1, 2, 3))
// error: the result type of an implicit conversion must be more specific than AnyRef
// Note: primitive types are not implicitly converted to AnyRef.
//You can safely force boxing by casting x.asInstanceOf[AnyRef].
hashCodes(Seq("one", "two"))

12.hashCode





