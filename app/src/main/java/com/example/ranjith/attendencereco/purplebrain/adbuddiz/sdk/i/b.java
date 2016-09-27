package com.purplebrain.adbuddiz.sdk.i;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.a.e;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static Map a(e parame)
  {
    List localList = m.a(AdBuddiz.getContext(), parame, false);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      File localFile = (File)localIterator.next();
      String str;
      int i;
      try
      {
        str = m.a(localFile, parame);
        i = str.indexOf('_');
        if (i != -1) {
          break label103;
        }
        throw new Exception();
      }
      catch (Exception localException)
      {
        new StringBuilder("Could not determine ad id from file name: '").append(localFile.getName()).append("'. May not be a cached resource.");
      }
      continue;
      label103:
      long l = Long.parseLong(str.substring(0, i));
      Object localObject = (List)localHashMap.get(Long.valueOf(l));
      if (localObject == null)
      {
        localObject = new ArrayList();
        localHashMap.put(Long.valueOf(l), localObject);
      }
      ((List)localObject).add(localFile);
    }
    return localHashMap;
  }
  
  public static void a(Collection paramCollection)
  {
    com.purplebrain.adbuddiz.sdk.f.b localb = com.purplebrain.adbuddiz.sdk.e.b.a().b();
    if (localb == null) {}
    for (;;)
    {
      return;
      HashMap localHashMap = new HashMap();
      a(localHashMap, e.a);
      a(localHashMap, e.b);
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(localHashMap.size());
      arrayOfObject[1] = Integer.valueOf(localb.k);
      for (int i = localHashMap.size(); i > localb.k; i--) {
        a(paramCollection, localHashMap);
      }
    }
  }
  
  private static void a(Collection paramCollection, Map paramMap)
  {
    Object localObject1 = null;
    long l1 = Long.MAX_VALUE;
    Iterator localIterator1 = paramMap.entrySet().iterator();
    Object localObject2;
    long l2;
    if (localIterator1.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator1.next();
      Long localLong = (Long)localEntry.getKey();
      int i = 0;
      if (paramCollection != null)
      {
        Iterator localIterator3 = paramCollection.iterator();
        if ((i == 0) && (localIterator3.hasNext()))
        {
          a locala = (a)localIterator3.next();
          if (locala != null) {}
          int j;
          switch (1.a[locala.e().ordinal()])
          {
          default: 
            j = i;
          }
          for (;;)
          {
            i = j;
            break;
            if (((com.purplebrain.adbuddiz.sdk.f.a.b)locala).g == localLong.longValue()) {
              j = 1;
            } else {
              j = 0;
            }
          }
        }
      }
      if (i != 0) {
        break label308;
      }
      long l3 = ((File)((List)localEntry.getValue()).get(0)).lastModified();
      if (l3 >= l1) {
        break label308;
      }
      localObject2 = localEntry;
      l2 = l3;
    }
    for (;;)
    {
      l1 = l2;
      localObject1 = localObject2;
      break;
      if (localObject1 != null)
      {
        Iterator localIterator2 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (localIterator2.hasNext())
        {
          File localFile = (File)localIterator2.next();
          new Object[1][0] = m.a(localFile, e.a);
          localFile.delete();
        }
        paramMap.remove(((Map.Entry)localObject1).getKey());
      }
      return;
      label308:
      l2 = l1;
      localObject2 = localObject1;
    }
  }
  
  private static void a(Map paramMap, e parame)
  {
    Iterator localIterator = a(parame).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramMap.put(localEntry.getKey(), localEntry.getValue());
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */