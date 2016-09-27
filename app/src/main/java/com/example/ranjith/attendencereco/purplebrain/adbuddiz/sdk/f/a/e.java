package com.purplebrain.adbuddiz.sdk.f.a;

public enum e
{
  String d;
  public String e;
  public boolean f;
  
  static
  {
    e[] arrayOfe = new e[3];
    arrayOfe[0] = a;
    arrayOfe[1] = b;
    arrayOfe[2] = c;
    g = arrayOfe;
  }
  
  private e(String paramString2, String paramString3, boolean paramBoolean)
  {
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramBoolean;
  }
  
  public static e a(String paramString)
  {
    for (e locale : ) {
      if (locale.d.equals(paramString)) {
        return locale;
      }
    }
    throw new IllegalArgumentException("'" + paramString + "' is not a valid ad type.");
  }
  
  public static e[] a()
  {
    return (e[])g.clone();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */