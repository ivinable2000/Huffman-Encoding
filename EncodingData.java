public class EncodingData {
  
  private char symbol;
  private String encoding;
	  
  public EncodingData(char symbol, String encoding) {
    this.symbol = symbol;
    this.encoding = encoding;
  }
	  
  public char getSymbol() {
    return this.symbol;
  }
  
  public String getEncoding() {
    return this.encoding;
  }
	  
  public void setEncoding(String s) {
      this.encoding = s;
	}
	  
  public boolean equals(Object obj) {
    EncodingData other = (EncodingData) obj;
    if (symbol != other.symbol) 
      return false;
    return true;
  }
	  
  public String toString() {
    return (symbol + ": " + encoding + "\n");
  }
		
		
}


