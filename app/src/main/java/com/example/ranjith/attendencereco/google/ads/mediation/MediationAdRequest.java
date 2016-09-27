package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest
{
  private final Date zzaW;
  private final AdRequest.Gender zzaX;
  private final Set<String> zzaY;
  private final boolean zzaZ;
  private final Location zzba;
  
  public MediationAdRequest(Date paramDate, AdRequest.Gender paramGender, Set<String> paramSet, boolean paramBoolean, Location paramLocation)
  {
    this.zzaW = paramDate;
    this.zzaX = paramGender;
    this.zzaY = paramSet;
    this.zzaZ = paramBoolean;
    this.zzba = paramLocation;
  }
  
  public Integer getAgeInYears()
  {
    if (this.zzaW != null)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar1.setTime(this.zzaW);
      Integer localInteger = Integer.valueOf(localCalendar2.get(1) - localCalendar1.get(1));
      if ((localCalendar2.get(2) < localCalendar1.get(2)) || ((localCalendar2.get(2) == localCalendar1.get(2)) && (localCalendar2.get(5) < localCalendar1.get(5)))) {
        localInteger = Integer.valueOf(-1 + localInteger.intValue());
      }
      return localInteger;
    }
    return null;
  }
  
  public Date getBirthday()
  {
    return this.zzaW;
  }
  
  public AdRequest.Gender getGender()
  {
    return this.zzaX;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaY;
  }
  
  public Location getLocation()
  {
    return this.zzba;
  }
  
  public boolean isTesting()
  {
    return this.zzaZ;
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\google\ads\mediation\MediationAdRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */