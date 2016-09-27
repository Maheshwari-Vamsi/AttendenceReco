package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zza zzajZ;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzaka = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzakb = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzakc = new ArrayList();
  private volatile boolean zzakd = false;
  private final AtomicInteger zzake = new AtomicInteger(0);
  private boolean zzakf = false;
  private final Object zzpK = new Object();
  
  public zzk(Looper paramLooper, zza paramzza)
  {
    this.zzajZ = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)paramMessage.obj;
      synchronized (this.zzpK)
      {
        if ((this.zzakd) && (this.zzajZ.isConnected()) && (this.zzaka.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zzajZ.zznQ());
        }
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle message: " + paramMessage.what, new Exception());
    return false;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzy(paramConnectionCallbacks);
    synchronized (this.zzpK)
    {
      boolean bool = this.zzaka.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzpK)
    {
      boolean bool = this.zzakc.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzy(paramConnectionCallbacks);
    synchronized (this.zzpK)
    {
      if (this.zzaka.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.zzajZ.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.zzaka.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzpK)
    {
      if (this.zzakc.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.zzakc.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzy(paramConnectionCallbacks);
    synchronized (this.zzpK)
    {
      if (!this.zzaka.remove(paramConnectionCallbacks)) {
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      while (!this.zzakf) {
        return;
      }
      this.zzakb.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzy(paramOnConnectionFailedListener);
    synchronized (this.zzpK)
    {
      if (!this.zzakc.remove(paramOnConnectionFailedListener)) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public void zzbV(int paramInt)
  {
    Looper localLooper1 = Looper.myLooper();
    Looper localLooper2 = this.mHandler.getLooper();
    boolean bool = false;
    if (localLooper1 == localLooper2) {
      bool = true;
    }
    zzx.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzpK)
    {
      this.zzakf = true;
      ArrayList localArrayList = new ArrayList(this.zzaka);
      int i = this.zzake.get();
      Iterator localIterator = localArrayList.iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if ((this.zzakd) && (this.zzake.get() == i)) {}
        }
        else
        {
          this.zzakb.clear();
          this.zzakf = false;
          return;
        }
      } while (!this.zzaka.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void zzk(Bundle paramBundle)
  {
    boolean bool1 = true;
    boolean bool2;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool2 = bool1;
      zzx.zza(bool2, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzakf) {
          break label208;
        }
        bool3 = bool1;
        zzx.zzaa(bool3);
        this.mHandler.removeMessages(1);
        this.zzakf = true;
        if (this.zzakb.size() != 0) {
          break label214;
        }
        zzx.zzaa(bool1);
        ArrayList localArrayList = new ArrayList(this.zzaka);
        int i = this.zzake.get();
        Iterator localIterator = localArrayList.iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        if (localIterator.hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)localIterator.next();
          if ((this.zzakd) && (this.zzajZ.isConnected()) && (this.zzake.get() == i)) {}
        }
        else
        {
          this.zzakb.clear();
          this.zzakf = false;
          return;
        }
        if (this.zzakb.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool2 = false;
      break;
      label208:
      boolean bool3 = false;
      continue;
      label214:
      bool1 = false;
    }
  }
  
  public void zzl(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.zzpK)
      {
        ArrayList localArrayList = new ArrayList(this.zzakc);
        int i = this.zzake.get();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)localIterator.next();
          if ((!this.zzakd) || (this.zzake.get() != i)) {
            return;
          }
          if (this.zzakc.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public void zzqA()
  {
    this.zzakd = false;
    this.zzake.incrementAndGet();
  }
  
  public void zzqB()
  {
    this.zzakd = true;
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zznQ();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */