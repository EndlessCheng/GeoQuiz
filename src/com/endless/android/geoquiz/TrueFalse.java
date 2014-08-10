package com.endless.android.geoquiz;

public class TrueFalse {
	private int mQuestion; // 保存问题字符串的资源 ID

	private boolean mTrueQuestion;

	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
	}
}
