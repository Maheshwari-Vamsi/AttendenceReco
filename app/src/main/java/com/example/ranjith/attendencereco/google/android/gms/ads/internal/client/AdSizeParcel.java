package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzha;

@zzha
public class AdSizeParcel
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  public final int height;
  public final int heightPixels;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  public final String zztV;
  public final boolean zztW;
  public final AdSizeParcel[] zztX;
  public final boolean zztY;
  public final boolean zztZ;
  public boolean zzua;
  
  public AdSizeParcel()
  {
    this(5, "interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
  }
  
  AdSizeParcel(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean1, int paramInt4, int paramInt5, AdSizeParcel[] paramArrayOfAdSizeParcel, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.versionCode = paramInt1;
    this.zztV = paramString;
    this.height = paramInt2;
    this.heightPixels = paramInt3;
    this.zztW = paramBoolean1;
    this.width = paramInt4;
    this.widthPixels = paramInt5;
    this.zztX = paramArrayOfAdSizeParcel;
    this.zztY = paramBoolean2;
    this.zztZ = paramBoolean3;
    this.zzua = paramBoolean4;
  }
  
  public AdSizeParcel(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public AdSizeParcel(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    this.versionCode = 5;
    this.zztW = false;
    this.zztZ = localAdSize.isFluid();
    int i;
    label64:
    int j;
    label76:
    DisplayMetrics localDisplayMetrics;
    label127:
    int m;
    label167:
    int n;
    if (this.zztZ)
    {
      this.width = AdSize.BANNER.getWidth();
      this.height = AdSize.BANNER.getHeight();
      if (this.width != -1) {
        break label306;
      }
      i = 1;
      if (this.height != -2) {
        break label312;
      }
      j = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (i == 0) {
        break label330;
      }
      if ((!zzl.zzcN().zzU(paramContext)) || (!zzl.zzcN().zzV(paramContext))) {
        break label318;
      }
      this.widthPixels = (zza(localDisplayMetrics) - zzl.zzcN().zzW(paramContext));
      double d = this.widthPixels / localDisplayMetrics.density;
      int i2 = (int)d;
      if (d - (int)d >= 0.01D) {
        i2++;
      }
      m = i2;
      if (j == 0) {
        break label359;
      }
      n = zzc(localDisplayMetrics);
      label179:
      this.heightPixels = zzl.zzcN().zza(localDisplayMetrics, n);
      if ((i == 0) && (j == 0)) {
        break label368;
      }
      this.zztV = (m + "x" + n + "_as");
    }
    for (;;)
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label395;
      }
      this.zztX = new AdSizeParcel[paramArrayOfAdSize.length];
      for (int i1 = 0; i1 < paramArrayOfAdSize.length; i1++) {
        this.zztX[i1] = new AdSizeParcel(paramContext, paramArrayOfAdSize[i1]);
      }
      this.width = localAdSize.getWidth();
      this.height = localAdSize.getHeight();
      break;
      label306:
      i = 0;
      break label64;
      label312:
      j = 0;
      break label76;
      label318:
      this.widthPixels = zza(localDisplayMetrics);
      break label127;
      label330:
      int k = this.width;
      this.widthPixels = zzl.zzcN().zza(localDisplayMetrics, this.width);
      m = k;
      break label167;
      label359:
      n = this.height;
      break label179;
      label368:
      if (this.zztZ) {
        this.zztV = "320x50_mb";
      } else {
        this.zztV = localAdSize.toString();
      }
    }
    label395:
    this.zztX = null;
    this.zztY = false;
    this.zzua = false;
  }
  
  public AdSizeParcel(AdSizeParcel paramAdSizeParcel, AdSizeParcel[] paramArrayOfAdSizeParcel)
  {
    this(5, paramAdSizeParcel.zztV, paramAdSizeParcel.height, paramAdSizeParcel.heightPixels, paramAdSizeParcel.zztW, paramAdSizeParcel.width, paramAdSizeParcel.widthPixels, paramArrayOfAdSizeParcel, paramAdSizeParcel.zztY, paramAdSizeParcel.zztZ, paramAdSizeParcel.zzua);
  }
  
  public static int zza(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }
  
  public static int zzb(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(zzc(paramDisplayMetrics) * paramDisplayMetrics.density);
  }
  
  private static int zzc(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public static AdSizeParcel zzcK()
  {
    return new AdSizeParcel(5, "reward_mb", 0, 0, false, 0, 0, null, false, false, false);
  }
  
  public static AdSizeParcel zzt(Context paramContext)
  {
    return new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public AdSize zzcL()
  {
    return com.google.android.gms.ads.zza.zza(this.width, this.height, this.zztV);
  }
  
  public void zzi(boolean paramBoolean)
  {
    this.zzua = paramBoolean;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\AdSizeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */