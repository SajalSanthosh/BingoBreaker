package com.scifi.bingobreaker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.scifi.bingobreaker.Utils.ObjectSerializer;
import java.io.IOException;
import cn.refactor.lib.colordialog.PromptDialog;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener
{
    BingoFragment bingoFragment1;
    BingoFragment bingoFragment2;
    BingoFragment bingoFragment3;
    BingoFragment bingoFragment4;
    BingoFragment bingoFragment5;
    BingoFragment bingoFragment6;
    BingoFragment bingoFragment7;
    BingoFragment bingoFragment8;

    RadioGroup bingo_patterns;
    private SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        bingoFragment1 = (BingoFragment) fm.findFragmentById(R.id.bingo1);
        bingoFragment2 = (BingoFragment) fm.findFragmentById(R.id.bingo2);
        bingoFragment3 = (BingoFragment) fm.findFragmentById(R.id.bingo3);
        bingoFragment4 = (BingoFragment) fm.findFragmentById(R.id.bingo4);
        bingoFragment5 = (BingoFragment) fm.findFragmentById(R.id.bingo5);
        bingoFragment6 = (BingoFragment) fm.findFragmentById(R.id.bingo6);
        bingoFragment7 = (BingoFragment) fm.findFragmentById(R.id.bingo7);
        bingoFragment8 = (BingoFragment) fm.findFragmentById(R.id.bingo8);

        bingo_patterns = findViewById(R.id.bingo_patterns);
        bingo_patterns.setOnCheckedChangeListener(this);

        Button resetBtn = findViewById(R.id.btn_reset);
        Button saveBtn = findViewById(R.id.btn_save);

        resetBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);

        sharedpreferences = getSharedPreferences("bingo_settings", Context.MODE_PRIVATE);

        bingoFragment1.loadBingo(getSavedBingo(1));
        bingoFragment2.loadBingo(getSavedBingo(2));
        bingoFragment3.loadBingo(getSavedBingo(3));
        bingoFragment4.loadBingo(getSavedBingo(4));
        bingoFragment5.loadBingo(getSavedBingo(5));
        bingoFragment6.loadBingo(getSavedBingo(6));
        bingoFragment7.loadBingo(getSavedBingo(7));
        bingoFragment8.loadBingo(getSavedBingo(8));
    }

    public void callNumber(String column, int num)
    {
        bingoFragment1.callNumber(column, num);
        bingoFragment2.callNumber(column, num);
        bingoFragment3.callNumber(column, num);
        bingoFragment4.callNumber(column, num);
        bingoFragment5.callNumber(column, num);
        bingoFragment6.callNumber(column, num);
        bingoFragment7.callNumber(column, num);
        bingoFragment8.callNumber(column, num);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i)
    {
        {
            int selectedId = radioGroup.getCheckedRadioButtonId();

            switch (selectedId)
            {
                case R.id.miniX:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.MINIX);
                    break;
                case R.id.bigX:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.BIGX);
                    break;
                case R.id.smallBox:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.SMALL_BOX);
                    break;
                case R.id.corners:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.CORNERS);
                    break;
                case R.id.rotating_postage_stamp:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.ROTATING_POSTAGE_STAMP);
                    break;
                case R.id.one_line_any_way:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.ONE_LINE_ANY_WAY);
                    break;
                case R.id.mini_plus:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.MINI_PLUS);
                    break;
                case R.id.person_yelling_bingo:
                    bingoFragment1.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment2.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment3.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment4.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment5.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment6.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment7.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    bingoFragment8.setBingomode(BingoFragment.BINGOMODE.PERSON_YELLING_BINGO);
                    break;
            }

        }
    }

    private void saveBingo(int bingoNumber, int[][] bingoAsArray)
    {
        try
        {
            sharedpreferences.edit().putString("Bingo" + bingoNumber, ObjectSerializer.serialize(bingoAsArray)).apply();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    private int[][] getSavedBingo(int bingoNumber)
    {
        int[][] bingoNumbers = new int[5][5];

        if (sharedpreferences.contains("Bingo" + bingoNumber))
        {
            try
            {
                bingoNumbers = (int[][]) ObjectSerializer.deserialize(sharedpreferences.getString("Bingo" + bingoNumber, null));
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return bingoNumbers;
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_reset:
                bingoFragment1.resetBingo();
                bingoFragment2.resetBingo();
                bingoFragment3.resetBingo();
                bingoFragment4.resetBingo();
                bingoFragment5.resetBingo();
                bingoFragment6.resetBingo();
                bingoFragment7.resetBingo();
                bingoFragment8.resetBingo();
                break;
            case R.id.btn_save:
                int[][] bingoAsArray;
                bingoAsArray = bingoFragment1.getBingoAsArray();
                saveBingo(1, bingoAsArray);
                bingoAsArray = bingoFragment2.getBingoAsArray();
                saveBingo(2, bingoAsArray);
                bingoAsArray = bingoFragment3.getBingoAsArray();
                saveBingo(3, bingoAsArray);
                bingoAsArray = bingoFragment4.getBingoAsArray();
                saveBingo(4, bingoAsArray);
                bingoAsArray = bingoFragment5.getBingoAsArray();
                saveBingo(5, bingoAsArray);
                bingoAsArray = bingoFragment6.getBingoAsArray();
                saveBingo(6, bingoAsArray);
                bingoAsArray = bingoFragment7.getBingoAsArray();
                saveBingo(7, bingoAsArray);
                bingoAsArray = bingoFragment8.getBingoAsArray();
                saveBingo(8, bingoAsArray);
                break;
        }
    }

    public void GotBingo()
    {
        new PromptDialog(this)
                .setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS)
                .setAnimationEnable(true)
                .setTitleText("Congrats!")
                .setContentText("You have a Bingo!!!")
                .setPositiveListener("OK", new PromptDialog.OnPositiveListener() {
                    @Override
                    public void onClick(PromptDialog dialog)
                    {
                        dialog.dismiss();
                    }}).show();
    }
}

