package com.leisure.tang.languageswitchview;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

import java.util.Locale;

/**
 * 作者：tangwenchao on 2017/3/27 0027 13:45
 * 邮箱：tangwenchao@kinenjoy.com
 */
public class LSUtil {

    public static int string2int (String str) {
        return string2int(str,0);
    }
    public static int string2int (String str, int def) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
        }
        return def;
    }

    /**
     * 更新语言
     * @param activity
     */
    public static void updateViewLanguageforActivity(Activity activity) {
        View view = activity.findViewById(android.R.id.content);
        if (view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            int count = vg.getChildCount();
            for (int i = 0; i < count; i++) {
                updateViewLanguageforView(vg.getChildAt(i));
            }
        } else if (view instanceof LanguageSwitchInterface) {
            LanguageSwitchInterface tv = (LanguageSwitchInterface) view;
            tv.reLoadLanguage();
        }
    }

    /**
     * 更新 Configuration 中的 locale 属性
     * @param locale
     * 例子：  switchLanguage(Locale.ENGLISH); 之后发送消息通知所有界面更换语言
     *  ClassEvent event = new ClassEvent();
     *  event.msg = "do it";
     *  EventBus.getDefault().post(event);
     *
     */
    public static void switchLanguage(Context context,Locale locale) {
        Configuration config = context.getResources().getConfiguration();// 获得设置对象
        Resources resources = context.getResources();// 获得res资源对象
        DisplayMetrics dm = resources.getDisplayMetrics();// 获得屏幕参数：主要是分辨率，像素等。
        config.locale = locale;
        resources.updateConfiguration(config, dm);
    }

    /**
     * 递归遍历viewgroup，改变语言
     * @param view
     */
    private static void updateViewLanguageforView(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) view;
            int count = vg.getChildCount();
            for (int i = 0; i < count; i++) {
                updateViewLanguageforView(vg.getChildAt(i));
            }
        } else if (view instanceof LanguageSwitchInterface) {
            LanguageSwitchInterface tv = (LanguageSwitchInterface) view;
            tv.reLoadLanguage();
        }
    }

}
