package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class zze
{
  public static final zze zzaiV = zza("\t\n\013\f\r     　 ᠎ ").zza(zza(' ', ' '));
  public static final zze zzaiW = zza("\t\n\013\f\r     　").zza(zza(' ', ' ')).zza(zza(' ', ' '));
  public static final zze zzaiX = zza('\000', '');
  public static final zze zzaiY;
  public static final zze zzaiZ = zza('\t', '\r').zza(zza('\034', ' ')).zza(zzc(' ')).zza(zzc('᠎')).zza(zza(' ', ' ')).zza(zza(' ', '​')).zza(zza(' ', ' ')).zza(zzc(' ')).zza(zzc('　'));
  public static final zze zzaja = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isDigit(paramAnonymousChar);
    }
  };
  public static final zze zzajb = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetter(paramAnonymousChar);
    }
  };
  public static final zze zzajc = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLetterOrDigit(paramAnonymousChar);
    }
  };
  public static final zze zzajd = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isUpperCase(paramAnonymousChar);
    }
  };
  public static final zze zzaje = new zze()
  {
    public boolean zzd(char paramAnonymousChar)
    {
      return Character.isLowerCase(paramAnonymousChar);
    }
  };
  public static final zze zzajf = zza('\000', '\037').zza(zza('', ''));
  public static final zze zzajg = zza('\000', ' ').zza(zza('', ' ')).zza(zzc('­')).zza(zza('؀', '؃')).zza(zza("۝܏ ឴឵᠎")).zza(zza(' ', '‏')).zza(zza(' ', ' ')).zza(zza(' ', '⁤')).zza(zza('⁪', '⁯')).zza(zzc('　')).zza(zza(55296, 63743)).zza(zza("﻿￹￺￻"));
  public static final zze zzajh = zza('\000', 'ӹ').zza(zzc('־')).zza(zza('א', 'ת')).zza(zzc('׳')).zza(zzc('״')).zza(zza('؀', 'ۿ')).zza(zza('ݐ', 'ݿ')).zza(zza('฀', '๿')).zza(zza('Ḁ', '₯')).zza(zza('℀', '℺')).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
  public static final zze zzaji = new zze()
  {
    public zze zza(zze paramAnonymouszze)
    {
      zzx.zzy(paramAnonymouszze);
      return this;
    }
    
    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      zzx.zzy(paramAnonymousCharSequence);
      return true;
    }
    
    public boolean zzd(char paramAnonymousChar)
    {
      return true;
    }
  };
  public static final zze zzajj = new zze()
  {
    public zze zza(zze paramAnonymouszze)
    {
      return (zze)zzx.zzy(paramAnonymouszze);
    }
    
    public boolean zzb(CharSequence paramAnonymousCharSequence)
    {
      return paramAnonymousCharSequence.length() == 0;
    }
    
    public boolean zzd(char paramAnonymousChar)
    {
      return false;
    }
  };
  
  static
  {
    zze localzze1 = zza('0', '9');
    char[] arrayOfChar = "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
    int i = arrayOfChar.length;
    zze localzze2 = localzze1;
    for (int j = 0; j < i; j++)
    {
      char c = arrayOfChar[j];
      localzze2 = localzze2.zza(zza(c, (char)(c + '\t')));
    }
    zzaiY = localzze2;
  }
  
  public static zze zza(char paramChar1, final char paramChar2)
  {
    if (paramChar2 >= paramChar1) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzab(bool);
      new zze()
      {
        public boolean zzd(char paramAnonymousChar)
        {
          return (this.zzajn <= paramAnonymousChar) && (paramAnonymousChar <= paramChar2);
        }
      };
    }
  }
  
  public static zze zza(CharSequence paramCharSequence)
  {
    switch (paramCharSequence.length())
    {
    default: 
      char[] arrayOfChar = paramCharSequence.toString().toCharArray();
      Arrays.sort(arrayOfChar);
      new zze()
      {
        public boolean zzd(char paramAnonymousChar)
        {
          return Arrays.binarySearch(this.zzajm, paramAnonymousChar) >= 0;
        }
      };
    case 0: 
      return zzajj;
    case 1: 
      return zzc(paramCharSequence.charAt(0));
    }
    new zze()
    {
      public boolean zzd(char paramAnonymousChar)
      {
        return (paramAnonymousChar == this.zzajk) || (paramAnonymousChar == this.zzajl);
      }
    };
  }
  
  public static zze zzc(char paramChar)
  {
    new zze()
    {
      public zze zza(zze paramAnonymouszze)
      {
        if (paramAnonymouszze.zzd(this.zzajp)) {
          return paramAnonymouszze;
        }
        return super.zza(paramAnonymouszze);
      }
      
      public boolean zzd(char paramAnonymousChar)
      {
        return paramAnonymousChar == this.zzajp;
      }
    };
  }
  
  public zze zza(zze paramzze)
  {
    zze[] arrayOfzze = new zze[2];
    arrayOfzze[0] = this;
    arrayOfzze[1] = ((zze)zzx.zzy(paramzze));
    return new zza(Arrays.asList(arrayOfzze));
  }
  
  public boolean zzb(CharSequence paramCharSequence)
  {
    for (int i = -1 + paramCharSequence.length(); i >= 0; i--) {
      if (!zzd(paramCharSequence.charAt(i))) {
        return false;
      }
    }
    return true;
  }
  
  public abstract boolean zzd(char paramChar);
  
  private static class zza
    extends zze
  {
    List<zze> zzajq;
    
    zza(List<zze> paramList)
    {
      this.zzajq = paramList;
    }
    
    public zze zza(zze paramzze)
    {
      ArrayList localArrayList = new ArrayList(this.zzajq);
      localArrayList.add(zzx.zzy(paramzze));
      return new zza(localArrayList);
    }
    
    public boolean zzd(char paramChar)
    {
      Iterator localIterator = this.zzajq.iterator();
      while (localIterator.hasNext()) {
        if (((zze)localIterator.next()).zzd(paramChar)) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\common\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */