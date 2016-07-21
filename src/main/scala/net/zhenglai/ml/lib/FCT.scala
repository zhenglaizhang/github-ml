package net.zhenglai.ml.lib

/**
  * Created by Zhenglai on 7/21/16.
  */

private[lib] object holder {
  // map: domain -> codomain
  // maps == morphism == arrow
  // f: A -> B
}


/*
scala> def f(s: String) = "f(" + s + ")"
f: (String)java.lang.String

scala> def g(s: String) = "g(" + s + ")"
g: (String)java.lang.String


// compose makes a new function that composes other functions f(g(x))

scala> val fComposeG = f _ compose g _
fComposeG: (String) => java.lang.String = <function>

// andThen is like compose, but calls the first function and then the second, g(f(x))
scala> fComposeG("yay")
res0: java.lang.String = f(g(yay))

 */



