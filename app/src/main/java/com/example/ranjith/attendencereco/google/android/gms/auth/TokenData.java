package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int mVersionCode;
  private final String zzTR;
  private final Long zzTS;
  private final boolean zzTT;
  private final boolean zzTU;
  private final List<String> zzTV;
  
  TokenData(int paramInt, String paramString, Long paramLong, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzTR = zzx.zzcG(paramString);
    this.zzTS = paramLong;
    this.zzTT = paramBoolean1;
    this.zzTU = paramBoolean2;
    this.zzTV = paramList;
  }
  
  public static TokenData zza(Bundle paramBundle, String paramString)
  {
    paramBundle.setClassLoader(TokenData.class.getClassLoader());
    Bundle localBundle = paramBundle.getBundle(paramString);
    if (localBundle == null) {
      return null;
    }
    localBundle.setClassLoader(TokenData.class.getClassLoader());
    return (TokenData)localBundle.getParcelable("TokenData");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TokenData)) {}
    TokenData localTokenData;
    do
    {
      return false;
      localTokenData = (TokenData)paramObject;
    } while ((!TextUtils.equals(this.zzTR, localTokenData.zzTR)) || (!zzw.equal(this.zzTS, localTokenData.zzTS)) || (this.zzTT != localTokenData.zzTT) || (this.zzTU != localTokenData.zzTU) || (!zzw.equal(this.zzTV, localTokenData.zzTV)));
    return true;
  }
  
  public String getToken()
  {
    return this.zzTR;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.zzTR;
    arrayOfObject[1] = this.zzTS;
    arrayOfObject[2] = Boolean.valueOf(this.zzTT);
    arrayOfObject[3] = Boolean.valueOf(this.zzTU);
    arrayOfObject[4] = this.zzTV;
    return zzw.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Long zzlW()
  {
    return this.zzTS;
  }
  
  public boolean zzlX()
  {
    return this.zzTT;
  }
  
  public boolean zzlY()
  {
    return this.zzTU;
  }
  
  public List<String> zzlZ()
  {
    return this.zzTV;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\TokenData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */