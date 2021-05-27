package com.scifi.bingobreaker;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class InputButtonsFragment extends Fragment implements View.OnClickListener
{

    public InputButtonsFragment()
    {
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    private void setListener(TableRow row)
    {
        for (int i = 0; i < row.getChildCount(); i++)
        {
            if (row.getChildAt(i) instanceof HorizontalScrollView)
            {
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) row.getChildAt(i);
                TableRow tableRow = (TableRow) horizontalScrollView.getChildAt(0);

                for (int j = 0; j < tableRow.getChildCount(); j++)
                {
                    TextView textView = (TextView) tableRow.getChildAt(j);
                    textView.setOnClickListener(this);
                }
            }
        }
    }

        @Override public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View view = inflater.inflate(R.layout.fragment_input_buttons, container, false);

            TableRow row1 = view.findViewById(R.id.btn_row_B);
            TableRow row2 = view.findViewById(R.id.btn_row_I);
            TableRow row3 = view.findViewById(R.id.btn_row_N);
            TableRow row4 = view.findViewById(R.id.btn_row_G);
            TableRow row5 = view.findViewById(R.id.btn_row_O);

            setListener(row1);
            setListener(row2);
            setListener(row3);
            setListener(row4);
            setListener(row5);
            return view;
        }

        @Override public void onClick (View view)
        {
            Button button = (Button) view;
            int number = Integer.parseInt(button.getText().toString());

            MainActivity mainActivity = ((MainActivity)getActivity());

            switch (((View)button.getParent().getParent().getParent()).getId())
            {
                case R.id.btn_row_B:
                    mainActivity.callNumber("B", number);
                    break;
                case R.id.btn_row_I:
                    mainActivity.callNumber("I", number);
                    break;
                case R.id.btn_row_N:
                    mainActivity.callNumber("N", number);
                    break;
                case R.id.btn_row_G:
                    mainActivity.callNumber("G", number);
                    break;
                case R.id.btn_row_O:
                    mainActivity.callNumber("O", number);
                    break;
            }
        }
    }
