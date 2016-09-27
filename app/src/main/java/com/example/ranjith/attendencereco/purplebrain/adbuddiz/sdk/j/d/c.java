package com.purplebrain.adbuddiz.sdk.j.d;

import com.purplebrain.adbuddiz.sdk.f.a.a.g;
import com.purplebrain.adbuddiz.sdk.f.e;
import com.purplebrain.adbuddiz.sdk.j.b.b.f;
import java.net.URL;
import java.util.Locale;

public final class c
  extends g
{
  public c(com.purplebrain.adbuddiz.sdk.f.a.a parama, f paramf, URL paramURL)
  {
    super(parama, com.purplebrain.adbuddiz.sdk.f.a.a.d.b, e.c, paramURL.toString());
    a.a(this, paramf);
  }
  
  public final String b()
  {
    int i = com.purplebrain.adbuddiz.sdk.i.c.d.c(this);
    int j = com.purplebrain.adbuddiz.sdk.i.c.d.d(this);
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(i);
    arrayOfObject[1] = Integer.valueOf(j);
    return String.format(localLocale, "MEDIA-%dx%d", arrayOfObject);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\d\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */