package com.leisure.tang.languageswitchview;

import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;

/**
 * 作者：tangwenchao on 2017/3/27 0027 11:43
 * 邮箱：tangwenchao@kinenjoy.com
 */
public interface LanguageSwitchInterface {
    /**
     * 由于setText无法被重写，需要添加以下三个必要的方法，如果你的app不需要对多语言的textview修改值(只是xml写死就够了)，那就不需要实现他们
     * @param id
     */

    String ANDROIDXML = "http://schemas.android.com/apk/res/android";

    //手动设置textId
    void setTextById (@StringRes int id);

    //手动去掉textId,不然重新加载语言的时候会被重置掉
    void setTextWithString (String text);

    //手动通过TextArray设置语言
    void setTextByArrayAndIndex (@ArrayRes int arrId, @StringRes int arrIndex);

    //修改语言时主要调用的方法
    void reLoadLanguage();
}
