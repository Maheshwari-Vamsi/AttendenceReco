package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class zzu
{
  protected static final Comparator<byte[]> zzaw = new Comparator()
  {
    public int zza(byte[] paramAnonymousArrayOfByte1, byte[] paramAnonymousArrayOfByte2)
    {
      return paramAnonymousArrayOfByte1.length - paramAnonymousArrayOfByte2.length;
    }
  };
  private List<byte[]> zzas = new LinkedList();
  private List<byte[]> zzat = new ArrayList(64);
  private int zzau = 0;
  private final int zzav;
  
  public zzu(int paramInt)
  {
    this.zzav = paramInt;
  }
  
  /* Error */
  private void zzy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   6: aload_0
    //   7: getfield 40	com/google/android/gms/internal/zzu:zzav	I
    //   10: if_icmple +47 -> 57
    //   13: aload_0
    //   14: getfield 30	com/google/android/gms/internal/zzu:zzas	Ljava/util/List;
    //   17: iconst_0
    //   18: invokeinterface 47 2 0
    //   23: checkcast 49	[B
    //   26: astore_2
    //   27: aload_0
    //   28: getfield 36	com/google/android/gms/internal/zzu:zzat	Ljava/util/List;
    //   31: aload_2
    //   32: invokeinterface 52 2 0
    //   37: pop
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   43: aload_2
    //   44: arraylength
    //   45: isub
    //   46: putfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   49: goto -47 -> 2
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	zzu
    //   52	4	1	localObject	Object
    //   26	18	2	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   2	49	52	finally
  }
  
  /* Error */
  public void zza(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +18 -> 21
    //   6: aload_1
    //   7: arraylength
    //   8: istore_3
    //   9: aload_0
    //   10: getfield 40	com/google/android/gms/internal/zzu:zzav	I
    //   13: istore 4
    //   15: iload_3
    //   16: iload 4
    //   18: if_icmple +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 30	com/google/android/gms/internal/zzu:zzas	Ljava/util/List;
    //   28: aload_1
    //   29: invokeinterface 57 2 0
    //   34: pop
    //   35: aload_0
    //   36: getfield 36	com/google/android/gms/internal/zzu:zzat	Ljava/util/List;
    //   39: aload_1
    //   40: getstatic 23	com/google/android/gms/internal/zzu:zzaw	Ljava/util/Comparator;
    //   43: invokestatic 63	java/util/Collections:binarySearch	(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;)I
    //   46: istore 6
    //   48: iload 6
    //   50: ifge +10 -> 60
    //   53: iconst_m1
    //   54: iload 6
    //   56: ineg
    //   57: iadd
    //   58: istore 6
    //   60: aload_0
    //   61: getfield 36	com/google/android/gms/internal/zzu:zzat	Ljava/util/List;
    //   64: iload 6
    //   66: aload_1
    //   67: invokeinterface 66 3 0
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   77: aload_1
    //   78: arraylength
    //   79: iadd
    //   80: putfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   83: aload_0
    //   84: invokespecial 68	com/google/android/gms/internal/zzu:zzy	()V
    //   87: goto -66 -> 21
    //   90: astore_2
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_2
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	zzu
    //   0	95	1	paramArrayOfByte	byte[]
    //   90	4	2	localObject	Object
    //   8	11	3	i	int
    //   13	6	4	j	int
    //   46	19	6	k	int
    // Exception table:
    //   from	to	target	type
    //   6	15	90	finally
    //   24	48	90	finally
    //   60	87	90	finally
  }
  
  /* Error */
  public byte[] zzb(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 36	com/google/android/gms/internal/zzu:zzat	Ljava/util/List;
    //   9: invokeinterface 74 1 0
    //   14: if_icmpge +71 -> 85
    //   17: aload_0
    //   18: getfield 36	com/google/android/gms/internal/zzu:zzat	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 77 2 0
    //   27: checkcast 49	[B
    //   30: astore 4
    //   32: aload 4
    //   34: arraylength
    //   35: iload_1
    //   36: if_icmplt +43 -> 79
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   44: aload 4
    //   46: arraylength
    //   47: isub
    //   48: putfield 38	com/google/android/gms/internal/zzu:zzau	I
    //   51: aload_0
    //   52: getfield 36	com/google/android/gms/internal/zzu:zzat	Ljava/util/List;
    //   55: iload_2
    //   56: invokeinterface 47 2 0
    //   61: pop
    //   62: aload_0
    //   63: getfield 30	com/google/android/gms/internal/zzu:zzas	Ljava/util/List;
    //   66: aload 4
    //   68: invokeinterface 52 2 0
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: aload 4
    //   78: areturn
    //   79: iinc 2 1
    //   82: goto -78 -> 4
    //   85: iload_1
    //   86: newarray <illegal type>
    //   88: astore 4
    //   90: goto -16 -> 74
    //   93: astore_3
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	zzu
    //   0	98	1	paramInt	int
    //   3	77	2	i	int
    //   93	4	3	localObject	Object
    //   30	59	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   4	74	93	finally
    //   85	90	93	finally
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */