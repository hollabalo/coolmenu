package my.app;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyViewGroup extends ViewGroup {

	int status = 0;

	ImageView img1;
	ImageView img2;
	ImageView img3;
	ImageView img4;
	ImageView overlay;
    TextView text;
	
	int width = 0;
	int height = 0;
	int centerH = 0;
	int centerW = 0;

	int pad = 20;
	int adjust = 0;
	float alpha = 1f;
	
	public MyViewGroup(Context context) {
        super(context);

        setBackgroundResource(R.drawable.bg);

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        width = metrics.widthPixels;
        height = metrics.heightPixels;

        centerH = height/2 - 130;
		centerW = width/2;

		ImageView ctr = new ImageView(context);
        ctr.setImageResource(R.drawable.ctr);
        ctr.layout(centerW - centerW/4 + pad/2, centerH - centerH/4, centerW + centerW/4 + pad/2, centerH + centerH/4);
        this.addView(ctr, 0);

        overlay = new ImageView(context);
        overlay.setImageResource(R.drawable.overlay);
        overlay.layout(1, 1, 500, 500);
        overlay.setAlpha(1);
        this.addView(overlay, 1);

        img1 = new ImageView(context);
        img1.setImageResource(R.drawable.shrek_1);
        this.addView(img1, 2);

        img2 = new ImageView(context);
        img2.setImageResource(R.drawable.shrek_2);
        this.addView(img2, 3);

        img3 = new ImageView(context);
        img3.setImageResource(R.drawable.shrek_3);
        this.addView(img3, 4);

        img4 = new ImageView(context);
        img4.setImageResource(R.drawable.shrek_4);
        this.addView(img4, 5);

        text = new TextView(context);
        text.setText("Tap to close menu");
        this.addView(text, 6);
    }

    @Override
    protected void onLayout (boolean changed, int left, int top, int right, int bottom) {
    	childViews();
    	clickListener();
    }

    public void clickListener() {
    	this.setOnClickListener(new OnClickListener() {
    		public void onClick(View w) {
    			if(status == 0) {
    				System.out.println("Hide things");
    				hide();
    				status = 1;
    			}
    			else if(status == 1) {
    				System.out.println("Show things");
    				show();
    				status = 0;
    			}
    		}
    	});
    }

    public void hide() {
    	final android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            	adjust += 50;
            	alpha -= .04;
            	overlay.setAlpha(overlay.getAlpha() - alpha);
                childViews();
                if(adjust > height/2) {
                	return;
                }
                else {
                	handler.postDelayed(this, 50);
                }
            }
        }, 50);
    }

    public void show() {
    	final android.os.Handler handler = new android.os.Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
            	adjust -= 50;
            	alpha += .04;
            	overlay.setAlpha(overlay.getAlpha() + alpha);
                childViews();
                if(adjust < pad) {
                	return;
                }
                else {
                	handler.postDelayed(this, 50);
                }
            }
        }, 50);
    }

    private void childViews() {
    	getChildAt(2).layout(centerW - pad - centerW/2 , centerH - centerH/2 - adjust, centerW - pad, centerH - adjust); // OK
    	getChildAt(3).layout(centerW + pad, centerH - centerH/2 - adjust, centerW + pad + centerW/2, centerH - adjust); // OK
    	getChildAt(4).layout(centerW - pad - centerW/2, centerH + adjust, centerW - pad, centerH + centerH/2 + adjust); 
    	getChildAt(5).layout(centerW + pad, centerH + adjust, centerW + pad + centerW/2, centerH + centerH/2 + adjust); // OK
        getChildAt(6).layout(centerW - centerW/2, centerH + 450, centerW + centerW/2, centerH + 450);

    	getChildAt(2).setAlpha(alpha);
    	getChildAt(3).setAlpha(alpha);
    	getChildAt(4).setAlpha(alpha);
    	getChildAt(5).setAlpha(alpha);
    }

}