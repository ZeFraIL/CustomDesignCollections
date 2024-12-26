package zeev.fraiman.customdesigncollections;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomSinusView extends View {
    private Paint paint;
    private int pointsCount = 100;
    private float[] xPoints = new float[pointsCount];
    private float[] yPoints = new float[pointsCount];
    private int currentPoint = 0;
    private long duration = 10000;
    private long startTime;

    public CustomSinusView(Context context) {
        super(context);
        init();
    }

    public CustomSinusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);

        for (int i = 0; i < pointsCount; i++) {
            xPoints[i] = i / (float) pointsCount * 2 * (float) Math.PI; // X: от 0 до 2π
            yPoints[i] = (float) Math.sin(xPoints[i]); //
        }

        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float width = getWidth();
        float height = getHeight();
        float xScale = width / (2 * (float) Math.PI);
        float yScale = height / 2;

        float yCenter = height / 2;

        for (int i = 0; i < currentPoint; i++) {
            float x = xPoints[i] * xScale;
            float y = yCenter - yPoints[i] * yScale;
            if (i > 0) {
                float prevX = xPoints[i - 1] * xScale;
                float prevY = yCenter - yPoints[i - 1] * yScale;
                canvas.drawLine(prevX, prevY, x, y, paint);
            }
        }

        long elapsedTime = System.currentTimeMillis() - startTime;
        float progress = Math.min(elapsedTime / (float) duration, 1.0f);
        currentPoint = (int) (pointsCount * progress);

        if (currentPoint < pointsCount) {
            postInvalidateDelayed(100);
        }
    }
}
