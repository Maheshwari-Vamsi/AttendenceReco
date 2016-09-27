package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final String packageName;
  public final int versionCode;
  public final String zzaYA;
  public final String zzaYB;
  public final boolean zzaYC;
  public final String zzaYD;
  public final boolean zzaYE;
  public final int zzaYF;
  public final int zzaYy;
  public final int zzaYz;
  
  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    this.versionCode = paramInt1;
    this.packageName = paramString1;
    this.zzaYy = paramInt2;
    this.zzaYz = paramInt3;
    this.zzaYA = paramString2;
    this.zzaYB = paramString3;
    this.zzaYC = paramBoolean1;
    this.zzaYD = paramString4;
    this.zzaYE = paramBoolean2;
    this.zzaYF = paramInt4;
  }
  
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.versionCode = 1;
    this.packageName = ((String)zzx.zzy(paramString1));
    this.zzaYy = paramInt1;
    this.zzaYz = paramInt2;
    this.zzaYD = paramString2;
    this.zzaYA = paramString3;
    this.zzaYB = paramString4;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaYC = bool;
      this.zzaYE = paramBoolean;
      this.zzaYF = paramInt3;
      return;
    }
  }
  
  @Deprecated
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = 1;
    this.packageName = ((String)zzx.zzy(paramString1));
    this.zzaYy = paramInt1;
    this.zzaYz = paramInt2;
    this.zzaYD = null;
    this.zzaYA = paramString2;
    this.zzaYB = paramString3;
    this.zzaYC = paramBoolean;
    this.zzaYE = false;
    this.zzaYF = 0;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    PlayLoggerContext localPlayLoggerContext;
    do
    {
      return true;
      if (!(paramObject instanceof PlayLoggerContext)) {
        break;
      }
      localPlayLoggerContext = (PlayLoggerContext)paramObject;
    } while ((this.versionCode == localPlayLoggerContext.versionCode) && (this.packageName.equals(localPlayLoggerContext.packageName)) && (this.zzaYy == localPlayLoggerContext.zzaYy) && (this.zzaYz == localPlayLoggerContext.zzaYz) && (zzw.equal(this.zzaYD, localPlayLoggerContext.zzaYD)) && (zzw.equal(this.zzaYA, localPlayLoggerContext.zzaYA)) && (zzw.equal(this.zzaYB, localPlayLoggerContext.zzaYB)) && (this.zzaYC == localPlayLoggerContext.zzaYC) && (this.zzaYE == localPlayLoggerContext.zzaYE) && (this.zzaYF == localPlayLoggerContext.zzaYF));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = Integer.valueOf(this.versionCode);
    arrayOfObject[1] = this.packageName;
    arrayOfObject[2] = Integer.valueOf(this.zzaYy);
    arrayOfObject[3] = Integer.valueOf(this.zzaYz);
    arrayOfObject[4] = this.zzaYD;
    arrayOfObject[5] = this.zzaYA;
    arrayOfObject[6] = this.zzaYB;
    arrayOfObject[7] = Boolean.valueOf(this.zzaYC);
    arrayOfObject[8] = Boolean.valueOf(this.zzaYE);
    arrayOfObject[9] = Integer.valueOf(this.zzaYF);
    return zzw.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(this.versionCode).append(',');
    localStringBuilder.append("package=").append(this.packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(this.zzaYy).append(',');
    localStringBuilder.append("logSource=").append(this.zzaYz).append(',');
    localStringBuilder.append("logSourceName=").append(this.zzaYD).append(',');
    localStringBuilder.append("uploadAccount=").append(this.zzaYA).append(',');
    localStringBuilder.append("loggingId=").append(this.zzaYB).append(',');
    localStringBuilder.append("logAndroidId=").append(this.zzaYC).append(',');
    localStringBuilder.append("isAnonymous=").append(this.zzaYE).append(',');
    localStringBuilder.append("qosTier=").append(this.zzaYF);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\playlog\internal\PlayLoggerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */