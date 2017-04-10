package me.sheepyang.sortdemo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SheepYang on 2017/4/10.
 */

public class SortView extends View {
    private Context mContext;
    private List<Integer> mList = new ArrayList<>();
    private Paint mPaint = new Paint();
    private Paint mTextPaint = new Paint();
    private Rect mBounds = new Rect();
    private List<Integer> mTempList = new ArrayList<>();
    private Runnable mBubbleRunnable = new Runnable() {
        @Override
        public void run() {
            ToastUtils.showShortToast("sasasas" + System.currentTimeMillis());

            for (int i = 0; i < mList.size(); i++) {

            }


            mHandler.postDelayed(mBubbleRunnable, 1000);
        }
    };
    private static Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public SortView(Context context) {
        this(context, null);
    }

    public SortView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SortView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(15);
        mPaint.setColor(0xffff0000);
        mPaint.setAntiAlias(true);

        mTextPaint.setTextSize(40);
        mTextPaint.setColor(0xffff0000);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextAlign(Paint.Align.LEFT);
    }

    private void init() {
        setBackgroundColor(0x3300ff00);
        mList.add(9);
        mList.add(4);
        mList.add(5);
        mList.add(6);
        mList.add(8);
        mList.add(3);
        mList.add(2);
        mList.add(7);
        mList.add(10);
        mList.add(1);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float lineWidth = (getMeasuredWidth() - mPaint.getStrokeWidth()) / mList.size();
        for (int i = 0; i < mList.size(); i++) {
            int line = mList.get(i);
            float lineHeight = line / 10f * getMeasuredHeight() - mPaint.getStrokeWidth() / 2;

            mTextPaint.getTextBounds(line + "", 0, (line + "").length(), mBounds);
            Paint.FontMetricsInt fontMetrics = mTextPaint.getFontMetricsInt();
            float baseline = (lineHeight - fontMetrics.bottom - fontMetrics.top) / 2f + (getMeasuredHeight() - lineHeight);
            canvas.drawText(line + "", lineWidth * i + mPaint.getStrokeWidth() / 2 + lineWidth / 2 - mBounds.width() / 2, baseline, mTextPaint);

            canvas.drawRect(lineWidth * i + mPaint.getStrokeWidth() / 2, getMeasuredHeight() - lineHeight, lineWidth * (i + 1) + mPaint.getStrokeWidth() / 2, getMeasuredHeight() - mPaint.getStrokeWidth() / 2, mPaint);
        }
    }

    public void bubbleSort() {
        mHandler.removeCallbacksAndMessages(null);
        mTempList.clear();
        for (int i = 0; i < mList.size(); i++) {
            mTempList.add(mList.get(i));
        }
        mHandler.postDelayed(mBubbleRunnable, 3000);
    }

    public void stop() {
        mHandler.removeCallbacksAndMessages(null);
    }

    public void restart() {
        mHandler.removeCallbacksAndMessages(null);
        mList.clear();
        mList.add(9);
        mList.add(4);
        mList.add(5);
        mList.add(6);
        mList.add(8);
        mList.add(3);
        mList.add(2);
        mList.add(7);
        mList.add(10);
        mList.add(1);
        invalidate();
    }
}
