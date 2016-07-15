package net.zhenglai.ml.dsl

/**
  * Created by Zhenglai on 7/15/16.
  */
object Resources {
  // anonymous, structural type for resources
  // fight with resource-related bugs!!
  // reflection!! pay attention
  type Resource = {
    // abstract methods (values)
    def close(): Unit
  }
  // defined type alias Resource

  def close(r: Resource) = r close
}

object test_holder {
  // structural type alias
  type T = {
    type X = Int
    def x: X
    type Y
    def y: Y
  }

  object Foo {
    type X = Int

    def x: X = 5

    type Y = String

    def y: Y = "Hello, World!"
  }

  // unstable type
  //  def test(t: T) = t.x
  //  def test2(t: T): t.X = t.x
  def test3(t: T): T#X = t.x

  //  test(Foo)
  test3(Foo)
  // Int = 5
}

// Resources.close(System.in)
