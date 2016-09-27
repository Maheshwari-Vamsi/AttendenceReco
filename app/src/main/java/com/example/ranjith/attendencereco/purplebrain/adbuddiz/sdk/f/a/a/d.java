package com.purplebrain.adbuddiz.sdk.f.a.a;

public enum d
{
  String d;
  public boolean e;
  
  static
  {
    d[] arrayOfd = new d[3];
    arrayOfd[0] = a;
    arrayOfd[1] = b;
    arrayOfd[2] = c;
    f = arrayOfd;
  }
  
  private d(String paramString1, boolean paramBoolean)
  {
    this.d = paramString1;
    this.e = paramBoolean;
  }
  
  public static d a(String paramString)
  {
    for (d locald : (d[])f.clone()) {
      if (locald.d.equals(paramString)) {
        return locald;
      }
    }
    throw new IllegalArgumentException(paramString + " is not a valid resource type");
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */