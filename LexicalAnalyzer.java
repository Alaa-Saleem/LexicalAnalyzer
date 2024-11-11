import java.io.*;
import java.util.*;

public class LexicalAnalyzer {
   
 
    private static final String[] PASCAL_KEYWORDS = {
            "PROGRAM", "VAR", "INTEGER", "BOOLEAN", "BEGIN", "END", "PROCEDURE", "IF", "THEN", "ELSE",
            "FOR", "DO", "WRITE", "READ", "TRUE", "FALSE", "MOD", "DIV", "AND", "OR", "NOT",
            "OF", "ARRAY", "TO", "DOWNTO"
    };
    private List<token> tokens = new ArrayList<>();  

    private boolean isKeyword(String word) {
        return Arrays.asList(PASCAL_KEYWORDS).contains(word.toUpperCase());
    }

    
    public void addToken(String name, String type, int lineNo) {
        tokens.add(new token(name, type, lineNo));  
    }

   
    public void processFile(File fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNo = 1;

         
            while ((line = reader.readLine()) != null) {
           
                processLine(line, lineNo);  
                lineNo++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }


    private void processLine(String line, int lineNo) {
     
        if (line.trim().isEmpty()) {
            return; 
        }


        line = line.trim();


        line = line.toUpperCase();

    
        String[] words = line.split("\\s+");


        for (String word : words) {
        
            if (word.equals(";") || word.equals(":") ||  word.equals(",")||  word.equals(".")) {
                addToken(word, "SYMBOL", lineNo); }
            else if ( word.equals("+") || word.equals(":=")) {
                addToken(word, "OPERATOR", lineNo); }
            else if (isKeyword(word)) {
                addToken(word, "KEYWORD", lineNo); 
            } else if (word.matches("\\d+")) {
                addToken(word, "NUM CONST", lineNo); 
            } else if (word.matches("[a-zA-Z_][a-zA-Z_0-9]*")) {  
                addToken(word, "IDENT", lineNo);  
            } else {
                addToken(word, "UNKNOWN", lineNo); 
            }
        }
    }

    public void printTokens() {
        for (token token : tokens) {  
            System.out.println(token);
        }
    }


  public static void main(String[] args) {
        
        File file = new File("C:/Users/Ahmed/Desktop/p.txt");
    
        LexicalAnalyzer analyzer = new LexicalAnalyzer();
 
        analyzer.processFile(file);

        analyzer.printTokens();
    }
    }
    

