package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zztp.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final int versionCode;
  public final zztp.zzd zzadA;
  public final zza.zzb zzadB;
  public final zza.zzb zzadC;
  public PlayLoggerContext zzadx;
  public byte[] zzady;
  public int[] zzadz;
  
  LogEventParcelable(int paramInt, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.versionCode = paramInt;
    this.zzadx = paramPlayLoggerContext;
    this.zzady = paramArrayOfByte;
    this.zzadz = paramArrayOfInt;
    this.zzadA = null;
    this.zzadB = null;
    this.zzadC = null;
  }
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, zztp.zzd paramzzd, zza.zzb paramzzb1, zza.zzb paramzzb2, int[] paramArrayOfInt)
  {
    this.versionCode = 1;
    this.zzadx = paramPlayLoggerContext;
    this.zzadA = paramzzd;
    this.zzadB = paramzzb1;
    this.zzadC = paramzzb2;
    this.zzadz = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    LogEventParcelable localLogEventParcelable;
    do
    {
      return true;
      if (!(paramObject instanceof LogEventParcelable)) {
        break;
      }
      localLogEventParcelable = (LogEventParcelable)paramObject;
    } while ((this.versionCode == localLogEventParcelable.versionCode) && (zzw.equal(this.zzadx, localLogEventParcelable.zzadx)) && (Arrays.equals(this.zzady, localLogEventParcelable.zzady)) && (Arrays.equals(this.zzadz, localLogEventParcelable.zzadz)) && (zzw.equal(this.zzadA, localLogEventParcelable.zzadA)) && (zzw.equal(this.zzadB, localLogEventParcelable.zzadB)) && (zzw.equal(this.zzadC, localLogEventParcelable.zzadC)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = Integer.valueOf(this.versionCode);
    arrayOfObject[1] = this.zzadx;
    arrayOfObject[2] = this.zzady;
    arrayOfObject[3] = this.zzadz;
    arrayOfObject[4] = this.zzadA;
    arrayOfObject[5] = this.zzadB;
    arrayOfObject[6] = this.zzadC;
    return zzw.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.zzadx);
    localStringBuilder.append(", ");
    String str1;
    if (this.zzady == null)
    {
      str1 = null;
      localStringBuilder.append(str1);
      localStringBuilder.append(", ");
      if (this.zzadz != null) {
        break label162;
      }
    }
    label162:
    zzv localzzv;
    int[][] arrayOfInt;
    for (String str2 = (String)null;; str2 = localzzv.zza(Arrays.asList(arrayOfInt)))
    {
      localStringBuilder.append(str2);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzadA);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzadB);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzadC);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str1 = new String(this.zzady);
      break;
      localzzv = zzv.zzcF(", ");
      arrayOfInt = new int[1][];
      arrayOfInt[0] = this.zzadz;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\clearcut\LogEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */