package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;

@zzha
public class zzk
{
  private final String zzux;
  
  public zzk(String paramString)
  {
    this.zzux = paramString;
  }
  
  public boolean zza(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = zzp.zzbH().zze(paramIntent);
      str2 = zzp.zzbH().zzf(paramIntent);
    } while ((str1 == null) || (str2 == null));
    if (!paramString.equals(zzp.zzbH().zzap(str1)))
    {
      zzb.zzaH("Developer payload not match.");
      return false;
    }
    if ((this.zzux != null) && (!zzl.zzc(this.zzux, str1, str2)))
    {
      zzb.zzaH("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String zzfN()
  {
    return zzp.zzbx().zzha();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\purchase\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */