package com.purplebrain.adbuddiz.sdk.i.a;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public final class g
{
  @SuppressLint({"NewApi"})
  public static a a(Context paramContext)
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalStateException("Cannot be called from the main thread");
    }
    b localb;
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      localb = new b((byte)0);
      Intent localIntent = new Intent("com.google.android.gms.ads.identifier.service.START");
      localIntent.setPackage("com.google.android.gms");
      if (!paramContext.bindService(localIntent, localb, 1)) {
        break label153;
      }
      try
      {
        if (localb.a) {
          throw new IllegalStateException();
        }
      }
      catch (Exception localException2)
      {
        throw localException2;
      }
      finally
      {
        paramContext.unbindService(localb);
      }
      localb.a = true;
    }
    catch (Exception localException1)
    {
      throw localException1;
    }
    c localc = new c((IBinder)localb.b.take());
    a locala = new a(localc.a(), localc.b());
    paramContext.unbindService(localb);
    return locala;
    label153:
    throw new IOException("Google Play connection failed");
  }
  
  public static final class a
  {
    final String a;
    final boolean b;
    
    a(String paramString, boolean paramBoolean)
    {
      this.a = paramString;
      this.b = paramBoolean;
    }
  }
  
  private static final class b
    implements ServiceConnection
  {
    boolean a = false;
    final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      try
      {
        this.b.put(paramIBinder);
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  private static final class c
    implements IInterface
  {
    private IBinder a;
    
    public c(IBinder paramIBinder)
    {
      this.a = paramIBinder;
    }
    
    public final String a()
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        this.a.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        String str = localParcel2.readString();
        return str;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    public final IBinder asBinder()
    {
      return this.a;
    }
    
    /* Error */
    public final boolean b()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   5: astore_2
      //   6: invokestatic 22	android/os/Parcel:obtain	()Landroid/os/Parcel;
      //   9: astore_3
      //   10: aload_2
      //   11: ldc 24
      //   13: invokevirtual 28	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
      //   16: aload_2
      //   17: iconst_1
      //   18: invokevirtual 51	android/os/Parcel:writeInt	(I)V
      //   21: aload_0
      //   22: getfield 15	com/purplebrain/adbuddiz/sdk/i/a/g$c:a	Landroid/os/IBinder;
      //   25: iconst_2
      //   26: aload_2
      //   27: aload_3
      //   28: iconst_0
      //   29: invokeinterface 34 5 0
      //   34: pop
      //   35: aload_3
      //   36: invokevirtual 37	android/os/Parcel:readException	()V
      //   39: aload_3
      //   40: invokevirtual 55	android/os/Parcel:readInt	()I
      //   43: istore 6
      //   45: iload 6
      //   47: ifeq +13 -> 60
      //   50: aload_3
      //   51: invokevirtual 43	android/os/Parcel:recycle	()V
      //   54: aload_2
      //   55: invokevirtual 43	android/os/Parcel:recycle	()V
      //   58: iload_1
      //   59: ireturn
      //   60: iconst_0
      //   61: istore_1
      //   62: goto -12 -> 50
      //   65: astore 4
      //   67: aload_3
      //   68: invokevirtual 43	android/os/Parcel:recycle	()V
      //   71: aload_2
      //   72: invokevirtual 43	android/os/Parcel:recycle	()V
      //   75: aload 4
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	c
      //   1	61	1	bool	boolean
      //   5	67	2	localParcel1	Parcel
      //   9	59	3	localParcel2	Parcel
      //   65	11	4	localObject	Object
      //   43	3	6	i	int
      // Exception table:
      //   from	to	target	type
      //   10	45	65	finally
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\purplebrain\adbuddiz\sdk\i\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */