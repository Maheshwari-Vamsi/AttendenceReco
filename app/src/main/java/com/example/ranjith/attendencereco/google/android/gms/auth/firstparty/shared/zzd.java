package com.google.android.gms.auth.firstparty.shared;

public enum zzd
{
  private final String zzXU;
  
  static
  {
    zzXA = new zzd("DM_STALE_SYNC_REQUIRED", 29, "DeviceManagementStaleSyncRequired");
    zzXB = new zzd("DM_DEACTIVATED", 30, "DeviceManagementDeactivated");
    zzXC = new zzd("DM_REQUIRED", 31, "DeviceManagementRequired");
    zzXD = new zzd("ALREADY_HAS_GMAIL", 32, "ALREADY_HAS_GMAIL");
    zzXE = new zzd("BAD_PASSWORD", 33, "WeakPassword");
    zzXF = new zzd("BAD_REQUEST", 34, "BadRequest");
    zzXG = new zzd("BAD_USERNAME", 35, "BadUsername");
    zzXH = new zzd("DELETED_GMAIL", 36, "DeletedGmail");
    zzXI = new zzd("EXISTING_USERNAME", 37, "ExistingUsername");
    zzXJ = new zzd("LOGIN_FAIL", 38, "LoginFail");
    zzXK = new zzd("NOT_LOGGED_IN", 39, "NotLoggedIn");
    zzXL = new zzd("NO_GMAIL", 40, "NoGmail");
    zzXM = new zzd("REQUEST_DENIED", 41, "RequestDenied");
    zzXN = new zzd("SERVER_ERROR", 42, "ServerError");
    zzXO = new zzd("USERNAME_UNAVAILABLE", 43, "UsernameUnavailable");
    zzXP = new zzd("GPLUS_OTHER", 44, "GPlusOther");
    zzXQ = new zzd("GPLUS_NICKNAME", 45, "GPlusNickname");
    zzXR = new zzd("GPLUS_INVALID_CHAR", 46, "GPlusInvalidChar");
    zzXS = new zzd("GPLUS_INTERSTITIAL", 47, "GPlusInterstitial");
    zzXT = new zzd("GPLUS_PROFILE_ERROR", 48, "ProfileUpgradeError");
    zzd[] arrayOfzzd = new zzd[49];
    arrayOfzzd[0] = zzWX;
    arrayOfzzd[1] = zzWY;
    arrayOfzzd[2] = zzWZ;
    arrayOfzzd[3] = zzXa;
    arrayOfzzd[4] = zzXb;
    arrayOfzzd[5] = zzXc;
    arrayOfzzd[6] = zzXd;
    arrayOfzzd[7] = zzXe;
    arrayOfzzd[8] = zzXf;
    arrayOfzzd[9] = zzXg;
    arrayOfzzd[10] = zzXh;
    arrayOfzzd[11] = zzXi;
    arrayOfzzd[12] = zzXj;
    arrayOfzzd[13] = zzXk;
    arrayOfzzd[14] = zzXl;
    arrayOfzzd[15] = zzXm;
    arrayOfzzd[16] = zzXn;
    arrayOfzzd[17] = zzXo;
    arrayOfzzd[18] = zzXp;
    arrayOfzzd[19] = zzXq;
    arrayOfzzd[20] = zzXr;
    arrayOfzzd[21] = zzXs;
    arrayOfzzd[22] = zzXt;
    arrayOfzzd[23] = zzXu;
    arrayOfzzd[24] = zzXv;
    arrayOfzzd[25] = zzXw;
    arrayOfzzd[26] = zzXx;
    arrayOfzzd[27] = zzXy;
    arrayOfzzd[28] = zzXz;
    arrayOfzzd[29] = zzXA;
    arrayOfzzd[30] = zzXB;
    arrayOfzzd[31] = zzXC;
    arrayOfzzd[32] = zzXD;
    arrayOfzzd[33] = zzXE;
    arrayOfzzd[34] = zzXF;
    arrayOfzzd[35] = zzXG;
    arrayOfzzd[36] = zzXH;
    arrayOfzzd[37] = zzXI;
    arrayOfzzd[38] = zzXJ;
    arrayOfzzd[39] = zzXK;
    arrayOfzzd[40] = zzXL;
    arrayOfzzd[41] = zzXM;
    arrayOfzzd[42] = zzXN;
    arrayOfzzd[43] = zzXO;
    arrayOfzzd[44] = zzXP;
    arrayOfzzd[45] = zzXQ;
    arrayOfzzd[46] = zzXR;
    arrayOfzzd[47] = zzXS;
    arrayOfzzd[48] = zzXT;
    zzXV = arrayOfzzd;
  }
  
  private zzd(String paramString)
  {
    this.zzXU = paramString;
  }
  
  public static boolean zza(zzd paramzzd)
  {
    return (zzXf.equals(paramzzd)) || (zzXo.equals(paramzzd)) || (zzXr.equals(paramzzd)) || (zzXj.equals(paramzzd)) || (zzXt.equals(paramzzd)) || (zzXv.equals(paramzzd)) || (zzb(paramzzd));
  }
  
  public static boolean zzb(zzd paramzzd)
  {
    return (zzWY.equals(paramzzd)) || (zzXw.equals(paramzzd)) || (zzXx.equals(paramzzd)) || (zzXy.equals(paramzzd)) || (zzXz.equals(paramzzd)) || (zzXA.equals(paramzzd)) || (zzXB.equals(paramzzd)) || (zzXC.equals(paramzzd));
  }
  
  public static final zzd zzbT(String paramString)
  {
    Object localObject1 = null;
    zzd[] arrayOfzzd = values();
    int i = arrayOfzzd.length;
    int j = 0;
    Object localObject2;
    if (j < i)
    {
      localObject2 = arrayOfzzd[j];
      if (!((zzd)localObject2).zzXU.equals(paramString)) {
        break label47;
      }
    }
    for (;;)
    {
      j++;
      localObject1 = localObject2;
      break;
      return (zzd)localObject1;
      label47:
      localObject2 = localObject1;
    }
  }
  
  public static boolean zzc(zzd paramzzd)
  {
    return (zzXc.equals(paramzzd)) || (zzXd.equals(paramzzd));
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\auth\firstparty\shared\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */