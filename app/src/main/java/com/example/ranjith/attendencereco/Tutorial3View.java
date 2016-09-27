package com.example.ranjith.attendencereco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.util.AttributeSet;
import android.util.Log;

import org.opencv.android.JavaCameraView;

import java.io.FileOutputStream;
import java.util.List;

public class Tutorial3View
  extends JavaCameraView
{
  private static final String TAG = "Sample::Tutorial3View";
  
  public Tutorial3View(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public String getEffect()
  {
    return this.mCamera.getParameters().getColorEffect();
  }
  
  public List<String> getEffectList()
  {
    return this.mCamera.getParameters().getSupportedColorEffects();
  }
  
  public Size getResolution()
  {
    return this.mCamera.getParameters().getPreviewSize();
  }
  
  public List<Size> getResolutionList()
  {
    return this.mCamera.getParameters().getSupportedPreviewSizes();
  }
  
  public boolean isEffectSupported()
  {
    return this.mCamera.getParameters().getColorEffect() != null;
  }
  
  public int numberCameras()
  {
    return Camera.getNumberOfCameras();
  }
  
  public void setAutofocus()
  {
    Parameters localParameters = this.mCamera.getParameters();
    localParameters.setFocusMode("continuous-video");
    this.mCamera.setParameters(localParameters);
  }
  
  public void setCamBack()
  {
    disconnectCamera();
    setCameraIndex(99);
    connectCamera(getWidth(), getHeight());
  }
  
  public void setCamFront()
  {
    disconnectCamera();
    setCameraIndex(98);
    connectCamera(getWidth(), getHeight());
  }
  
  public void setEffect(String paramString)
  {
    Parameters localParameters = this.mCamera.getParameters();
    localParameters.setColorEffect(paramString);
    this.mCamera.setParameters(localParameters);
  }
  
  public void setResolution(int paramInt1, int paramInt2)
  {
    disconnectCamera();
    this.mMaxHeight = paramInt2;
    this.mMaxWidth = paramInt1;
    connectCamera(getWidth(), getHeight());
  }
  
  public void setResolution(Size paramSize)
  {
    disconnectCamera();
    this.mMaxHeight = paramSize.height;
    this.mMaxWidth = paramSize.width;
    connectCamera(getWidth(), getHeight());
  }
  
  public void takePicture(final String paramString)
  {
    Log.i("Sample::Tutorial3View", "Tacking picture");
    PictureCallback local1 = new PictureCallback()
    {
      private String mPictureFileName = paramString;
      
      public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        Log.i("Sample::Tutorial3View", "Saving a bitmap to file");
        Bitmap localBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
        try
        {
          FileOutputStream localFileOutputStream = new FileOutputStream(this.mPictureFileName);
          localBitmap.compress(CompressFormat.JPEG, 90, localFileOutputStream);
          localBitmap.recycle();
          Tutorial3View.this.mCamera.startPreview();
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    };
    this.mCamera.takePicture(null, null, local1);
  }
}


