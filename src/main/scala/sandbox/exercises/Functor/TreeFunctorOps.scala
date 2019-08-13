package sandbox.exercises.Functor

import cats.Functor
import sandbox.utils.{Branch, Leaf, Tree}

object TreeFunctorOps {
  val treeInstance: Functor[Tree] = new Functor[Tree] {
    def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
      case Leaf(v) => Leaf(f(v))
    }
  }
}

object TreeSyntax {
  implicit class RichTreeFunctor[A](t: Tree[A]) {
    def map[B](func: A => B)(implicit instance: Functor[Tree]): Tree[B] = instance.map(t)(func)
  }
}
