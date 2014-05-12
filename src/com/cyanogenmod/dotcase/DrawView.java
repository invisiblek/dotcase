package com.cyanogenmod.dotcase;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public class DrawView extends View {
    // 960 wide (27 dots)
    // 1707 high (48 dots)
    // 35.5pixels per dot
    private static final String TAG = "Dotcase";
    Paint paint = new Paint();
    double center = 14;
    double dotratio = 35.5;

    public DrawView(Context context) {
        super(context);
        paint.setARGB(255, 51, 181, 229);
        paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        String time = Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) +
                      ((Calendar.getInstance().get(Calendar.MINUTE) < 10) ?
                       "0" + Integer.toString(Calendar.getInstance().get(Calendar.MINUTE)) :
                       Integer.toString(Calendar.getInstance().get(Calendar.MINUTE)));
        int[] sprite;
        int col, row;
        double left, right, top, bottom;

        for (int i = 0; i < time.length(); i++) {
            Log.e(TAG, "char " + i + " is " + time.charAt(i));
            sprite = getSprite(time.charAt(i));
            col = 0;
            row = 0;

            for (int j = 0; j < 48; j++) {
                if (col > 3) {
                    col = 0;
                    row++;
                }

                if (sprite[j] == 1) {
                    left = ((col + i * 5) + 4) * dotratio;
                    top = (row + 6) * dotratio;
                    right = ((col + i * 5) + 4 + 1) * dotratio;
                    bottom = (row + 6 + 1) * dotratio;

                    canvas.drawRect((float) left,
                                    (float) top,
                                    (float) right,
                                    (float) bottom,
                                    paint);
                }

                col++;
            }
        }
    }

    public int[] getSprite(char c) {
        int[] sprite;
        switch (c) {
            case '0': sprite = new int[]
                               {1, 1, 1, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 1, 1, 1 };
                      break;
            case '1': sprite = new int[]
                               {0, 0, 1, 0,
                                0, 1, 1, 0,
                                1, 1, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                1, 1, 1, 1 };
                      break;
            case '2': sprite = new int[]
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 1, 0, 0,
                                0, 1, 0, 0,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 1, 1, 1 };
                      break;
            case '3': sprite = new int[]
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 1, 1, 0,
                                0, 1, 1, 0,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            case '4': sprite = new int[]
                               {0, 0, 0, 1,
                                0, 0, 1, 1,
                                0, 0, 1, 1,
                                0, 1, 0, 1,
                                0, 1, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 1, 1, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1 };
                      break;
            case '5': sprite = new int[]
                               {1, 1, 1, 1,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 1, 1, 0,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            case '6': sprite = new int[]
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 0, 0, 0,
                                1, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            case '7': sprite = new int[]
                               {1, 1, 1, 1,
                                1, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 0, 1, 0,
                                0, 1, 0, 0,
                                0, 1, 0, 0,
                                0, 1, 0, 0,
                                0, 1, 0, 0 };
                      break;
            case '8': sprite = new int[]
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0,
                                0, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            case '9': sprite = new int[]
                               {0, 1, 1, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            default: sprite = new int[]
                               {0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0,
                                0, 0, 0, 0};
                     break;
        }

        return sprite;
    }
}
