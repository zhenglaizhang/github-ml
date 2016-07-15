package net.zhenglai.ml.indepth

import java.security.{AccessController, PrivilegedAction}
import java.util

/**
  * Created by Zhenglai on 7/14/16.
  */
package test {

  class Foo

}

object Implicit {

  def findAnInt(implicit x: Int) = x

  findAnInt
  findAnInt(13)
  implicit val y = 12
  findAnInt
  findAnInt(14)


  // entity
  // binding
  class Foo {
    def x = 5
  }

  // Foo is bound locally
  val z = new Foo

  import test.{Foo ⇒ Bar}

  val b = new Bar

  import java.util.{List ⇒ JList}
  import java.{io ⇒ jio}

  val l: JList[Int] = new util.ArrayList[Int]()


  object holder {

    trait Foo

    object Foo {
      implicit val x = new Foo {
        override def toString = "Companion Foo"
      }
    }

    // trait & object Foo should be :paste in REPL to become companion, or use the holder object

    def method(implicit foo: Foo) = println(foo)

    method
  }


  implicit val a = "test"
  val s = implicitly[String]
  val x = implicitly[Float]

  object holder2 {

    // type class
    trait BinaryFormat[T] {
      def asBinary(entity: T): Array[Byte]
    }

    trait Foo {}

    object Foo {
      implicit lazy val binaryFormat = new BinaryFormat[Foo] {
        override def asBinary(entity: Foo) = "serializedFoo".toArray.map(_.toByte)
      }
    }

  }

  object holder3 {

    object Foo {

      object Bar {
        override def toString = "Bar"
      }

      implicit def b: Bar.type = Bar
    }

    implicitly[Foo.Bar.type]

  }


  // implicit view: Int => String
  implicit def intToString(x: Int) = x.toString

  def log(msg: String) = println(msg)

  log(12)

  implicit def stringToFoo(x: String) = new {
    def foo(): Unit = println("foo")
  }

  "foo".foo
  "hello".foo

  object ScalaSecurityImplicits {
    implicit def functionToPrivilegedAction[A](func: Function0[A]) =
      new PrivilegedAction[A] {
        override def run() = func()
      }
  }
  import ScalaSecurityImplicits._
  AccessController.doPrivileged(() ⇒ println(""))


}
