package com.eric;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SmiliesEditText extends EditText {
  
	public SmiliesEditText(Context context) {
		super(context);
	}

	public SmiliesEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	public void insertIcon(int id, final Context context) {
		SpannableString ss = new SpannableString(getText().toString()+"[cat]");
		Drawable d = getResources().getDrawable(id);
		d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
		ImageSpan span = new ImageSpan(d, ImageSpan.ALIGN_BASELINE);
		ss.setSpan(span, getText().length(),getText().length()+"[cat]".length(),
				Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		setText(ss);

		//ss.setSpan(new StyleSpan(Typeface.ITALIC), 22, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		ClickableSpan clickableSpan = new ClickableSpan() {
			@Override
			public void onClick(View textView) {
				Log.e("happy","congratulations!");
				Toast.makeText(context, "发送成功", Toast.LENGTH_SHORT).show();
			}
		};
		ss.setSpan(clickableSpan, "HelloWorld".length(), ss.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		setText(ss);
		setMovementMethod(LinkMovementMethod.getInstance());
	}
}
