package com.purplebrain.adbuddiz.sdk.h.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.purplebrain.adbuddiz.sdk.i.a.e;
import com.purplebrain.adbuddiz.sdk.i.a.i;
import com.purplebrain.adbuddiz.sdk.i.a.l;
import com.purplebrain.adbuddiz.sdk.i.g;
import com.purplebrain.adbuddiz.sdk.i.n;
import java.util.Locale;
import org.json.JSONObject;

public final class b
{
  String a;
  String b;
  boolean c;
  String d;
  String e;
  String f;
  String g;
  int h;
  String i;
  int j;
  int k;
  int l;
  float m;
  Integer n;
  Integer o;
  String p;
  String q;
  String r;
  String s;
  String t;
  String u;
  String v;
  String w;
  
  public final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    if (this.a != null) {
      localJSONObject.put("a", this.a);
    }
    localJSONObject.put("ai", this.b);
    localJSONObject.put("lat", this.c);
    localJSONObject.put("s", this.h);
    localJSONObject.put("v", this.i);
    if (this.d != null)
    {
      localJSONObject.put("im", this.d);
      localJSONObject.put("is", this.e);
    }
    if (this.f != null)
    {
      localJSONObject.put("mm", this.f);
      localJSONObject.put("ms", this.g);
    }
    localJSONObject.put("sw", this.j);
    localJSONObject.put("sh", this.k);
    localJSONObject.put("sd", this.l);
    localJSONObject.put("sdf", this.m);
    localJSONObject.put("nt", this.n);
    localJSONObject.put("nst", this.o);
    localJSONObject.put("no", this.p);
    localJSONObject.put("non", this.q);
    localJSONObject.put("c", this.r);
    localJSONObject.put("l", this.s);
    localJSONObject.put("ma", this.t);
    localJSONObject.put("mo", this.u);
    localJSONObject.put("p", this.v);
    localJSONObject.put("cp", this.w);
    return localJSONObject;
  }
  
  public static final class a
  {
    public static b a(Context paramContext)
    {
      b localb = new b();
      String str1 = e.a(paramContext);
      if (str1 != null) {
        localb.a = g.a(str1);
      }
      String str2 = com.purplebrain.adbuddiz.sdk.i.b.b.a(paramContext);
      if (str2 != null) {
        localb.b = g.a(str2);
      }
      localb.c = paramContext.getSharedPreferences("ABZ-prefs", 0).getBoolean("lat", false);
      localb.h = com.purplebrain.adbuddiz.sdk.i.a.b.b();
      localb.i = Build.VERSION.RELEASE;
      String str8;
      String str9;
      String str6;
      String str7;
      label148:
      TelephonyManager localTelephonyManager;
      String str3;
      if (e.d(paramContext) != null)
      {
        localb.d = g.a(e.d(paramContext));
        str8 = e.e(paramContext);
        if (str8 == null)
        {
          str9 = null;
          localb.e = g.a(str9);
        }
      }
      else
      {
        if (e.b(paramContext) != null)
        {
          localb.f = g.a(e.b(paramContext));
          str6 = e.c(paramContext);
          str7 = null;
          if (str6 != null) {
            break label457;
          }
          localb.g = g.a(str7);
        }
        localb.j = l.a(paramContext).widthPixels;
        localb.k = l.a(paramContext).heightPixels;
        DisplayMetrics localDisplayMetrics = l.a(paramContext);
        localb.l = ((int)Math.max(localDisplayMetrics.xdpi, localDisplayMetrics.ydpi));
        localb.m = l.a(paramContext).density;
        localb.n = i.b(paramContext);
        localb.o = i.c(paramContext);
        localb.p = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
        localb.q = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperatorName();
        localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
        str3 = localTelephonyManager.getSimCountryIso();
        if (((str3 != null) && (str3.length() != 0)) || (localTelephonyManager.getPhoneType() == 2)) {
          break label469;
        }
      }
      label457:
      label469:
      for (String str4 = localTelephonyManager.getNetworkCountryIso();; str4 = str3)
      {
        if ((str4 == null) || (str4.length() == 0)) {
          str4 = paramContext.getResources().getConfiguration().locale.getCountry();
        }
        if (str4 != null) {
          str4 = str4.toUpperCase(Locale.US);
        }
        if ((str4 != null) && (str4.length() > 2)) {
          str4 = str4.substring(0, 2);
        }
        localb.r = str4;
        String str5 = paramContext.getResources().getConfiguration().locale.getLanguage();
        if (str5 == null) {
          str5 = Locale.getDefault().getLanguage();
        }
        localb.s = str5;
        localb.t = Build.MANUFACTURER;
        localb.u = Build.MODEL;
        localb.v = Build.PRODUCT;
        localb.w = Build.CPU_ABI;
        return localb;
        str9 = n.a("SHA-1", str8);
        break;
        str7 = n.a("SHA-1", str6);
        break label148;
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */