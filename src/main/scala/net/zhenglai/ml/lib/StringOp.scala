package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/22/16.
  */
object StringOp {

  def capitalizeAll(args: String*) = {
    args map (_.capitalize)
  }

  // Methods are just functions that can access the state of the class.
}
