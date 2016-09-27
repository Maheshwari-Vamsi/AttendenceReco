package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;

@zzha
public class zzdo
  implements zzdl
{
  private final zzdp zzyZ;
  
  public zzdo(zzdp paramzzdp)
  {
    this.zzyZ = paramzzdp;
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    boolean bool1 = "1".equals(paramMap.get("transparentBackground"));
    boolean bool2 = "1".equals(paramMap.get("blur"));
    try
    {
      if (paramMap.get("blurRadius") == null) {
        break label93;
      }
      float f2 = Float.parseFloat((String)paramMap.get("blurRadius"));
      f1 = f2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        zzb.zzb("Fail to parse float", localNumberFormatException);
        float f1 = 0.0F;
      }
    }
    this.zzyZ.zzd(bool1);
    this.zzyZ.zza(bool2, f1);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */