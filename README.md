# Scala with Cats Code

1.1
-----
* Type classes have 2 ways of specifying interfaces:
    - interface object and interface syntax
    - this is really just creating an object the normal way, or pimping your class
    
* `implicitly`
    - scala provides a typeclass interface for you to use

2.3
---
* Semigroups are Monoids for datatypes that don't have `empty` elements.

```scala
trait Semigroup[A] {
def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
def empty: A
}
```

B.3
-----
* *Context-Bound Syntax*
  - this makes the implicit typeclass declaration easier to read

```
def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
items.foldLeft(monoid.empty)(_ |+| _)

def add[A: Monoid](items: List[A]): A =
items.foldLeft(Monoid[A].empty)(_ |+| _)
```
