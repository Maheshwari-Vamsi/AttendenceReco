package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvBox2D;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvPoint2D32f;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.CvSize2D32f;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.IplROI;
import com.googlecode.javacv.cpp.opencv_imgproc;
import com.googlecode.javacv.cpp.opencv_imgproc.CvMoments;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

public class JavaCV
{
  private static ThreadLocal<opencv_core.CvMat> A3x3;
  private static ThreadLocal<opencv_core.CvMat> A8x8;
  public static final double DBL_EPSILON = 2.220446049250313E-16D;
  public static final double FLT_EPSILON = 1.1920928955078125E-7D;
  private static ThreadLocal<opencv_core.CvMat> H13x3;
  private static ThreadLocal<opencv_core.CvMat> H23x3;
  private static ThreadLocal<opencv_core.CvMat> H3x3;
  private static ThreadLocal<opencv_core.CvMat> M3x2;
  private static ThreadLocal<opencv_core.CvMat> R13x3;
  private static ThreadLocal<opencv_core.CvMat> R23x3;
  private static ThreadLocal<opencv_core.CvMat> S2x2;
  private static ThreadLocal<opencv_core.CvMat> S3x3;
  public static final double SQRT2 = 1.4142135623730951D;
  private static ThreadLocal<opencv_core.CvMat> U3x2;
  private static ThreadLocal<opencv_core.CvMat> U3x3;
  private static ThreadLocal<opencv_core.CvMat> V2x2;
  private static ThreadLocal<opencv_core.CvMat> V3x3;
  private static ThreadLocal<opencv_core.CvMat> b3x1;
  private static ThreadLocal<opencv_core.CvMat> b8x1;
  private static ThreadLocal<opencv_imgproc.CvMoments> moments;
  private static ThreadLocal<opencv_core.CvMat> n13x1;
  private static ThreadLocal<opencv_core.CvMat> n23x1;
  private static ThreadLocal<opencv_core.CvMat> n3x1;
  private static ThreadLocal<opencv_core.CvMat> t13x1;
  private static ThreadLocal<opencv_core.CvMat> t23x1;
  private static ThreadLocal<opencv_core.CvMat> x8x1;
  
  static
  {
    if (!JavaCV.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      moments = opencv_imgproc.CvMoments.createThreadLocal();
      A8x8 = opencv_core.CvMat.createThreadLocal(8, 8);
      b8x1 = opencv_core.CvMat.createThreadLocal(8, 1);
      x8x1 = opencv_core.CvMat.createThreadLocal(8, 1);
      A3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      b3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      n3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      H3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      M3x2 = opencv_core.CvMat.createThreadLocal(3, 2);
      S2x2 = opencv_core.CvMat.createThreadLocal(2, 2);
      U3x2 = opencv_core.CvMat.createThreadLocal(3, 2);
      V2x2 = opencv_core.CvMat.createThreadLocal(2, 2);
      R13x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      R23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      t13x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      t23x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      n13x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      n23x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      H13x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      H23x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      S3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      U3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      V3x3 = opencv_core.CvMat.createThreadLocal(3, 3);
      return;
    }
  }
  
  public static double HnToRt(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)S3x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)U3x3.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)V3x3.get();
    opencv_core.cvSVD(paramCvMat1, localCvMat1, localCvMat2, localCvMat3, 0);
    opencv_core.CvMat localCvMat4 = (opencv_core.CvMat)R13x3.get();
    opencv_core.CvMat localCvMat5 = (opencv_core.CvMat)R23x3.get();
    opencv_core.CvMat localCvMat6 = (opencv_core.CvMat)t13x1.get();
    opencv_core.CvMat localCvMat7 = (opencv_core.CvMat)t23x1.get();
    opencv_core.CvMat localCvMat8 = (opencv_core.CvMat)n13x1.get();
    opencv_core.CvMat localCvMat9 = (opencv_core.CvMat)n23x1.get();
    opencv_core.CvMat localCvMat10 = (opencv_core.CvMat)H13x3.get();
    opencv_core.CvMat localCvMat11 = (opencv_core.CvMat)H23x3.get();
    homogToRt(localCvMat1, localCvMat2, localCvMat3, localCvMat4, localCvMat6, localCvMat8, localCvMat5, localCvMat7, localCvMat9);
    opencv_core.cvGEMM(localCvMat4, paramCvMat1, 1.0D / localCvMat1.get(4), null, 0.0D, localCvMat10, 1);
    opencv_core.cvGEMM(localCvMat5, paramCvMat1, 1.0D / localCvMat1.get(4), null, 0.0D, localCvMat11, 1);
    localCvMat10.put(0, localCvMat10.get(0) - 1.0D);
    localCvMat10.put(4, localCvMat10.get(4) - 1.0D);
    localCvMat10.put(8, localCvMat10.get(8) - 1.0D);
    localCvMat11.put(0, localCvMat11.get(0) - 1.0D);
    localCvMat11.put(4, localCvMat11.get(4) - 1.0D);
    localCvMat11.put(8, localCvMat11.get(8) - 1.0D);
    double d1 = Math.abs(paramCvMat2.get(0)) + Math.abs(paramCvMat2.get(1)) + Math.abs(paramCvMat2.get(2));
    double[] arrayOfDouble = new double[3];
    arrayOfDouble[0] = (-Math.signum(paramCvMat2.get(0)));
    arrayOfDouble[1] = (-Math.signum(paramCvMat2.get(1)));
    arrayOfDouble[2] = (-Math.signum(paramCvMat2.get(2)));
    localCvMat6.put(new double[] { 0.0D, 0.0D, 0.0D });
    localCvMat7.put(new double[] { 0.0D, 0.0D, 0.0D });
    for (int i = 0; i < 3; i++)
    {
      localCvMat6.put(0, localCvMat6.get(0) + arrayOfDouble[i] * localCvMat10.get(i) / d1);
      localCvMat6.put(1, localCvMat6.get(1) + arrayOfDouble[i] * localCvMat10.get(i + 3) / d1);
      localCvMat6.put(2, localCvMat6.get(2) + arrayOfDouble[i] * localCvMat10.get(i + 6) / d1);
      localCvMat7.put(0, localCvMat7.get(0) + arrayOfDouble[i] * localCvMat11.get(i) / d1);
      localCvMat7.put(1, localCvMat7.get(1) + arrayOfDouble[i] * localCvMat11.get(i + 3) / d1);
      localCvMat7.put(2, localCvMat7.get(2) + arrayOfDouble[i] * localCvMat11.get(i + 6) / d1);
    }
    opencv_core.cvGEMM(localCvMat6, paramCvMat2, 1.0D, localCvMat10, 1.0D, localCvMat10, 2);
    opencv_core.cvGEMM(localCvMat7, paramCvMat2, 1.0D, localCvMat11, 1.0D, localCvMat11, 2);
    double d2 = opencv_core.cvNorm(localCvMat10);
    double d3 = opencv_core.cvNorm(localCvMat11);
    if (d2 < d3)
    {
      if (paramCvMat3 != null) {
        paramCvMat3.put(localCvMat4);
      }
      if (paramCvMat4 != null) {
        paramCvMat4.put(localCvMat6);
      }
      return d2;
    }
    if (paramCvMat3 != null) {
      paramCvMat3.put(localCvMat5);
    }
    if (paramCvMat4 != null) {
      paramCvMat4.put(localCvMat7);
    }
    return d3;
  }
  
  public static void HtoRt(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)M3x2.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)S2x2.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)U3x2.get();
    opencv_core.CvMat localCvMat4 = (opencv_core.CvMat)V2x2.get();
    double[] arrayOfDouble1 = new double[6];
    arrayOfDouble1[0] = paramCvMat1.get(0);
    arrayOfDouble1[1] = paramCvMat1.get(1);
    arrayOfDouble1[2] = paramCvMat1.get(3);
    arrayOfDouble1[3] = paramCvMat1.get(4);
    arrayOfDouble1[4] = paramCvMat1.get(6);
    arrayOfDouble1[5] = paramCvMat1.get(7);
    localCvMat1.put(arrayOfDouble1);
    opencv_core.cvSVD(localCvMat1, localCvMat2, localCvMat3, localCvMat4, 4);
    double d = localCvMat2.get(3);
    double[] arrayOfDouble2 = new double[3];
    arrayOfDouble2[0] = (paramCvMat1.get(2) / d);
    arrayOfDouble2[1] = (paramCvMat1.get(5) / d);
    arrayOfDouble2[2] = (paramCvMat1.get(8) / d);
    paramCvMat3.put(arrayOfDouble2);
    opencv_core.cvMatMul(localCvMat3, localCvMat4, localCvMat1);
    double[] arrayOfDouble3 = new double[9];
    arrayOfDouble3[0] = localCvMat1.get(0);
    arrayOfDouble3[1] = localCvMat1.get(1);
    arrayOfDouble3[2] = (localCvMat1.get(2) * localCvMat1.get(5) - localCvMat1.get(3) * localCvMat1.get(4));
    arrayOfDouble3[3] = localCvMat1.get(2);
    arrayOfDouble3[4] = localCvMat1.get(3);
    arrayOfDouble3[5] = (localCvMat1.get(1) * localCvMat1.get(4) - localCvMat1.get(0) * localCvMat1.get(5));
    arrayOfDouble3[6] = localCvMat1.get(4);
    arrayOfDouble3[7] = localCvMat1.get(5);
    arrayOfDouble3[8] = (localCvMat1.get(0) * localCvMat1.get(3) - localCvMat1.get(1) * localCvMat1.get(2));
    paramCvMat2.put(arrayOfDouble3);
  }
  
  public static void adaptiveThreshold(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.IplImage paramIplImage3, opencv_core.IplImage paramIplImage4, final boolean paramBoolean, final int paramInt1, final int paramInt2, double paramDouble1, final double paramDouble2)
  {
    int i = paramIplImage1.width();
    final int j = paramIplImage1.height();
    int k = paramIplImage1.nChannels();
    int m = paramIplImage1.depth();
    int n = paramIplImage4.depth();
    if ((k > 1) && (n == 8)) {
      if (k != 4) {
        break label292;
      }
    }
    label292:
    for (int i5 = 11;; i5 = 6)
    {
      opencv_imgproc.cvCvtColor(paramIplImage1, paramIplImage4, i5);
      paramIplImage1 = paramIplImage4;
      final ByteBuffer localByteBuffer1 = paramIplImage1.getByteBuffer();
      final ByteBuffer localByteBuffer2 = paramIplImage4.getByteBuffer();
      final DoubleBuffer localDoubleBuffer1 = paramIplImage2.getDoubleBuffer();
      final DoubleBuffer localDoubleBuffer2 = paramIplImage3.getDoubleBuffer();
      final int i1 = paramIplImage1.widthStep();
      int i2 = paramIplImage4.widthStep();
      final int i3 = paramIplImage2.widthStep();
      final int i4 = paramIplImage3.widthStep();
      opencv_imgproc.cvIntegral(paramIplImage1, paramIplImage2, paramIplImage3, null);
      double d = (localDoubleBuffer1.get(i3 * (j - 1) / 8 + (i - 1)) - localDoubleBuffer1.get(i3 * (j - 1) / 8) - localDoubleBuffer1.get(i - 1) + localDoubleBuffer1.get(0)) / (i * j);
      Parallel.loop(0, j, new Parallel.Looper()
      {
        static
        {
          if (!JavaCV.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            return;
          }
        }
        
        public void loop(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          for (int i = paramAnonymousInt1; i < paramAnonymousInt2; i++)
          {
            int j = 0;
            int k = this.val$w;
            if (j < k)
            {
              double d1 = 0.0D;
              int m = paramInt1;
              int n = paramInt2;
              int i1 = m;
              double d5;
              double d2;
              label358:
              ByteBuffer localByteBuffer2;
              int i3;
              if (m - n > 2)
              {
                int i4 = Math.max(j - i1 / 2, 0);
                int i5 = Math.min(1 + (j + i1 / 2), this.val$w);
                int i6 = Math.max(i - i1 / 2, 0);
                int i7 = Math.min(1 + (i + i1 / 2), j);
                d1 = (localDoubleBuffer1.get(i5 + i7 * i3 / 8) - localDoubleBuffer1.get(i4 + i7 * i3 / 8) - localDoubleBuffer1.get(i5 + i6 * i3 / 8) + localDoubleBuffer1.get(i4 + i6 * i3 / 8)) / (i1 * i1);
                d5 = (localDoubleBuffer2.get(i5 + i7 * i4 / 8) - localDoubleBuffer2.get(i4 + i7 * i4 / 8) - localDoubleBuffer2.get(i5 + i6 * i4 / 8) + localDoubleBuffer2.get(i4 + i6 * i4 / 8)) / (i1 * i1) - d1 * d1;
                if ((i1 != m) || (d5 >= this.val$targetVar)) {}
              }
              else
              {
                d2 = 0.0D;
                if (localByteBuffer1 != 8) {
                  break label469;
                }
                d2 = 0xFF & i1.get(j + i * paramBoolean);
                if (!paramDouble2) {
                  break label557;
                }
                double d4 = 255.0D - (255.0D - d1) * localByteBuffer2;
                localByteBuffer2 = this.val$dstBuf;
                i3 = j + i * this.val$dstStep;
                if (d2 >= d4) {
                  break label551;
                }
              }
              label469:
              label551:
              for (byte b2 = -1;; b2 = 0)
              {
                localByteBuffer2.put(i3, b2);
                j++;
                break;
                if (d5 > this.val$targetVar) {
                  m = i1;
                }
                for (;;)
                {
                  i1 = 1 + 2 * ((n + (m - n) / 2) / 2);
                  break;
                  n = i1;
                }
                if (localByteBuffer1 == 32)
                {
                  d2 = i1.getFloat(i * paramBoolean + j * 4);
                  break label358;
                }
                if (localByteBuffer1 == 64)
                {
                  d2 = i1.getDouble(i * paramBoolean + j * 8);
                  break label358;
                }
                if ($assertionsDisabled) {
                  break label358;
                }
                throw new AssertionError();
              }
              label557:
              double d3 = d1 * localByteBuffer2;
              ByteBuffer localByteBuffer1 = this.val$dstBuf;
              int i2 = j + i * this.val$dstStep;
              if (d2 > d3) {}
              for (byte b1 = -1;; b1 = 0)
              {
                localByteBuffer1.put(i2, b1);
                break;
              }
            }
          }
        }
      });
      return;
    }
  }
  
  public static opencv_core.CvBox2D boundedRect(opencv_core.CvMat paramCvMat, opencv_core.CvBox2D paramCvBox2D)
  {
    int i = paramCvMat.length();
    opencv_imgproc.CvMoments localCvMoments = (opencv_imgproc.CvMoments)moments.get();
    opencv_imgproc.cvMoments(paramCvMat, localCvMoments, 0);
    double d1 = 1.0D / localCvMoments.m00();
    double d2 = d1 * localCvMoments.m10();
    double d3 = d1 * localCvMoments.m01();
    float[] arrayOfFloat = new float[8];
    opencv_core.CvPoint2D32f localCvPoint2D32f = paramCvBox2D.center();
    opencv_core.CvSize2D32f localCvSize2D32f = paramCvBox2D.size();
    localCvPoint2D32f.put(d2, d3);
    opencv_imgproc.cvBoxPoints(paramCvBox2D, arrayOfFloat);
    float f = Float.POSITIVE_INFINITY;
    for (int j = 0; j < 4; j++)
    {
      double d4 = arrayOfFloat[(j * 2)];
      double d5 = arrayOfFloat[(1 + j * 2)];
      for (int k = 0; k < i; k++)
      {
        int m = (k + 1) % i;
        double d6 = paramCvMat.get(k * 2);
        double d7 = paramCvMat.get(1 + k * 2);
        double d8 = paramCvMat.get(m * 2);
        double d9 = paramCvMat.get(1 + m * 2);
        double d10 = (d9 - d7) * (d4 - d2) - (d8 - d6) * (d5 - d3);
        double d11 = ((d8 - d6) * (d3 - d7) - (d9 - d7) * (d2 - d6)) / d10;
        double d12 = ((d4 - d2) * (d3 - d7) - (d5 - d3) * (d2 - d6)) / d10;
        if ((d12 >= 0.0D) && (d12 <= 1.0D) && (d11 >= 0.0D) && (d11 < f)) {
          f = (float)d11;
        }
      }
    }
    localCvSize2D32f.width(f * localCvSize2D32f.width()).height(f * localCvSize2D32f.height());
    return paramCvBox2D;
  }
  
  public static opencv_core.CvRect boundingRect(double[] paramArrayOfDouble, opencv_core.CvRect paramCvRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[1];
    double d3 = paramArrayOfDouble[0];
    double d4 = paramArrayOfDouble[1];
    for (int i = 1; i < paramArrayOfDouble.length / 2; i++)
    {
      double d5 = paramArrayOfDouble[(i * 2)];
      double d6 = paramArrayOfDouble[(1 + i * 2)];
      d1 = Math.min(d1, d5);
      d2 = Math.min(d2, d6);
      d3 = Math.max(d3, d5);
      d4 = Math.max(d4, d6);
    }
    int j = paramInt3 * (int)Math.floor(Math.max(paramCvRect.x(), d1 - paramInt1) / paramInt3);
    int k = paramInt4 * (int)Math.floor(Math.max(paramCvRect.y(), d2 - paramInt2) / paramInt4);
    int m = paramInt3 * (int)Math.ceil(Math.min(paramCvRect.width(), d3 + paramInt1) / paramInt3) - j;
    int n = paramInt4 * (int)Math.ceil(Math.min(paramCvRect.height(), d4 + paramInt2) / paramInt4) - k;
    return paramCvRect.x(j).y(k).width(Math.max(0, m)).height(Math.max(0, n));
  }
  
  public static void clamp(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, double paramDouble1, double paramDouble2)
  {
    ByteBuffer localByteBuffer3;
    ByteBuffer localByteBuffer4;
    int i2;
    switch (paramIplImage1.depth())
    {
    default: 
      if (!$assertionsDisabled) {
        throw new AssertionError();
      }
      break;
    case 8: 
      localByteBuffer3 = paramIplImage1.getByteBuffer();
      localByteBuffer4 = paramIplImage2.getByteBuffer();
      i2 = 0;
    case 16: 
    case 32: 
    case -2147483640: 
    case -2147483632: 
    case -2147483616: 
    case 64: 
      while (i2 < localByteBuffer3.capacity())
      {
        localByteBuffer4.put(i2, (byte)(int)Math.max(Math.min(0xFF & localByteBuffer3.get(i2), paramDouble2), paramDouble1));
        i2++;
        continue;
        ShortBuffer localShortBuffer3 = paramIplImage1.getShortBuffer();
        ShortBuffer localShortBuffer4 = paramIplImage2.getShortBuffer();
        int i1 = 0;
        while (i1 < localShortBuffer3.capacity())
        {
          localShortBuffer4.put(i1, (short)(int)Math.max(Math.min(0xFFFF & localShortBuffer3.get(i1), paramDouble2), paramDouble1));
          i1++;
          continue;
          FloatBuffer localFloatBuffer1 = paramIplImage1.getFloatBuffer();
          FloatBuffer localFloatBuffer2 = paramIplImage2.getFloatBuffer();
          int n = 0;
          while (n < localFloatBuffer1.capacity())
          {
            localFloatBuffer2.put(n, (float)Math.max(Math.min(localFloatBuffer1.get(n), paramDouble2), paramDouble1));
            n++;
            continue;
            ByteBuffer localByteBuffer1 = paramIplImage1.getByteBuffer();
            ByteBuffer localByteBuffer2 = paramIplImage2.getByteBuffer();
            int m = 0;
            while (m < localByteBuffer1.capacity())
            {
              localByteBuffer2.put(m, (byte)(int)Math.max(Math.min(localByteBuffer1.get(m), paramDouble2), paramDouble1));
              m++;
              continue;
              ShortBuffer localShortBuffer1 = paramIplImage1.getShortBuffer();
              ShortBuffer localShortBuffer2 = paramIplImage2.getShortBuffer();
              int k = 0;
              while (k < localShortBuffer1.capacity())
              {
                localShortBuffer2.put(k, (short)(int)Math.max(Math.min(localShortBuffer1.get(k), paramDouble2), paramDouble1));
                k++;
                continue;
                IntBuffer localIntBuffer1 = paramIplImage1.getIntBuffer();
                IntBuffer localIntBuffer2 = paramIplImage2.getIntBuffer();
                int j = 0;
                while (j < localIntBuffer1.capacity())
                {
                  localIntBuffer2.put(j, (int)Math.max(Math.min(localIntBuffer1.get(j), paramDouble2), paramDouble1));
                  j++;
                  continue;
                  DoubleBuffer localDoubleBuffer1 = paramIplImage1.getDoubleBuffer();
                  DoubleBuffer localDoubleBuffer2 = paramIplImage2.getDoubleBuffer();
                  for (int i = 0; i < localDoubleBuffer1.capacity(); i++) {
                    localDoubleBuffer2.put(i, Math.max(Math.min(localDoubleBuffer1.get(i), paramDouble2), paramDouble1));
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static double cond(opencv_core.CvMat paramCvMat)
  {
    return cond(paramCvMat, 2.0D);
  }
  
  public static double cond(opencv_core.CvMat paramCvMat, double paramDouble)
  {
    return cond(paramCvMat, paramDouble, null);
  }
  
  public static double cond(opencv_core.CvMat paramCvMat1, double paramDouble, opencv_core.CvMat paramCvMat2)
  {
    if (paramDouble == 2.0D)
    {
      int k = Math.min(paramCvMat1.rows(), paramCvMat1.cols());
      if ((paramCvMat2 == null) || (paramCvMat2.rows() != k) || (paramCvMat2.cols() != 1)) {
        paramCvMat2 = opencv_core.CvMat.create(k, 1);
      }
      opencv_core.cvSVD(paramCvMat1, paramCvMat2, null, null, 0);
      return paramCvMat2.get(0) / paramCvMat2.get(-1 + paramCvMat2.length());
    }
    int i = paramCvMat1.rows();
    int j = paramCvMat1.cols();
    if ((paramCvMat2 == null) || (paramCvMat2.rows() != i) || (paramCvMat2.cols() != j)) {
      paramCvMat2 = opencv_core.CvMat.create(i, j);
    }
    opencv_core.CvMat localCvMat = paramCvMat2;
    opencv_core.cvInvert(paramCvMat1, localCvMat);
    return norm(paramCvMat1, paramDouble) * norm(localCvMat, paramDouble);
  }
  
  public static double distanceToLine(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    double d1 = paramDouble3 - paramDouble1;
    double d2 = paramDouble4 - paramDouble2;
    double d3 = d1 * d1 + d2 * d2;
    double d4 = (d1 * (paramDouble5 - paramDouble1) + d2 * (paramDouble6 - paramDouble2)) / d3;
    double d5 = paramDouble1 + d4 * d1;
    double d6 = paramDouble2 + d4 * d2;
    double d7 = d5 - paramDouble5;
    double d8 = d6 - paramDouble6;
    return d7 * d7 + d8 * d8;
  }
  
  public static void fractalTriangleWave(opencv_core.IplImage paramIplImage, opencv_core.CvMat paramCvMat)
  {
    fractalTriangleWave(paramIplImage, paramCvMat, -1);
  }
  
  public static void fractalTriangleWave(opencv_core.IplImage paramIplImage, opencv_core.CvMat paramCvMat, int paramInt)
  {
    assert (paramIplImage.depth() == 32);
    double[] arrayOfDouble1 = new double[paramIplImage.width()];
    fractalTriangleWave(arrayOfDouble1, 0, arrayOfDouble1.length / 2, 1.0D, paramInt);
    fractalTriangleWave(arrayOfDouble1, arrayOfDouble1.length / 2, -1 + arrayOfDouble1.length, -1.0D, paramInt);
    double[] arrayOfDouble2 = { Double.MAX_VALUE, Double.MIN_VALUE };
    int i = paramIplImage.height();
    int j = paramIplImage.width();
    int k = paramIplImage.nChannels();
    int m = paramIplImage.widthStep();
    opencv_core.IplROI localIplROI = paramIplImage.roi();
    int n = 0;
    if (localIplROI != null)
    {
      i = paramIplImage.roi().height();
      j = paramIplImage.roi().width();
      n = m * paramIplImage.roi().yOffset() / 4 + k * paramIplImage.roi().xOffset();
    }
    FloatBuffer localFloatBuffer = paramIplImage.getFloatBuffer(n);
    double[] arrayOfDouble3;
    if (paramCvMat == null) {
      arrayOfDouble3 = null;
    }
    label193:
    label398:
    for (int i1 = 0;; i1++)
    {
      if (i1 >= i) {
        break label404;
      }
      for (int i2 = 0;; i2++)
      {
        if (i2 >= j) {
          break label398;
        }
        int i3 = 0;
        if (i3 < k)
        {
          if (arrayOfDouble3 == null) {}
          int i4;
          double d2;
          for (double d3 = 0.0D + arrayOfDouble1[i2];; d3 = 0.0D + (arrayOfDouble1[(i4 % arrayOfDouble1.length)] * (1.0D - d2) + d2 * arrayOfDouble1[((i4 + 1) % arrayOfDouble1.length)]))
          {
            arrayOfDouble2[0] = Math.min(arrayOfDouble2[0], d3);
            arrayOfDouble2[1] = Math.max(arrayOfDouble2[1], d3);
            localFloatBuffer.put(i3 + (i1 * m / 4 + i2 * k), (float)d3);
            i3++;
            break label193;
            arrayOfDouble3 = paramCvMat.get();
            break;
            for (double d1 = (arrayOfDouble3[0] * i2 + arrayOfDouble3[1] * i1 + arrayOfDouble3[2]) / (arrayOfDouble3[6] * i2 + arrayOfDouble3[7] * i1 + arrayOfDouble3[8]); d1 < 0.0D; d1 += arrayOfDouble1.length) {}
            i4 = (int)d1;
            d2 = d1 - i4;
          }
        }
      }
    }
    label404:
    opencv_core.cvConvertScale(paramIplImage, paramIplImage, 1.0D / (arrayOfDouble2[1] - arrayOfDouble2[0]), -arrayOfDouble2[0] / (arrayOfDouble2[1] - arrayOfDouble2[0]));
  }
  
  public static void fractalTriangleWave(double[] paramArrayOfDouble, int paramInt1, int paramInt2, double paramDouble)
  {
    fractalTriangleWave(paramArrayOfDouble, paramInt1, paramInt2, paramDouble, -1);
  }
  
  public static void fractalTriangleWave(double[] paramArrayOfDouble, int paramInt1, int paramInt2, double paramDouble, int paramInt3)
  {
    int i = paramInt1 + (paramInt2 - paramInt1) / 2;
    if ((paramInt1 == paramInt2) || (paramInt1 == i)) {
      return;
    }
    paramArrayOfDouble[i] = (paramDouble + (paramArrayOfDouble[paramInt1] + paramArrayOfDouble[paramInt2]) / 2.0D);
    if ((paramInt3 > 0) && (paramArrayOfDouble.length > paramInt3 * (paramInt2 - paramInt1)))
    {
      fractalTriangleWave(paramArrayOfDouble, paramInt1, i, 0.0D, paramInt3);
      fractalTriangleWave(paramArrayOfDouble, i, paramInt2, 0.0D, paramInt3);
      return;
    }
    fractalTriangleWave(paramArrayOfDouble, paramInt1, i, paramDouble / 1.4142135623730951D, paramInt3);
    fractalTriangleWave(paramArrayOfDouble, i, paramInt2, -paramDouble / 1.4142135623730951D, paramInt3);
  }
  
  public static opencv_core.CvMat getPerspectiveTransform(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)A8x8.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)b8x1.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)x8x1.get();
    for (int i = 0; i < 4; i++)
    {
      localCvMat1.put(0 + i * 8, paramArrayOfDouble1[(i * 2)]);
      localCvMat1.put(3 + 8 * (i + 4), paramArrayOfDouble1[(i * 2)]);
      localCvMat1.put(1 + i * 8, paramArrayOfDouble1[(1 + i * 2)]);
      localCvMat1.put(4 + 8 * (i + 4), paramArrayOfDouble1[(1 + i * 2)]);
      localCvMat1.put(2 + i * 8, 1.0D);
      localCvMat1.put(5 + 8 * (i + 4), 1.0D);
      localCvMat1.put(3 + i * 8, 0.0D);
      localCvMat1.put(4 + i * 8, 0.0D);
      localCvMat1.put(5 + i * 8, 0.0D);
      localCvMat1.put(0 + 8 * (i + 4), 0.0D);
      localCvMat1.put(1 + 8 * (i + 4), 0.0D);
      localCvMat1.put(2 + 8 * (i + 4), 0.0D);
      localCvMat1.put(6 + i * 8, -paramArrayOfDouble1[(i * 2)] * paramArrayOfDouble2[(i * 2)]);
      localCvMat1.put(7 + i * 8, -paramArrayOfDouble1[(1 + i * 2)] * paramArrayOfDouble2[(i * 2)]);
      localCvMat1.put(6 + 8 * (i + 4), -paramArrayOfDouble1[(i * 2)] * paramArrayOfDouble2[(1 + i * 2)]);
      localCvMat1.put(7 + 8 * (i + 4), -paramArrayOfDouble1[(1 + i * 2)] * paramArrayOfDouble2[(1 + i * 2)]);
      localCvMat2.put(i, paramArrayOfDouble2[(i * 2)]);
      localCvMat2.put(i + 4, paramArrayOfDouble2[(1 + i * 2)]);
    }
    opencv_core.cvSolve(localCvMat1, localCvMat2, localCvMat3, 0);
    paramCvMat.put(localCvMat3.get());
    paramCvMat.put(8, 1.0D);
    return paramCvMat;
  }
  
  public static opencv_core.CvMat getPerspectiveTransform(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5)
  {
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)n3x1.get();
    getPlaneParameters(paramArrayOfDouble1, paramArrayOfDouble2, paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4, localCvMat);
    opencv_core.cvGEMM(paramCvMat4, localCvMat, -1.0D, paramCvMat3, 1.0D, paramCvMat5, 2);
    opencv_core.cvMatMul(paramCvMat2, paramCvMat5, paramCvMat5);
    opencv_core.cvMatMul(paramCvMat5, paramCvMat1, paramCvMat5);
    return paramCvMat5;
  }
  
  public static opencv_core.CvMat getPlaneParameters(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)A3x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)b3x1.get();
    double[] arrayOfDouble1 = new double[6];
    double[] arrayOfDouble2 = new double[6];
    perspectiveTransform(paramArrayOfDouble1, arrayOfDouble1, paramCvMat1);
    opencv_core.cvInvert(paramCvMat2, localCvMat1);
    perspectiveTransform(paramArrayOfDouble2, arrayOfDouble2, localCvMat1);
    for (int i = 0; i < 3; i++)
    {
      localCvMat1.put(i, 0, (paramCvMat4.get(2) * arrayOfDouble2[(i * 2)] - paramCvMat4.get(0)) * arrayOfDouble1[(i * 2)]);
      localCvMat1.put(i, 1, (paramCvMat4.get(2) * arrayOfDouble2[(i * 2)] - paramCvMat4.get(0)) * arrayOfDouble1[(1 + i * 2)]);
      localCvMat1.put(i, 2, paramCvMat4.get(2) * arrayOfDouble2[(i * 2)] - paramCvMat4.get(0));
      localCvMat2.put(i, (paramCvMat3.get(2, 0) * arrayOfDouble1[(i * 2)] + paramCvMat3.get(2, 1) * arrayOfDouble1[(1 + i * 2)] + paramCvMat3.get(2, 2)) * arrayOfDouble2[(i * 2)] - (paramCvMat3.get(0, 0) * arrayOfDouble1[(i * 2)] + paramCvMat3.get(0, 1) * arrayOfDouble1[(1 + i * 2)] + paramCvMat3.get(0, 2)));
    }
    opencv_core.cvSolve(localCvMat1, localCvMat2, paramCvMat5, 0);
    return paramCvMat5;
  }
  
  public static double homogToRt(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7)
  {
    opencv_core.CvMat localCvMat1 = (opencv_core.CvMat)S3x3.get();
    opencv_core.CvMat localCvMat2 = (opencv_core.CvMat)U3x3.get();
    opencv_core.CvMat localCvMat3 = (opencv_core.CvMat)V3x3.get();
    opencv_core.cvSVD(paramCvMat1, localCvMat1, localCvMat2, localCvMat3, 0);
    return homogToRt(localCvMat1, localCvMat2, localCvMat3, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramCvMat6, paramCvMat7);
  }
  
  public static double homogToRt(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, opencv_core.CvMat paramCvMat6, opencv_core.CvMat paramCvMat7, opencv_core.CvMat paramCvMat8, opencv_core.CvMat paramCvMat9)
  {
    double d1 = paramCvMat1.get(0) / paramCvMat1.get(4);
    double d2 = paramCvMat1.get(8) / paramCvMat1.get(4);
    double d3 = d1 - d2;
    double d4 = Math.sqrt(1.0D - d2 * d2);
    double d5 = Math.sqrt(d1 * d1 - 1.0D);
    double[] arrayOfDouble1 = unitize(d4, d5);
    double[] arrayOfDouble2 = unitize(1.0D + d1 * d2, d4 * d5);
    double[] arrayOfDouble3 = unitize(-arrayOfDouble1[1] / d1, -arrayOfDouble1[0] / d2);
    double[] arrayOfDouble4 = new double[9];
    arrayOfDouble4[0] = arrayOfDouble2[0];
    arrayOfDouble4[1] = 0.0D;
    arrayOfDouble4[2] = arrayOfDouble2[1];
    arrayOfDouble4[3] = 0.0D;
    arrayOfDouble4[4] = 1.0D;
    arrayOfDouble4[5] = 0.0D;
    arrayOfDouble4[6] = (-arrayOfDouble2[1]);
    arrayOfDouble4[7] = 0.0D;
    arrayOfDouble4[8] = arrayOfDouble2[0];
    paramCvMat4.put(arrayOfDouble4);
    opencv_core.cvGEMM(paramCvMat2, paramCvMat4, 1.0D, null, 0.0D, paramCvMat4, 0);
    opencv_core.cvGEMM(paramCvMat4, paramCvMat3, 1.0D, null, 0.0D, paramCvMat4, 2);
    double[] arrayOfDouble5 = new double[9];
    arrayOfDouble5[0] = arrayOfDouble2[0];
    arrayOfDouble5[1] = 0.0D;
    arrayOfDouble5[2] = (-arrayOfDouble2[1]);
    arrayOfDouble5[3] = 0.0D;
    arrayOfDouble5[4] = 1.0D;
    arrayOfDouble5[5] = 0.0D;
    arrayOfDouble5[6] = arrayOfDouble2[1];
    arrayOfDouble5[7] = 0.0D;
    arrayOfDouble5[8] = arrayOfDouble2[0];
    paramCvMat7.put(arrayOfDouble5);
    opencv_core.cvGEMM(paramCvMat2, paramCvMat7, 1.0D, null, 0.0D, paramCvMat7, 0);
    opencv_core.cvGEMM(paramCvMat7, paramCvMat3, 1.0D, null, 0.0D, paramCvMat7, 2);
    double[] arrayOfDouble6 = new double[3];
    arrayOfDouble6[0] = paramCvMat3.get(0);
    arrayOfDouble6[1] = paramCvMat3.get(3);
    arrayOfDouble6[2] = paramCvMat3.get(6);
    double[] arrayOfDouble7 = new double[3];
    arrayOfDouble7[0] = paramCvMat3.get(2);
    arrayOfDouble7[1] = paramCvMat3.get(5);
    arrayOfDouble7[2] = paramCvMat3.get(8);
    double d6 = 1.0D;
    double d7 = 1.0D;
    for (int i = 2; i >= 0; i--)
    {
      double d8 = d6 * (arrayOfDouble1[1] * arrayOfDouble6[i] - arrayOfDouble1[0] * arrayOfDouble7[i]);
      paramCvMat6.put(i, d8);
      double d9 = d7 * (arrayOfDouble1[1] * arrayOfDouble6[i] + arrayOfDouble1[0] * arrayOfDouble7[i]);
      paramCvMat9.put(i, d9);
      double d10 = d6 * (arrayOfDouble3[0] * arrayOfDouble6[i] + arrayOfDouble3[1] * arrayOfDouble7[i]);
      paramCvMat5.put(i, d10);
      double d11 = d7 * (arrayOfDouble3[0] * arrayOfDouble6[i] - arrayOfDouble3[1] * arrayOfDouble7[i]);
      paramCvMat8.put(i, d11);
      if (i == 2)
      {
        if (paramCvMat6.get(2) < 0.0D)
        {
          paramCvMat6.put(2, -paramCvMat6.get(2));
          paramCvMat5.put(2, -paramCvMat5.get(2));
          d6 = -1.0D;
        }
        if (paramCvMat9.get(2) < 0.0D)
        {
          paramCvMat9.put(2, -paramCvMat9.get(2));
          paramCvMat8.put(2, -paramCvMat8.get(2));
          d7 = -1.0D;
        }
      }
    }
    return d3;
  }
  
  public static void hysteresisThreshold(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    int i = (int)Math.round(paramDouble1);
    int j = (int)Math.round(paramDouble2);
    byte b1 = (byte)(int)Math.round(paramDouble3 / 2.0D);
    byte b2 = (byte)(int)Math.round(paramDouble3);
    int k = paramIplImage1.height();
    int m = paramIplImage1.width();
    ByteBuffer localByteBuffer1 = paramIplImage1.getByteBuffer();
    ByteBuffer localByteBuffer2 = paramIplImage2.getByteBuffer();
    int n = paramIplImage1.widthStep();
    int i1 = paramIplImage2.widthStep();
    int i2 = 0;
    int i3 = 0;
    int i4 = 0xFF & localByteBuffer1.get(0);
    int i5;
    label110:
    int i24;
    if (i4 >= i)
    {
      localByteBuffer2.put(0, b2);
      i5 = 1;
      if (i5 >= m - 1) {
        break label256;
      }
      i24 = 0xFF & localByteBuffer1.get(0 + i5);
      if (i24 < i) {
        break label189;
      }
      localByteBuffer2.put(0 + i5, b2);
    }
    for (;;)
    {
      i5++;
      break label110;
      if (i4 < j)
      {
        localByteBuffer2.put(0, (byte)0);
        break;
      }
      localByteBuffer2.put(0, b1);
      break;
      label189:
      if (i24 < j) {
        localByteBuffer2.put(0 + i5, (byte)0);
      } else if (localByteBuffer2.get(-1 + (0 + i5)) == b2) {
        localByteBuffer2.put(0 + i5, b2);
      } else {
        localByteBuffer2.put(0 + i5, b1);
      }
    }
    label256:
    int i6 = m - 1;
    int i7 = 0xFF & localByteBuffer1.get(0 + i6);
    int i8;
    if (i7 >= i)
    {
      localByteBuffer2.put(0 + i6, b2);
      i8 = k - 1;
    }
    int i9;
    label361:
    label364:
    label577:
    label722:
    int i21;
    for (;;)
    {
      i9 = i8 - 1;
      if (i8 <= 0) {
        break label900;
      }
      i2 += n;
      i3 += i1;
      int i19 = 0xFF & localByteBuffer1.get(i2 + 0);
      int i20;
      int i23;
      if (i19 >= i)
      {
        localByteBuffer2.put(i3 + 0, b2);
        i20 = 1;
        if (i20 >= m - 1) {
          break label722;
        }
        i23 = 0xFF & localByteBuffer1.get(i2 + i20);
        if (i23 < i) {
          break label577;
        }
        localByteBuffer2.put(i3 + i20, b2);
      }
      for (;;)
      {
        i20++;
        break label364;
        if (i7 < j)
        {
          localByteBuffer2.put(0 + i6, (byte)0);
          break;
        }
        if (localByteBuffer2.get(-1 + (0 + i6)) == b2)
        {
          localByteBuffer2.put(0 + i6, b2);
          break;
        }
        localByteBuffer2.put(0 + i6, b1);
        break;
        if (i19 < j)
        {
          localByteBuffer2.put(i3 + 0, (byte)0);
          break label361;
        }
        byte b3 = localByteBuffer2.get(i3 + 0 - i1);
        byte b4 = localByteBuffer2.get(1 + (i3 + 0 - i1));
        if ((b3 == b2) || (b4 == b2))
        {
          localByteBuffer2.put(i3 + 0, b2);
          break label361;
        }
        localByteBuffer2.put(i3 + 0, b1);
        break label361;
        if (i23 < j)
        {
          localByteBuffer2.put(i3 + i20, (byte)0);
        }
        else
        {
          byte b8 = localByteBuffer2.get(-1 + (i3 + i20));
          byte b9 = localByteBuffer2.get(-1 + (i3 + i20 - i1));
          byte b10 = localByteBuffer2.get(i3 + i20 - i1);
          byte b11 = localByteBuffer2.get(1 + (i3 + i20 - i1));
          if ((b8 == b2) || (b9 == b2) || (b10 == b2) || (b11 == b2)) {
            localByteBuffer2.put(i3 + i20, b2);
          } else {
            localByteBuffer2.put(i3 + i20, b1);
          }
        }
      }
      i21 = m - 1;
      int i22 = 0xFF & localByteBuffer1.get(i2 + i21);
      if (i22 >= i)
      {
        localByteBuffer2.put(i3 + i21, b2);
        i8 = i9;
      }
      else
      {
        if (i22 >= j) {
          break label797;
        }
        localByteBuffer2.put(i3 + i21, (byte)0);
        i8 = i9;
      }
    }
    label797:
    byte b5 = localByteBuffer2.get(-1 + (i3 + i21));
    byte b6 = localByteBuffer2.get(-1 + (i3 + i21 - i1));
    byte b7 = localByteBuffer2.get(i3 + i21 - i1);
    if ((b5 == b2) || (b6 == b2) || (b7 == b2)) {
      localByteBuffer2.put(i3 + i21, b2);
    }
    for (;;)
    {
      i8 = i9;
      break;
      localByteBuffer2.put(i3 + i21, b1);
    }
    label900:
    int i10 = paramIplImage1.height();
    int i11 = paramIplImage1.width();
    int i12 = i1 * (i10 - 1);
    int i13 = i11 - 1;
    if (localByteBuffer2.get(i12 + i13) == b1) {
      localByteBuffer2.put(i12 + i13, (byte)0);
    }
    int i14 = i11 - 2;
    if (i14 > 0)
    {
      if (localByteBuffer2.get(i12 + i14) == b1)
      {
        if (localByteBuffer2.get(1 + (i12 + i14)) != b2) {
          break label1016;
        }
        localByteBuffer2.put(i12 + i14, b2);
      }
      for (;;)
      {
        i14--;
        break;
        label1016:
        localByteBuffer2.put(i12 + i14, (byte)0);
      }
    }
    int i15;
    if (localByteBuffer2.get(i12 + 0) == b1)
    {
      if (localByteBuffer2.get(1 + (i12 + 0)) == b2) {
        localByteBuffer2.put(i12 + 0, b2);
      }
    }
    else {
      i15 = i10 - 1;
    }
    for (;;)
    {
      int i16 = i15 - 1;
      if (i15 > 0)
      {
        i12 -= i1;
        int i17 = i11 - 1;
        label1169:
        int i18;
        if (localByteBuffer2.get(i12 + i17) == b1)
        {
          if ((localByteBuffer2.get(i1 + (i12 + i17)) == b2) || (localByteBuffer2.get(-1 + (i1 + (i12 + i17))) == b2)) {
            localByteBuffer2.put(i12 + i17, b2);
          }
        }
        else
        {
          i18 = i11 - 2;
          label1175:
          if (i18 <= 0) {
            break label1333;
          }
          if (localByteBuffer2.get(i12 + i18) == b1)
          {
            if ((localByteBuffer2.get(1 + (i12 + i18)) != b2) && (localByteBuffer2.get(1 + (i1 + (i12 + i18))) != b2) && (localByteBuffer2.get(i1 + (i12 + i18)) != b2) && (localByteBuffer2.get(-1 + (i1 + (i12 + i18))) != b2)) {
              break label1318;
            }
            localByteBuffer2.put(i12 + i18, b2);
          }
        }
        for (;;)
        {
          i18--;
          break label1175;
          localByteBuffer2.put(i12 + 0, (byte)0);
          break;
          localByteBuffer2.put(i12 + i17, (byte)0);
          break label1169;
          label1318:
          localByteBuffer2.put(i12 + i18, (byte)0);
        }
        label1333:
        if (localByteBuffer2.get(i12 + 0) == b1)
        {
          if ((localByteBuffer2.get(1 + (i12 + 0)) == b2) || (localByteBuffer2.get(1 + (i1 + (i12 + 0))) == b2) || (localByteBuffer2.get(i1 + (i12 + 0)) == b2))
          {
            localByteBuffer2.put(i12 + 0, b2);
            i15 = i16;
            continue;
          }
          localByteBuffer2.put(i12 + 0, (byte)0);
          i15 = i16;
        }
      }
      else
      {
        return;
      }
      i15 = i16;
    }
  }
  
  public static void main(String[] paramArrayOfString)
  {
    String str = JavaCV.class.getPackage().getImplementationVersion();
    if (str == null) {
      str = "unknown";
    }
    System.out.println("JavaCV version " + str + "\n" + "Copyright (C) 2009-2013 Samuel Audet <samuel.audet@gmail.com>\n" + "Project site: http://code.google.com/p/javacv/\n\n" + "Licensed under the GNU General Public License version 2 (GPLv2) with Classpath exception.\n" + "Please refer to LICENSE.txt or http://www.gnu.org/licenses/ for details.");
    System.exit(0);
  }
  
  public static double median(double[] paramArrayOfDouble)
  {
    double[] arrayOfDouble = (double[])paramArrayOfDouble.clone();
    Arrays.sort(arrayOfDouble);
    if (paramArrayOfDouble.length % 2 == 0) {
      return (arrayOfDouble[(-1 + paramArrayOfDouble.length / 2)] + arrayOfDouble[(paramArrayOfDouble.length / 2)]) / 2.0D;
    }
    return arrayOfDouble[(paramArrayOfDouble.length / 2)];
  }
  
  public static <T> T median(T[] paramArrayOfT)
  {
    Object[] arrayOfObject = (Object[])paramArrayOfT.clone();
    Arrays.sort(arrayOfObject);
    return (T)arrayOfObject[(arrayOfObject.length / 2)];
  }
  
  public static double norm(opencv_core.CvMat paramCvMat)
  {
    return norm(paramCvMat, 2.0D);
  }
  
  public static double norm(opencv_core.CvMat paramCvMat, double paramDouble)
  {
    return norm(paramCvMat, paramDouble, null);
  }
  
  public static double norm(opencv_core.CvMat paramCvMat1, double paramDouble, opencv_core.CvMat paramCvMat2)
  {
    double d1 = -1.0D;
    if (paramDouble == 1.0D)
    {
      int i1 = paramCvMat1.cols();
      int i2 = paramCvMat1.rows();
      for (int i3 = 0; i3 < i1; i3++)
      {
        double d3 = 0.0D;
        for (int i4 = 0; i4 < i2; i4++) {
          d3 += Math.abs(paramCvMat1.get(i4, i3));
        }
        d1 = Math.max(d3, d1);
      }
    }
    if (paramDouble == 2.0D)
    {
      int n = Math.min(paramCvMat1.rows(), paramCvMat1.cols());
      if ((paramCvMat2 == null) || (paramCvMat2.rows() != n) || (paramCvMat2.cols() != 1)) {
        paramCvMat2 = opencv_core.CvMat.create(n, 1);
      }
      opencv_core.cvSVD(paramCvMat1, paramCvMat2, null, null, 0);
      d1 = paramCvMat2.get(0);
    }
    do
    {
      for (;;)
      {
        return d1;
        if (paramDouble != Double.POSITIVE_INFINITY) {
          break;
        }
        int i = paramCvMat1.rows();
        int j = paramCvMat1.cols();
        for (int k = 0; k < i; k++)
        {
          double d2 = 0.0D;
          for (int m = 0; m < j; m++) {
            d2 += Math.abs(paramCvMat1.get(k, m));
          }
          d1 = Math.max(d2, d1);
        }
      }
    } while ($assertionsDisabled);
    throw new AssertionError();
  }
  
  public static double norm(double[] paramArrayOfDouble)
  {
    return norm(paramArrayOfDouble, 2.0D);
  }
  
  public static double norm(double[] paramArrayOfDouble, double paramDouble)
  {
    double d1 = 0.0D;
    if (paramDouble == 1.0D)
    {
      int i4 = paramArrayOfDouble.length;
      for (int i5 = 0; i5 < i4; i5++) {
        d1 += Math.abs(paramArrayOfDouble[i5]);
      }
    }
    if (paramDouble == 2.0D)
    {
      int i2 = paramArrayOfDouble.length;
      for (int i3 = 0; i3 < i2; i3++)
      {
        double d4 = paramArrayOfDouble[i3];
        d1 += d4 * d4;
      }
      d1 = Math.sqrt(d1);
    }
    for (;;)
    {
      return d1;
      if (paramDouble == Double.POSITIVE_INFINITY)
      {
        int n = paramArrayOfDouble.length;
        for (int i1 = 0; i1 < n; i1++)
        {
          double d3 = Math.abs(paramArrayOfDouble[i1]);
          if (d3 > d1) {
            d1 = d3;
          }
        }
      }
      else
      {
        if (paramDouble != Double.NEGATIVE_INFINITY) {
          break;
        }
        d1 = Double.MAX_VALUE;
        int k = paramArrayOfDouble.length;
        for (int m = 0; m < k; m++)
        {
          double d2 = Math.abs(paramArrayOfDouble[m]);
          if (d2 < d1) {
            d1 = d2;
          }
        }
      }
    }
    int i = paramArrayOfDouble.length;
    for (int j = 0; j < i; j++) {
      d1 += Math.pow(Math.abs(paramArrayOfDouble[j]), paramDouble);
    }
    return Math.pow(d1, 1.0D / paramDouble);
  }
  
  public static void perspectiveTransform(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat)
  {
    double[] arrayOfDouble = paramCvMat.get();
    int i = 0;
    if (i < paramArrayOfDouble1.length)
    {
      double d1 = paramArrayOfDouble1[i];
      double d2 = paramArrayOfDouble1[(i + 1)];
      double d3 = d1 * arrayOfDouble[6] + d2 * arrayOfDouble[7] + arrayOfDouble[8];
      if (Math.abs(d3) > 1.1920928955078125E-7D)
      {
        double d4 = 1.0D / d3;
        paramArrayOfDouble2[i] = (d4 * (d1 * arrayOfDouble[0] + d2 * arrayOfDouble[1] + arrayOfDouble[2]));
        paramArrayOfDouble2[(i + 1)] = (d4 * (d1 * arrayOfDouble[3] + d2 * arrayOfDouble[4] + arrayOfDouble[5]));
      }
      for (;;)
      {
        i += 2;
        break;
        paramArrayOfDouble2[(i + 1)] = 0.0D;
        paramArrayOfDouble2[i] = 0.0D;
      }
    }
  }
  
  public static void perspectiveTransform(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, boolean paramBoolean)
  {
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)H3x3.get();
    opencv_core.cvGEMM(paramCvMat4, paramCvMat5, -1.0D, paramCvMat3, 1.0D, localCvMat, 2);
    opencv_core.cvMatMul(paramCvMat2, localCvMat, localCvMat);
    opencv_core.cvMatMul(localCvMat, paramCvMat1, localCvMat);
    if (paramBoolean) {
      opencv_core.cvInvert(localCvMat, localCvMat);
    }
    perspectiveTransform(paramArrayOfDouble1, paramArrayOfDouble2, localCvMat);
  }
  
  public static double[] unitize(double paramDouble1, double paramDouble2)
  {
    double d = Math.sqrt(paramDouble1 * paramDouble1 + paramDouble2 * paramDouble2);
    if (d > 1.1920928955078125E-7D)
    {
      paramDouble1 /= d;
      paramDouble2 /= d;
    }
    return new double[] { paramDouble1, paramDouble2 };
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\JavaCV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */