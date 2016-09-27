package com.example.ranjith.attendencereco.googlecode.javacpp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Parser
{
  StringBuilder buffer = new StringBuilder();
  TokenList futureTokens = new TokenList();
  Reader input;
  Token lastToken = null;
  int lastc = -1;
  int lineNumber = 0;
  String lineSeparator = System.getProperty("line.separator");
  Writer out;
  Writer output;
  TokenList pastTokens = new TokenList();
  Token token = null;
  
  public Parser(Reader paramReader, Writer paramWriter)
  {
    this.input = paramReader;
    this.output = paramWriter;
  }
  
  public static void main(String[] paramArrayOfString)
    throws IOException
  {
    BufferedReader localBufferedReader = new BufferedReader(new FileReader("/home/saudet/workspace/foo.h"));
    PrintWriter localPrintWriter = new PrintWriter(System.out);
    new Parser(localBufferedReader, localPrintWriter).parse("/home/saudet/workspace/foo.h", "moo");
    localPrintWriter.close();
  }
  
  public void block()
    throws IOException
  {
    for (int i = 0;; i++)
    {
      String str;
      if (i < this.pastTokens.size())
      {
        str = ((Token)this.pastTokens.get(i)).value;
        if ((str.equals("struct")) || (str.equals("class")) || (str.equals("union"))) {
          group();
        }
      }
      else
      {
        return;
      }
      if (str.equals("enum"))
      {
        enumeration();
        return;
      }
    }
  }
  
  void commentAfter(Token paramToken)
    throws IOException
  {
    paramToken.spacing = "";
    paramToken.value = "";
    while ((nextToken().type == 4) && (this.token.value.charAt(3) == '<'))
    {
      String str1 = this.token.spacing;
      String str2 = this.token.value;
      if (str2.charAt(1) == '/')
      {
        StringBuilder localStringBuilder = new StringBuilder().append(paramToken.value);
        if (paramToken.value.length() > 0) {}
        for (String str3 = " * ";; str3 = "/**")
        {
          paramToken.value = (str3 + str2.substring(4));
          break;
        }
      }
      paramToken.value = (paramToken.value + str1 + str2);
    }
    if (paramToken.value.length() > 0)
    {
      if (!paramToken.value.endsWith("*/")) {
        paramToken.value += " */";
      }
      paramToken.value += this.lineSeparator;
    }
    this.lastToken = this.token;
  }
  
  Token commentBefore()
    throws IOException
  {
    Iterator localIterator = this.pastTokens.iterator();
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      Object localObject = null;
      Token localToken;
      if (bool)
      {
        localToken = (Token)localIterator.next();
        if (localToken.type == 3) {
          localObject = localToken;
        }
      }
      else
      {
        return (Token)localObject;
      }
      if (localToken.type == 4) {
        this.out.append(localToken.spacing + localToken.value);
      }
    }
  }
  
  void enumeration()
    throws IOException
  {
    match(123);
    Token localToken1 = commentBefore();
    Token localToken2 = this.futureTokens.getOrAdd((Token)this.pastTokens.getLast());
    this.pastTokens.clear();
    String str1 = localToken1.spacing.substring(1 + localToken1.spacing.lastIndexOf('\n'));
    this.out.append(localToken1.spacing + "/** enum " + localToken2.value + " */" + this.lineSeparator);
    this.out.append(str1 + "public static final int");
    int i = 0;
    int j = 0;
    while ((j == 0) && (nextToken().type != -1)) {
      switch (this.token.type)
      {
      default: 
        this.pastTokens.add(this.token);
        break;
      case 125: 
        j = 1;
      case 44: 
        if (((this.pastTokens.size() != 1) && (this.pastTokens.size() != 3)) || ((this.pastTokens.size() == 3) && (((Token)this.pastTokens.get(1)).type != 61))) {
          throw new RuntimeException(this.lineNumber + ": Could not parse enumerator");
        }
        this.out.append(((Token)this.pastTokens.get(0)).spacing + ((Token)this.pastTokens.get(0)).value);
        if (this.pastTokens.size() == 3) {
          i = Integer.parseInt(((Token)this.pastTokens.get(2)).value);
        }
        this.pastTokens.clear();
        Writer localWriter = this.out;
        StringBuilder localStringBuilder1 = new StringBuilder().append(" = ");
        int k = i + 1;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(i);
        if (j != 0) {}
        for (String str2 = ";";; str2 = ",")
        {
          localWriter.append(str2);
          i = k;
          break;
        }
      }
    }
    if (nextToken().type == 3)
    {
      localToken2.value = this.token.value;
      nextToken();
    }
    match(59);
  }
  
  void function()
    throws IOException
  {
    match(40);
    Token localToken1 = commentBefore();
    String str1 = ((Token)this.pastTokens.getLast()).value;
    this.pastTokens.clear();
    String str2 = localToken1.spacing;
    Token localToken2 = this.futureTokens.getOrAdd(null);
    if ((localToken2.value != null) && (localToken2.value.length() > 0))
    {
      this.out.append(localToken1.spacing + localToken2.value);
      str2 = localToken1.spacing.substring(1 + localToken1.spacing.lastIndexOf('\n'));
    }
    this.out.append(str2 + "public static " + modifiers() + localToken1.value + " " + str1 + "(");
    int i = 0;
    while ((i == 0) && (nextToken().type != -1)) {
      switch (this.token.type)
      {
      default: 
        this.pastTokens.add(this.token);
        break;
      case 41: 
      case 44: 
        if (this.pastTokens.size() > 0)
        {
          String str3 = ((Token)this.pastTokens.getFirst()).spacing;
          Token localToken3 = (Token)this.pastTokens.getFirst();
          String str4 = ((Token)this.pastTokens.getLast()).value;
          this.out.append(str3 + modifiers() + localToken3.value + " " + str4);
        }
        this.out.append((char)this.token.type);
        break;
      case 59: 
        i = 1;
      }
    }
    match(59);
    this.out.append(this.token.spacing + ';');
    commentAfter(localToken2);
  }
  
  void group()
    throws IOException
  {
    int i;
    Token localToken1;
    int j;
    if (this.pastTokens.size() > 0)
    {
      i = 1;
      localToken1 = null;
      if (i != 0)
      {
        match(123);
        Token localToken3 = commentBefore();
        Token localToken4 = (Token)this.pastTokens.getLast();
        this.pastTokens.clear();
        localToken1 = this.futureTokens.getOrAdd(localToken4);
        this.out.append(localToken3.spacing + "public static class " + localToken1.value + " extends Pointer {");
      }
      j = 0;
    }
    for (;;)
    {
      if ((j != 0) || (nextToken().type == -1)) {
        break label234;
      }
      switch (this.token.type)
      {
      default: 
        this.pastTokens.add(this.token);
        continue;
        i = 0;
        break;
      case 40: 
        function();
        break;
      case 59: 
        variable(localToken1);
        break;
      case 35: 
        macro();
        break;
      case 123: 
        block();
        break;
      case 125: 
        j = 1;
      }
    }
    label234:
    Iterator localIterator = this.pastTokens.iterator();
    while (localIterator.hasNext())
    {
      Token localToken2 = (Token)localIterator.next();
      if (localToken2.type == 4) {
        this.out.append(localToken2.spacing + localToken2.value);
      }
    }
    this.pastTokens.clear();
    if (i != 0)
    {
      match(125);
      this.out.append(this.token.spacing + '}');
      if (nextToken().type == 3)
      {
        localToken1.value = this.token.value;
        nextToken();
      }
      match(59);
    }
    this.out.append(this.token.spacing);
  }
  
  void macro()
    throws IOException
  {
    match(35);
    String str1 = this.token.spacing;
    if (nextToken().type != -1)
    {
      if (this.token.spacing.length() > 0) {}
      for (int i = this.token.spacing.charAt(0);; i = -1)
      {
        if ((i == 13) || (i == 10))
        {
          if (((Token)this.pastTokens.getLast()).type != 92) {
            break label112;
          }
          this.pastTokens.pop();
        }
        this.pastTokens.add(this.token);
        break;
      }
    }
    label112:
    if (this.pastTokens.size() > 0) {}
    for (Token localToken1 = (Token)this.pastTokens.getFirst(); (localToken1 == null) || (localToken1.type != 3); localToken1 = null) {
      throw new RuntimeException(this.lineNumber + ": Could not parse macro");
    }
    Token localToken2;
    Token localToken3;
    if ((localToken1.value.equals("define")) && (this.pastTokens.size() > 2))
    {
      localToken2 = (Token)this.pastTokens.get(1);
      localToken3 = (Token)this.pastTokens.get(2);
      switch (localToken3.type)
      {
      default: 
        return;
      }
    }
    for (String str2 = "int ";; str2 = "String ")
    {
      this.out.append(str1 + "public static final " + str2);
      this.out.append(localToken2.value + " = " + localToken3.value + ";");
      this.out.append(this.token.spacing);
      return;
    }
  }
  
  void match(int paramInt)
  {
    if (this.token.type != paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.lineNumber).append(": Unexpected token '");
      if ((this.token.value != null) && (this.token.value.length() > 0)) {}
      for (Object localObject = this.token.value;; localObject = Character.valueOf((char)this.token.type)) {
        throw new RuntimeException(localObject + "'");
      }
    }
  }
  
  String modifiers()
  {
    String str = "";
    int i;
    int j;
    if (this.pastTokens.size() > 1)
    {
      i = ((Token)this.pastTokens.get(1)).type;
      if (this.pastTokens.size() <= 2) {
        break label79;
      }
      j = ((Token)this.pastTokens.get(2)).type;
      label55:
      if (i != 38) {
        break label84;
      }
      str = "@ByRef ";
    }
    for (;;)
    {
      this.pastTokens.clear();
      return str;
      i = -1;
      break;
      label79:
      j = -1;
      break label55;
      label84:
      if ((i == 42) && (j == 38)) {
        str = "@ByPtrRef ";
      } else if ((i == 42) && (j == 42)) {
        str = "@ByPtrPtr ";
      } else if (i != 42) {
        str = "@ByVal ";
      }
    }
  }
  
  Token nextToken()
    throws IOException
  {
    if (this.lastToken != null)
    {
      this.token = this.lastToken;
      this.lastToken = null;
      return this.token;
    }
    this.token = new Token();
    if (this.lastc == -1) {}
    for (int i = this.input.read();; i = this.lastc)
    {
      this.lastc = -1;
      this.buffer.setLength(0);
      if (!Character.isWhitespace(i)) {
        break;
      }
      this.buffer.append((char)i);
      if ((i == 13) || (i == 10)) {}
      for (this.lineNumber = (1 + this.lineNumber);; this.lineNumber = (1 + this.lineNumber)) {
        do
        {
          i = this.input.read();
          if ((i == -1) || (!Character.isWhitespace(i))) {
            break;
          }
          this.buffer.append((char)i);
        } while ((i != 13) && (i != 10));
      }
    }
    this.token.spacing = this.buffer.toString();
    this.buffer.setLength(0);
    if ((Character.isLetter(i)) || (i == 95))
    {
      this.token.type = 3;
      this.buffer.append((char)i);
      int j;
      for (;;)
      {
        j = this.input.read();
        if ((j == -1) || ((!Character.isLetter(j)) && (!Character.isDigit(j)) && (j != 95))) {
          break;
        }
        this.buffer.append((char)j);
      }
      this.token.value = this.buffer.toString();
      this.lastc = j;
    }
    for (;;)
    {
      return this.token;
      if ((Character.isDigit(i)) || (i == 45) || (i == 46))
      {
        this.token.type = 1;
        this.buffer.append((char)i);
        int k;
        for (;;)
        {
          k = this.input.read();
          if ((k == -1) || ((!Character.isDigit(k)) && (k != 46))) {
            break;
          }
          this.buffer.append((char)k);
        }
        this.token.value = this.buffer.toString();
        this.lastc = k;
      }
      else if (i == 47)
      {
        int m = this.input.read();
        if (m == 47)
        {
          this.token.type = 4;
          this.buffer.append('/').append('/');
          int i2;
          for (;;)
          {
            i2 = this.input.read();
            if ((i2 == -1) || (i2 == 13) || (i2 == 10)) {
              break;
            }
            this.buffer.append((char)i2);
          }
          this.token.value = this.buffer.toString();
          this.lastc = i2;
        }
        else if (m == 42)
        {
          this.token.type = 4;
          this.buffer.append('/').append('*');
          int i1;
          for (int n = 0;; n = i1)
          {
            i1 = this.input.read();
            if ((i1 == -1) || ((n == 42) && (i1 == 47))) {
              break;
            }
            this.buffer.append((char)i1);
          }
          this.buffer.append((char)i1);
          this.token.value = this.buffer.toString();
        }
        else
        {
          this.lastc = m;
          this.token.type = 47;
        }
      }
      else
      {
        this.token.type = i;
      }
    }
  }
  
  public void parse(String paramString1, String paramString2)
    throws IOException
  {
    this.input = new BufferedReader(new FileReader(paramString1));
    this.out = new Writer()
    {
      public void close() {}
      
      public void flush() {}
      
      public void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2) {}
    };
    this.pastTokens.clear();
    this.futureTokens.clear();
    this.lineNumber = 0;
    group();
    this.input.close();
    this.input = new BufferedReader(new FileReader(paramString1));
    this.out = new PrintWriter(System.out);
    this.pastTokens.clear();
    this.futureTokens.reset();
    this.lineNumber = 0;
    group();
    this.input.close();
    this.out.close();
  }
  
  void variable(Token paramToken)
    throws IOException
  {
    match(59);
    Token localToken1 = commentBefore();
    String str1 = ((Token)this.pastTokens.getLast()).value;
    this.pastTokens.clear();
    String str2 = localToken1.spacing;
    Token localToken2 = this.futureTokens.getOrAdd(null);
    if ((localToken2.value != null) && (localToken2.value.length() > 0))
    {
      this.out.append(localToken1.spacing + localToken2.value);
      str2 = localToken1.spacing.substring(1 + localToken1.spacing.lastIndexOf('\n'));
    }
    String str3 = "public ";
    String str4 = "void ";
    if (paramToken != null) {
      str4 = paramToken.value + " ";
    }
    for (;;)
    {
      this.out.append(str2 + modifiers() + str3 + localToken1.value + " " + str1 + "(); ");
      this.out.append(str3 + str4 + str1 + "(" + localToken1.value + " " + str1 + ");");
      this.out.append(this.token.spacing);
      commentAfter(localToken2);
      return;
      str3 = str3 + "static ";
    }
  }
  
  class Token
  {
    static final int COMMENT = 4;
    static final int IDENTIFIER = 3;
    static final int NUMBER = 1;
    static final int STRING = 2;
    String spacing;
    int type;
    String value;
    
    Token() {}
  }
  
  class TokenList
    extends LinkedList<Token>
  {
    ListIterator<Token> iterator = listIterator();
    
    TokenList() {}
    
    public void clear()
    {
      super.clear();
      reset();
    }
    
    Token getOrAdd(Token paramToken)
    {
      if (this.iterator.hasNext()) {
        return (Token)this.iterator.next();
      }
      if (paramToken == null) {
        paramToken = new Token(Parser.this);
      }
      this.iterator.add(paramToken);
      return paramToken;
    }
    
    void reset()
    {
      this.iterator = listIterator();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacpp\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */