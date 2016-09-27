package com.google.ads.afma.nano;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzti;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.internal.zztn;
import java.io.IOException;

public abstract interface NanoAdshieldEvent
{
  public static final class AdShieldEvent
    extends zztk
  {
    private static volatile AdShieldEvent[] zzaK;
    public String appId;
    
    public AdShieldEvent()
    {
      clear();
    }
    
    public static AdShieldEvent[] emptyArray()
    {
      if (zzaK == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaK == null) {
          zzaK = new AdShieldEvent[0];
        }
        return zzaK;
      }
    }
    
    public static AdShieldEvent parseFrom(zztc paramzztc)
      throws IOException
    {
      return new AdShieldEvent().mergeFrom(paramzztc);
    }
    
    public static AdShieldEvent parseFrom(byte[] paramArrayOfByte)
      throws zztj
    {
      return (AdShieldEvent)zztk.mergeFrom(new AdShieldEvent(), paramArrayOfByte);
    }
    
    public AdShieldEvent clear()
    {
      this.appId = "";
      this.zzbqb = -1;
      return this;
    }
    
    public AdShieldEvent mergeFrom(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        switch (i)
        {
        default: 
          if (zztn.zzb(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.appId = paramzztc.readString();
        }
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (!this.appId.equals("")) {
        paramzztd.zzb(1, this.appId);
      }
      super.writeTo(paramzztd);
    }
    
    protected int zzz()
    {
      int i = super.zzz();
      if (!this.appId.equals("")) {
        i += zztd.zzp(1, this.appId);
      }
      return i;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\ads\afma\nano\NanoAdshieldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */