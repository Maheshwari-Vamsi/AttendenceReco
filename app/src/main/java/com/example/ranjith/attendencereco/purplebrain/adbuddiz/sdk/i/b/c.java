package com.purplebrain.adbuddiz.sdk.i.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.purplebrain.adbuddiz.sdk.f.a.a;
import com.purplebrain.adbuddiz.sdk.f.a.e;
import com.purplebrain.adbuddiz.sdk.i.l;
import com.purplebrain.adbuddiz.sdk.i.o;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static String a(Map paramMap)
  {
    long l = 0L;
    Iterator localIterator = paramMap.entrySet().iterator();
    Object localObject2;
    for (Object localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      JSONArray localJSONArray = (JSONArray)localEntry.getValue();
      localObject2 = localObject1;
      for (int i = 0; i < localJSONArray.length(); i++) {
        if (localJSONArray.getLong(i) > l)
        {
          localObject2 = (String)localEntry.getKey();
          l = localJSONArray.getLong(i);
        }
      }
    }
    if (System.currentTimeMillis() - l > 10000L) {
      return null;
    }
    return (String)localObject1;
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "I-";
    }
    return "A-";
  }
  
  public static JSONArray a(Context paramContext, a parama, boolean paramBoolean)
  {
    return a(paramContext.getSharedPreferences("ABZ-impr", 0), a(paramBoolean) + parama.b());
  }
  
  public static JSONArray a(Context paramContext, boolean paramBoolean)
  {
    return a(paramContext.getSharedPreferences("ABZ-impr", 0), b(paramBoolean));
  }
  
  private static JSONArray a(SharedPreferences paramSharedPreferences, String paramString)
  {
    String str = paramSharedPreferences.getString(paramString, "[]");
    try
    {
      JSONArray localJSONArray = new JSONArray(str);
      return localJSONArray;
    }
    catch (JSONException localJSONException) {}
    return new JSONArray();
  }
  
  public static JSONObject a(Context paramContext, boolean paramBoolean, a parama)
  {
    JSONObject localJSONObject = new JSONObject();
    Map localMap = b(paramContext.getSharedPreferences("ABZ-impr", 0), a(paramBoolean));
    if ((parama != null) && (parama.e().f))
    {
      String str = a(localMap);
      if ((str == null) || (!str.equals(parama.b())))
      {
        JSONArray localJSONArray = (JSONArray)localMap.get(parama.b());
        if (localJSONArray == null)
        {
          localJSONArray = new JSONArray();
          localMap.put(parama.b(), localJSONArray);
        }
        localJSONArray.put(System.currentTimeMillis());
      }
    }
    Iterator localIterator = localMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
    }
    return localJSONObject;
  }
  
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("ABZ-impr", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    Iterator localIterator = localSharedPreferences.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((String)localEntry.getKey()).startsWith("A-")) || (((String)localEntry.getKey()).startsWith("I-")) || (((String)localEntry.getKey()).equals("MRAID")) || (((String)localEntry.getKey()).equals("RI"))) {
        localEditor.remove((String)localEntry.getKey());
      }
    }
    localEditor.commit();
  }
  
  public static void a(Context paramContext, a parama)
  {
    if ((parama.e() == e.a) || (parama.e() == e.b))
    {
      Date localDate1 = new Date();
      SharedPreferences localSharedPreferences1 = paramContext.getSharedPreferences("ABZ-impr", 0);
      String str1 = a(parama.b);
      String str2 = a(parama.b);
      JSONArray localJSONArray1 = a(localSharedPreferences1, str2 + parama.b());
      localJSONArray1.put(localDate1.getTime());
      a(localSharedPreferences1, str1 + parama.b(), localJSONArray1);
      return;
    }
    Date localDate2 = new Date();
    SharedPreferences localSharedPreferences2 = paramContext.getSharedPreferences("ABZ-impr", 0);
    JSONArray localJSONArray2 = a(localSharedPreferences2, b(parama.b));
    localJSONArray2.put(localDate2.getTime());
    a(localSharedPreferences2, b(parama.b), localJSONArray2);
  }
  
  private static void a(SharedPreferences paramSharedPreferences, String paramString, JSONArray paramJSONArray)
  {
    SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
    localEditor.putString(paramString, paramJSONArray.toString());
    localEditor.commit();
  }
  
  private static String b(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "RI";
    }
    return "MRAID";
  }
  
  private static Map b(SharedPreferences paramSharedPreferences, String paramString)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramSharedPreferences.getAll().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      try
      {
        if (((String)localEntry.getKey()).startsWith(paramString)) {
          localHashMap.put(((String)localEntry.getKey()).substring(paramString.length()), new JSONArray(localEntry.getValue().toString()));
        }
      }
      catch (JSONException localJSONException) {}
    }
    return localHashMap;
  }
  
  @SuppressLint({"NewApi"})
  private static final class a
  {
    Context a;
    int b;
    int c;
    
    public a(Context paramContext, int paramInt1, int paramInt2)
    {
      this.a = paramContext;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */