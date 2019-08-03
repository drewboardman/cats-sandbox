package sandbox.exercises

import cats._
import cats.implicits._
import sandbox.utils.Cat

object EqInstances {
  implicit val catEq: Eq[Cat] = Eq.instance[Cat] { (cat1: Cat, cat2: Cat) =>
    cat1.name === cat2.name &&
      cat1.age === cat2.age &&
      cat1.color === cat2.color
  }
}
