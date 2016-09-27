package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcx.zza;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcy.zza;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzcz.zza;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzda.zza;

public abstract interface zzq
  extends IInterface
{
  public abstract void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
    throws RemoteException;
  
  public abstract void zza(zzcx paramzzcx)
    throws RemoteException;
  
  public abstract void zza(zzcy paramzzcy)
    throws RemoteException;
  
  public abstract void zza(String paramString, zzda paramzzda, zzcz paramzzcz)
    throws RemoteException;
  
  public abstract void zzb(zzo paramzzo)
    throws RemoteException;
  
  public abstract void zzb(zzv paramzzv)
    throws RemoteException;
  
  public abstract zzp zzbm()
    throws RemoteException;
  
  public static abstract class zza
    extends Binder
    implements zzq
  {
    public zza()
    {
      attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }
    
    public static zzq zzi(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
      if ((localIInterface != null) && ((localIInterface instanceof zzq))) {
        return (zzq)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zzp localzzp = zzbm();
        paramParcel2.writeNoException();
        IBinder localIBinder = null;
        if (localzzp != null) {
          localIBinder = localzzp.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zzb(zzo.zza.zzg(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zza(zzcx.zza.zzz(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zza(zzcy.zza.zzA(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        zza(paramParcel1.readString(), zzda.zza.zzC(paramParcel1.readStrongBinder()), zzcz.zza.zzB(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        int i = paramParcel1.readInt();
        NativeAdOptionsParcel localNativeAdOptionsParcel = null;
        if (i != 0) {
          localNativeAdOptionsParcel = NativeAdOptionsParcel.CREATOR.zze(paramParcel1);
        }
        zza(localNativeAdOptionsParcel);
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
      zzb(zzv.zza.zzn(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      return true;
    }
    
    private static class zza
      implements zzq
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
      
      /* Error */
      public void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 43	com/google/android/gms/ads/internal/formats/NativeAdOptionsParcel:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/ads/internal/client/zzq$zza$zza:zzoo	Landroid/os/IBinder;
        //   33: bipush 6
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 49 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 52	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 55	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 55	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 37	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	zza
        //   0	78	1	paramNativeAdOptionsParcel	NativeAdOptionsParcel
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void zza(zzcx paramzzcx)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 60 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 63	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/ads/internal/client/zzq$zza$zza:zzoo	Landroid/os/IBinder;
        //   36: iconst_3
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 5
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	zza
        //   0	78	1	paramzzcx	zzcx
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        //   24	37	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	26	65	finally
        //   26	50	65	finally
      }
      
      /* Error */
      public void zza(zzcy paramzzcy)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 67 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 63	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/ads/internal/client/zzq$zza$zza:zzoo	Landroid/os/IBinder;
        //   36: iconst_4
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 5
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	zza
        //   0	78	1	paramzzcy	zzcy
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        //   24	37	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	26	65	finally
        //   26	50	65	finally
      }
      
      /* Error */
      public void zza(String paramString, zzda paramzzda, zzcz paramzzcz)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 29
        //   14: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 71	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   23: aload_2
        //   24: ifnull +72 -> 96
        //   27: aload_2
        //   28: invokeinterface 74 1 0
        //   33: astore 7
        //   35: aload 4
        //   37: aload 7
        //   39: invokevirtual 63	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   42: aconst_null
        //   43: astore 8
        //   45: aload_3
        //   46: ifnull +11 -> 57
        //   49: aload_3
        //   50: invokeinterface 77 1 0
        //   55: astore 8
        //   57: aload 4
        //   59: aload 8
        //   61: invokevirtual 63	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   64: aload_0
        //   65: getfield 15	com/google/android/gms/ads/internal/client/zzq$zza$zza:zzoo	Landroid/os/IBinder;
        //   68: iconst_5
        //   69: aload 4
        //   71: aload 5
        //   73: iconst_0
        //   74: invokeinterface 49 5 0
        //   79: pop
        //   80: aload 5
        //   82: invokevirtual 52	android/os/Parcel:readException	()V
        //   85: aload 5
        //   87: invokevirtual 55	android/os/Parcel:recycle	()V
        //   90: aload 4
        //   92: invokevirtual 55	android/os/Parcel:recycle	()V
        //   95: return
        //   96: aconst_null
        //   97: astore 7
        //   99: goto -64 -> 35
        //   102: astore 6
        //   104: aload 5
        //   106: invokevirtual 55	android/os/Parcel:recycle	()V
        //   109: aload 4
        //   111: invokevirtual 55	android/os/Parcel:recycle	()V
        //   114: aload 6
        //   116: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	117	0	this	zza
        //   0	117	1	paramString	String
        //   0	117	2	paramzzda	zzda
        //   0	117	3	paramzzcz	zzcz
        //   3	107	4	localParcel1	Parcel
        //   8	97	5	localParcel2	Parcel
        //   102	13	6	localObject	Object
        //   33	65	7	localIBinder1	IBinder
        //   43	17	8	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   10	23	102	finally
        //   27	35	102	finally
        //   35	42	102	finally
        //   49	57	102	finally
        //   57	85	102	finally
      }
      
      /* Error */
      public void zzb(zzo paramzzo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 82 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 63	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/ads/internal/client/zzq$zza$zza:zzoo	Landroid/os/IBinder;
        //   36: iconst_2
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 49 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 52	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 55	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 55	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 5
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 55	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 55	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	zza
        //   0	78	1	paramzzo	zzo
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        //   24	37	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	26	65	finally
        //   26	50	65	finally
      }
      
      /* Error */
      public void zzb(zzv paramzzv)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 27	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 29
        //   11: invokevirtual 33	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 86 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 63	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/ads/internal/client/zzq$zza$zza:zzoo	Landroid/os/IBinder;
        //   36: bipush 7
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 49 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 52	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 55	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 55	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 55	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 55	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	zza
        //   0	79	1	paramzzv	zzv
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      public zzp zzbm()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
          this.zzoo.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          zzp localzzp = zzp.zza.zzh(localParcel2.readStrongBinder());
          return localzzp;
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


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */