class LinkedListTest extends org.scalatest.funsuite.AnyFunSuite {

  test("should create empty list") {
    // When
    val linkedList = new LinkedList[Int]()

    // Then
    assert(linkedList.size() == 0)
  }

  test("should add first element to list") {
    // When
    val linkedList = new LinkedList[Int]() add 1

    // Then
    assert(linkedList.size() == 1)
  }

  test("should add more elements to list") {
    // When
    val linkedList = new LinkedList[Int]() add 1 add 2 add 3

    // Then
    assert(linkedList.size() == 3)
    assert(linkedList.toString() == "LinkedList : 1 2 3")
  }

  test("should map list value") {
    // Given
    val linkedList = new LinkedList[Int]() add 1 add 2 add 3

    // When
    val newLinkedList = linkedList.map(value => value + 1)

    // Then
    assert(newLinkedList.size() == 3)
    assert(newLinkedList.toString() == "LinkedList : 2 3 4")
  }

  test("map on empty list should do nothing") {
    // Given
    val linkedList = new LinkedList[Int]()

    // When
    val newLinkedList = linkedList.map(value => value + 1)

    // Then
    assert(newLinkedList.size() == 0)
    assert(newLinkedList.toString() == "LinkedList :")
  }

  test("should remove last value") {
    // Given
    val linkedList = new LinkedList[Int]() add 1 add 2 add 3

    // When
    val newLinkedList = linkedList.remove(3)

    // Then
    assert(newLinkedList.size() == 2)
    assert(newLinkedList.toString() == "LinkedList : 1 2")
  }

  test("should remove middle value") {
    // Given
    val linkedList = new LinkedList[Int]() add 1 add 2 add 3

    // When
    val newLinkedList = linkedList.remove(2)

    // Then
    assert(newLinkedList.size() == 2)
    assert(newLinkedList.toString() == "LinkedList : 1 3")
  }

  test("should do nothing if value to remove not found") {
    // Given
    val linkedList = new LinkedList[Int]() add 1 add 2 add 3

    // When
    val newLinkedList = linkedList.remove(4)

    // Then
    assert(newLinkedList.size() == 3)
    assert(newLinkedList.toString() == "LinkedList : 1 2 3")
  }

  test("remove on empty list should do nothing") {
    // Given
    val linkedList = new LinkedList[Int]()

    // When
    val newLinkedList = linkedList.remove(1)

    // Then
    assert(newLinkedList.size() == 0)
    assert(newLinkedList.toString() == "LinkedList :")
  }

}
