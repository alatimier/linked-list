import scala.annotation.tailrec

sealed case class Node[T](value: T, next: Node[T])

object Node {
  def apply[T](value: T): Node[T] = new Node(value, null)
}

class LinkedList[T] private(root: Node[T]) {

  def this() {
    this(null)
  }

  def add(value: T): LinkedList[T] = {
    new LinkedList(add(root, value))
  }

  private def add(node: Node[T], value: T): Node[T] = {
    if (node == null) {
      Node(value)
    } else {
      Node(node.value, add(node.next, value))
    }
  }

  def remove(value: T): LinkedList[T] = {
    new LinkedList(remove(root, value))
  }

  private def remove(node: Node[T], value: T): Node[T] = {
    if (node == null) {
      null
    } else if (node.value == value) {
      node.next
    } else {
      Node(node.value, remove(node.next, value))
    }
  }

  def size(): Int = {
    reduceLeft(0)((acc: Int, _) => acc + 1)
  }

  override def toString: String = {
    reduceLeft(root, "LinkedList :")((acc, value) => s"$acc $value")
  }

  def reduceLeft[R](acc: R)(f: (R, T) => R): R = {
    reduceLeft(root, acc)(f)
  }

  @tailrec
  private def reduceLeft[R](node: Node[T], acc: R)(f: (R, T) => R): R = {
    if (node != null) {
      reduceLeft(node.next, f(acc, node.value))(f)
    } else {
      acc
    }
  }

  def map[R](f: T => R): LinkedList[R] = {
    new LinkedList[R](applyFunction(root, f))
  }

  private def applyFunction[R](node: Node[T], f: T => R): Node[R] = {
    if (node != null) {
      Node(f(node.value), applyFunction(node.next, f))
    } else {
      null
    }
  }
}
