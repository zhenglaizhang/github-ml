

// Array
// Arrays preserve order, can contain duplicates, and are mutable.
val array = Array(1, 2, 3, 4, 5)
array foreach println
array(2) = 10
array foreach println


// List
// Lists preserve order, can contain duplicates, and are immutable.
val list = List(1, 2, 3, 4, 5)
//list(2) = 10 //  value update is not a member of List[Int]
list foreach println


// Sets
// Sets do not preserve order and have no duplicates
val set = Set(1, 2, 3, 4, 5, 5, 3)
set foreach println


// Tuple
// A tuple groups together simple logical collections of items without using a class.
val hostPort = ("localhost", 80)
val hostPort2 = "localhost" → 80 // literal shorthand

// Unlike case classes, they don’t have named accessors, instead they have accessors that are named by their position and is 1-based rather than 0-based.
hostPort._1
hostPort._2
hostPort.productArity
hostPort.productElement(0)
hostPort.productElement(1)

// Tuples fit with pattern matching nicely.

hostPort match {
  case ("localhost", port) ⇒ println(s"localhost: $port")
  case (host, port) ⇒ println(s"$host: $port")
} // Unit returned


// Maps
Map(1 -> 2)
Map(1 -> 2)
Map(1 -> "one", 2 -> "two")
Map((1, "one"), (2, "two"))
Map(1 → Map("foo" → "bar"))
Map("timesTwo" → { i: Int ⇒ 2 * i })


// Option
//  Option is a container that may or may not hold something.
trait Option[T] {
  def isDefined: Boolean

  def get: T

  def getOrElse(t: T): T
}

// Option itself is generic and has two subclasses: Some[T] or None

//Map.get uses Option for its return type. Option tells you that the method might not return what you’re asking for.

Map(1 → 2).get(3)
// None

// We would suggest that you use either getOrElse or pattern matching to work with this result.

val result: Int = None.getOrElse(3) * 2

val v = Option(3)
v match {
  case Some(n) ⇒ n * 2
  case None ⇒ 0
}




