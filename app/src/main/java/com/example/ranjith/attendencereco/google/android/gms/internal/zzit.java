package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzit
{
  private final String[] zzKZ;
  private final double[] zzLa;
  private final double[] zzLb;
  private final int[] zzLc;
  private int zzLd;
  
  private zzit(zzb paramzzb)
  {
    int i = zzb.zza(paramzzb).size();
    this.zzKZ = ((String[])zzb.zzb(paramzzb).toArray(new String[i]));
    this.zzLa = zzi(zzb.zza(paramzzb));
    this.zzLb = zzi(zzb.zzc(paramzzb));
    this.zzLc = new int[i];
    this.zzLd = 0;
  }
  
  private double[] zzi(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    for (int i = 0; i < arrayOfDouble.length; i++) {
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
    }
    return arrayOfDouble;
  }
  
  public List<zza> getBuckets()
  {
    ArrayList localArrayList = new ArrayList(this.zzKZ.length);
    for (int i = 0; i < this.zzKZ.length; i++) {
      localArrayList.add(new zza(this.zzKZ[i], this.zzLb[i], this.zzLa[i], this.zzLc[i] / this.zzLd, this.zzLc[i]));
    }
    return localArrayList;
  }
  
  public void zza(double paramDouble)
  {
    this.zzLd = (1 + this.zzLd);
    for (int i = 0;; i++) {
      if (i < this.zzLb.length)
      {
        if ((this.zzLb[i] <= paramDouble) && (paramDouble < this.zzLa[i]))
        {
          int[] arrayOfInt = this.zzLc;
          arrayOfInt[i] = (1 + arrayOfInt[i]);
        }
        if (paramDouble >= this.zzLb[i]) {}
      }
      else
      {
        return;
      }
    }
  }
  
  public static class zza
  {
    public final int count;
    public final String name;
    public final double zzLe;
    public final double zzLf;
    public final double zzLg;
    
    public zza(String paramString, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt)
    {
      this.name = paramString;
      this.zzLf = paramDouble1;
      this.zzLe = paramDouble2;
      this.zzLg = paramDouble3;
      this.count = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof zza)) {}
      zza localzza;
      do
      {
        return false;
        localzza = (zza)paramObject;
      } while ((!zzw.equal(this.name, localzza.name)) || (this.zzLe != localzza.zzLe) || (this.zzLf != localzza.zzLf) || (this.count != localzza.count) || (Double.compare(this.zzLg, localzza.zzLg) != 0));
      return true;
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = this.name;
      arrayOfObject[1] = Double.valueOf(this.zzLe);
      arrayOfObject[2] = Double.valueOf(this.zzLf);
      arrayOfObject[3] = Double.valueOf(this.zzLg);
      arrayOfObject[4] = Integer.valueOf(this.count);
      return zzw.hashCode(arrayOfObject);
    }
    
    public String toString()
    {
      return zzw.zzx(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzLf)).zzg("maxBound", Double.valueOf(this.zzLe)).zzg("percent", Double.valueOf(this.zzLg)).zzg("count", Integer.valueOf(this.count)).toString();
    }
  }
  
  public static class zzb
  {
    private final List<String> zzLh = new ArrayList();
    private final List<Double> zzLi = new ArrayList();
    private final List<Double> zzLj = new ArrayList();
    
    public zzb zza(String paramString, double paramDouble1, double paramDouble2)
    {
      for (int i = 0;; i++)
      {
        double d1;
        double d2;
        if (i < this.zzLh.size())
        {
          d1 = ((Double)this.zzLj.get(i)).doubleValue();
          d2 = ((Double)this.zzLi.get(i)).doubleValue();
          if (paramDouble1 >= d1) {
            break label107;
          }
        }
        label107:
        while ((d1 == paramDouble1) && (paramDouble2 < d2))
        {
          this.zzLh.add(i, paramString);
          this.zzLj.add(i, Double.valueOf(paramDouble1));
          this.zzLi.add(i, Double.valueOf(paramDouble2));
          return this;
        }
      }
    }
    
    public zzit zzhi()
    {
      return new zzit(this, null);
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\android\gms\internal\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */