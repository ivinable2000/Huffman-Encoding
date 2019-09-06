
public class HuffmanCoder {
  private HuffmanTree huffTree;
  private ArrayUnorderedList<EncodingData>encodingList;
  
  public HuffmanCoder(ArrayOrderedList<HuffmanPair> pairslist) {
    huffTree = new HuffmanTree(pairslist); 
  }

  private void buildEncodingList(BinaryTreeNode<HuffmanPair>node, 
      String encoding){
    if(node.isLeaf()) {
      EncodingData data = new EncodingData(node.getElement().getCharacter(), encoding);
      encodingList.addToFront(data);
    }
    else {
      buildEncodingList(node.getLeft(), encoding + "0");
      buildEncodingList(node.getRight(), encoding + "1");
    }
    
  }
  
  public char decode(String code) {
    BinaryTreeNode<HuffmanPair> node = huffTree.getRoot();
    
    for(int i = 0; i < code.length(); i++) {
      
      if(node.getLeft() != null && Character.getNumericValue(code.charAt(i)) == 0) {
        node = node.getLeft();
      }
      else if(node.getRight() != null && Character.getNumericValue(code.charAt(i)) == 1) {
        node = node.getRight();
      }
      else {
        return (char) 0;
      }
    }
    
    if(node.isLeaf()) {
      return node.getElement().getCharacter();
    }
    else {
      return (char) 0;
    }
  }
  
  private BinaryTreeNode<HuffmanPair> find(char targetchar, 
      BinaryTreeNode<HuffmanPair> next) {
    
    if (next == null)
        return null;

    if (next.getElement().getCharacter() == targetchar)
        return next;

    BinaryTreeNode<HuffmanPair> temp = find(targetchar, next.getLeft());

    if (temp == null)
        temp = find(targetchar, next.getRight());

    return temp;
}
  
  public String encode(char c) throws ElementNotFoundException {
    BinaryTreeNode<HuffmanPair> node = huffTree.getRoot();
    String code = "";
    if(find(c,node) == null) {
      throw new ElementNotFoundException("huffman code");
    }
 
    while (find(c, node) != null) {
      if(find(c,node.getLeft()) != null) {
        node = node.getLeft();
        code = code + "0";
      }
      else if(find(c, node.getRight()) != null) {
        node = node.getRight();
        code = code + "1";
      }
      else {
        break;
      }
    }
    return code;
  }
  
  public String toString() {
    
    String s = "" ;
    for (int i = 0; i < encodingList.rear; i++) {
        s += encodingList.getElement(i).toString();
    }
    return s;
}
}

