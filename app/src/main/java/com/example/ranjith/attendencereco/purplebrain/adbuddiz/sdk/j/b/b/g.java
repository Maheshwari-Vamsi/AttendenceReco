package com.purplebrain.adbuddiz.sdk.j.b.b;

public enum g
{
  private String d;
  
  static
  {
    g[] arrayOfg = new g[3];
    arrayOfg[0] = a;
    arrayOfg[1] = b;
    arrayOfg[2] = c;
    e = arrayOfg;
  }
  
  private g(String paramString1)
  {
    this.d = paramString1;
  }
  
  public static g a(String paramString)
  {
    for (g localg : (g[])e.clone()) {
      if (localg.d.equals(paramString)) {
        return localg;
      }
    }
    throw new IllegalArgumentException(paramString + " is not a valid delivery.");
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\b\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */