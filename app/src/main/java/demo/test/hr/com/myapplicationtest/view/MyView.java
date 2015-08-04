package demo.test.hr.com.myapplicationtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * Created by Administrator on 7/29/2015.
 */
public class MyView extends ViewGroup{

    private int viewHeight=0;
    private int viewWidth=0;
    private int screenHeight=0;
    private int screenWidth=0;
    private Paint myPaint;
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MyView(Context context) {
        super(context);
        initView();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView(){
        myPaint=new Paint();
        myPaint.setColor(Color.RED);

    }

    /**计算视图大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.screenHeight=getHeight();
        this.screenWidth=getWidth();
    }


    /**绘制视图
     * @param canvas
     */
    @Override
    public void onDraw(Canvas canvas) {
       // super.draw(canvas);
      //  canvas.drawRect(100,100,100,100,myPaint);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

            int action= MotionEventCompat.getActionMasked(ev);
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    Log.d("view", "viewDown");
                    break;
                case MotionEvent.ACTION_UP:
                    Log.d("view", "viewUp");
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.d("view", "viewMove");

                    break;
            }
        return true;
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

        Log.d("view","i-->"+i);
        Log.d("view","i1-->"+i1);
        Log.d("view","i2-->"+i2);
        Log.d("view","i3-->"+i3);
        //layout(i,i1,i2,i3);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.d("view", "w-->" + w);
        Log.d("view","h-->"+h);
    }


}
