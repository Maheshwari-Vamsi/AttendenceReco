package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.TimeUnit;

public final class BatchResult
  implements Result
{
  private final Status zzTA;
  private final PendingResult<?>[] zzaev;
  
  BatchResult(Status paramStatus, PendingResult<?>[] paramArrayOfPendingResult)
  {
    this.zzTA = paramStatus;
    this.zzaev = paramArrayOfPendingResult;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public <R extends Result> R take(BatchResultToken<R> paramBatchResultToken)
  {
    if (paramBatchResultToken.mId < this.zzaev.length) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "The result token does not belong to this batch");
      return this.zzaev[paramBatchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\BatchResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */