package com.aibasis

/**
  * Created by hxx on 06/07/2017.
  */
object TreeNode {

  def asciiDisplay(root: TreeNode[String]): Seq[String] = asciiDisplay(root, "", "  ")

  case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

  def asciiDisplay(root: TreeNode[String], prefix: String, nextPrefix: String): Seq[String] = root match {
    case TreeNode(d, Nil) => prefix + "+-" + d :: Nil
    case TreeNode(d, c) => (prefix + "+-" + d) +: asciiDisplay(c, prefix, nextPrefix)
    case _ => List()
  }

  def asciiDisplay(children: Seq[TreeNode[String]], prefix: String, nextPrefix: String): Seq[String] = children match {
    case h :: t if t.nonEmpty =>
      if (h.children.nonEmpty) {
        (asciiDisplay(h, nextPrefix, nextPrefix + "| ") :+ nextPrefix + "| ") ++ asciiDisplay(t, prefix, nextPrefix)
      } else {
        asciiDisplay(h, nextPrefix, nextPrefix + "| ") ++ asciiDisplay(t, prefix, nextPrefix)
      }
    case h :: Nil => asciiDisplay(h, nextPrefix, nextPrefix + "  ")
    case _ => List()
  }

}

