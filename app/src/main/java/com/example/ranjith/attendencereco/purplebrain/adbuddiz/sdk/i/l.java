package com.purplebrain.adbuddiz.sdk.i;

import com.purplebrain.adbuddiz.sdk.AdBuddizError;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.d;
import com.purplebrain.adbuddiz.sdk.f.d.a;
import com.purplebrain.adbuddiz.sdk.h.g;

public final class l
{
  public static void a(d.a parama, Throwable paramThrowable)
  {
    a(new d(parama, null), null, paramThrowable);
  }
  
  private static void a(d paramd, a parama, Throwable paramThrowable)
  {
    g localg = new g();
    localg.g = parama;
    localg.a(AdBuddizError.UNKNOWN_EXCEPTION_RAISED);
    localg.i = paramd;
    localg.a(paramThrowable);
    localg.f();
  }
  
  public static void a(String paramString, a parama, Throwable paramThrowable)
  {
    a(new d(paramString, null), parama, paramThrowable);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */