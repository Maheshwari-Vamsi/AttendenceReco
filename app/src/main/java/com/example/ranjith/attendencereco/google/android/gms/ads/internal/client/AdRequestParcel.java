package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzha;
import java.util.List;

@zzha
public final class AdRequestParcel
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  public final Bundle extras;
  public final int versionCode;
  public final Bundle zztA;
  public final Bundle zztB;
  public final List<String> zztC;
  public final String zztD;
  public final String zztE;
  public final boolean zztF;
  public final long zztq;
  public final int zztr;
  public final List<String> zzts;
  public final boolean zztt;
  public final int zztu;
  public final boolean zztv;
  public final String zztw;
  public final SearchAdRequestParcel zztx;
  public final Location zzty;
  public final String zztz;
  
  public AdRequestParcel(int paramInt1, long paramLong, Bundle paramBundle1, int paramInt2, List<String> paramList1, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, SearchAdRequestParcel paramSearchAdRequestParcel, Location paramLocation, String paramString2, Bundle paramBundle2, Bundle paramBundle3, List<String> paramList2, String paramString3, String paramString4, boolean paramBoolean3)
  {
    this.versionCode = paramInt1;
    this.zztq = paramLong;
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    this.extras = paramBundle1;
    this.zztr = paramInt2;
    this.zzts = paramList1;
    this.zztt = paramBoolean1;
    this.zztu = paramInt3;
    this.zztv = paramBoolean2;
    this.zztw = paramString1;
    this.zztx = paramSearchAdRequestParcel;
    this.zzty = paramLocation;
    this.zztz = paramString2;
    this.zztA = paramBundle2;
    this.zztB = paramBundle3;
    this.zztC = paramList2;
    this.zztD = paramString3;
    this.zztE = paramString4;
    this.zztF = paramBoolean3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof AdRequestParcel)) {}
    AdRequestParcel localAdRequestParcel;
    do
    {
      return false;
      localAdRequestParcel = (AdRequestParcel)paramObject;
    } while ((this.versionCode != localAdRequestParcel.versionCode) || (this.zztq != localAdRequestParcel.zztq) || (!zzw.equal(this.extras, localAdRequestParcel.extras)) || (this.zztr != localAdRequestParcel.zztr) || (!zzw.equal(this.zzts, localAdRequestParcel.zzts)) || (this.zztt != localAdRequestParcel.zztt) || (this.zztu != localAdRequestParcel.zztu) || (this.zztv != localAdRequestParcel.zztv) || (!zzw.equal(this.zztw, localAdRequestParcel.zztw)) || (!zzw.equal(this.zztx, localAdRequestParcel.zztx)) || (!zzw.equal(this.zzty, localAdRequestParcel.zzty)) || (!zzw.equal(this.zztz, localAdRequestParcel.zztz)) || (!zzw.equal(this.zztA, localAdRequestParcel.zztA)) || (!zzw.equal(this.zztB, localAdRequestParcel.zztB)) || (!zzw.equal(this.zztC, localAdRequestParcel.zztC)) || (!zzw.equal(this.zztD, localAdRequestParcel.zztD)) || (!zzw.equal(this.zztE, localAdRequestParcel.zztE)) || (this.zztF != localAdRequestParcel.zztF));
    return true;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[18];
    arrayOfObject[0] = Integer.valueOf(this.versionCode);
    arrayOfObject[1] = Long.valueOf(this.zztq);
    arrayOfObject[2] = this.extras;
    arrayOfObject[3] = Integer.valueOf(this.zztr);
    arrayOfObject[4] = this.zzts;
    arrayOfObject[5] = Boolean.valueOf(this.zztt);
    arrayOfObject[6] = Integer.valueOf(this.zztu);
    arrayOfObject[7] = Boolean.valueOf(this.zztv);
    arrayOfObject[8] = this.zztw;
    arrayOfObject[9] = this.zztx;
    arrayOfObject[10] = this.zzty;
    arrayOfObject[11] = this.zztz;
    arrayOfObject[12] = this.zztA;
    arrayOfObject[13] = this.zztB;
    arrayOfObject[14] = this.zztC;
    arrayOfObject[15] = this.zztD;
    arrayOfObject[16] = this.zztE;
    arrayOfObject[17] = Boolean.valueOf(this.zztF);
    return zzw.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\AdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */