package com.google.android.gms.internal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@zzha
public class zzis
{
  private final Context mContext;
  private int mState = 0;
  private final float zzCB;
  private String zzKT;
  private float zzKU;
  private float zzKV;
  private float zzKW;
  
  public zzis(Context paramContext)
  {
    this.mContext = paramContext;
    this.zzCB = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public zzis(Context paramContext, String paramString)
  {
    this(paramContext);
    this.zzKT = paramString;
  }
  
  private void showDialog()
  {
    if (!(this.mContext instanceof Activity))
    {
      zzb.zzaG("Can not create dialog without Activity Context");
      return;
    }
    final String str = zzaD(this.zzKT);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setMessage(str);
    localBuilder.setTitle("Ad Information");
    localBuilder.setPositiveButton("Share", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        zzp.zzbx().zzb(zzis.zza(zzis.this), Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str), "Share via"));
      }
    });
    localBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    localBuilder.create().show();
  }
  
  static String zzaD(String paramString)
  {
    String str2;
    if (TextUtils.isEmpty(paramString)) {
      str2 = "No debug information";
    }
    do
    {
      return str2;
      String str1 = paramString.replaceAll("\\+", "%20");
      Uri localUri = new Uri.Builder().encodedQuery(str1).build();
      StringBuilder localStringBuilder = new StringBuilder();
      Map localMap = zzp.zzbx().zze(localUri);
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        localStringBuilder.append(str3).append(" = ").append((String)localMap.get(str3)).append("\n\n");
      }
      str2 = localStringBuilder.toString().trim();
    } while (!TextUtils.isEmpty(str2));
    return "No debug information";
  }
  
  /* Error */
  void zza(int paramInt, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: iload_1
    //   1: ifne +24 -> 25
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 23	com/google/android/gms/internal/zzis:mState	I
    //   9: aload_0
    //   10: fload_2
    //   11: putfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   14: aload_0
    //   15: fload_3
    //   16: putfield 198	com/google/android/gms/internal/zzis:zzKV	F
    //   19: aload_0
    //   20: fload_3
    //   21: putfield 200	com/google/android/gms/internal/zzis:zzKW	F
    //   24: return
    //   25: aload_0
    //   26: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   29: iconst_m1
    //   30: if_icmpeq -6 -> 24
    //   33: iload_1
    //   34: iconst_2
    //   35: if_icmpne +212 -> 247
    //   38: fload_3
    //   39: aload_0
    //   40: getfield 198	com/google/android/gms/internal/zzis:zzKV	F
    //   43: fcmpl
    //   44: ifle +34 -> 78
    //   47: aload_0
    //   48: fload_3
    //   49: putfield 198	com/google/android/gms/internal/zzis:zzKV	F
    //   52: aload_0
    //   53: getfield 198	com/google/android/gms/internal/zzis:zzKV	F
    //   56: aload_0
    //   57: getfield 200	com/google/android/gms/internal/zzis:zzKW	F
    //   60: fsub
    //   61: ldc -55
    //   63: aload_0
    //   64: getfield 44	com/google/android/gms/internal/zzis:zzCB	F
    //   67: fmul
    //   68: fcmpl
    //   69: ifle +26 -> 95
    //   72: aload_0
    //   73: iconst_m1
    //   74: putfield 23	com/google/android/gms/internal/zzis:mState	I
    //   77: return
    //   78: fload_3
    //   79: aload_0
    //   80: getfield 200	com/google/android/gms/internal/zzis:zzKW	F
    //   83: fcmpg
    //   84: ifge -32 -> 52
    //   87: aload_0
    //   88: fload_3
    //   89: putfield 200	com/google/android/gms/internal/zzis:zzKW	F
    //   92: goto -40 -> 52
    //   95: aload_0
    //   96: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   99: ifeq +11 -> 110
    //   102: aload_0
    //   103: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   106: iconst_2
    //   107: if_icmpne +66 -> 173
    //   110: fload_2
    //   111: aload_0
    //   112: getfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   115: fsub
    //   116: ldc -54
    //   118: aload_0
    //   119: getfield 44	com/google/android/gms/internal/zzis:zzCB	F
    //   122: fmul
    //   123: fcmpl
    //   124: iflt +18 -> 142
    //   127: aload_0
    //   128: fload_2
    //   129: putfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   132: aload_0
    //   133: iconst_1
    //   134: aload_0
    //   135: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   138: iadd
    //   139: putfield 23	com/google/android/gms/internal/zzis:mState	I
    //   142: aload_0
    //   143: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   146: iconst_1
    //   147: if_icmpeq +11 -> 158
    //   150: aload_0
    //   151: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   154: iconst_3
    //   155: if_icmpne +69 -> 224
    //   158: fload_2
    //   159: aload_0
    //   160: getfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   163: fcmpl
    //   164: ifle -140 -> 24
    //   167: aload_0
    //   168: fload_2
    //   169: putfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   172: return
    //   173: aload_0
    //   174: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   177: iconst_1
    //   178: if_icmpeq +11 -> 189
    //   181: aload_0
    //   182: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   185: iconst_3
    //   186: if_icmpne -44 -> 142
    //   189: fload_2
    //   190: aload_0
    //   191: getfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   194: fsub
    //   195: ldc -53
    //   197: aload_0
    //   198: getfield 44	com/google/android/gms/internal/zzis:zzCB	F
    //   201: fmul
    //   202: fcmpg
    //   203: ifgt -61 -> 142
    //   206: aload_0
    //   207: fload_2
    //   208: putfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   211: aload_0
    //   212: iconst_1
    //   213: aload_0
    //   214: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   217: iadd
    //   218: putfield 23	com/google/android/gms/internal/zzis:mState	I
    //   221: goto -79 -> 142
    //   224: aload_0
    //   225: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   228: iconst_2
    //   229: if_icmpne -205 -> 24
    //   232: fload_2
    //   233: aload_0
    //   234: getfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   237: fcmpg
    //   238: ifge -214 -> 24
    //   241: aload_0
    //   242: fload_2
    //   243: putfield 196	com/google/android/gms/internal/zzis:zzKU	F
    //   246: return
    //   247: iload_1
    //   248: iconst_1
    //   249: if_icmpne -225 -> 24
    //   252: aload_0
    //   253: getfield 23	com/google/android/gms/internal/zzis:mState	I
    //   256: iconst_4
    //   257: if_icmpne -233 -> 24
    //   260: aload_0
    //   261: invokespecial 205	com/google/android/gms/internal/zzis:showDialog	()V
    //   264: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	zzis
    //   0	265	1	paramInt	int
    //   0	265	2	paramFloat1	float
    //   0	265	3	paramFloat2	float
  }
  
  public void zzaC(String paramString)
  {
    this.zzKT = paramString;
  }
  
  public void zze(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getHistorySize();
    for (int j = 0; j < i; j++) {
      zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, j), paramMotionEvent.getHistoricalY(0, j));
    }
    zza(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */