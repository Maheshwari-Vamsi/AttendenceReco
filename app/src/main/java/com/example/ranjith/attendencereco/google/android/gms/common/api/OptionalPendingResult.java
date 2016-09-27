package com.google.android.gms.common.api;

public abstract class OptionalPendingResult<R extends Result>
  extends PendingResult<R>
{
  public abstract R get();
  
  public abstract boolean isDone();
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\OptionalPendingResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */