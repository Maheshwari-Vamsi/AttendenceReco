package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class Status
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new zzd();
  public static final Status zzaeX = new Status(0);
  public static final Status zzaeY = new Status(14);
  public static final Status zzaeZ = new Status(8);
  public static final Status zzafa = new Status(15);
  public static final Status zzafb = new Status(16);
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final int zzabx;
  private final String zzadS;
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.mVersionCode = paramInt1;
    this.zzabx = paramInt2;
    this.zzadS = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String zzoO()
  {
    if (this.zzadS != null) {
      return this.zzadS;
    }
    return CommonStatusCodes.getStatusCodeString(this.zzabx);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    Status localStatus;
    do
    {
      return false;
      localStatus = (Status)paramObject;
    } while ((this.mVersionCode != localStatus.mVersionCode) || (this.zzabx != localStatus.zzabx) || (!zzw.equal(this.zzadS, localStatus.zzadS)) || (!zzw.equal(this.mPendingIntent, localStatus.mPendingIntent)));
    return true;
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.zzabx;
  }
  
  public String getStatusMessage()
  {
    return this.zzadS;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.mVersionCode);
    arrayOfObject[1] = Integer.valueOf(this.zzabx);
    arrayOfObject[2] = this.zzadS;
    arrayOfObject[3] = this.mPendingIntent;
    return zzw.hashCode(arrayOfObject);
  }
  
  public boolean isCanceled()
  {
    return this.zzabx == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.zzabx == 14;
  }
  
  public boolean isSuccess()
  {
    return this.zzabx <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("statusCode", zzoO()).zzg("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  PendingIntent zzoN()
  {
    return this.mPendingIntent;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\api\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */