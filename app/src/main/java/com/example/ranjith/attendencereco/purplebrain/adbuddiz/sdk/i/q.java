package com.purplebrain.adbuddiz.sdk.i;

import android.content.Context;
import com.purplebrain.adbuddiz.sdk.i.a.h;
import com.purplebrain.adbuddiz.sdk.i.b.d;

public class q
{
  private static boolean a = false;
  private static String b = null;
  private static String c = null;
  
  public static void a(Context paramContext)
  {
    c = null;
    d.c(paramContext, "PK");
  }
  
  public static void a(String paramString)
  {
    b = paramString;
    a = true;
    c = null;
  }
  
  public static String b(Context paramContext)
  {
    if ((c == null) && (a))
    {
      String str2 = d.a(paramContext, "PK");
      c = str2;
      if ((str2 == null) || (!c.equals(b)))
      {
        new Object[1][0] = b;
        if (b == null) {
          break label79;
        }
        d.a(paramContext, "PK", b);
      }
    }
    for (c = b; b != null; c = null)
    {
      return b;
      label79:
      d.c(paramContext, "PK");
    }
    if (c == null)
    {
      c = d.a(paramContext, "PK");
      new Object[1][0] = c;
    }
    if (c != null)
    {
      String str1 = c;
      b = str1;
      return str1;
    }
    new Object[1][0] = Integer.valueOf(q.class.hashCode());
    return h.a(paramContext);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */