package com.purplebrain.adbuddiz.sdk.f;

public final class d
{
  public String a;
  public String b;
  public a c;
  
  public d(a parama, String paramString)
  {
    this(parama.k, paramString);
    this.c = parama;
  }
  
  public d(String paramString1, String paramString2)
  {
    this.b = paramString1;
    this.c = null;
    if (paramString2 != null)
    {
      this.a = paramString2;
      return;
    }
    this.a = "";
  }
  
  public static enum a
  {
    String k;
    
    static
    {
      a[] arrayOfa = new a[10];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
      arrayOfa[5] = f;
      arrayOfa[6] = g;
      arrayOfa[7] = h;
      arrayOfa[8] = i;
      arrayOfa[9] = j;
      l = arrayOfa;
    }
    
    private a(String paramString1)
    {
      this.k = paramString1;
    }
    
    public static a[] a()
    {
      return (a[])l.clone();
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */