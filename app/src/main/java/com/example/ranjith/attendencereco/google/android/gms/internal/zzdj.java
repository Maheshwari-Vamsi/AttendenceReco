package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public final class zzdj
  implements zzdl
{
  private void zzb(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("label");
    String str2 = (String)paramMap.get("start_label");
    String str3 = (String)paramMap.get("timestamp");
    if (TextUtils.isEmpty(str1))
    {
      zzb.zzaH("No label given for CSI tick.");
      return;
    }
    if (TextUtils.isEmpty(str3))
    {
      zzb.zzaH("No timestamp given for CSI tick.");
      return;
    }
    try
    {
      long l = zzc(Long.parseLong(str3));
      if (TextUtils.isEmpty(str2)) {
        str2 = "native:view_load";
      }
      paramzzjn.zzhL().zza(str1, str2, l);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzb.zzd("Malformed timestamp for CSI tick.", localNumberFormatException);
    }
  }
  
  private long zzc(long paramLong)
  {
    long l = zzp.zzbB().currentTimeMillis();
    return zzp.zzbB().elapsedRealtime() + (paramLong - l);
  }
  
  private void zzc(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("value");
    if (TextUtils.isEmpty(str))
    {
      zzb.zzaH("No value given for CSI experiment.");
      return;
    }
    zzch localzzch = paramzzjn.zzhL().zzdt();
    if (localzzch == null)
    {
      zzb.zzaH("No ticker for WebView, dropping experiment ID.");
      return;
    }
    localzzch.zzd("e", str);
  }
  
  private void zzd(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("name");
    String str2 = (String)paramMap.get("value");
    if (TextUtils.isEmpty(str2))
    {
      zzb.zzaH("No value given for CSI extra.");
      return;
    }
    if (TextUtils.isEmpty(str1))
    {
      zzb.zzaH("No name given for CSI extra.");
      return;
    }
    zzch localzzch = paramzzjn.zzhL().zzdt();
    if (localzzch == null)
    {
      zzb.zzaH("No ticker for WebView, dropping extra parameter.");
      return;
    }
    localzzch.zzd(str1, str2);
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("action");
    if ("tick".equals(str)) {
      zzb(paramzzjn, paramMap);
    }
    do
    {
      return;
      if ("experiment".equals(str))
      {
        zzc(paramzzjn, paramMap);
        return;
      }
    } while (!"extra".equals(str));
    zzd(paramzzjn, paramMap);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */