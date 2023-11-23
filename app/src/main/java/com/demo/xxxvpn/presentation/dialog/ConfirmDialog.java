package com.demo.xxxvpn.presentation.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

import com.demo.xxxvpn.R;

public class ConfirmDialog extends Dialog {
    private Button btnConfirm;
    private Button btnCancel;
    private View view;
    private TextView title,message,tvTime;
    private String messageStr;
    private String titleStr;

    private String timeStr;

    private String confirmStr;

    private String cancelStr;
    private onConfirmOnclickListener onConfirmOnclickListener;
    private onCancelOnclickListener onCancelOnclickListener;

    public ConfirmDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    public void setConfirmOnclickListener(String str, onConfirmOnclickListener onConfirmOnclickListener) {
        if (str != null) {
            confirmStr = str;
        }
        this.onConfirmOnclickListener = onConfirmOnclickListener;
    }

    public void setCancelOnclickListener(String str, onCancelOnclickListener onCancelOnclickListener) {
        if (str != null) {
            cancelStr = str;
        }
        this.onCancelOnclickListener = onCancelOnclickListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirm);
        setCanceledOnTouchOutside(false);

        initView();
        initData();
        initEvent();
    }

    private void initView() {
        view = findViewById(R.id.view);
        btnConfirm = findViewById(R.id.btn_confirm);
        btnCancel = findViewById(R.id.btn_cancel);
        title = findViewById(R.id.title);
        message = findViewById(R.id.message);
        tvTime = findViewById(R.id.tv_time);
    }

    private void initData() {
        if (messageStr != null) {
            message.setText(messageStr);
            message.setMovementMethod(ScrollingMovementMethod.getInstance());
        }

        if (titleStr != null) {
            tvTime.setVisibility(View.VISIBLE);
            title.setText(titleStr);
        }else {
            title.setVisibility(View.GONE);
        }

        if (timeStr != null) {
            tvTime.setVisibility(View.VISIBLE);
            tvTime.setText(timeStr);
        }else {
            tvTime.setVisibility(View.GONE);
        }

        if (confirmStr != null) {
            btnConfirm.setText(confirmStr);
        }
        if (cancelStr != null) {
            btnCancel.setText(cancelStr);
        }else {
            btnCancel.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
        }
    }

    private void initEvent() {
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onConfirmOnclickListener != null) {
                    onConfirmOnclickListener.onConfirmOnclick();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onCancelOnclickListener != null) {
                    onCancelOnclickListener.onCancelOnclick();
                }

            }
        });
    }

    public void setMessage(String message) {
        messageStr = message;
    }

    public void setTitle(String titleStr) {
        this.titleStr = titleStr;
    }

    public void setTime(String time) {
        timeStr = time;
    }

    public interface onConfirmOnclickListener {
        public void onConfirmOnclick();
    }

    public interface onCancelOnclickListener {
        public void onCancelOnclick();
    }
}
