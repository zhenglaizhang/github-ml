package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/22/16.
  */
object StringOp {

  // Variable length arguments
  //  There is a special syntax for methods that can take parameters of a repeated type.
  def capitalizeAll(args: String*) = {
    args map (_.capitalize)
  }

  // TODO ArrayBuffer
  capitalizeAll()
  capitalizeAll("test", "TEH012", "0123&")

  // Methods are just functions that can access the state of the class.
}
