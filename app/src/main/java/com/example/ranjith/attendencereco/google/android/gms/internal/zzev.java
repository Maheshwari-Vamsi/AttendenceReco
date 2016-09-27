package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

@zzha
public final class zzev
  extends zzew.zza
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> zzBG;
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> zzex zzah(String paramString)
    throws RemoteException
  {
    try
    {
      Class localClass = Class.forName(paramString, false, zzev.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom(localClass))
      {
        com.google.ads.mediation.MediationAdapter localMediationAdapter = (com.google.ads.mediation.MediationAdapter)localClass.newInstance();
        return new zzfi(localMediationAdapter, (com.google.ads.mediation.NetworkExtras)this.zzBG.get(localMediationAdapter.getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(localClass)) {
        return new zzfd((com.google.android.gms.ads.mediation.MediationAdapter)localClass.newInstance());
      }
      zzb.zzaH("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
  }
  
  public zzex zzaf(String paramString)
    throws RemoteException
  {
    return zzah(paramString);
  }
  
  public boolean zzag(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, zzev.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      zzb.zzaH("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
  
  public void zze(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    this.zzBG = paramMap;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */