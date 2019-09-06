import java.util.Iterator;

public class HuffmanTree extends LinkedBinaryTree<HuffmanPair> implements Comparable<HuffmanTree>{
  
  private BinaryTreeNode<HuffmanPair> root;
  
  public HuffmanTree() {
    super();
  }
  
  public HuffmanTree(HuffmanPair element) {
    
    super(element);
  }
  
  public HuffmanTree(HuffmanPair element, HuffmanTree leftSubtree, HuffmanTree rightSubtree) {
    
    super(element,leftSubtree,rightSubtree);
  }
  
  public HuffmanTree(ArrayOrderedList<HuffmanPair> pairslist) {
    
    ArrayOrderedList<HuffmanTree> list = new ArrayOrderedList<HuffmanTree>(pairslist.size());
    while(!(pairslist.isEmpty())) {
      HuffmanTree tree = new HuffmanTree(pairslist.removeLast());
      list.add(tree);
    }
    
    while(list.size() > 1) {
      HuffmanTree leftsubtree = list.removeFirst();
      HuffmanTree rightsubtree = list.removeFirst();
      int freq1 = leftsubtree.getRoot().getElement().getFrequency();
      int freq2 = rightsubtree.getRoot().getElement().getFrequency();
      
      HuffmanPair pair = new HuffmanPair(freq1+freq2);
      HuffmanTree root = new HuffmanTree(pair, leftsubtree, rightsubtree);
      list.add(root);   
    }
    super.setRoot(list.removeFirst().getRoot());
  }

  @Override
  public int compareTo(HuffmanTree otherTree) {
    int freq1 = this.getRoot().getElement().getFrequency();
    int freq2 = otherTree.getRoot().getElement().getFrequency();
    
    return freq1-freq2;
  }
  
  @Override
  public String toString() {
    String s = "";
    
    Iterator<HuffmanPair> list ;
    
    list = iteratorPreOrder();
    while (list.hasNext()) {
        s += list.next().toString();
    }
    return s;
  }

}
