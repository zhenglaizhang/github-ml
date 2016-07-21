package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/21/16.
  */


trait PipeOperator[-T, +U] {

  /**
    * Transform a data of type T into a data of type U.
    * Use an option to handle internal errors or exceptions
    *
    * @param data
    * @return
    */
  def |>(data: T): Option[U]
}
