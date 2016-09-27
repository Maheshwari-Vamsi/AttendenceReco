package com.purplebrain.adbuddiz.sdk.i.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONArray;

public final class d
{
  public static String a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("ABZ-prefs", 0).getString(paramString, null);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("ABZ-prefs", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static void a(Context paramContext, String paramString, JSONArray paramJSONArray)
  {
    a(paramContext, paramString, paramJSONArray.toString());
  }
  
  public static JSONArray b(Context paramContext, String paramString)
  {
    return new JSONArray(paramContext.getSharedPreferences("ABZ-prefs", 0).getString(paramString, "[]"));
  }
  
  public static void c(Context paramContext, String paramString)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("ABZ-prefs", 0).edit();
    localEditor.remove(paramString);
    localEditor.commit();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */