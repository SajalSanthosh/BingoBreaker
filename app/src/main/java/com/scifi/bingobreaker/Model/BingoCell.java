package com.scifi.bingobreaker.Model;

import android.widget.EditText;
import android.widget.TextView;

public class BingoCell
{
    private EditText editText;
    private boolean isCalled;

    public BingoCell(EditText editText)
    {
        this.editText = editText;
    }


    public TextView getEditText()
    {
        return editText;
    }

    public void setEditText(EditText editText)
    {
        this.editText = editText;
    }

    public boolean isCalled()
    {
        return isCalled;
    }

    public void setCalled(boolean called)
    {
        isCalled = called;
    }
}
