package works.flyingmole.android.fixedlengthedittext.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

import works.flyingmole.android.fixedlengthedittext.R;

/**
 * 横幅固定長のEditText
 */
public class FixedLengthEditText extends AppCompatEditText {

	/** EditTextの幅計算用 */
	private final Paint mPaint = new Paint();

	/** 文字長 */
	private int mTextCount;

	/**
	 * {@inheritDoc}
	 */
	public FixedLengthEditText(Context context) {
		super(context, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public FixedLengthEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		initTextCount(context, attrs);
	}

	/**
	 * {@inheritDoc}
	 */
	public FixedLengthEditText(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initTextCount(context, attrs);
	}

	/**
	 * 1行に入力可能な文字数を返します
	 * @return 文字数
	 */
	public int getTextCount() {
		return mTextCount;
	}

	/**
	 *　{@inheritDoc}
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int widthSize = MeasureSpec.getSize(widthMeasureSpec);
		int calcWidth = calcWidth();
		if (widthSize < calcWidth) {
			widthSize = calcWidth;
		}

		super.onMeasure(MeasureSpec.makeMeasureSpec(widthSize, MeasureSpec.EXACTLY), heightMeasureSpec);
	}

	/**
	 * 1行に入力可能な文字数を取得します
	 * @param context コンテキスト
	 * @param attrs 属性
	 */
	private void initTextCount(Context context, AttributeSet attrs) {
		TypedArray a = context.getTheme().obtainStyledAttributes(
				attrs,
				R.styleable.FixedLengthEditText,
				0,
				0);
		try {
			mTextCount = a.getInteger(R.styleable.FixedLengthEditText_textCount, 0);
		} finally {
			a.recycle();
		}
	}

	/**
	 * 指定した文字数が収まる幅を計算し返します
	 * @return 幅
	 */
	private int calcWidth() {
		if (mTextCount == 0) {
			return 0;
		}

		StringBuilder builder = new StringBuilder(mTextCount);
		for (int i = 0; i <= mTextCount; i++) {
			builder.append("あ");
		}
		mPaint.setTextSize(getTextSize());
		float width = mPaint.measureText(builder.toString());
		return (int) Math.ceil(width);
	}
}
