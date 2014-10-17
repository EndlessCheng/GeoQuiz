package com.endless.android.geoquiz;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends Activity {

	private static final String TAG = "QuizActivity";
	private static final String KEY_INDEX = "index";

	private Button mTrueButton;
	private Button mFalseButton;
	private Button mPrevButton;
	private Button mNextButton;
	private TextView mQuestionTextView;
	private TextView mApiLevelTextView;

	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_me, true),
			new TrueFalse(R.string.question_you, false),
			new TrueFalse(R.string.question_java, true),
			new TrueFalse(R.string.question_cplusplus, true),
			new TrueFalse(R.string.question_python, true) };

	private int mCurrentIndex = 0;

	private void updateQuestion() {
		int question = mQuestionBank[mCurrentIndex].getQuestion();
		mQuestionTextView.setText(question);
	}

	private void checkAnswer(boolean userPressedTrue) {
		boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion();
		Toast.makeText(
				this,
				answerIsTrue == userPressedTrue ? R.string.correct_toast
						: R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
	}

	@TargetApi(11)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate(Bundle) called");  // *********

		setContentView(R.layout.activity_quiz);
		mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
		mQuestionTextView.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			ActionBar actionBar = getActionBar();
			actionBar.setSubtitle("∏„—ßœ∞£°");
			mApiLevelTextView = (TextView) findViewById(R.id.api_level_text_view);
			mApiLevelTextView.setText("API Level " + Build.VERSION.SDK_INT);
		}

		mTrueButton = (Button) findViewById(R.id.true_button);
		mTrueButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				checkAnswer(true);
			}
		});

		mFalseButton = (Button) findViewById(R.id.false_button);
		mFalseButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				checkAnswer(false);
			}
		});

		mPrevButton = (Button) findViewById(R.id.prev_button);
		mPrevButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex - 1 + mQuestionBank.length)
						% mQuestionBank.length;
				updateQuestion();
			}
		});

		mNextButton = (Button) findViewById(R.id.next_button);
		mNextButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				updateQuestion();
			}
		});

		if (savedInstanceState != null) {
			mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
		}

		updateQuestion();
	}

	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);
		Log.i(TAG, "savedInstanceState");
		savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d(TAG, "onStart() called");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d(TAG, "onPause() called");
	}

	@Override
	public void onResume() {
		super.onResume();
		// Intent i = new Intent(QuizActivity.this, CheatActivity.class);
		// startActivity(i);
		Log.d(TAG, "onResume() called");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d(TAG, "onStop() called");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy() called");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.geo, menu);
		return true;
	}

}
