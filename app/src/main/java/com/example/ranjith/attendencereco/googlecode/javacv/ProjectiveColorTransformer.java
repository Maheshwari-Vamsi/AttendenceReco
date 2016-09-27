package com.example.ranjith.attendencereco.googlecode.javacv;

import com.googlecode.javacv.cpp.cvkernels;
import com.googlecode.javacv.cpp.cvkernels.KernelData;
import com.googlecode.javacv.cpp.opencv_core;
import com.googlecode.javacv.cpp.opencv_core.CvArr;
import com.googlecode.javacv.cpp.opencv_core.CvMat;
import com.googlecode.javacv.cpp.opencv_core.CvRect;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import java.util.Arrays;

public class ProjectiveColorTransformer
  extends ProjectiveTransformer
{
  protected static ThreadLocal<opencv_core.CvMat> X24x4;
  protected static ThreadLocal<opencv_core.CvMat> temp3x1;
  protected opencv_core.CvMat X = null;
  protected opencv_core.CvMat[] X2 = null;
  protected int numBiases = 0;
  protected int numGains = 0;
  
  static
  {
    if (!ProjectiveColorTransformer.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      X24x4 = opencv_core.CvMat.createThreadLocal(4, 4);
      temp3x1 = opencv_core.CvMat.createThreadLocal(3, 1);
      return;
    }
  }
  
  public ProjectiveColorTransformer(opencv_core.CvMat paramCvMat1, opencv_core.CvMat paramCvMat2, opencv_core.CvMat paramCvMat3, opencv_core.CvMat paramCvMat4, opencv_core.CvMat paramCvMat5, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, opencv_core.CvMat paramCvMat6, int paramInt1, int paramInt2)
  {
    super(paramCvMat1, paramCvMat2, paramCvMat3, paramCvMat4, paramCvMat5, paramArrayOfDouble1, paramArrayOfDouble2);
    opencv_core.CvMat localCvMat = null;
    if (paramCvMat6 == null) {}
    for (;;)
    {
      this.X = localCvMat;
      this.numGains = paramInt1;
      this.numBiases = paramInt2;
      return;
      localCvMat = paramCvMat6.clone();
    }
  }
  
  public Parameters createParameters()
  {
    return new Parameters();
  }
  
  public int getNumBiases()
  {
    return this.numBiases;
  }
  
  public int getNumGains()
  {
    return this.numGains;
  }
  
  public opencv_core.CvMat getX()
  {
    return this.X;
  }
  
  protected void prepareColorTransform(opencv_core.CvMat paramCvMat, int paramInt, Parameters paramParameters, boolean paramBoolean)
  {
    opencv_core.CvMat localCvMat1 = paramParameters.getA();
    opencv_core.CvMat localCvMat2 = paramParameters.getB();
    opencv_core.cvSetIdentity(paramCvMat);
    paramCvMat.rows(3);
    paramCvMat.cols(3);
    if ((paramParameters.fakeIdentity) && (!paramBoolean)) {
      paramCvMat.put(localCvMat1);
    }
    for (;;)
    {
      paramCvMat.rows(4);
      paramCvMat.cols(4);
      if (localCvMat2 != null)
      {
        paramCvMat.put(0, 3, localCvMat2.get(0));
        paramCvMat.put(1, 3, localCvMat2.get(1));
        paramCvMat.put(2, 3, localCvMat2.get(2));
      }
      if (paramBoolean) {
        opencv_core.cvInvert(paramCvMat, paramCvMat, 1);
      }
      return;
      if ((localCvMat1 != null) && (this.X != null)) {
        opencv_core.cvMatMul(this.X, localCvMat1, paramCvMat);
      } else if (this.X == null) {
        paramCvMat.put(localCvMat1);
      } else if (localCvMat1 == null) {
        paramCvMat.put(this.X);
      }
    }
  }
  
  public void transform(ImageTransformer.Data[] paramArrayOfData, opencv_core.CvRect paramCvRect, ImageTransformer.Parameters[] paramArrayOfParameters, boolean[] paramArrayOfBoolean)
  {
    assert (paramArrayOfData.length == paramArrayOfParameters.length);
    if ((this.kernelData == null) || (this.kernelData.capacity() < paramArrayOfData.length)) {
      this.kernelData = new cvkernels.KernelData(paramArrayOfData.length);
    }
    if ((this.H == null) || (this.H.length < paramArrayOfData.length))
    {
      this.H = new opencv_core.CvMat[paramArrayOfData.length];
      for (int i = 0; i < this.H.length; i++) {
        this.H[i] = opencv_core.CvMat.create(3, 3);
      }
    }
    if ((this.X2 == null) || (this.X2.length < paramArrayOfData.length))
    {
      this.X2 = new opencv_core.CvMat[paramArrayOfData.length];
      for (int j = 0; j < this.X2.length; j++) {
        this.X2[j] = opencv_core.CvMat.create(4, 4);
      }
    }
    int k = 0;
    if (k < paramArrayOfData.length)
    {
      this.kernelData.position(k);
      this.kernelData.srcImg(paramArrayOfData[k].srcImg);
      this.kernelData.srcImg2(null);
      this.kernelData.subImg(paramArrayOfData[k].subImg);
      this.kernelData.srcDotImg(paramArrayOfData[k].srcDotImg);
      this.kernelData.mask(paramArrayOfData[k].mask);
      this.kernelData.zeroThreshold(paramArrayOfData[k].zeroThreshold);
      this.kernelData.outlierThreshold(paramArrayOfData[k].outlierThreshold);
      if (paramArrayOfBoolean == null) {}
      int i1;
      for (boolean bool = false;; i1 = paramArrayOfBoolean[k])
      {
        prepareHomography(this.H[k], paramArrayOfData[k].pyramidLevel, (Parameters)paramArrayOfParameters[k], bool);
        prepareColorTransform(this.X2[k], paramArrayOfData[k].pyramidLevel, (Parameters)paramArrayOfParameters[k], bool);
        this.kernelData.H1(this.H[k]);
        this.kernelData.H2(null);
        this.kernelData.X(this.X2[k]);
        this.kernelData.transImg(paramArrayOfData[k].transImg);
        this.kernelData.dstImg(paramArrayOfData[k].dstImg);
        this.kernelData.dstDstDot(paramArrayOfData[k].dstDstDot);
        k++;
        break;
      }
    }
    int m = this.kernelData.capacity();
    this.kernelData.capacity(paramArrayOfData.length);
    cvkernels.multiWarpColorTransform(this.kernelData, paramCvRect, getFillColor());
    this.kernelData.capacity(m);
    for (int n = 0; n < paramArrayOfData.length; n++)
    {
      this.kernelData.position(n);
      paramArrayOfData[n].dstCount = this.kernelData.dstCount();
      paramArrayOfData[n].dstCountZero = this.kernelData.dstCountZero();
      paramArrayOfData[n].dstCountOutlier = this.kernelData.dstCountOutlier();
      paramArrayOfData[n].srcDstDot = this.kernelData.srcDstDot();
    }
  }
  
  public void transformColor(opencv_core.IplImage paramIplImage1, opencv_core.IplImage paramIplImage2, opencv_core.CvRect paramCvRect, int paramInt, ImageTransformer.Parameters paramParameters, boolean paramBoolean)
  {
    Parameters localParameters = (Parameters)paramParameters;
    if (((Arrays.equals(localParameters.getColorParameters(), localParameters.getIdentityColorParameters())) && ((this.X == null) || (localParameters.fakeIdentity))) || ((this.X == null) && (this.numGains == 0) && (this.numBiases == 0)))
    {
      if (paramIplImage1 != paramIplImage2) {
        opencv_core.cvCopy(paramIplImage1, paramIplImage2);
      }
      return;
    }
    opencv_core.CvMat localCvMat = (opencv_core.CvMat)X24x4.get();
    prepareColorTransform(localCvMat, paramInt, localParameters, paramBoolean);
    localCvMat.rows(3);
    if (paramCvRect == null) {
      opencv_core.cvResetImageROI(paramIplImage2);
    }
    for (;;)
    {
      localCvMat.put(0, 3, localCvMat.get(0, 3) * paramIplImage2.highValue());
      localCvMat.put(1, 3, localCvMat.get(1, 3) * paramIplImage2.highValue());
      localCvMat.put(2, 3, localCvMat.get(2, 3) * paramIplImage2.highValue());
      opencv_core.cvTransform(paramIplImage1, paramIplImage2, localCvMat, null);
      localCvMat.rows(4);
      return;
      opencv_core.cvSetImageROI(paramIplImage2, paramCvRect);
    }
  }
  
  public class Parameters
    extends ProjectiveTransformer.Parameters
  {
    private opencv_core.CvMat A = null;
    private opencv_core.CvMat b = null;
    protected double[] colorParameters = null;
    protected double[] identityColorParameters = null;
    
    static
    {
      if (!ProjectiveColorTransformer.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }
    
    protected Parameters()
    {
      super();
      if (ProjectiveColorTransformer.this.numGains > 0)
      {
        this.A = opencv_core.CvMat.create(3, 3);
        opencv_core.cvSetIdentity(this.A);
      }
      if (ProjectiveColorTransformer.this.numBiases > 0)
      {
        this.b = opencv_core.CvMat.create(3, 1);
        opencv_core.cvSetZero(this.b);
      }
      switch (ProjectiveColorTransformer.this.numGains)
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
        break;
      case 0: 
        if ((!$assertionsDisabled) && (this.A != null)) {
          throw new AssertionError();
        }
        break;
      case 1: 
        this.identityColorParameters[0] = ((this.A.get(0) + this.A.get(4) + this.A.get(8)) / 3.0D);
      }
      for (;;)
      {
        switch (ProjectiveColorTransformer.this.numBiases)
        {
        case 2: 
        default: 
          if ($assertionsDisabled) {
            break label383;
          }
          throw new AssertionError();
          this.identityColorParameters[0] = this.A.get(0);
          this.identityColorParameters[1] = this.A.get(4);
          this.identityColorParameters[2] = this.A.get(8);
          continue;
          this.A.get(0, this.identityColorParameters, 0, 9);
        }
      }
      if ((!$assertionsDisabled) && (this.b != null))
      {
        throw new AssertionError();
        this.identityColorParameters[ProjectiveColorTransformer.this.numGains] = ((this.b.get(0) + this.b.get(1) + this.b.get(2)) / 3.0D);
      }
      for (;;)
      {
        label383:
        reset(false);
        return;
        this.b.get(0, this.identityColorParameters, ProjectiveColorTransformer.this.numGains, 3);
      }
    }
    
    public Parameters clone()
    {
      Parameters localParameters = new Parameters(ProjectiveColorTransformer.this);
      localParameters.set(this);
      return localParameters;
    }
    
    public void compose(ImageTransformer.Parameters paramParameters1, boolean paramBoolean1, ImageTransformer.Parameters paramParameters2, boolean paramBoolean2)
    {
      super.compose(paramParameters1, paramBoolean1, paramParameters2, paramBoolean2);
      composeColor(paramParameters1, paramBoolean1, paramParameters2, paramBoolean2);
    }
    
    public void composeColor(ImageTransformer.Parameters paramParameters1, boolean paramBoolean1, ImageTransformer.Parameters paramParameters2, boolean paramBoolean2)
    {
      assert ((!paramBoolean1) && (!paramBoolean2));
      Parameters localParameters1 = (Parameters)paramParameters1;
      Parameters localParameters2 = (Parameters)paramParameters2;
      opencv_core.CvMat localCvMat1 = localParameters1.getA();
      Object localObject = localParameters1.getB();
      opencv_core.CvMat localCvMat2 = localParameters2.getA();
      opencv_core.CvMat localCvMat3 = localParameters2.getB();
      if (this.b != null)
      {
        if ((localParameters1.fakeIdentity) && (ProjectiveColorTransformer.this.X != null))
        {
          opencv_core.CvMat localCvMat4 = (opencv_core.CvMat)ProjectiveColorTransformer.temp3x1.get();
          opencv_core.cvMatMul(ProjectiveColorTransformer.this.X, (opencv_core.CvArr)localObject, localCvMat4);
          localObject = localCvMat4;
        }
        if ((localCvMat2 == null) && (localCvMat3 == null)) {
          opencv_core.cvCopy((opencv_core.CvArr)localObject, this.b);
        }
      }
      else
      {
        label136:
        if (this.A != null)
        {
          if (localCvMat1 != null) {
            break label277;
          }
          opencv_core.cvCopy(localCvMat2, this.A);
        }
      }
      for (;;)
      {
        switch (ProjectiveColorTransformer.this.numGains)
        {
        default: 
          if ($assertionsDisabled) {
            break label366;
          }
          throw new AssertionError();
          if (localObject == null)
          {
            opencv_core.cvCopy(localCvMat3, this.b);
            break label136;
          }
          if (localCvMat3 == null)
          {
            opencv_core.cvMatMul(localCvMat2, (opencv_core.CvArr)localObject, this.b);
            break label136;
          }
          opencv_core.cvGEMM(localCvMat2, (opencv_core.CvArr)localObject, 1.0D, localCvMat3, 1.0D, this.b, 0);
          break label136;
          label277:
          if (localCvMat2 == null) {
            opencv_core.cvCopy(localCvMat1, this.A);
          } else {
            opencv_core.cvMatMul(localCvMat2, localCvMat1, this.A);
          }
          break;
        }
      }
      if ((!$assertionsDisabled) && (this.A != null))
      {
        throw new AssertionError();
        this.colorParameters[0] = ((this.A.get(0) + this.A.get(4) + this.A.get(8)) / 3.0D);
      }
      for (;;)
      {
        label366:
        switch (ProjectiveColorTransformer.this.numBiases)
        {
        case 2: 
        default: 
          if ($assertionsDisabled) {
            break label546;
          }
          throw new AssertionError();
          this.colorParameters[0] = this.A.get(0);
          this.colorParameters[1] = this.A.get(4);
          this.colorParameters[2] = this.A.get(8);
          continue;
          this.A.get(0, this.colorParameters, 0, 9);
        }
      }
      if ((!$assertionsDisabled) && (this.b != null))
      {
        throw new AssertionError();
        this.colorParameters[ProjectiveColorTransformer.this.numGains] = ((this.b.get(0) + this.b.get(1) + this.b.get(2)) / 3.0D);
      }
      label546:
      return;
      this.b.get(0, this.colorParameters, ProjectiveColorTransformer.this.numGains, 3);
    }
    
    public double get(int paramInt)
    {
      int i = super.size();
      if (paramInt < i) {
        return super.get(paramInt);
      }
      return this.colorParameters[(paramInt - i)];
    }
    
    public opencv_core.CvMat getA()
    {
      update();
      return this.A;
    }
    
    public opencv_core.CvMat getB()
    {
      update();
      return this.b;
    }
    
    public double[] getColorParameters()
    {
      return this.colorParameters;
    }
    
    public double[] getIdentityColorParameters()
    {
      return this.identityColorParameters;
    }
    
    public void reset(boolean paramBoolean)
    {
      super.reset(paramBoolean);
      resetColor(paramBoolean);
    }
    
    public void resetColor(boolean paramBoolean)
    {
      if ((this.identityColorParameters != null) && ((!Arrays.equals(this.colorParameters, this.identityColorParameters)) || (this.fakeIdentity != paramBoolean)))
      {
        this.fakeIdentity = paramBoolean;
        this.colorParameters = ((double[])this.identityColorParameters.clone());
        setUpdateNeeded(true);
      }
    }
    
    public void set(int paramInt, double paramDouble)
    {
      int i = super.size();
      if (paramInt < i) {
        super.set(paramInt, paramDouble);
      }
      while (this.colorParameters[(paramInt - i)] == paramDouble) {
        return;
      }
      this.colorParameters[(paramInt - i)] = paramDouble;
      setUpdateNeeded(true);
    }
    
    public int size()
    {
      return super.size() + ProjectiveColorTransformer.this.numGains + ProjectiveColorTransformer.this.numBiases;
    }
    
    protected void update()
    {
      if (!isUpdateNeeded()) {
        return;
      }
      switch (ProjectiveColorTransformer.this.numGains)
      {
      default: 
        if (!$assertionsDisabled) {
          throw new AssertionError();
        }
        break;
      case 0: 
        if ((!$assertionsDisabled) && (this.A != null)) {
          throw new AssertionError();
        }
        break;
      case 1: 
        this.A.put(0, this.colorParameters[0]);
        this.A.put(4, this.colorParameters[0]);
        this.A.put(8, this.colorParameters[0]);
      }
      for (;;)
      {
        switch (ProjectiveColorTransformer.this.numBiases)
        {
        case 2: 
        default: 
          if ($assertionsDisabled) {
            break label342;
          }
          throw new AssertionError();
          this.A.put(0, this.colorParameters[0]);
          this.A.put(4, this.colorParameters[1]);
          this.A.put(8, this.colorParameters[2]);
          continue;
          this.A.put(0, this.colorParameters, 0, 9);
        }
      }
      if ((!$assertionsDisabled) && (this.b != null))
      {
        throw new AssertionError();
        this.b.put(0, this.colorParameters[ProjectiveColorTransformer.this.numGains]);
        this.b.put(1, this.colorParameters[ProjectiveColorTransformer.this.numGains]);
        this.b.put(2, this.colorParameters[ProjectiveColorTransformer.this.numGains]);
      }
      for (;;)
      {
        label342:
        super.update();
        setUpdateNeeded(false);
        return;
        this.b.put(0, this.colorParameters, ProjectiveColorTransformer.this.numGains, 3);
      }
    }
  }
}


/* Location:              D:\Apk\dex2jar-0.0.9.15\classes-dex2jar.jar!\com\googlecode\javacv\ProjectiveColorTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */