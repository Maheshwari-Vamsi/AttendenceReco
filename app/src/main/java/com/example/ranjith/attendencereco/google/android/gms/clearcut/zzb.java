package com.google.android.gms.clearcut;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract interface zzb
{
  public abstract PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, LogEventParcelable paramLogEventParcelable);
  
  public abstract boolean zza(GoogleApiClient paramGoogleApiClient, long paramLong, TimeUnit paramTimeUnit);
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\clearcut\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */