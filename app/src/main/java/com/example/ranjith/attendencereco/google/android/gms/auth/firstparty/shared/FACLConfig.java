package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class FACLConfig
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int version;
  boolean zzWH;
  String zzWI;
  boolean zzWJ;
  boolean zzWK;
  boolean zzWL;
  boolean zzWM;
  
  FACLConfig(int paramInt, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    this.version = paramInt;
    this.zzWH = paramBoolean1;
    this.zzWI = paramString;
    this.zzWJ = paramBoolean2;
    this.zzWK = paramBoolean3;
    this.zzWL = paramBoolean4;
    this.zzWM = paramBoolean5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FACLConfig;
    boolean bool2 = false;
    if (bool1)
    {
      FACLConfig localFACLConfig = (FACLConfig)paramObject;
      boolean bool3 = this.zzWH;
      boolean bool4 = localFACLConfig.zzWH;
      bool2 = false;
      if (bool3 == bool4)
      {
        boolean bool5 = TextUtils.equals(this.zzWI, localFACLConfig.zzWI);
        bool2 = false;
        if (bool5)
        {
          boolean bool6 = this.zzWJ;
          boolean bool7 = localFACLConfig.zzWJ;
          bool2 = false;
          if (bool6 == bool7)
          {
            boolean bool8 = this.zzWK;
            boolean bool9 = localFACLConfig.zzWK;
            bool2 = false;
            if (bool8 == bool9)
            {
              boolean bool10 = this.zzWL;
              boolean bool11 = localFACLConfig.zzWL;
              bool2 = false;
              if (bool10 == bool11)
              {
                boolean bool12 = this.zzWM;
                boolean bool13 = localFACLConfig.zzWM;
                bool2 = false;
                if (bool12 == bool13) {
                  bool2 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Boolean.valueOf(this.zzWH);
    arrayOfObject[1] = this.zzWI;
    arrayOfObject[2] = Boolean.valueOf(this.zzWJ);
    arrayOfObject[3] = Boolean.valueOf(this.zzWK);
    arrayOfObject[4] = Boolean.valueOf(this.zzWL);
    arrayOfObject[5] = Boolean.valueOf(this.zzWM);
    return zzw.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\firstparty\shared\FACLConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */