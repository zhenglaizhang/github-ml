package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/15/16.
  */
object Functor {

  trait Function[-Arg, +Return] {
    def apply(arg: Arg): Return
  }

  val func = new Function[Any, String] {
    override def apply(arg: Any): String = {
      s"Hello, I received a $arg"
    }
  }

  val func2: Function[String, Any] = func

  func2("test")
}
