package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result>
{
  public abstract R await();
  
  public abstract R await(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract void cancel();
  
  public abstract boolean isCanceled();
  
  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback);
  
  public abstract void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit);
  
  public void zza(zza paramzza)
  {
    throw new UnsupportedOperationException();
  }
  
  public Integer zzoL()
  {
    throw new UnsupportedOperationException();
  }
  
  public static abstract interface zza
  {
    public abstract void zzu(Status paramStatus);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\PendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */