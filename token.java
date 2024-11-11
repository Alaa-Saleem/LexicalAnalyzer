public class token {
  
    private String name;
    private String type;
    private int lineNo; 
    public token(String name, String type, int lineNo) {
        this.name = name;
        this.type = type;
        this.lineNo = lineNo;
    }

   
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLineNo() {
        return lineNo;
    }

    
    @Override
    public String toString() {
        return "Token{Name='" + name + "', Type='" + type + "', Line No=" + lineNo + "}";
    }
}
