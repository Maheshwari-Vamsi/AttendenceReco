package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzha
public final class zzdg
  implements zzdl
{
  private final zzdh zzyy;
  
  public zzdg(zzdh paramzzdh)
  {
    this.zzyy = paramzzdh;
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    if (str == null)
    {
      zzb.zzaH("App event with no name parameter.");
      return;
    }
    this.zzyy.onAppEvent(str, (String)paramMap.get("info"));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */