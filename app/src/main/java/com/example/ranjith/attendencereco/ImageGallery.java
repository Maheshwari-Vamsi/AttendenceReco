package com.example.ranjith.attendencereco;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;

import google.android.gms.ads.AdListener;
import google.android.gms.ads.AdRequest;
import google.android.gms.ads.InterstitialAd;

public class ImageGallery
  extends Activity
  implements OnItemSelectedListener, ViewSwitcher.ViewFactory
{
  Bitmap[] bmlist;
  ImageButton buttonBack;
  Button buttonDel;
  TextView code;
  int count = 0;
  Gallery g;
  String[] idlist;
  private InterstitialAd mInterstitialAd;
  String mPath = "";
  private ImageSwitcher mSwitcher;
  TextView name;
  String[] namelist;
  TextView sex;
  String[] sexlist;
  TextView tel;
  String[] tellist;
  labels thelabels;

  private void requestNewInterstitial()
  {
    AdapterView localAdRequest = new AdRequest.Builder().addTestDevice("5629AA23086C4D69007CEF9771E8D8B2").build();
    this.mInterstitialAd.loadAd(localAdRequest);
  }

  public View makeView()
  {
    ImageView localImageView = new ImageView(this);
    localImageView.setBackgroundColor(-16777216);
    localImageView.setScaleType(ScaleType.FIT_CENTER);
    localImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    return localImageView;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(2130903066);
    this.mInterstitialAd = new InterstitialAd(this);
    this.mInterstitialAd.setAdUnitId("ca-app-pub-2734229751141383/7603049759");
    this.mInterstitialAd.setAdListener(new AdListener()
    {
      public void onAdClosed()
      {
        ImageGallery.this.requestNewInterstitial();
        ImageGallery.this.finish();
      }
    });
    requestNewInterstitial();
    this.name = ((TextView)findViewById(2131492949));
    this.code = ((TextView)findViewById(2131492957));
    this.sex = ((TextView)findViewById(2131492958));
    this.tel = ((TextView)findViewById(2131492959));
    this.buttonDel = ((Button)findViewById(2131492960));
    this.buttonBack = ((ImageButton)findViewById(2131492956));
    this.mSwitcher = ((ImageSwitcher)findViewById(2131492955));
    this.mSwitcher.setFactory(this);
    this.mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, 17432576));
    this.mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, 17432577));
    this.mPath = getIntent().getExtras().getString("path");
    this.thelabels = new labels(this.mPath);
    this.thelabels.Read();
    this.count = 0;
    int i = this.thelabels.max();
    for (int j = 0; j <= i; j++) {
      if (this.thelabels.get(j) != "") {
        this.count = (1 + this.count);
      }
    }
    this.bmlist = new Bitmap[this.count];
    this.namelist = new String[this.count];
    this.idlist = new String[this.count];
    this.sexlist = new String[this.count];
    this.tellist = new String[this.count];
    this.count = 0;
    int k = 0;
    for (;;)
    {
      if (k <= i)
      {
        File[] arrayOfFile;
        if (this.thelabels.get(k) != "")
        {
          arrayOfFile = new File(this.mPath).listFiles(new FilenameFilter()
          {
            public  val$fname;

            public boolean accept(File paramAnonymousFile, String paramAnonymousString)
            {
              return paramAnonymousString.toLowerCase().startsWith(this.val$fname.toLowerCase() + "-");
            }
          });
          if (arrayOfFile.length <= 0) {}
        }
        try
        {
          FileInputStream localFileInputStream = new FileInputStream(arrayOfFile[0]);
          this.bmlist[this.count] = BitmapFactory.decodeStream(localFileInputStream);
          this.namelist[this.count] = this.thelabels.get(k);
          this.idlist[this.count] = this.thelabels.getCode(k);
          this.sexlist[this.count] = this.thelabels.getSex(k);
          this.tellist[this.count] = this.thelabels.getTel(k);
          this.count = (1 + this.count);
          k++;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            Log.e("File erro", localFileNotFoundException.getMessage() + " " + localFileNotFoundException.getCause());
            localFileNotFoundException.printStackTrace();
          }
        }
      }
    }
    this.g = ((Gallery)findViewById(2131492954));
    this.g.setAdapter(new ImageAdapter(this));
    this.g.setOnItemSelectedListener(this);
    this.buttonBack.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ImageGallery.this.mInterstitialAd.isLoaded())
        {
          ImageGallery.this.mInterstitialAd.show();
          return;
        }
        ImageGallery.this.finish();
      }
    });
    this.buttonDel.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        File[] arrayOfFile = new File(ImageGallery.this.mPath).listFiles(new FilenameFilter()
        {
          public boolean accept(File paramAnonymous2File, String paramAnonymous2String)
          {
            String str = ImageGallery.this.name.getText().toString();
            return paramAnonymous2String.toLowerCase().startsWith(str.toLowerCase() + "-");
          }
        });
        int i = arrayOfFile.length;
        int j = 0;
        if (j < i)
        {
          arrayOfFile[j].delete();
          for (int k = 0;; k++) {
            if (k < ImageGallery.this.count)
            {
              if ((ImageGallery.this.namelist[k] != null) && (ImageGallery.this.namelist[k].equalsIgnoreCase(ImageGallery.this.name.getText().toString())))
              {
                for (int m = k; m < -1 + ImageGallery.this.count; m++)
                {
                  ImageGallery.this.namelist[m] = ImageGallery.this.namelist[(m + 1)];
                  ImageGallery.this.bmlist[m] = ImageGallery.this.bmlist[(m + 1)];
                }
                ImageGallery localImageGallery = ImageGallery.this;
                localImageGallery.count = (-1 + localImageGallery.count);
                ImageGallery.this.refresh();
              }
            }
            else
            {
              j++;
              break;
            }
          }
        }
        ImageGallery.this.thelabels.Delete(ImageGallery.this.name.getText().toString());
      }
    });
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.mSwitcher.setImageDrawable(new BitmapDrawable(getResources(), this.bmlist[paramInt]));
    this.name.setText(this.namelist[paramInt]);
    this.code.setText(this.idlist[paramInt]);
    this.sex.setText(this.sexlist[paramInt]);
    this.tel.setText(this.tellist[paramInt]);
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView) {}

  public void refresh()
  {
    this.g.setAdapter(new ImageAdapter(this));
  }

  public class ImageAdapter
    extends BaseAdapter
  {
    private Context mContext;

    public ImageAdapter(Context paramContext)
    {
      this.mContext = paramContext;
    }

    public int getCount()
    {
      return ImageGallery.this.count;
    }

    public Object getItem(int paramInt)
    {
      return ImageGallery.this.bmlist[paramInt];
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      ImageView localImageView = new ImageView(this.mContext);
      localImageView.setImageBitmap(ImageGallery.this.bmlist[paramInt]);
      localImageView.setAdjustViewBounds(true);
      localImageView.setLayoutParams(new Gallery.LayoutParams(-2, -2));
      return localImageView;
    }
  }
}
