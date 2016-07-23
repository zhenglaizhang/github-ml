
// View bounds (“type classes”)

// Sometimes you don’t need to specify that one type is equal/sub/super another, just that you could fake it with conversions. A view bound specifies a type that can be “viewed as” another. This makes sense for an operation that needs to “read” an object but doesn’t modify the object.

// Implicit functions allow automatic conversion. More precisely, they allow on-demand function application when this can help satisfy type inference. e.g.:

implicit def strToInt(x: String) = x.toInt

"123"

val y: Int = "123"

math.max("123", 111)


// View bounds, like type bounds demand such a function exists for the given type. You specify a view bound with <%

class Container[A <% Int] { def addIt(x: A) = 123 + x }
// A has to be “viewable” as Int

(new Container[String]).addIt("123")
// we have one implicit from String to Int

(new Container[Int]).addIt(123)

//(new Container[Float]).addIt(123.2F)
// error: No implicit view available from Float => Int.

// Other type bounds
// Methods can enforce more complex type bounds via implicit parameters.

//  List supports sum on numeric contents but not on others. Alas, Scala’s numeric types don’t all share a superclass, so we can’t just say T <: Number. Instead, to make this work, Scala’s math library defines an implicit Numeric[T] for the appropriate types T. Then in List’s definition uses it:
// sum[B >: A](imlicit num: Numeric[B]): B

// If you invoke List(1,2).sum(), you don’t need to pass a num parameter; it’s set implicitly. But if you invoke List("whoop").sum(), it complains that it couldn’t set num

