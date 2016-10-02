package com.example.ranjith.attendencereco;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

import googlecode.javacv.cpp.opencv_contrib;

public class FdActivity
        extends Activity
        implements CameraBridgeViewBase.CvCameraViewListener2 {
  private static final Scalar FACE_RECT_COLOR = new Scalar(0.0D, 255.0D, 0.0D, 255.0D);
  public static final int IDLE = 2;
  public static final int JAVA_DETECTOR = 0;
  static final long MAXIMG = 10L;
  public static final int NATIVE_DETECTOR = 1;
  public static final int SEARCHING = 1;
  private static final String TAG = "OCVSample::Activity";
  public static final int TRAINING = 0;
  private static final int backCam = 2;
  private static final int frontCam = 1;
  private ImageView Iv;
  ArrayList<Mat> alimgs = new ArrayList();
  Button buttonCatalog;
  ToggleButton buttonSearch;
  LayoutInflater controlInflator = null;
  int countImages = 0;
  opencv_contrib.FaceRecognizer faceRecognizer;
  private int faceState = 2;
  PersonRecognizer fr;
  EditText id;
  ImageButton imCamera;
  ImageView ivGreen;
  ImageView ivRed;
  ImageView ivYellow;
  int[] labels = new int[10];
  labels labelsFile;
  private int mAbsoluteFaceSize = 0;
  Bitmap mBitmap;
  private File mCascadeFile;
  private int mChooseCamera = 2;
  private String[] mDetectorName = new String[2];
  private int mDetectorType = 0;
  private MenuItem mEigen;
  private MenuItem mFrontCam;
  private Mat mGray;
  Handler mHandler;
  private CascadeClassifier mJavaDetector;
  private int mLikely = 999;
  private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
    public void onManagerConnected(int paramAnonymousInt) throws IOException {
      switch (paramAnonymousInt) {
        default:
          super.onManagerConnected(paramAnonymousInt);
          return;
      }
      Log.i("OCVSample::Activity", "OpenCV loaded successfully");
      FdActivity.this.fr = new PersonRecognizer(FdActivity.this.mPath);
      FdActivity.this.getResources().getString(2131099705);
      FdActivity.this.fr.load();
      InputStream localInputStream;
      File localFile;
      FileOutputStream localFileOutputStream;
      try {
        localInputStream = FdActivity.this.getResources().openRawResource(2131034112);
        localFile = FdActivity.this.getDir("cascade", 0);
        FdActivity.access$002(FdActivity.this, new File(localFile, "lbpcascade.xml"));
        localFileOutputStream = new FileOutputStream(FdActivity.this.mCascadeFile);
        byte[] arrayOfByte = new byte['က'];
        for (; ; ) {
          int i = localInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localFileOutputStream.write(arrayOfByte, 0, i);
        }
        FdActivity.this.mOpenCvCameraView.enableView();
      } catch (IOException localIOException) {
        localIOException.printStackTrace();
        Log.e("OCVSample::Activity", "Failed to load cascade. Exception thrown: " + localIOException);
      }
      return;
      localInputStream.close();
      localFileOutputStream.close();
      FdActivity.access$102(FdActivity.this, new CascadeClassifier(FdActivity.this.mCascadeFile.getAbsolutePath()));
      if (FdActivity.this.mJavaDetector.empty()) {
        Log.e("OCVSample::Activity", "Failed to load cascade classifier");
        FdActivity.access$102(FdActivity.this, null);
      }
      for (; ; ) {
        localFile.delete();
        break;
        Log.i("OCVSample::Activity", "Loaded cascade classifier from " + FdActivity.this.mCascadeFile.getAbsolutePath());
      }
    }
  };


  private Tutorial3View mOpenCvCameraView;
  String mPath = "";
  private float mRelativeFaceSize = 0.2F;
  private Mat mRgba;
  private MenuItem nBackCam;
  EditText sex;
  EditText tel;
  EditText text;
  TextView textState;
  TextView textresult;
  ToggleButton toggleButtonGrabar;
  ToggleButton toggleButtonTrain;

  private GoogleApiClient client;

  public FdActivity() {
    this.mDetectorName[0] = "Java";
    this.mDetectorName[1] = "Native (tracking)";
  }

  private void initializeOpenCVDependencies() throws IOException {
    InputStream localInputStream;
    File localFile;
    FileOutputStream localFileOutputStream;
    try {
      localInputStream = getResources().openRawResource(2131034112);
      localFile = new File(getDir("cascade", 0), "lbpcascade_frontalface.xml");
      localFileOutputStream = new FileOutputStream(localFile);
      byte[] arrayOfByte = new byte['က'];
      for (; ; ) {
        int i = localInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      this.mOpenCvCameraView.enableView();
    } catch (Exception localException) {
      Log.e("OpenCVActivity", "Error loading cascade", localException);
    }
    for (; ; ) {
      return;
      localInputStream.close();
      localFileOutputStream.close();
      this.mJavaDetector = new CascadeClassifier(localFile.getAbsolutePath());
    }
  }

  public static double round(Long paramLong, int paramInt) {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    return new BigDecimal(paramLong.longValue()).setScale(paramInt, RoundingMode.HALF_UP).doubleValue();
  }

  private void saveImage(Bitmap paramBitmap) {
    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
    System.out.println(str + " Root value in saveImage Function");
    File localFile1 = new File(str + "/FaceRecogntion");
    if (!localFile1.exists()) {
      localFile1.mkdirs();
    }
    int i = new Random().nextInt(10000);
    File localFile2 = new File(localFile1, "Image-" + i + ".jpg");
    if (localFile2.exists()) {
      localFile2.delete();
    }
    try {
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
      paramBitmap.compress(CompressFormat.JPEG, 90, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      Toast.makeText(getApplicationContext(), "Saving to ScholarshipApp Folder...", 0).show();
      String[] arrayOfString = new String[1];
      arrayOfString[0] = localFile2.toString();
      MediaScannerConnection.scanFile(this, arrayOfString, null, new OnScanCompletedListener() {
        public void onScanCompleted(String paramAnonymousString, Uri paramAnonymousUri) {
          Log.i("ExternalStorage", "Scanned " + paramAnonymousString + ":");
          Log.i("ExternalStorage", "-> uri=" + paramAnonymousUri);
        }
      });
      return;
    } catch (Exception localException) {
      for (; ; ) {
        localException.printStackTrace();
      }
    }
  }

  private void setDetectorType(int paramInt) {
  }

  private void setMinFaceSize(float paramFloat) {
    this.mRelativeFaceSize = paramFloat;
    this.mAbsoluteFaceSize = 0;
  }

  void grabarOnclick() {
    if (this.toggleButtonGrabar.isChecked()) {
      this.faceState = 0;
      return;
    }
    if (this.faceState == 0) {
    }
    this.countImages = 0;
    this.faceState = 2;
  }

  public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame paramCvCameraViewFrame) {
    this.mRgba = paramCvCameraViewFrame.rgba();
    this.mGray = paramCvCameraViewFrame.gray();
    if (this.mAbsoluteFaceSize == 0) {
      int k = this.mGray.rows();
      if (Math.round(k * this.mRelativeFaceSize) > 0) {
        this.mAbsoluteFaceSize = Math.round(k * this.mRelativeFaceSize);
      }
    }
    MatOfRect localMatOfRect = new MatOfRect();
    Rect[] arrayOfRect = new Rect[0];
    if (this.mDetectorType == 0) {
      if (this.mJavaDetector != null) {
        this.mJavaDetector.detectMultiScale(this.mGray, localMatOfRect, 1.1D, 2, 2, new Size(this.mAbsoluteFaceSize, this.mAbsoluteFaceSize), new Size());
      }
      arrayOfRect = localMatOfRect.toArray();
      if ((arrayOfRect.length != 1) || (this.faceState != 0) || (this.countImages >= 10L) || (this.text.getText().toString().isEmpty())) {
        break label366;
      }
      new Mat();
      Rect localRect = arrayOfRect[0];
      Mat localMat2 = this.mRgba.submat(localRect);
      this.mBitmap = Bitmap.createBitmap(localMat2.width(), localMat2.height(), Config.ARGB_8888);
      Utils.matToBitmap(localMat2, this.mBitmap);
      Message localMessage3 = new Message();
      localMessage3.obj = "IMG";
      this.mHandler.sendMessage(localMessage3);
      if (this.countImages < 10L) {
        this.fr.add(localMat2, this.text.getText().toString());
        this.countImages = (1 + this.countImages);
      }
    }
    for (; ; ) {
      for (int i = 0; ; i++) {
        int j = arrayOfRect.length;
        if (i >= j) {
          break;
        }
        Core.rectangle(this.mRgba, arrayOfRect[i].tl(), arrayOfRect[i].br(), FACE_RECT_COLOR, 3);
      }
      if (this.mDetectorType == 1) {
        break;
      }
      Log.e("OCVSample::Activity", "Detection method is not selected!");
      break;
      label366:
      if ((arrayOfRect.length > 0) && (this.faceState == 1)) {
        new Mat();
        Mat localMat1 = this.mGray.submat(arrayOfRect[0]);
        this.mBitmap = Bitmap.createBitmap(localMat1.width(), localMat1.height(), Config.ARGB_8888);
        Utils.matToBitmap(localMat1, this.mBitmap);
        Message localMessage1 = new Message();
        localMessage1.obj = "IMG";
        this.mHandler.sendMessage(localMessage1);
        Long localLong = Long.valueOf(System.nanoTime());
        String str = this.fr.predict(localMat1);
        this.mLikely = this.fr.getProb();
        ((Long.valueOf(System.nanoTime()).longValue() - localLong.longValue()) / 1000000L);
        Message localMessage2 = new Message();
        localMessage2.obj = str;
        this.mHandler.sendMessage(localMessage2);
      }
    }
    return this.mRgba;
  }

  public void onCameraViewStarted(int paramInt1, int paramInt2) {
    this.mGray = new Mat();
    this.mRgba = new Mat();
  }

  public void onCameraViewStopped() {
    this.mGray.release();
    this.mRgba.release();
  }

  public void onCreate(Bundle paramBundle) {
    Log.i("OCVSample::Activity", "called onCreate");
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView(R.layout.face_detect_surface_view);
    this.mOpenCvCameraView = ((Tutorial3View) findViewById(R.id.tutorial3_activity_java_surface_view));
    this.mOpenCvCameraView.setCvCameraViewListener(this);
    this.mPath = (getFilesDir() + "/facerecogOCV/");
    this.labelsFile = new labels(this.mPath);
    this.controlInflator = LayoutInflater.from(getBaseContext());
    addContentView(this.controlInflator.inflate(R.layout.control, null), new ViewGroup.LayoutParams(-1, -1));
    this.Iv = ((ImageView) findViewById(R.id.imageView1));
    this.textresult = ((TextView) findViewById(R.id.textView1));
    this.mHandler = new Handler() {
      public void handleMessage(Message paramAnonymousMessage) {
        if (paramAnonymousMessage.obj == "IMG") {
          new Canvas().setBitmap(FdActivity.this.mBitmap);
          FdActivity.this.Iv.setImageBitmap(FdActivity.this.mBitmap);
          if (FdActivity.this.countImages >= 9L) {
            FdActivity.this.toggleButtonGrabar.setChecked(false);
            FdActivity.this.grabarOnclick();
          }
        }
   ;

          FdActivity.this.textresult.setText(" " + paramAnonymousMessage.obj.toString());
          FdActivity.this.ivGreen.setVisibility(View.INVISIBLE);
          FdActivity.this.ivYellow.setVisibility(View.INVISIBLE);
          FdActivity.this.ivRed.setVisibility(View.VISIBLE);

      while (FdActivity.this.mLikely < 0);
        if (FdActivity.this.mLikely < 50) {
          FdActivity.this.ivGreen.setVisibility(View.VISIBLE);
          return;
        }
        if (FdActivity.this.mLikely < 80) {
          FdActivity.this.ivYellow.setVisibility(View.VISIBLE);
          return;
        }
        FdActivity.this.ivRed.setVisibility(View.VISIBLE);
      }
    };
    this.text = ((EditText) findViewById(R.id.editText1));
    this.id = ((EditText) findViewById(R.id.editTextId));
    this.sex = ((EditText) findViewById(R.id.editTextSex));
    this.tel = ((EditText) findViewById(R.id.editTextTel));
    this.buttonCatalog = ((Button) findViewById(R.id.buttonCat));
    this.toggleButtonGrabar = ((ToggleButton) findViewById(R.id.toggleButtonGrabar));
    this.buttonSearch = ((ToggleButton) findViewById(R.id.buttonBuscar));
    this.toggleButtonTrain = ((ToggleButton) findViewById(R.id.toggleButton1));
    this.textState = ((TextView) findViewById(R.id.textViewState));
    this.ivGreen = ((ImageView) findViewById(R.id.imageView3));
    this.ivYellow = ((ImageView) findViewById(R.id.imageView4));
    this.ivRed = ((ImageView) findViewById(R.id.imageView2));
    this.imCamera = ((ImageButton) findViewById(R.id.imageButton1));
    this.ivGreen.setVisibility(View.INVISIBLE);
    this.ivYellow.setVisibility(View.INVISIBLE);
    this.ivRed.setVisibility(View.INVISIBLE);
    this.text.setVisibility(View.INVISIBLE);
    this.id.setVisibility(View.INVISIBLE);
    this.sex.setVisibility(View.INVISIBLE);
    this.tel.setVisibility(View.INVISIBLE);
    this.textresult.setVisibility(View.INVISIBLE);

    this.toggleButtonGrabar.setVisibility(View.INVISIBLE);
    this.buttonCatalog.setOnClickListener(new OnClickListener() {
      public void onClick(View paramAnonymousView) {
        Intent localIntent = new Intent(FdActivity.this, ImageGallery.class);
        localIntent.putExtra("path", FdActivity.this.mPath);
        FdActivity.this.startActivity(localIntent);
      }
    });
    this.text.setOnKeyListener(new OnKeyListener() {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent) {
        if ((FdActivity.this.text.getText().toString().length() > 0) && (FdActivity.this.toggleButtonTrain.isChecked())) {
          FdActivity.this.toggleButtonGrabar.setVisibility(View.VISIBLE);
          return false;
        }
        FdActivity.this.toggleButtonGrabar.setVisibility(View.INVISIBLE);
        return false;
      }
    });
    this.toggleButtonTrain.setOnClickListener(new OnClickListener() {
      public void onClick(View paramAnonymousView) {
        if (FdActivity.this.toggleButtonTrain.isChecked()) {
          FdActivity.this.textState.setVisibility(View.VISIBLE);
          FdActivity.this.textState.setText(FdActivity.this.getResources().getString(R.string.S));
          FdActivity.this.buttonSearch.setVisibility(View.INVISIBLE);
          FdActivity.this.textresult.setVisibility(View.GONE);
          FdActivity.this.id.setVisibility(View.VISIBLE);
          FdActivity.this.text.setVisibility(View.VISIBLE);
          FdActivity.this.sex.setVisibility(View.VISIBLE);
          FdActivity.this.tel.setVisibility(View.VISIBLE);
          FdActivity.this.ivGreen.setVisibility(View.GONE);
          FdActivity.this.ivYellow.setVisibility(View.GONE);
          FdActivity.this.ivRed.setVisibility(View.GONE);
          if ((FdActivity.this.text.getText().toString().length() > 0) && (FdActivity.this.id.getText().toString().length() > 0) && (FdActivity.this.tel.getText().toString().length() > 0) && (FdActivity.this.sex.getText().toString().length() > 0)) {
            FdActivity.this.toggleButtonGrabar.setVisibility(View.VISIBLE);
          }
          return;
        }
        FdActivity.this.textState.setText(R.string.STrain);
        FdActivity.this.text.setVisibility(View.INVISIBLE);
        FdActivity.this.buttonSearch.setVisibility(View.VISIBLE);
        FdActivity.this.textresult.setText("");
        FdActivity.this.toggleButtonGrabar.setVisibility(View.INVISIBLE);
        FdActivity.this.text.setVisibility(View.INVISIBLE);
        FdActivity.this.id.setVisibility(View.INVISIBLE);
        FdActivity.this.sex.setVisibility(View.INVISIBLE);
        FdActivity.this.tel.setVisibility(View.INVISIBLE);
        Long localLong = Long.valueOf(System.nanoTime());
        FdActivity.this.fr.train(FdActivity.this.id.getText().toString(), FdActivity.this.sex.getText().toString(), FdActivity.this.tel.getText().toString());
        double d = (Long.valueOf(System.nanoTime()).longValue() - localLong.longValue()) / 1000000L;
        if ((FdActivity.this.text.getText().toString().length() > 0) && ((FdActivity.this.id.getText().toString().length() > 0) || (FdActivity.this.tel.getText().toString().length() > 0) || (FdActivity.this.sex.getText().toString().length() > 0))) {
          Toast.makeText(FdActivity.this.getApplicationContext(), FdActivity.this.getResources().getString(2131099705), 0).show();
          Toast.makeText(FdActivity.this.getApplicationContext(), String.valueOf(d) + "ms", 0).show();
        }
        FdActivity.this.textState.setText(FdActivity.this.getResources().getString(2131099698));
        FdActivity.this.textState.setVisibility(4);
        FdActivity.this.text.setText("");
        FdActivity.this.id.setText("");
        FdActivity.this.sex.setText("");
        FdActivity.this.tel.setText("");
      }
    });
    this.toggleButtonGrabar.setOnClickListener(new OnClickListener() {
      public void onClick(View paramAnonymousView) {
        FdActivity.this.grabarOnclick();
      }
    });
    this.imCamera.setOnClickListener(new OnClickListener() {
      public void onClick(View paramAnonymousView) {
        if (FdActivity.this.mChooseCamera == 1) {
          FdActivity.access$502(FdActivity.this, 2);
          FdActivity.this.mOpenCvCameraView.setCamBack();
          return;
        }
        FdActivity.access$502(FdActivity.this, 1);
        FdActivity.this.mOpenCvCameraView.setCamFront();
      }
    });
    this.buttonSearch.setOnClickListener(new OnClickListener() {
      public void onClick(View paramAnonymousView) {
        if (FdActivity.this.buttonSearch.isChecked()) {
          if (!FdActivity.this.fr.canPredict()) {
            FdActivity.this.buttonSearch.setChecked(false);
            Toast.makeText(FdActivity.this.getApplicationContext(), FdActivity.this.getResources().getString(2131099693), 1).show();
            return;
          }
          FdActivity.this.textState.setVisibility(0);
          FdActivity.this.textState.setText(FdActivity.this.getResources().getString(2131099700));
          FdActivity.this.toggleButtonGrabar.setVisibility(4);
          FdActivity.this.toggleButtonTrain.setVisibility(4);
          FdActivity.this.text.setVisibility(4);
          FdActivity.this.id.setVisibility(4);
          FdActivity.this.sex.setVisibility(4);
          FdActivity.this.tel.setVisibility(4);
          FdActivity.access$602(FdActivity.this, 1);
          FdActivity.this.textresult.setVisibility(0);
          return;
        }
        FdActivity.access$602(FdActivity.this, 2);
        FdActivity.this.textState.setText(FdActivity.this.getResources().getString(2131099698));
        FdActivity.this.textState.setVisibility(4);
        FdActivity.this.toggleButtonGrabar.setVisibility(4);
        FdActivity.this.toggleButtonTrain.setVisibility(0);
        FdActivity.this.text.setVisibility(4);
        FdActivity.this.id.setVisibility(4);
        FdActivity.this.sex.setVisibility(4);
        FdActivity.this.tel.setVisibility(4);
        FdActivity.this.textresult.setVisibility(4);
        FdActivity.this.ivGreen.setVisibility(4);
        FdActivity.this.ivRed.setVisibility(4);
        FdActivity.this.ivYellow.setVisibility(4);
      }
    });
    if (!new File(this.mPath).mkdirs()) {
      Log.e("Error", "Error creating directory");
    }
    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu) {
    Log.i("OCVSample::Activity", "called onCreateOptionsMenu");
    if (this.mOpenCvCameraView.numberCameras() > 1) {
      this.nBackCam = paramMenu.add(getResources().getString(2131099697));
      this.mFrontCam = paramMenu.add(getResources().getString(2131099692));
      return true;
    }
    this.imCamera.setVisibility(View.INVISIBLE);
    return true;
  }

  public void onDestroy() {
    super.onDestroy();
    this.mOpenCvCameraView.disableView();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem) {
    Log.i("OCVSample::Activity", "called onOptionsItemSelected; selected item: " + paramMenuItem);
    this.nBackCam.setChecked(false);
    this.mFrontCam.setChecked(false);
    if (paramMenuItem == this.nBackCam) {
      this.mOpenCvCameraView.setCamFront();
      this.mChooseCamera = 1;
    }
    for (; ; ) {
      paramMenuItem.setChecked(true);
      if (paramMenuItem == this.mFrontCam) {
        this.mChooseCamera = 2;
        this.mOpenCvCameraView.setCamBack();
      }
      return true;

    }
  }

  public void onPause() {
    super.onPause();
    if (this.mOpenCvCameraView != null) {
      this.mOpenCvCameraView.disableView();
    }
  }

  public void onResume() {
    super.onResume();
    OpenCVLoader.initAsync("2.4.6", this, this.mLoaderCallback);
  }

  @Override
  public void onStart() {
    super.onStart();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    client.connect();
    Action viewAction = Action.newAction(
            Action.TYPE_VIEW, // TODO: choose an action type.
            "Fd Page", // TODO: Define a title for the content shown.
            // TODO: If you have web page content that matches this app activity's content,
            // make sure this auto-generated web page URL is correct.
            // Otherwise, set the URL to null.
            Uri.parse("http://host/path"),
            // TODO: Make sure this auto-generated app deep link URI is correct.
            Uri.parse("android-app://com.example.ranjith.attendencereco/http/host/path")
    );
    AppIndex.AppIndexApi.start(client, viewAction);
  }

  @Override
  public void onStop() {
    super.onStop();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    Action viewAction = Action.newAction(
            Action.TYPE_VIEW, // TODO: choose an action type.
            "Fd Page", // TODO: Define a title for the content shown.
            // TODO: If you have web page content that matches this app activity's content,
            // make sure this auto-generated web page URL is correct.
            // Otherwise, set the URL to null.
            Uri.parse("http://host/path"),
            // TODO: Make sure this auto-generated app deep link URI is correct.
            Uri.parse("android-app://com.example.ranjith.attendencereco/http/host/path")
    );
    AppIndex.AppIndexApi.end(client, viewAction);
    client.disconnect();
  }

  static abstract interface AdBuddizDelegate {
    public abstract void didCacheAd();

    public abstract void didClick();


    public abstract void didHideAd();

    public abstract void didShowAd();
  }
}

