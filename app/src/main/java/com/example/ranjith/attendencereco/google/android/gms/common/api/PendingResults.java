package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzmo;
import com.google.android.gms.internal.zzmq;

public final class PendingResults
{
  public static PendingResult<Status> canceledPendingResult()
  {
    zzmq localzzmq = new zzmq(Looper.getMainLooper());
    localzzmq.cancel();
    return localzzmq;
  }
  
  public static <R extends Result> PendingResult<R> canceledPendingResult(R paramR)
  {
    zzx.zzb(paramR, "Result must not be null");
    if (paramR.getStatus().getStatusCode() == 16) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Status code must be CommonStatusCodes.CANCELED");
      zza localzza = new zza(paramR);
      localzza.cancel();
      return localzza;
    }
  }
  
  public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R paramR)
  {
    zzx.zzb(paramR, "Result must not be null");
    zzc localzzc = new zzc(null);
    localzzc.zzb(paramR);
    return new zzmo(localzzc);
  }
  
  public static PendingResult<Status> immediatePendingResult(Status paramStatus)
  {
    zzx.zzb(paramStatus, "Result must not be null");
    zzmq localzzmq = new zzmq(Looper.getMainLooper());
    localzzmq.zzb(paramStatus);
    return localzzmq;
  }
  
  public static <R extends Result> PendingResult<R> zza(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(paramR, "Result must not be null");
    if (!paramR.getStatus().isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Status code must not be SUCCESS");
      zzb localzzb = new zzb(paramGoogleApiClient, paramR);
      localzzb.zzb(paramR);
      return localzzb;
    }
  }
  
  public static PendingResult<Status> zza(Status paramStatus, GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(paramStatus, "Result must not be null");
    zzmq localzzmq = new zzmq(paramGoogleApiClient);
    localzzmq.zzb(paramStatus);
    return localzzmq;
  }
  
  public static <R extends Result> OptionalPendingResult<R> zzb(R paramR, GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(paramR, "Result must not be null");
    zzc localzzc = new zzc(paramGoogleApiClient);
    localzzc.zzb(paramR);
    return new zzmo(localzzc);
  }
  
  private static final class zza<R extends Result>
    extends zzly<R>
  {
    private final R zzaeS;
    
    public zza(R paramR)
    {
      super();
      this.zzaeS = paramR;
    }
    
    protected R zzc(Status paramStatus)
    {
      if (paramStatus.getStatusCode() != this.zzaeS.getStatus().getStatusCode()) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
      }
      return this.zzaeS;
    }
  }
  
  private static final class zzb<R extends Result>
    extends zzly<R>
  {
    private final R zzaeT;
    
    public zzb(GoogleApiClient paramGoogleApiClient, R paramR)
    {
      super();
      this.zzaeT = paramR;
    }
    
    protected R zzc(Status paramStatus)
    {
      return this.zzaeT;
    }
  }
  
  private static final class zzc<R extends Result>
    extends zzly<R>
  {
    public zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected R zzc(Status paramStatus)
    {
      throw new UnsupportedOperationException("Creating failed results is not supported");
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\PendingResults.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */