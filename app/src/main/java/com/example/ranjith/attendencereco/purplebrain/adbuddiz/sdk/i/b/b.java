package com.purplebrain.adbuddiz.sdk.i.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.purplebrain.adbuddiz.sdk.i.q;
import com.purplebrain.adbuddiz.sdk.i.u;

public final class b
{
  public static String a(Context paramContext)
  {
    return paramContext.getSharedPreferences("ABZ-prefs", 0).getString("ai", null);
  }
  
  public static boolean a()
  {
    boolean bool1 = u.a(AdBuddiz.getContext());
    SharedPreferences localSharedPreferences = AdBuddiz.getContext().getSharedPreferences("ABZ-prefs", 0);
    if (localSharedPreferences.contains("tm"))
    {
      boolean bool2 = localSharedPreferences.getBoolean("tm", false);
      boolean bool3 = false;
      if (bool2 != bool1)
      {
        SharedPreferences.Editor localEditor2 = localSharedPreferences.edit();
        localEditor2.putBoolean("tm", bool1);
        localEditor2.commit();
        bool3 = true;
      }
      return bool3;
    }
    SharedPreferences.Editor localEditor1 = localSharedPreferences.edit();
    localEditor1.putBoolean("tm", bool1);
    localEditor1.commit();
    return false;
  }
  
  public static boolean b()
  {
    String str = q.b(AdBuddiz.getContext());
    SharedPreferences localSharedPreferences = AdBuddiz.getContext().getSharedPreferences("ABZ-prefs", 0);
    if (localSharedPreferences.contains("LAST_PUBLISHER_KEY"))
    {
      boolean bool1 = str.equals(localSharedPreferences.getString("LAST_PUBLISHER_KEY", null));
      boolean bool2 = false;
      if (!bool1)
      {
        SharedPreferences.Editor localEditor2 = localSharedPreferences.edit();
        localEditor2.putString("LAST_PUBLISHER_KEY", str);
        localEditor2.commit();
        bool2 = true;
      }
      return bool2;
    }
    SharedPreferences.Editor localEditor1 = localSharedPreferences.edit();
    localEditor1.putString("LAST_PUBLISHER_KEY", str);
    localEditor1.commit();
    return false;
  }
  
  public static void c()
  {
    SharedPreferences.Editor localEditor = AdBuddiz.getContext().getSharedPreferences("ABZ-prefs", 0).edit();
    localEditor.clear();
    localEditor.putString("LAST_PUBLISHER_KEY", q.b(AdBuddiz.getContext()));
    localEditor.putBoolean("tm", u.a(AdBuddiz.getContext()));
    localEditor.commit();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */