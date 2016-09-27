package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.Map;

@zzha
public abstract class zzce
{
  @zzha
  public static final zzce zzwU = new zzce()
  {
    public String zzc(String paramAnonymousString1, String paramAnonymousString2)
    {
      return paramAnonymousString2;
    }
  };
  @zzha
  public static final zzce zzwV = new zzce()
  {
    public String zzc(String paramAnonymousString1, String paramAnonymousString2)
    {
      if (paramAnonymousString1 != null) {
        return paramAnonymousString1;
      }
      return paramAnonymousString2;
    }
  };
  @zzha
  public static final zzce zzwW = new zzce()
  {
    private String zzQ(String paramAnonymousString)
    {
      if (TextUtils.isEmpty(paramAnonymousString)) {}
      int i;
      int j;
      do
      {
        return paramAnonymousString;
        i = 0;
        j = paramAnonymousString.length();
        while ((i < paramAnonymousString.length()) && (paramAnonymousString.charAt(i) == ',')) {
          i++;
        }
        while ((j > 0) && (paramAnonymousString.charAt(j - 1) == ',')) {
          j--;
        }
      } while ((i == 0) && (j == paramAnonymousString.length()));
      return paramAnonymousString.substring(i, j);
    }
    
    public String zzc(String paramAnonymousString1, String paramAnonymousString2)
    {
      String str1 = zzQ(paramAnonymousString1);
      String str2 = zzQ(paramAnonymousString2);
      if (TextUtils.isEmpty(str1)) {
        return str2;
      }
      if (TextUtils.isEmpty(str2)) {
        return str1;
      }
      return str1 + "," + str2;
    }
  };
  
  public final void zza(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    paramMap.put(paramString1, zzc((String)paramMap.get(paramString1), paramString2));
  }
  
  public abstract String zzc(String paramString1, String paramString2);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */