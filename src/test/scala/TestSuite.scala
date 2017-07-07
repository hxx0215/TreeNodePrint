import org.scalatest.FunSuite

import com.aibasis.TreeNode._

/**
  * Created by hxx on 07/07/2017.
  */
class TestSuite extends FunSuite {
  test("An empty Set should have size 0") {
    assert(Set.empty.isEmpty)
  }

  test("Sample 1") {
    val t1 = asciiDisplay(TreeNode("Root",
      children = List(TreeNode("level1-1"),
        TreeNode("level1-2"),
        TreeNode("level1-3"))))
    val a1 = List(
      "+-Root",
      "  +-level1-1",
      "  +-level1-2",
      "  +-level1-3"
    )
    assert(t1 == a1)
  }

  test("Sample 2") {
    val t1 = asciiDisplay(TreeNode("Root",
      children = List(
        TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
        TreeNode("level1-2"),
        TreeNode("level1-3"))))
    val a1 = List(
      "+-Root",
      "  +-level1-1",
      "  | +-level2-1",
      "  |   +-level3-1",
      "  | ",
      "  +-level1-2",
      "  +-level1-3")
    assert(t1 == a1)
  }

  test("my Test 1"){
    val t1 = asciiDisplay(TreeNode("Root",
        children = List(
          TreeNode("level1-1", children = List(
            TreeNode("level2-1", children = List(TreeNode("level3-1"), TreeNode("level3-2", List(TreeNode("level4-1"))))), TreeNode("level2-2"))),
          TreeNode("level1-2", children = List(TreeNode("level2-3"))),
          TreeNode("level1-3"),
          TreeNode("level1-4"))))
    val a1 = List(
      "+-Root",
      "  +-level1-1",
      "  | +-level2-1",
      "  | | +-level3-1",
      "  | | +-level3-2",
      "  | |   +-level4-1",
      "  | | ",
      "  | +-level2-2",
      "  | ",
      "  +-level1-2",
      "  | +-level2-3",
      "  | ",
      "  +-level1-3",
      "  +-level1-4")
    assert(a1 == t1)
  }

  test("only Root"){
    val t1 = asciiDisplay(TreeNode("Root"))
    val a1 = List("+-Root")
    assert(a1 == t1)
  }

  test("Nil"){
    val t1 = asciiDisplay(null)
    val a1 = List()
    assert(t1 == a1)
  }
}
