import leetcode.easy.SortArrayByParity

object SbtScalaMainApp	extends	App	{
	//println("Hello	world	SBT	/	Scala	App	")
	//println(JewelsAndStones.numJewelsInStones("aA", "aAAbbbb"))
  SortArrayByParity.sortArrayByParity(Array[Int](3,1,2,4)).foreach(print)
}
