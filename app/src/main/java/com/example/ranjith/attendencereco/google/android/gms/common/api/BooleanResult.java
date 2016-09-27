package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult
  implements Result
{
  private final Status zzTA;
  private final boolean zzaey;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.zzTA = ((Status)zzx.zzb(paramStatus, "Status must not be null"));
    this.zzaey = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    BooleanResult localBooleanResult;
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      localBooleanResult = (BooleanResult)paramObject;
    } while ((this.zzTA.equals(localBooleanResult.zzTA)) && (this.zzaey == localBooleanResult.zzaey));
    return false;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public boolean getValue()
  {
    return this.zzaey;
  }
  
  public final int hashCode()
  {
    int i = 31 * (527 + this.zzTA.hashCode());
    if (this.zzaey) {}
    for (int j = 1;; j = 0) {
      return j + i;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\BooleanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */