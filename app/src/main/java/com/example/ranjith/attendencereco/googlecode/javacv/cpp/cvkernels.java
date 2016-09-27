package com.example.ranjith.attendencereco.googlecode.javacv.cpp;

import com.googlecode.javacpp.Loader;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.MemberSetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Properties;
import com.googlecode.javacv.Parallel;
import com.googlecode.javacv.Parallel.Looper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.util.Arrays;

@Properties({@com.googlecode.javacpp.annotation.Platform(define={"MAX_SIZE 16"}, include={"cvkernels.h"}, includepath={"/usr/local/include:/opt/local/include/"}, options={"fastfpu"}), @com.googlecode.javacpp.annotation.Platform(includepath={"C:/opencv/build/include/"}, value={"windows"}), @com.googlecode.javacpp.annotation.Platform(includepath={"../include/"}, value={"android"})})
public class cvkernels
{
  private static ThreadLocal<ParallelData[]> parallelData = new ThreadLocal()
  {
    protected ParallelData[] initialValue()
    {
      ParallelData[] arrayOfParallelData = new ParallelData[Parallel.getNumThreads()];
      for (int i = 0; i < arrayOfParallelData.length; i++) {
        arrayOfParallelData[i] = new ParallelData(null);
      }
      return arrayOfParallelData;
    }
  };
  
  static
  {
    Loader.load();
  }
  
  public static void multiWarpColorTransform(KernelData paramKernelData, opencv_core.CvRect paramCvRect, final opencv_core.CvScalar paramCvScalar)
  {
    final int i = paramKernelData.capacity();
    ParallelData[] arrayOfParallelData = (ParallelData[])parallelData.get();
    for (int j = 0;; j++)
    {
      int k = arrayOfParallelData.length;
      if (j >= k) {
        break;
      }
      if ((arrayOfParallelData[j].data == null) || (arrayOfParallelData[j].data.capacity() < i))
      {
        arrayOfParallelData[j].data = new KernelData(i);
        for (int i14 = 0; i14 < i; i14++)
        {
          KernelData localKernelData3 = arrayOfParallelData[j].data.position(i14);
          paramKernelData.position(i14);
          if (paramKernelData.dstDstDot() != null) {
            localKernelData3.dstDstDot(ByteBuffer.allocateDirect(8 * paramKernelData.dstDstDot().capacity()).order(ByteOrder.nativeOrder()).asDoubleBuffer());
          }
        }
      }
      for (int i15 = 0; i15 < i; i15++)
      {
        KernelData localKernelData2 = arrayOfParallelData[j].data.position(i15);
        localKernelData2.put(paramKernelData.position(i15));
        localKernelData2.dstDstDot(localKernelData2.dstDstDot());
      }
    }
    opencv_core.IplImage localIplImage = paramKernelData.position(0).srcImg();
    final int m = localIplImage.depth();
    final int i2;
    int i3;
    final int n;
    int i1;
    if (paramCvRect != null)
    {
      i2 = paramCvRect.x();
      i3 = paramCvRect.y();
      n = paramCvRect.width();
      i1 = paramCvRect.height();
      int i4 = i3 + i1;
      int i5 = arrayOfParallelData.length;
      Parallel.Looper local2 = new Parallel.Looper()
      {
        static
        {
          if (!cvkernels.class.desiredAssertionStatus()) {}
          for (boolean bool = true;; bool = false)
          {
            $assertionsDisabled = bool;
            return;
          }
        }
        
        public void loop(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          opencv_core.CvRect localCvRect = this.val$pd[paramAnonymousInt3].roi.x(i2).y(paramAnonymousInt1).width(n).height(paramAnonymousInt2 - paramAnonymousInt1);
          if (m == 32) {
            cvkernels.multiWarpColorTransform32F(this.val$pd[paramAnonymousInt3].data.position(0), i, localCvRect, paramCvScalar);
          }
          do
          {
            return;
            if (m == 8)
            {
              cvkernels.multiWarpColorTransform8U(this.val$pd[paramAnonymousInt3].data.position(0), i, localCvRect, paramCvScalar);
              return;
            }
          } while ($assertionsDisabled);
          throw new AssertionError();
        }
      };
      Parallel.loop(i3, i4, i5, local2);
    }
    for (int i6 = 0;; i6++)
    {
      if (i6 >= i) {
        return;
      }
      int i7 = 0;
      int i8 = 0;
      int i9 = 0;
      double d = 0.0D;
      DoubleBuffer localDoubleBuffer = paramKernelData.dstDstDot();
      double[] arrayOfDouble = null;
      if (localDoubleBuffer != null) {
        arrayOfDouble = new double[paramKernelData.dstDstDot().capacity()];
      }
      for (int i10 = 0;; i10++)
      {
        int i11 = arrayOfParallelData.length;
        if (i10 >= i11) {
          break label491;
        }
        KernelData localKernelData1 = arrayOfParallelData[i10].data.position(i6);
        i7 += localKernelData1.dstCount();
        i8 += localKernelData1.dstCountZero();
        i9 += localKernelData1.dstCountOutlier();
        d += localKernelData1.srcDstDot();
        if ((arrayOfDouble != null) && (localKernelData1.dstDstDot() != null))
        {
          for (int i12 = 0;; i12++)
          {
            int i13 = arrayOfDouble.length;
            if (i12 >= i13) {
              break;
            }
            arrayOfDouble[i12] += localKernelData1.dstDstDot().get(i12);
          }
          n = localIplImage.width();
          i1 = localIplImage.height();
          i2 = 0;
          i3 = 0;
          break;
        }
      }
      label491:
      paramKernelData.position(i6);
      paramKernelData.dstCount(i7);
      paramKernelData.dstCountZero(i8);
      paramKernelData.dstCountOutlier(i9);
      paramKernelData.srcDstDot(d);
      if ((arrayOfDouble != null) && (paramKernelData.dstDstDot() != null))
      {
        paramKernelData.dstDstDot().position(0);
        paramKernelData.dstDstDot().put(arrayOfDouble);
      }
    }
  }
  
  public static native void multiWarpColorTransform32F(KernelData paramKernelData, int paramInt, opencv_core.CvRect paramCvRect, opencv_core.CvScalar paramCvScalar);
  
  public static native void multiWarpColorTransform8U(KernelData paramKernelData, int paramInt, opencv_core.CvRect paramCvRect, opencv_core.CvScalar paramCvScalar);
  
  public static class KernelData
    extends Pointer
  {
    private DoubleBuffer[] dstDstDotBuffers = new DoubleBuffer[1];
    
    static
    {
      Loader.load();
    }
    
    public KernelData()
    {
      allocate();
    }
    
    public KernelData(int paramInt)
    {
      allocateArray(paramInt);
    }
    
    public KernelData(Pointer paramPointer)
    {
      super();
    }
    
    private native void allocate();
    
    private native void allocateArray(int paramInt);
    
    @ByRef
    @Name({"operator="})
    private native KernelData put(@ByRef KernelData paramKernelData);
    
    @MemberSetter
    @Name({"dstDstDot"})
    private native KernelData setDstDstDot(DoubleBuffer paramDoubleBuffer);
    
    public native KernelData H1(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat H1();
    
    public native KernelData H2(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat H2();
    
    public native KernelData X(opencv_core.CvMat paramCvMat);
    
    public native opencv_core.CvMat X();
    
    public native int dstCount();
    
    public native KernelData dstCount(int paramInt);
    
    public native int dstCountOutlier();
    
    public native KernelData dstCountOutlier(int paramInt);
    
    public native int dstCountZero();
    
    public native KernelData dstCountZero(int paramInt);
    
    public KernelData dstDstDot(DoubleBuffer paramDoubleBuffer)
    {
      if (this.dstDstDotBuffers.length < this.capacity) {
        this.dstDstDotBuffers = ((DoubleBuffer[])Arrays.copyOf(this.dstDstDotBuffers, this.capacity));
      }
      this.dstDstDotBuffers[this.position] = paramDoubleBuffer;
      return setDstDstDot(paramDoubleBuffer);
    }
    
    public DoubleBuffer dstDstDot()
    {
      return this.dstDstDotBuffers[this.position];
    }
    
    public native KernelData dstImg(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage dstImg();
    
    public native KernelData mask(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage mask();
    
    public native double outlierThreshold();
    
    public native KernelData outlierThreshold(double paramDouble);
    
    public KernelData position(int paramInt)
    {
      return (KernelData)super.position(paramInt);
    }
    
    public native KernelData srcDotImg(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage srcDotImg();
    
    public native double srcDstDot();
    
    public native KernelData srcDstDot(double paramDouble);
    
    public native KernelData srcImg(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage srcImg();
    
    public native KernelData srcImg2(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage srcImg2();
    
    public native KernelData subImg(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage subImg();
    
    public native KernelData transImg(opencv_core.IplImage paramIplImage);
    
    public native opencv_core.IplImage transImg();
    
    public native double zeroThreshold();
    
    public native KernelData zeroThreshold(double paramDouble);
  }
  
  private static class ParallelData
  {
    KernelData data = null;
    opencv_core.CvRect roi = new opencv_core.CvRect();
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\cpp\cvkernels.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */