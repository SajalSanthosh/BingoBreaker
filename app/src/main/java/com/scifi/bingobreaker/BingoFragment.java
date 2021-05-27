package com.scifi.bingobreaker;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableRow;

import androidx.fragment.app.Fragment;

import com.scifi.bingobreaker.Model.BingoCell;

import java.util.ArrayList;
import java.util.Arrays;


public class BingoFragment extends Fragment
{
    private View view;
    private ArrayList<BingoCell> columnB = new ArrayList<>();
    private ArrayList<BingoCell> columnI = new ArrayList<>();
    private ArrayList<BingoCell> columnN = new ArrayList<>();
    private ArrayList<BingoCell> columnG = new ArrayList<>();
    private ArrayList<BingoCell> columnO = new ArrayList<>();

    private BINGOMODE bingomode = BINGOMODE.ROTATING_POSTAGE_STAMP;

    //    private boolean[][] bingoSolution = new boolean[4][4];
    private boolean[][] bingoSolution = {{false, false, false, false, false}, {false, true, false, true, false}, {false, false, true, false, false}, {false, true, false, true, false}, {false, false, false, false, false},};

    public BingoFragment()
    {
        bingoSolution[2][2] = true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    public BINGOMODE getBingomode()
    {
        return bingomode;
    }

    public void setBingomode(BINGOMODE bingomode)
    {
        this.bingomode = bingomode;
    }


    enum BINGOMODE
    {
        MINIX, BIGX, SMALL_BOX, CORNERS, ROTATING_POSTAGE_STAMP, ONE_LINE_ANY_WAY, MINI_PLUS, PERSON_YELLING_BINGO
    }

    public boolean selectBingoMode(BINGOMODE mode)
    {
        boolean[][] miniX = {{false, false, false, false, false}, {false, true, false, true, false}, {false, false, true, false, false}, {false, true, false, true, false}, {false, false, false, false, false},};

        boolean[][] BigX = {{true, false, false, false, true}, {false, true, false, true, false}, {false, false, true, false, false}, {false, true, false, true, false}, {true, false, false, false, true},};

        boolean[][] smallBox = {{false, false, false, false, false}, {false, true, true, true, false}, {false, true, true, true, false}, {false, true, true, true, false}, {false, false, false, false, false},};

        boolean[][] corners = {{true, false, false, false, true}, {false, false, false, false, false}, {false, false, true, false, false}, {false, false, false, false, false}, {true, false, false, false, true},};

        boolean[][] rotating_postage_stamp1 = {{true, true, false, false, false}, {true, true, false, false, false}, {false, false, true, false, false}, {false, false, false, false, false}, {false, false, false, false, false},};

        boolean[][] rotating_postage_stamp2 = {{false, false, false, true, true}, {false, false, false, true, true}, {false, false, true, false, false}, {false, false, false, false, false}, {false, false, false, false, false},};

        boolean[][] rotating_postage_stamp3 = {{false, false, false, false, false}, {false, false, false, false, false}, {false, false, true, false, false}, {true, true, false, false, false}, {true, true, false, false, false},};

        boolean[][] rotating_postage_stamp4 = {{false, false, false, false, false}, {false, false, false, false, false}, {false, false, true, false, false}, {false, false, false, true, true}, {false, false, false, true, true},};

        boolean[][] diagonal1 = {{true, false, false, false, false}, {false, true, false, false, false}, {false, false, true, false, false}, {false, false, false, true, false}, {false, false, false, false, true},};


        boolean[][] diagonal2 = {{false, false, false, false, true}, {false, false, false, true, false}, {false, false, true, false, false}, {false, true, false, false, false}, {true, false, false, false, false},};


        boolean[][] miniPlus = {{false, false, false, false, false}, {false, false, true, false, false}, {false, true, true, true, false}, {false, false, true, false, false}, {false, false, false, false, false},};


        boolean[][] person_yelling_bingo = {{false, true, false, true, false}, {false, false, false, false, false}, {false, false, true, false, false}, {false, false, true, false, false}, {false, false, false, false, false},};


        switch (mode)
        {
            case MINIX:
                bingoSolution = miniX;
                return isBingo();
            case BIGX:
                bingoSolution = BigX;
                return isBingo();
            case SMALL_BOX:
                bingoSolution = smallBox;
                return isBingo();
            case CORNERS:
                bingoSolution = corners;
                return isBingo();
            case MINI_PLUS:
                bingoSolution = miniPlus;
                return isBingo();
            case PERSON_YELLING_BINGO:
                bingoSolution = person_yelling_bingo;
                return isBingo();
            case ROTATING_POSTAGE_STAMP:
                bingoSolution = rotating_postage_stamp1;
                boolean b;
                b = isBingo();
                if (b)
                    return true;
                bingoSolution = rotating_postage_stamp2;
                b = isBingo();
                if (b)
                    return true;
                bingoSolution = rotating_postage_stamp3;
                b = isBingo();
                if (b)
                    return true;
                bingoSolution = rotating_postage_stamp4;
                b = isBingo();
                if (b)
                    return true;
            case ONE_LINE_ANY_WAY:
                bingoSolution = new boolean[][]{{false, false, false, false, false}, {false, false, false, false, false}, {false, false, true, false, false}, {false, false, false, false, false}, {false, false, false, false, false},};
                for (int row = 0; row < 5; row++)
                {
                    for (int col = 0; col < 5; col++)
                    {
                        bingoSolution[row][col] = true;
                    }

                    //                    Log.d("BingoBreaker", Arrays.deepToString(bingoSolution));
                    b = isBingo();
                    if (b)
                        return true;

                    for (int col = 0; col < 5; col++)
                    {
                        bingoSolution[row][col] = false;
                    }

                    bingoSolution[2][2] = true;
                }

                for (int col = 0; col < 5; col++)
                {
                    for (int row = 0; row < 5; row++)
                    {
                        bingoSolution[row][col] = true;
                    }

                    Log.d("BingoBreaker", Arrays.deepToString(bingoSolution));
                    b = isBingo();
                    if (b)
                        return true;

                    for (int row = 0; row < 5; row++)
                    {
                        bingoSolution[row][col] = false;
                    }

                    bingoSolution[2][2] = true;
                }
                bingoSolution = diagonal1;
                b = isBingo();
                if (b)
                    return true;
                bingoSolution = diagonal2;
                b = isBingo();
                if (b)
                    return true;
        }
        return false;
    }


    public boolean isBingo()
    {
        int noOfCalled = 0;
        int noOfCalledInSolution = 0;

        for (int row = 0; row < 5; row++)
        {
            for (int col = 0; col < 5; col++)
            {
                boolean b = bingoSolution[row][col];
                if (!b)
                    continue;
                noOfCalledInSolution++;

                switch (col)
                {
                    case 0:
                        if (columnB.get(row).isCalled())
                            noOfCalled++;
                        break;
                    case 1:
                        if (columnI.get(row).isCalled())
                            noOfCalled++;
                        break;
                    case 2:
                        if (columnN.get(row).isCalled())
                            noOfCalled++;
                        break;
                    case 3:
                        if (columnG.get(row).isCalled())
                            noOfCalled++;
                        break;
                    case 4:
                        if (columnO.get(row).isCalled())
                            noOfCalled++;
                        break;
                }
            }
        }

        if (++noOfCalled == noOfCalledInSolution)
        {
            view.setBackgroundColor(Color.GREEN);
            Log.d("BingoBreaker", "BINGO !!!!!!!!!!");
            ((MainActivity) getActivity()).GotBingo();
            return true;
        }
        return false;
    }

    public void checkBingo()
    {
        selectBingoMode(bingomode);
    }

    public void resetBingo()
    {
        view.setBackgroundColor(Color.WHITE);
        for (BingoCell bingoCell : columnB)
        {
            bingoCell.getEditText().setTextColor(Color.GRAY);
            bingoCell.setCalled(false);
        }

        for (BingoCell bingoCell : columnI)
        {
            bingoCell.getEditText().setTextColor(Color.GRAY);
            bingoCell.setCalled(false);
        }

        for (BingoCell bingoCell : columnN)
        {
            bingoCell.getEditText().setTextColor(Color.GRAY);
            bingoCell.setCalled(false);
        }

        for (BingoCell bingoCell : columnG)
        {
            bingoCell.getEditText().setTextColor(Color.GRAY);
            bingoCell.setCalled(false);
        }

        for (BingoCell bingoCell : columnO)
        {
            bingoCell.getEditText().setTextColor(Color.GRAY);
            bingoCell.setCalled(false);
        }
    }

    public void callNumber(String column, int num)
    {
        String calledNum = String.valueOf(num);
        switch (column)
        {
            case "B":
                for (BingoCell bingoCell : columnB)
                {
                    if (bingoCell.getEditText().getText().toString().equals(calledNum))
                    {
                        if (bingoCell.isCalled())
                        {
                            bingoCell.getEditText().setTextColor(Color.GRAY);
                            bingoCell.setCalled(false);
                        } else
                        {
                            bingoCell.getEditText().setTextColor(Color.RED);
                            bingoCell.setCalled(true);
                        }
                    }
                }
                break;
            case "I":
                for (BingoCell bingoCell : columnI)
                {
                    if (bingoCell.getEditText().getText().toString().equals(calledNum))
                    {

                        if (bingoCell.isCalled())
                        {
                            bingoCell.getEditText().setTextColor(Color.GRAY);
                            bingoCell.setCalled(false);
                        } else
                        {
                            bingoCell.getEditText().setTextColor(Color.RED);
                            bingoCell.setCalled(true);
                        }
                    }
                }
                break;
            case "N":
                for (BingoCell bingoCell : columnN)
                {
                    if (bingoCell.getEditText().getText().toString().equals(calledNum))
                    {
                        if (bingoCell.isCalled())
                        {
                            bingoCell.getEditText().setTextColor(Color.GRAY);
                            bingoCell.setCalled(false);
                        } else
                        {
                            bingoCell.getEditText().setTextColor(Color.RED);
                            bingoCell.setCalled(true);
                        }
                    }
                }
                break;
            case "G":
                for (BingoCell bingoCell : columnG)
                {
                    if (bingoCell.getEditText().getText().toString().equals(calledNum))
                    {
                        if (bingoCell.isCalled())
                        {
                            bingoCell.getEditText().setTextColor(Color.GRAY);
                            bingoCell.setCalled(false);
                        } else
                        {
                            bingoCell.getEditText().setTextColor(Color.RED);
                            bingoCell.setCalled(true);
                        }
                    }
                }
                break;
            case "O":
                for (BingoCell bingoCell : columnO)
                {
                    if (bingoCell.getEditText().getText().toString().equals(calledNum))
                    {
                        if (bingoCell.isCalled())
                        {
                            bingoCell.getEditText().setTextColor(Color.GRAY);
                            bingoCell.setCalled(false);
                        } else
                        {
                            bingoCell.getEditText().setTextColor(Color.RED);
                            bingoCell.setCalled(true);
                        }
                    }
                }
                break;

        }
        checkBingo();

    }

        //Add the corresponding cells from bingo to the its array list
        private void generateBingoColumns (TableRow row)
        {
            for (int i = 0; i < row.getChildCount(); i++)
            {
                EditText editText = (EditText) row.getChildAt(i);

                switch (i)
                {
                    case 0:
                        columnB.add(new BingoCell(editText));
                        break;
                    case 1:
                        columnI.add(new BingoCell(editText));
                        break;
                    case 2:
                        columnN.add(new BingoCell(editText));
                        break;
                    case 3:
                        columnG.add(new BingoCell(editText));
                        break;
                    case 4:
                        columnO.add(new BingoCell(editText));
                        break;
                }
            }
        }

        public void loadBingo ( int[][] bingoAsArray)
        {
            for (int i = 0; i < columnB.size(); i++)
            {
                BingoCell bingoCell = columnB.get(i);
                bingoCell.getEditText().setText(String.valueOf(bingoAsArray[i][0]));
            }

            for (int i = 0; i < columnI.size(); i++)
            {
                BingoCell bingoCell = columnI.get(i);
                bingoCell.getEditText().setText(String.valueOf(bingoAsArray[i][1]));
            }

            for (int i = 0; i < columnN.size(); i++)
            {
                BingoCell bingoCell = columnN.get(i);
                if (i != 2)
                    bingoCell.getEditText().setText(String.valueOf(bingoAsArray[i][2]));
            }

            for (int i = 0; i < columnG.size(); i++)
            {
                BingoCell bingoCell = columnG.get(i);
                bingoCell.getEditText().setText(String.valueOf(bingoAsArray[i][3]));
            }

            for (int i = 0; i < columnO.size(); i++)
            {
                BingoCell bingoCell = columnO.get(i);
                bingoCell.getEditText().setText(String.valueOf(bingoAsArray[i][4]));
            }
        }

        public int[][] getBingoAsArray () {
        int[][] bingoNumbers = new int[5][5];

        for (int i = 0, columnBSize = columnB.size(); i < columnBSize; i++)
        {
            BingoCell bingoCell = columnB.get(i);
            bingoNumbers[i][0] = Integer.parseInt(bingoCell.getEditText().getText().toString());
        }

        for (int i = 0, columnSize = columnI.size(); i < columnSize; i++)
        {
            BingoCell bingoCell = columnI.get(i);
            bingoNumbers[i][1] = Integer.parseInt(bingoCell.getEditText().getText().toString());
        }

        for (int i = 0, columnSize = columnN.size(); i < columnSize; i++)
        {
            BingoCell bingoCell = columnN.get(i);
            bingoNumbers[i][2] = i == 2 ? 0 : Integer.parseInt(bingoCell.getEditText().getText().toString());
        }

        for (int i = 0, columnSize = columnG.size(); i < columnSize; i++)
        {
            BingoCell bingoCell = columnG.get(i);
            bingoNumbers[i][3] = Integer.parseInt(bingoCell.getEditText().getText().toString());
        }

        for (int i = 0, columnSize = columnO.size(); i < columnSize; i++)
        {
            BingoCell bingoCell = columnO.get(i);
            bingoNumbers[i][4] = Integer.parseInt(bingoCell.getEditText().getText().toString());
        }


        return bingoNumbers;
    }

        @Override public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            view = inflater.inflate(R.layout.fragment_bingo, container, false);

            TableRow row1 = view.findViewById(R.id.row_1);
            TableRow row2 = view.findViewById(R.id.row_2);
            TableRow row3 = view.findViewById(R.id.row_3);
            TableRow row4 = view.findViewById(R.id.row_4);
            TableRow row5 = view.findViewById(R.id.row_5);
            generateBingoColumns(row1);
            generateBingoColumns(row2);
            generateBingoColumns(row3);
            generateBingoColumns(row4);
            generateBingoColumns(row5);

            return view;
        }

    }
