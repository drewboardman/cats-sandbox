package sandbox.exercises.MonoidAndSemiGroup

import sandbox.utils._
import cats.Monoid
import cats.implicits._
import cats.instances.int._ // for monoid
import cats.instances.option._ // for monoid

object SuperAdder {
  implicit val orderInstance: Monoid[Order] = new Monoid[Order] {
    override def combine(x: Order, y: Order): Order = Order(
      totalCost = x.totalCost |+| y.totalCost,
      quantity = x.quantity |+| y.quantity
    )

    override def empty: Order = Order(0, 0)
  }

  def add[T: Monoid](items: List[T]): T = items.foldLeft(Monoid[T].empty)(_ |+| _)
}
