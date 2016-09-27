package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;
import java.util.ArrayList;
import java.util.List;

public abstract interface zzct
  extends IInterface
{
  public abstract void destroy()
    throws RemoteException;
  
  public abstract String getAdvertiser()
    throws RemoteException;
  
  public abstract String getBody()
    throws RemoteException;
  
  public abstract String getCallToAction()
    throws RemoteException;
  
  public abstract Bundle getExtras()
    throws RemoteException;
  
  public abstract String getHeadline()
    throws RemoteException;
  
  public abstract List getImages()
    throws RemoteException;
  
  public abstract zzd zzdE()
    throws RemoteException;
  
  public abstract zzcn zzdH()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzct
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }
    
    public static zzct zzx(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
      if ((localIInterface != null) && ((localIInterface instanceof zzct))) {
        return (zzct)localIInterface;
      }
      return new zza(paramIBinder);
    }
    
    public IBinder asBinder()
    {
      return this;
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        zzd localzzd = zzdE();
        paramParcel2.writeNoException();
        IBinder localIBinder2 = null;
        if (localzzd != null) {
          localIBinder2 = localzzd.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder2);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        String str4 = getHeadline();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str4);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        List localList = getImages();
        paramParcel2.writeNoException();
        paramParcel2.writeList(localList);
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        String str3 = getBody();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str3);
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        zzcn localzzcn = zzdH();
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (localzzcn != null) {
          localIBinder1 = localzzcn.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        String str2 = getCallToAction();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        String str1 = getAdvertiser();
        paramParcel2.writeNoException();
        paramParcel2.writeString(str1);
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
        Bundle localBundle = getExtras();
        paramParcel2.writeNoException();
        if (localBundle != null)
        {
          paramParcel2.writeInt(1);
          localBundle.writeToParcel(paramParcel2, 1);
        }
        for (;;)
        {
          return true;
          paramParcel2.writeInt(0);
        }
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
      destroy();
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzct
    {
      private IBinder zzoo;
      
      zza(IBinder paramIBinder)
      {
        this.zzoo = paramIBinder;
      }
      
      public IBinder asBinder()
      {
        return this.zzoo;
      }
      
      public void destroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(10, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public String getAdvertiser()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(8, localParcel1, localParcel2, 0);
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
      
      public String getBody()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(5, localParcel1, localParcel2, 0);
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
      
      public String getCallToAction()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(7, localParcel1, localParcel2, 0);
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
      
      /* Error */
      public Bundle getExtras()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 26	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 28
        //   11: invokevirtual 32	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 15	com/google/android/gms/internal/zzct$zza$zza:zzoo	Landroid/os/IBinder;
        //   18: bipush 9
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 38 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 41	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 57	android/os/Parcel:readInt	()I
        //   37: ifeq +28 -> 65
        //   40: getstatic 63	android/os/Bundle:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_2
        //   44: invokeinterface 69 2 0
        //   49: checkcast 59	android/os/Bundle
        //   52: astore 5
        //   54: aload_2
        //   55: invokevirtual 44	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 44	android/os/Parcel:recycle	()V
        //   62: aload 5
        //   64: areturn
        //   65: aconst_null
        //   66: astore 5
        //   68: goto -14 -> 54
        //   71: astore_3
        //   72: aload_2
        //   73: invokevirtual 44	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: invokevirtual 44	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	zza
        //   3	74	1	localParcel1	Parcel
        //   7	66	2	localParcel2	Parcel
        //   71	10	3	localObject	Object
        //   52	15	5	localBundle	Bundle
        // Exception table:
        //   from	to	target	type
        //   8	54	71	finally
      }
      
      public String getHeadline()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(3, localParcel1, localParcel2, 0);
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
      
      public List getImages()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(4, localParcel1, localParcel2, 0);
          localParcel2.readException();
          ArrayList localArrayList = localParcel2.readArrayList(getClass().getClassLoader());
          return localArrayList;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public zzd zzdE()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzd localzzd = zzd.zza.zzbs(localParcel2.readStrongBinder());
          return localzzd;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public zzcn zzdH()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
          this.zzoo.transact(6, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzcn localzzcn = zzcn.zza.zzt(localParcel2.readStrongBinder());
          return localzzcn;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */