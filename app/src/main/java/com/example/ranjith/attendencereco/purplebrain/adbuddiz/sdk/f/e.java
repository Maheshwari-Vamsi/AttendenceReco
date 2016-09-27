package com.purplebrain.adbuddiz.sdk.f;

public enum e
{
  public String d;
  public String e;
  
  static
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    f = arrayOfe;
  }
  
  private e(String paramString2, String paramString3)
  {
    this.d = paramString2;
    this.e = paramString3;
  }
  
  public static e a(String paramString)
  {
    for (e locale : ) {
      if (locale.d.equals(paramString)) {
        return locale;
      }
    }
    throw new IllegalArgumentException(paramString + " is not a valid orientation.");
  }
  
  public static e[] a()
  {
    return (e[])f.clone();
  }
  
  public static e b(e parame)
  {
    if (b.equals(parame)) {
      return a;
    }
    return b;
  }
  
  public final boolean a(e parame)
  {
    if (parame == c) {
      return false;
    }
    if (this == c) {
      return true;
    }
    return equals(parame);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */