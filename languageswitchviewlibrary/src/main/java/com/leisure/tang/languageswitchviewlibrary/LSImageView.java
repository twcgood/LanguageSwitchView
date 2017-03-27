package com.leisure.tang.languageswitchviewlibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 作者：tangwenchao on 2017/3/27 0027 14:27
 * 邮箱：tangwenchao@kinenjoy.com
 */
public class LSImageView extends ImageView implements LanguageSwitchInterface{

    private int imgId ;//图片id

    public LSImageView(Context context) {
        super(context);
        init(context, null);
    }

    public LSImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LSImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    /**
     * 初始化获取xml的资源id
     * @param context
     * @param attributeSet
     */
    private void init (Context context,AttributeSet attributeSet) {
        if (attributeSet!=null) {
            String imgValue = attributeSet.getAttributeValue(ANDROIDXML, "src");
            if (!(imgValue==null || imgValue.length()<2)) {
                imgId = LSUtil.string2int(imgValue.substring(1,imgValue.length()));
            }
        }
    }

    @Override
    public void setTextById(@DrawableRes int id) {
        this.imgId = id;
        setImageResource(id);
    }

    @Override
    public void setTextWithString(String text) {
    }

    public void setImageWithDrawable(Drawable drawable) {
        this.imgId = 0;
        setImageDrawable(drawable);
    }

    @Override
    public void setTextByArrayAndIndex(@ArrayRes int arrId, @StringRes int arrIndex) {
    }

    @Override
    public void reLoadLanguage() {
        try {
            if (imgId>0) {
                setImageResource(imgId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
