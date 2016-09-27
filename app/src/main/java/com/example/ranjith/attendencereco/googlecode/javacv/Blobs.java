package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.io.PrintStream;
import java.lang.reflect.Array;

public class Blobs
{
  public static int BLOBAREA;
  static int BLOBCOLCOUNT;
  public static int BLOBCOLOR;
  public static int BLOBDATACOUNT;
  public static int BLOBLABEL;
  public static int BLOBMAXX;
  public static int BLOBMAXY;
  public static int BLOBMINX;
  public static int BLOBMINY;
  public static int BLOBPARENT;
  public static int BLOBPERIMETER;
  static int BLOBROWCOUNT = 3500;
  public static int BLOBSUMX;
  public static int BLOBSUMXX;
  public static int BLOBSUMXY;
  public static int BLOBSUMY;
  public static int BLOBSUMYY;
  static int BLOBTOTALCOUNT;
  public static int[] CondensationMap = new int[BLOBTOTALCOUNT];
  public static int[][] LabelMat;
  public static int MaxLabel;
  public static double[][] RegionData;
  public static int[] SubsumedLabel;
  static double iField;
  static double[] iProperty;
  static double jField;
  static double[] jProperty;
  public int ColorA;
  public int ColorB;
  public int ColorC;
  public int ColorD;
  public int LabelA;
  public int LabelB;
  public int LabelC;
  public int LabelD;
  public int jcol;
  public int jrow;
  
  static
  {
    BLOBCOLCOUNT = 2700;
    BLOBTOTALCOUNT = 5 * (BLOBROWCOUNT + BLOBCOLCOUNT);
    BLOBLABEL = 0;
    BLOBPARENT = 1;
    BLOBCOLOR = 2;
    BLOBAREA = 3;
    BLOBPERIMETER = 4;
    BLOBSUMX = 5;
    BLOBSUMY = 6;
    BLOBSUMXX = 7;
    BLOBSUMYY = 8;
    BLOBSUMXY = 9;
    BLOBMINX = 10;
    BLOBMAXX = 11;
    BLOBMINY = 12;
    BLOBMAXY = 13;
    BLOBDATACOUNT = 14;
    int[] arrayOfInt1 = { BLOBROWCOUNT, BLOBCOLCOUNT };
    LabelMat = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt1);
    int[] arrayOfInt2 = { BLOBTOTALCOUNT, BLOBDATACOUNT };
    RegionData = (double[][])Array.newInstance(Double.TYPE, arrayOfInt2);
    SubsumedLabel = new int[BLOBTOTALCOUNT];
  }
  
  public static int NextRegion(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    double d1 = paramInt1;
    double d2 = paramInt2;
    if (d2 > 0.0D) {
      d2 = 1.0D;
    }
    int i = paramInt3;
    if (i <= MaxLabel)
    {
      double[] arrayOfDouble = RegionData[i];
      double d3 = arrayOfDouble[BLOBPARENT];
      double d4 = arrayOfDouble[BLOBCOLOR];
      if ((d1 >= 0.0D) && (d1 != d3)) {}
      while (((d2 >= 0.0D) && (d2 != d4)) || (arrayOfDouble[BLOBAREA] < paramDouble1) || (arrayOfDouble[BLOBAREA] > paramDouble2))
      {
        i++;
        break;
      }
    }
    if (i > MaxLabel) {
      i = -1;
    }
    return i;
  }
  
  public static int PriorRegion(int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, int paramInt3)
  {
    double d1 = paramInt1;
    double d2 = paramInt2;
    if (d2 > 0.0D) {
      d2 = 1.0D;
    }
    int i = paramInt3;
    if (i >= 0)
    {
      double[] arrayOfDouble = RegionData[i];
      double d3 = arrayOfDouble[BLOBPARENT];
      double d4 = arrayOfDouble[BLOBCOLOR];
      if ((d1 >= 0.0D) && (d1 != d3)) {}
      while (((d2 >= 0.0D) && (d2 != d4)) || (arrayOfDouble[BLOBAREA] < paramDouble1) || (arrayOfDouble[BLOBAREA] > paramDouble2))
      {
        i--;
        break;
      }
    }
    if (i < 0) {
      i = -1;
    }
    return i;
  }
  
  public static void SortRegions(int paramInt)
  {
    for (int i = 0; i < MaxLabel; i++) {
      for (int j = i + 1; j <= MaxLabel; j++)
      {
        iProperty = RegionData[i];
        jProperty = RegionData[j];
        iField = iProperty[paramInt];
        jField = jProperty[paramInt];
        if (iField > jField)
        {
          RegionData[i] = jProperty;
          RegionData[j] = iProperty;
        }
      }
    }
  }
  
  public static int SubsumptionChain(int paramInt)
  {
    return SubsumptionChain(paramInt, 0);
  }
  
  public static int SubsumptionChain(int paramInt1, int paramInt2)
  {
    String str = "";
    if (paramInt2 > 0) {
      str = "Subsumption chain for " + paramInt1 + ": ";
    }
    int i = paramInt1;
    for (;;)
    {
      if (paramInt1 > -1)
      {
        i = paramInt1;
        if (paramInt2 > 0) {
          str = str + " " + paramInt1;
        }
        if (paramInt1 != 0) {}
      }
      else
      {
        if (paramInt2 > 0) {
          System.out.println(str);
        }
        return i;
      }
      paramInt1 = SubsumedLabel[paramInt1];
    }
  }
  
  public int BlobAnalysis(opencv_core.IplImage paramIplImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    opencv_core.CvMat localCvMat = paramIplImage.asCvMat();
    int i = localCvMat.cols();
    int j = localCvMat.rows();
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    if (paramInt2 < 0) {
      paramInt2 = 0;
    }
    if (paramInt3 < 0) {
      paramInt3 = i;
    }
    if (paramInt4 < 0) {
      paramInt4 = j;
    }
    if (paramInt1 + paramInt3 > i) {
      paramInt3 = i - paramInt1;
    }
    if (paramInt2 + paramInt4 > j) {
      paramInt4 = j - paramInt2;
    }
    int k = BLOBCOLCOUNT;
    if (paramInt3 <= k)
    {
      int m = BLOBROWCOUNT;
      if (paramInt4 <= m) {}
    }
    else
    {
      System.out.println("Error in Class Blobs: Image too large: Edit Blobs.java");
      System.exit(666);
      return 0;
    }
    int n = 0;
    if (paramInt5 > 0) {
      n = 1;
    }
    this.LabelD = 0;
    this.LabelC = 0;
    this.LabelB = 0;
    this.LabelA = 0;
    this.ColorD = n;
    this.ColorC = n;
    this.ColorB = n;
    this.ColorA = n;
    for (int i1 = 0;; i1++)
    {
      int i2 = BLOBTOTALCOUNT;
      if (i1 >= i2) {
        break;
      }
      SubsumedLabel[i1] = -1;
    }
    MaxLabel = 0;
    double[] arrayOfDouble1 = RegionData[0];
    arrayOfDouble1[BLOBLABEL] = 0.0D;
    arrayOfDouble1[BLOBPARENT] = -1.0D;
    arrayOfDouble1[BLOBAREA] = (4 + (paramInt4 + paramInt3));
    arrayOfDouble1[BLOBCOLOR] = n;
    arrayOfDouble1[BLOBSUMX] = (0.5D * ((2.0D + paramInt3) * (paramInt3 - 1.0D)) - paramInt4 - 1.0D);
    arrayOfDouble1[BLOBSUMY] = (0.5D * ((2.0D + paramInt4) * (paramInt4 - 1.0D)) - paramInt3 - 1.0D);
    arrayOfDouble1[BLOBMINX] = -1.0D;
    arrayOfDouble1[BLOBMINY] = -1.0D;
    arrayOfDouble1[BLOBMAXX] = (1.0D + paramInt3);
    arrayOfDouble1[BLOBMAXY] = (1.0D + paramInt4);
    System.arraycopy(arrayOfDouble1, 0, RegionData[0], 0, BLOBDATACOUNT);
    for (int i3 = paramInt2;; i3++)
    {
      int i4 = paramInt2 + paramInt4;
      if (i3 >= i4) {
        break;
      }
      this.jrow = (i3 - paramInt2);
      int i33 = paramInt1;
      int i34 = paramInt1 + paramInt3;
      if (i33 < i34)
      {
        this.jcol = (i33 - paramInt1);
        this.ColorC = n;
        this.ColorB = n;
        this.ColorA = n;
        this.LabelD = 0;
        this.LabelC = 0;
        this.LabelB = 0;
        this.LabelA = 0;
        this.ColorD = ((int)localCvMat.get(this.jrow, this.jcol));
        label576:
        int i35;
        if ((this.jrow == 0) || (this.jcol == 0))
        {
          if (this.jcol > 0)
          {
            this.ColorC = ((int)localCvMat.get(this.jrow, -1 + this.jcol));
            this.LabelC = LabelMat[this.jrow][(-1 + this.jcol)];
          }
          if (this.jrow > 0)
          {
            this.ColorB = ((int)localCvMat.get(-1 + this.jrow, this.jcol));
            this.LabelB = LabelMat[(-1 + this.jrow)][this.jcol];
          }
          if (this.ColorA > 0) {
            this.ColorA = 1;
          }
          if (this.ColorB > 0) {
            this.ColorB = 1;
          }
          if (this.ColorC > 0) {
            this.ColorC = 1;
          }
          if (this.ColorD > 0) {
            this.ColorD = 1;
          }
          if (this.ColorA != this.ColorB) {
            break label957;
          }
          if (this.ColorC != this.ColorD) {
            break label933;
          }
          if (this.ColorA != this.ColorC) {
            break label927;
          }
          i35 = 1;
          label660:
          if (i35 != 1) {
            break label1016;
          }
          OldRegion(this.LabelC, -1, -1);
          label676:
          if (((this.jrow == paramInt4) || (this.jcol == paramInt3)) && (this.ColorD == n))
          {
            if (this.jcol >= paramInt3) {
              break label1243;
            }
            if (this.ColorC != n)
            {
              int i37 = SubsumptionChain(this.LabelB);
              SubsumedLabel[i37] = 0;
            }
          }
        }
        for (;;)
        {
          OldRegion(0, -1, -1);
          LabelMat[this.jrow][this.jcol] = this.LabelD;
          i33++;
          break;
          this.ColorA = ((int)localCvMat.get(-1 + this.jrow, -1 + this.jcol));
          if (this.ColorA > 0) {
            this.ColorA = 1;
          }
          this.ColorB = ((int)localCvMat.get(-1 + this.jrow, this.jcol));
          if (this.ColorB > 0) {
            this.ColorB = 1;
          }
          this.ColorC = ((int)localCvMat.get(this.jrow, -1 + this.jcol));
          if (this.ColorC > 0) {
            this.ColorC = 1;
          }
          this.LabelA = LabelMat[(-1 + this.jrow)][(-1 + this.jcol)];
          this.LabelB = LabelMat[(-1 + this.jrow)][this.jcol];
          this.LabelC = LabelMat[this.jrow][(-1 + this.jcol)];
          break label576;
          label927:
          i35 = 2;
          break label660;
          label933:
          if (this.ColorA == this.ColorC)
          {
            i35 = 5;
            break label660;
          }
          i35 = 6;
          break label660;
          label957:
          if (this.ColorC == this.ColorD)
          {
            if (this.ColorA == this.ColorC)
            {
              i35 = 3;
              break label660;
            }
            i35 = 4;
            break label660;
          }
          if (this.ColorA == this.ColorC)
          {
            i35 = 7;
            break label660;
          }
          i35 = 8;
          break label660;
          label1016:
          if ((i35 == 2) || (i35 == 3))
          {
            OldRegion(this.LabelC, this.LabelB, this.LabelC);
            break label676;
          }
          if ((i35 == 5) || (i35 == 8))
          {
            if (((this.jrow == paramInt4) || (this.jcol == paramInt3)) && (this.ColorD == n))
            {
              OldRegion(0, -1, -1);
              break label676;
            }
            NewRegion(this.LabelB);
            break label676;
          }
          if ((i35 == 6) || (i35 == 7))
          {
            OldRegion(this.LabelB, this.LabelB, this.LabelC);
            break label676;
          }
          int i38 = SubsumptionChain(this.LabelB);
          int i39 = SubsumptionChain(this.LabelC);
          int i40 = Math.min(i38, i39);
          if (i38 < i39) {
            OldRegion(this.LabelB, -1, -1);
          }
          for (int i41 = this.LabelC; i40 < i41; i41 = this.LabelB)
          {
            label1194:
            int i42 = SubsumedLabel[i41];
            SubsumedLabel[i41] = i40;
            i41 = i42;
            break label1194;
            OldRegion(this.LabelC, -1, -1);
          }
          break label676;
          label1243:
          if ((this.jrow < paramInt4) && (this.ColorB != n))
          {
            int i36 = SubsumptionChain(this.LabelC);
            SubsumedLabel[i36] = 0;
          }
        }
      }
    }
    int i5 = 0;
    for (int i6 = 1; i6 <= MaxLabel; i6++)
    {
      if (SubsumedLabel[i6] > -1) {
        i5++;
      }
      CondensationMap[i6] = (i6 - i5);
    }
    for (int i7 = 1; i7 <= MaxLabel; i7++)
    {
      int i32 = SubsumptionChain(i7);
      if (i32 != i7) {
        Subsume(i32, i7, 1);
      }
    }
    int i8 = 0;
    for (int i9 = 1;; i9++)
    {
      int i10 = MaxLabel;
      if (i9 > i10) {
        break;
      }
      if (SubsumedLabel[i9] < 0)
      {
        double[] arrayOfDouble6 = RegionData[i9];
        int i28 = (int)arrayOfDouble6[BLOBPARENT];
        int i29 = CondensationMap[i9];
        int i30 = SubsumptionChain(i28);
        int i31 = CondensationMap[i30];
        arrayOfDouble6[BLOBLABEL] = i29;
        arrayOfDouble6[BLOBPARENT] = i31;
        System.arraycopy(arrayOfDouble6, 0, RegionData[i29], 0, BLOBDATACOUNT);
        i8 = i29;
      }
    }
    for (int i11 = i8 + 1; i11 <= MaxLabel; i11++) {
      ResetRegion(i11);
    }
    MaxLabel = i8;
    int i12 = MaxLabel;
    if (i12 > 0)
    {
      double[] arrayOfDouble5 = RegionData[i12];
      if ((int)arrayOfDouble5[BLOBAREA] < paramInt6)
      {
        int i27 = (int)arrayOfDouble5[BLOBPARENT];
        SubsumedLabel[i12] = i27;
      }
      for (;;)
      {
        i12--;
        break;
        SubsumedLabel[i12] = -1;
      }
    }
    int i13 = 0;
    for (int i14 = 1; i14 <= MaxLabel; i14++)
    {
      if (SubsumedLabel[i14] > -1) {
        i13++;
      }
      CondensationMap[i14] = (i14 - i13);
    }
    for (int i15 = 1; i15 <= MaxLabel; i15++)
    {
      int i26 = SubsumptionChain(i15);
      if (i26 != i15) {
        Subsume(i26, i15, -1);
      }
    }
    for (int i16 = 1;; i16++)
    {
      int i17 = MaxLabel;
      if (i16 > i17) {
        break;
      }
      if (SubsumedLabel[i16] < 0)
      {
        double[] arrayOfDouble4 = RegionData[i16];
        int i22 = (int)arrayOfDouble4[BLOBPARENT];
        int i23 = CondensationMap[i16];
        int i24 = SubsumptionChain(i22);
        int i25 = CondensationMap[i24];
        arrayOfDouble4[BLOBLABEL] = i23;
        arrayOfDouble4[BLOBPARENT] = i25;
        System.arraycopy(arrayOfDouble4, 0, RegionData[i23], 0, BLOBDATACOUNT);
        i8 = i23;
      }
    }
    for (int i18 = i8 + 1; i18 <= MaxLabel; i18++) {
      ResetRegion(i18);
    }
    MaxLabel = i8;
    for (int i19 = 0; i19 <= MaxLabel; i19++)
    {
      double[] arrayOfDouble3 = RegionData[i19];
      double d1 = arrayOfDouble3[BLOBAREA];
      double d2 = arrayOfDouble3[BLOBSUMX];
      double d3 = arrayOfDouble3[BLOBSUMY];
      double d4 = arrayOfDouble3[BLOBSUMXX];
      double d5 = arrayOfDouble3[BLOBSUMYY];
      double d6 = arrayOfDouble3[BLOBSUMXY];
      double d7 = d2 / d1;
      double d8 = d3 / d1;
      double d9 = d4 / d1;
      double d10 = d5 / d1;
      double d11 = d6 / d1;
      double d12 = d9 - d7 * d7;
      double d13 = d10 - d8 * d8;
      double d14 = d11 - d7 * d8;
      if ((d14 > -1.0E-14D) && (d14 < 1.0E-14D)) {
        d14 = 0.0D;
      }
      arrayOfDouble3[BLOBSUMX] = d7;
      arrayOfDouble3[BLOBSUMY] = d8;
      arrayOfDouble3[BLOBSUMXX] = d12;
      arrayOfDouble3[BLOBSUMYY] = d13;
      arrayOfDouble3[BLOBSUMXY] = d14;
      System.arraycopy(arrayOfDouble3, 0, RegionData[i19], 0, BLOBDATACOUNT);
    }
    double[] arrayOfDouble2 = RegionData[0];
    int i20 = BLOBSUMXX;
    int i21 = BLOBSUMYY;
    arrayOfDouble2[BLOBSUMXY] = 0.0D;
    arrayOfDouble2[i21] = 0.0D;
    arrayOfDouble2[i20] = 0.0D;
    System.arraycopy(arrayOfDouble2, 0, RegionData[0], 0, BLOBDATACOUNT);
    return MaxLabel;
  }
  
  public void NewRegion(int paramInt)
  {
    int i = 1 + MaxLabel;
    MaxLabel = i;
    this.LabelD = i;
    double[] arrayOfDouble1 = RegionData[this.LabelD];
    arrayOfDouble1[BLOBLABEL] = this.LabelD;
    arrayOfDouble1[BLOBPARENT] = paramInt;
    arrayOfDouble1[BLOBCOLOR] = this.ColorD;
    arrayOfDouble1[BLOBAREA] = 1.0D;
    arrayOfDouble1[BLOBPERIMETER] = 2.0D;
    arrayOfDouble1[BLOBSUMX] = this.jcol;
    arrayOfDouble1[BLOBSUMY] = this.jrow;
    arrayOfDouble1[BLOBSUMXX] = (this.jcol * this.jcol);
    arrayOfDouble1[BLOBSUMYY] = (this.jrow * this.jrow);
    arrayOfDouble1[BLOBSUMXY] = (this.jcol * this.jrow);
    arrayOfDouble1[BLOBMINX] = this.jcol;
    arrayOfDouble1[BLOBMAXX] = this.jcol;
    arrayOfDouble1[BLOBMINY] = this.jrow;
    arrayOfDouble1[BLOBMAXY] = this.jrow;
    System.arraycopy(arrayOfDouble1, 0, RegionData[this.LabelD], 0, BLOBDATACOUNT);
    SubsumedLabel[this.LabelD] = -1;
    double[] arrayOfDouble2 = RegionData[this.LabelB];
    int j = BLOBPERIMETER;
    arrayOfDouble2[j] = (1.0D + arrayOfDouble2[j]);
    System.arraycopy(arrayOfDouble2, 0, RegionData[this.LabelB], 0, BLOBDATACOUNT);
    double[] arrayOfDouble3 = RegionData[this.LabelC];
    int k = BLOBPERIMETER;
    arrayOfDouble3[k] = (1.0D + arrayOfDouble3[k]);
    System.arraycopy(arrayOfDouble3, 0, RegionData[this.LabelC], 0, BLOBDATACOUNT);
  }
  
  public void OldRegion(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    if (paramInt2 >= 0)
    {
      i = 0;
      if (paramInt2 != paramInt1)
      {
        i = 0 + 1;
        double[] arrayOfDouble3 = RegionData[paramInt2];
        int i7 = BLOBPERIMETER;
        arrayOfDouble3[i7] = (1.0D + arrayOfDouble3[i7]);
        System.arraycopy(arrayOfDouble3, 0, RegionData[paramInt2], 0, BLOBDATACOUNT);
      }
    }
    if ((paramInt3 >= 0) && (paramInt3 != paramInt1))
    {
      i++;
      double[] arrayOfDouble2 = RegionData[paramInt3];
      int i6 = BLOBPERIMETER;
      arrayOfDouble2[i6] = (1.0D + arrayOfDouble2[i6]);
      System.arraycopy(arrayOfDouble2, 0, RegionData[paramInt3], 0, BLOBDATACOUNT);
    }
    this.LabelD = paramInt1;
    double[] arrayOfDouble1 = RegionData[this.LabelD];
    arrayOfDouble1[BLOBLABEL] = this.LabelD;
    int j = BLOBPARENT;
    arrayOfDouble1[j] = (0.0D + arrayOfDouble1[j]);
    int k = BLOBCOLOR;
    arrayOfDouble1[k] = (0.0D + arrayOfDouble1[k]);
    int m = BLOBAREA;
    arrayOfDouble1[m] = (1.0D + arrayOfDouble1[m]);
    int n = BLOBPERIMETER;
    arrayOfDouble1[n] += i;
    int i1 = BLOBSUMX;
    arrayOfDouble1[i1] += this.jcol;
    int i2 = BLOBSUMY;
    arrayOfDouble1[i2] += this.jrow;
    int i3 = BLOBSUMXX;
    arrayOfDouble1[i3] += this.jcol * this.jcol;
    int i4 = BLOBSUMYY;
    arrayOfDouble1[i4] += this.jrow * this.jrow;
    int i5 = BLOBSUMXY;
    arrayOfDouble1[i5] += this.jcol * this.jrow;
    arrayOfDouble1[BLOBMINX] = Math.min(arrayOfDouble1[BLOBMINX], this.jcol);
    arrayOfDouble1[BLOBMAXX] = Math.max(arrayOfDouble1[BLOBMAXX], this.jcol);
    arrayOfDouble1[BLOBMINY] = Math.min(arrayOfDouble1[BLOBMINY], this.jrow);
    arrayOfDouble1[BLOBMAXY] = Math.max(arrayOfDouble1[BLOBMAXY], this.jrow);
    System.arraycopy(arrayOfDouble1, 0, RegionData[this.LabelD], 0, BLOBDATACOUNT);
  }
  
  public void PrintRegionData()
  {
    PrintRegionData(0, MaxLabel);
  }
  
  public void PrintRegionData(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    int i = MaxLabel;
    if (paramInt2 > i) {
      paramInt2 = MaxLabel;
    }
    if (paramInt2 < paramInt1) {
      return;
    }
    for (int j = paramInt1; j <= paramInt2; j++)
    {
      double[] arrayOfDouble = RegionData[j];
      int k = (int)arrayOfDouble[BLOBLABEL];
      int m = (int)arrayOfDouble[BLOBPARENT];
      int n = (int)arrayOfDouble[BLOBCOLOR];
      double d1 = arrayOfDouble[BLOBAREA];
      double d2 = arrayOfDouble[BLOBPERIMETER];
      double d3 = arrayOfDouble[BLOBSUMX];
      double d4 = arrayOfDouble[BLOBSUMY];
      double d5 = arrayOfDouble[BLOBSUMXX];
      double d6 = arrayOfDouble[BLOBSUMYY];
      double d7 = arrayOfDouble[BLOBSUMXY];
      int i1 = (int)arrayOfDouble[BLOBMINX];
      int i2 = (int)arrayOfDouble[BLOBMAXX];
      int i3 = (int)arrayOfDouble[BLOBMINY];
      int i4 = (int)arrayOfDouble[BLOBMAXY];
      String str1 = " " + j + ": L[" + k + "] P[" + m + "] C[" + n + "]";
      String str2 = " AP[" + d1 + ", " + d2 + "]";
      String str3 = " M1[" + d3 + ", " + d4 + "] M2[" + d5 + ", " + d6 + ", " + d7 + "]";
      String str4 = " MINMAX[" + i1 + ", " + i2 + ", " + i3 + ", " + i4 + "]";
      String str5 = str1 + str2 + str3 + str4;
      System.out.println(str5);
    }
    System.out.println();
  }
  
  public void ResetRegion(int paramInt)
  {
    double[] arrayOfDouble = RegionData[paramInt];
    int i = BLOBLABEL;
    int j = BLOBPARENT;
    int k = BLOBCOLOR;
    int m = BLOBAREA;
    int n = BLOBPERIMETER;
    int i1 = BLOBSUMX;
    int i2 = BLOBSUMY;
    int i3 = BLOBSUMXX;
    int i4 = BLOBSUMYY;
    int i5 = BLOBSUMXY;
    int i6 = BLOBMINX;
    int i7 = BLOBMAXX;
    int i8 = BLOBMINY;
    arrayOfDouble[BLOBMAXY] = 0.0D;
    arrayOfDouble[i8] = 0.0D;
    arrayOfDouble[i7] = 0.0D;
    arrayOfDouble[i6] = 0.0D;
    arrayOfDouble[i5] = 0.0D;
    arrayOfDouble[i4] = 0.0D;
    arrayOfDouble[i3] = 0.0D;
    arrayOfDouble[i2] = 0.0D;
    arrayOfDouble[i1] = 0.0D;
    arrayOfDouble[n] = 0.0D;
    arrayOfDouble[m] = 0.0D;
    arrayOfDouble[k] = 0.0D;
    arrayOfDouble[j] = 0.0D;
    arrayOfDouble[i] = 0.0D;
    System.arraycopy(arrayOfDouble, 0, RegionData[paramInt], 0, BLOBDATACOUNT);
  }
  
  public void Subsume(int paramInt1, int paramInt2, int paramInt3)
  {
    this.LabelD = paramInt1;
    double[] arrayOfDouble1 = RegionData[paramInt1];
    double[] arrayOfDouble2 = RegionData[paramInt2];
    arrayOfDouble1[BLOBLABEL] = arrayOfDouble1[BLOBLABEL];
    arrayOfDouble1[BLOBPARENT] = arrayOfDouble1[BLOBPARENT];
    arrayOfDouble1[BLOBCOLOR] = arrayOfDouble1[BLOBCOLOR];
    int i = BLOBAREA;
    arrayOfDouble1[i] += arrayOfDouble2[BLOBAREA];
    int j = BLOBPERIMETER;
    arrayOfDouble1[j] += arrayOfDouble2[BLOBPERIMETER] * paramInt3;
    int k = BLOBSUMX;
    arrayOfDouble1[k] += arrayOfDouble2[BLOBSUMX];
    int m = BLOBSUMY;
    arrayOfDouble1[m] += arrayOfDouble2[BLOBSUMY];
    int n = BLOBSUMXX;
    arrayOfDouble1[n] += arrayOfDouble2[BLOBSUMXX];
    int i1 = BLOBSUMYY;
    arrayOfDouble1[i1] += arrayOfDouble2[BLOBSUMYY];
    int i2 = BLOBSUMXY;
    arrayOfDouble1[i2] += arrayOfDouble2[BLOBSUMXY];
    arrayOfDouble1[BLOBMINX] = Math.min(arrayOfDouble1[BLOBMINX], arrayOfDouble2[BLOBMINX]);
    arrayOfDouble1[BLOBMAXX] = Math.max(arrayOfDouble1[BLOBMAXX], arrayOfDouble2[BLOBMAXX]);
    arrayOfDouble1[BLOBMINY] = Math.min(arrayOfDouble1[BLOBMINY], arrayOfDouble2[BLOBMINY]);
    arrayOfDouble1[BLOBMAXY] = Math.max(arrayOfDouble1[BLOBMAXY], arrayOfDouble2[BLOBMAXY]);
    System.arraycopy(arrayOfDouble1, 0, RegionData[paramInt1], 0, BLOBDATACOUNT);
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\Blobs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */