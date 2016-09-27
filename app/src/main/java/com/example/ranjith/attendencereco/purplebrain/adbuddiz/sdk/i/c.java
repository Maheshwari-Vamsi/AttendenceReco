package com.purplebrain.adbuddiz.sdk.i;

import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.a.a.d;
import com.purplebrain.adbuddiz.sdk.f.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class c
{
  public static com.purplebrain.adbuddiz.sdk.f.a.a.c a(a parama, d paramd, e parame)
  {
    List localList = a(parama, paramd, true, parame);
    if (!localList.isEmpty()) {
      return (com.purplebrain.adbuddiz.sdk.f.a.a.c)localList.get(0);
    }
    return null;
  }
  
  public static com.purplebrain.adbuddiz.sdk.f.a.a.c a(a parama, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parama.d().iterator();
    while (localIterator.hasNext())
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc = (com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next();
      if (localc.b().equals(paramString)) {
        localArrayList.add(localc);
      }
    }
    if (!localArrayList.isEmpty()) {
      return (com.purplebrain.adbuddiz.sdk.f.a.a.c)localArrayList.get(0);
    }
    return null;
  }
  
  public static List a(a parama, d paramd, boolean paramBoolean, e parame)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parama.d().iterator();
    while (localIterator.hasNext())
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc = (com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next();
      if ((localc.b == paramd) && (localc.d == paramBoolean) && (localc.c.a(parame))) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  public static List a(a parama, e parame)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = parama.d().iterator();
    while (localIterator.hasNext())
    {
      com.purplebrain.adbuddiz.sdk.f.a.a.c localc = (com.purplebrain.adbuddiz.sdk.f.a.a.c)localIterator.next();
      if ((localc.d == true) && (localc.c.a(parame))) {
        localArrayList.add(localc);
      }
    }
    return localArrayList;
  }
  
  public static com.purplebrain.adbuddiz.sdk.f.a.a.c b(a parama, e parame)
  {
    List localList = a(parama, parame);
    if (!localList.isEmpty()) {
      return (com.purplebrain.adbuddiz.sdk.f.a.a.c)localList.get(0);
    }
    return null;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */