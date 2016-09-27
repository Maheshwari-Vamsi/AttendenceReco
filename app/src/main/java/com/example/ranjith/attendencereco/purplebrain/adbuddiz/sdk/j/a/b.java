package com.purplebrain.adbuddiz.sdk.j.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class b
  extends Exception
{
  public a a;
  public List b = new ArrayList();
  
  public b(a parama)
  {
    this(parama, new ArrayList(), null);
  }
  
  public b(a parama, com.purplebrain.adbuddiz.sdk.j.b.a.a parama1)
  {
    this(parama, Collections.singletonList(parama1), null);
  }
  
  public b(a parama, com.purplebrain.adbuddiz.sdk.j.b.a.a parama1, String paramString)
  {
    this(parama, Collections.singletonList(parama1), paramString);
  }
  
  public b(a parama, String paramString)
  {
    this(parama, new ArrayList(), paramString);
  }
  
  public b(a parama, Throwable paramThrowable)
  {
    this(parama, new ArrayList(), paramThrowable);
  }
  
  public b(a parama, List paramList)
  {
    this(parama, paramList, null);
  }
  
  private b(a parama, List paramList, String paramString)
  {
    super(a(parama, paramString));
    this.a = parama;
    this.b.addAll(paramList);
  }
  
  private b(a parama, List paramList, Throwable paramThrowable)
  {
    super(a(parama, null), paramThrowable);
    this.a = parama;
    this.b.addAll(paramList);
  }
  
  private static String a(a parama, String paramString)
  {
    if (paramString == null)
    {
      Locale localLocale2 = Locale.US;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(parama.j);
      return String.format(localLocale2, "VAST Error: %d", arrayOfObject2);
    }
    Locale localLocale1 = Locale.US;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = Integer.valueOf(parama.j);
    arrayOfObject1[1] = paramString;
    return String.format(localLocale1, "VAST Error: %d. %s", arrayOfObject1);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\j\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */