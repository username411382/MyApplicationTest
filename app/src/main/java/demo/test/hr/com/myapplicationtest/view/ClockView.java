package demo.test.hr.com.myapplicationtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**仪表盘
 * Created by herui on 10/8/2015.
 */
public class ClockView extends View{
    private Paint paintCircle;
    private Paint paintDegree;
    private Paint paintHour;
    private Paint paintMinute;
    private float mWidth;
    private float mHeight;
    private float centerX;
    private float centerY;

    public ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ClockView(Context context) {
        super(context);
        initView();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth=getWidth();
        mHeight=getHeight();
        centerX=mWidth/2;
        centerY=mHeight/2;
    }

    private void initView(){

        //画外圆的画笔
        paintCircle=new Paint();
        paintCircle.setColor(Color.BLUE);
        paintCircle.setStyle(Paint.Style.STROKE);//空心
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        //画指针的画笔
        paintHour=new Paint();
        paintHour.setStrokeWidth(20);
        paintMinute=new Paint();
        paintMinute.setStrokeWidth(10);
        //画分度值的画笔
        paintDegree=new Paint();
        paintDegree.setStrokeWidth(3);
    }

    /**
     * 画分度值
     */
    private void drawDivideValue(Canvas canvas){
        canvas.rotate(30, centerX, centerY);
        for (int i=1;i<13;i++){
            if (i==3||i==6||i==9||i==12){
                paintDegree.setStrokeWidth(5);
                paintDegree.setTextSize(60);
                canvas.drawLine(centerX,centerY-centerX+10,centerX,centerY-centerX+50,paintDegree);
                String numberValue=String.valueOf(i);
                canvas.drawText(numberValue,centerX-paintDegree.measureText(numberValue)/2,centerY-centerX+100,paintDegree);
            }else{
                paintDegree.setStrokeWidth(3);
                paintDegree.setTextSize(30);
                canvas.drawLine(centerX,centerY-centerX+10,centerX,centerY-centerX+30,paintDegree);
                String numberValue=String.valueOf(i);
                canvas.drawText(numberValue,centerX-paintDegree.measureText(numberValue)/2,centerY-centerX+70,paintDegree);
            }
            canvas.rotate(30,centerX,centerY);

        }
    }

    /**画指针
     * @param canvas
     */
    private void drawPointer(Canvas canvas){
        canvas.save();
        canvas.translate(centerX, centerY);
        canvas.drawLine(0,0,100, 100, paintHour);
        canvas.drawLine(0,0,100,200,paintMinute);
        canvas.restore();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画外圆
        canvas.drawCircle(centerX, centerY, centerX - 10, paintCircle);
        //画分度值
        drawDivideValue(canvas);
        //画指针
        drawPointer(canvas);
    }



}
