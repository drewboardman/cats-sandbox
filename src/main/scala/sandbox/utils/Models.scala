package sandbox.utils

final case class Dog(name: String, age: Int, color: String)
final case class Cat(name: String, age: Int, color: String)
final case class Order(totalCost: Double, quantity: Double)

sealed trait Tree[+A]
final case class Branch[A](l: Tree[A], r: Tree[A]) extends Tree[A]
final case class Leaf[A](v: A) extends Tree[A]

sealed trait Tree2[+A]
final case class Branch2[A](v: A, l: Tree[A], r: Tree[A]) extends Tree2[A]
final case class Leaf2[A](v: A) extends Tree2[A]
