/*
 * Copyright (c) 2014 The CyanogenMod Project
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * Also add information on how to contact you by electronic and paper mail.
 *
 */

package org.cyanogenmod.dotcase;

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
        String time = ((Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < 10) ?
                       "0" + Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) :
                       Integer.toString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)))
                      +
                      ((Calendar.getInstance().get(Calendar.MINUTE) < 10) ?
                       "0" + Integer.toString(Calendar.getInstance().get(Calendar.MINUTE)) :
                       Integer.toString(Calendar.getInstance().get(Calendar.MINUTE)));
        int[] sprite;
        int col, row;
        double left, right, top, bottom;

        canvas.drawRect((float)(13 * dotratio),
                        (float)(9 * dotratio),
                        (float)(14 * dotratio),
                        (float)(10 * dotratio),
                        paint);

        canvas.drawRect((float)(13 * dotratio),
                        (float)(12 * dotratio),
                        (float)(14 * dotratio),
                        (float)(13 * dotratio),
                        paint);

        for (int i = 0; i < time.length(); i++) {
            Log.e(TAG, "char " + i + " is " + time.charAt(i));
            sprite = getSprite(time.charAt(i));
            col = 0;
            row = 0;

            for (int j = 0; j < 44; j++) {
                if (col > 3) {
                    col = 0;
                    row++;
                }

                if (sprite[j] == 1) {
                    left = ((col + i * 5) + 4) * dotratio;
                    top = (row + 6) * dotratio;
                    right = ((col + i * 5) + 4 + 1) * dotratio;
                    bottom = (row + 6 + 1) * dotratio;

                if (i < 2) {
                    left = left - dotratio;
                    right = right - dotratio;
                } else {
                    left = left + dotratio;
                    right = right + dotratio;
                }

                    canvas.drawRect((float) left + 2,
                                    (float) top + 2,
                                    (float) right - 2,
                                    (float) bottom -2,
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
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
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
                                1, 1, 1, 1 };
                      break;
            case '3': sprite = new int[]
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 1, 1, 0,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            case '4': sprite = new int[]
                               {1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 1, 1, 1,
                                0, 0, 0, 1,
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
                                0, 1, 1, 0 };
                      break;
            case '7': sprite = new int[]
                               {1, 1, 1, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1,
                                0, 0, 0, 1 };
                      break;
            case '8': sprite = new int[]
                               {0, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                1, 0, 0, 1,
                                0, 1, 1, 0 };
                      break;
            case '9': sprite = new int[]
                               {0, 1, 1, 0,
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
                                0, 0, 0, 0};
                     break;
        }

        return sprite;
    }
}
