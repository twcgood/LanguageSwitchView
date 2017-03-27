package com.leisure.tang.languageswitchview;

import android.content.Context;
import android.support.annotation.ArrayRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * 作者：tangwenchao on 2017/3/27 0027 14:17
 * 邮箱：tangwenchao@kinenjoy.com
 */
public class LSEditText extends EditText implements LanguageSwitchInterface {

    private int textId ;//文字id
    private int hintId ;//hint的id
    private int arrResId,arrResIndex;

    public LSEditText(Context context) {
        super(context);
        init(context, null);
    }

    public LSEditText(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init(paramContext, paramAttributeSet);
    }

    public LSEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init(paramContext, paramAttributeSet);
    }

    /**
     * 初始化获取xml的资源id
     * @param context
     * @param attributeSet
     */
    private void init (Context context,AttributeSet attributeSet) {
        if (attributeSet!=null) {
            String textValue = attributeSet.getAttributeValue(ANDROIDXML, "text");
            if (!(textValue==null || textValue.length()<2)) {
                //如果是 android:text="@string/testText"
                //textValue会长这样 @156878785,去掉@号就是资源id
                textId = LSUtil.string2int(textValue.substring(1,textValue.length()));
            }

            String hintValue = attributeSet.getAttributeValue(ANDROIDXML, "hint");
            if (!(hintValue==null || hintValue.length()<2)) {
                hintId = LSUtil.string2int(hintValue.substring(1,hintValue.length()));
            }
        }
    }

    @Override
    public void setTextById (@StringRes int strId) {
        this.textId = strId;
        setText(strId);
    }

    @Override
    public void setTextWithString(String text) {
        this.textId = 0;
        setText(text);
    }
    @Override
    public void setTextByArrayAndIndex (@ArrayRes int arrId, @StringRes int arrIndex) {
        arrResId = arrId;
        arrResIndex = arrIndex;
        String[] strs = getContext().getResources().getStringArray(arrId);
        setText(strs[arrIndex]);
    }

    @Override
    public void reLoadLanguage () {
        try {
            if (textId>0) {
                setText(textId);
            } else if (arrResId>0) {
                String[] strs = getContext().getResources().getStringArray(arrResId);
                setText(strs[arrResIndex]);
            }

            if (hintId>0) {
                setHint(hintId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
