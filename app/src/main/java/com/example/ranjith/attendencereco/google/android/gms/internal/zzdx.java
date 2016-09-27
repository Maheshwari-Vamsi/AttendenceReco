package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzdx
  implements zzdl
{
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    zzdv localzzdv = zzp.zzbL();
    if (paramMap.containsKey("abort"))
    {
      if (!localzzdv.zza(paramzzjn)) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache abort but no preload task running.");
      }
      return;
    }
    String str1 = (String)paramMap.get("src");
    if (str1 == null)
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache video action is missing the src parameter.");
      return;
    }
    try
    {
      int j = Integer.parseInt((String)paramMap.get("player"));
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      String str2;
      for (;;)
      {
        i = 0;
        continue;
        str2 = "";
      }
      com.google.android.gms.common.internal.zzb.zzu(paramzzjn.zzhz());
      new zzdu(paramzzjn, paramzzjn.zzhz().zzpm.zza(paramzzjn, i, str2), str1).zzgX();
    }
    if (paramMap.containsKey("mimetype"))
    {
      str2 = (String)paramMap.get("mimetype");
      if (!localzzdv.zzb(paramzzjn)) {
        break label126;
      }
      com.google.android.gms.ads.internal.util.client.zzb.zzaH("Precache task already running.");
    }
    label126:
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */