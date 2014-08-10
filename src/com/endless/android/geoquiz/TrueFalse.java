package com.endless.android.geoquiz;

public class TrueFalse {
	private int mQuestion; // 保存问题字符串的资源 ID

	private boolean mTrueQuestion;

	public TrueFalse(int question, boolean trueQuestion) {
		mQuestion = question;
		mTrueQuestion = trueQuestion;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}
}
