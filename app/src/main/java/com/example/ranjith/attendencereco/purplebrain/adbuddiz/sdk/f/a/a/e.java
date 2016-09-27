package com.purplebrain.adbuddiz.sdk.f.a.a;

import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.i.n;
import java.net.URL;

public class e
  extends c
{
  private URL e;
  
  public e(a parama, d paramd, boolean paramBoolean, com.purplebrain.adbuddiz.sdk.f.e parame, URL paramURL)
  {
    super(parama, paramd, paramBoolean, parame);
    this.e = paramURL;
  }
  
  public String b()
  {
    String str = this.e.toString();
    return n.a("SHA-1", str.substring(1 + str.lastIndexOf('/'))).substring(0, 6);
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public final URL d()
  {
    return this.e;
  }
  
  public final boolean e()
  {
    return false;
  }
  
  public final String f()
  {
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\f\a\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */