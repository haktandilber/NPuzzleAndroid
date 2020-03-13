/*Haktan Bilgehan Dilber 171044070 */
package com.example.npuzzle;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView[][] texts = new TextView[9][9];
        texts = setViews(texts);
        final Button buttonUp = findViewById(R.id.button);
        Button buttonDown = findViewById(R.id.button2);
        Button buttonLeft = findViewById(R.id.button3);
        Button buttonRight = findViewById(R.id.button4);
        Button buttonSetSize = findViewById(R.id.buttonSetSize);
        TextInputEditText xin= findViewById(R.id.inputx);
        TextInputEditText yin= findViewById(R.id.inputy);
        BoardArray2D theBoard= new BoardArray2D();
        theBoard.setSize(3,3);
        theBoard.readFromArray(theBoard.sizedArr());
        theBoard.shuffle();
        theBoard.showBoard(texts);


        buttonSetSize.setOnClickListener(new MyOnClickListener(theBoard,texts,xin,yin) {
            @Override
            public void onClick(View v) {
                if(!xin.getText().toString().equals("") & !yin.getText().toString().equals("") /*& Integer.valueOf(xin.getText().toString())>2 & Integer.valueOf(yin.getText().toString())>2*/){
                    theBoard.setSize((Integer.valueOf(xin.getText().toString())%10),(Integer.valueOf(yin.getText().toString())%10));
                    theBoard.readFromArray(theBoard.sizedArr());
                    theBoard.shuffle();
                    theBoard.showBoard(texts);
                    theBoard.setNumberOfMoves(0);
                    TextView moves = findViewById(R.id.textView92);
                    moves.setText(String.valueOf(theBoard.getNumberOfMoves()));
                }

            }
        });
        buttonUp.setOnClickListener(new MyOnClickListener(theBoard,texts,xin,yin) {
            @Override
            public void onClick(View v) {
                if(theBoard.move('U')){
                    theBoard.setNumberOfMoves(theBoard.getNumberOfMoves()+1);
                }
                TextView moves = findViewById(R.id.textView92);
                moves.setText(String.valueOf(theBoard.getNumberOfMoves()));
                theBoard.showBoard(texts);
                if(theBoard.isSolved()){
                    Toast toast = Toast.makeText(getApplicationContext(), "You won!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
        buttonDown.setOnClickListener(new MyOnClickListener(theBoard,texts,xin,yin) {
            @Override
            public void onClick(View v) {
                if(theBoard.move('D')){
                    theBoard.setNumberOfMoves(theBoard.getNumberOfMoves()+1);
                }
                TextView moves = findViewById(R.id.textView92);
                moves.setText(String.valueOf(theBoard.getNumberOfMoves()));
                theBoard.showBoard(texts);
                if(theBoard.isSolved()){
                    Toast toast = Toast.makeText(getApplicationContext(), "You won!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
        buttonLeft.setOnClickListener(new MyOnClickListener(theBoard,texts,xin,yin) {
            @Override
            public void onClick(View v) {
                if(theBoard.move('L')){
                    theBoard.setNumberOfMoves(theBoard.getNumberOfMoves()+1);
                }
                TextView moves = findViewById(R.id.textView92);
                moves.setText(String.valueOf(theBoard.getNumberOfMoves()));
                theBoard.showBoard(texts);
                if(theBoard.isSolved()){
                    Toast toast = Toast.makeText(getApplicationContext(), "You won!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
        buttonRight.setOnClickListener(new MyOnClickListener(theBoard,texts,xin,yin) {
            @Override
            public void onClick(View v) {
                if(theBoard.move('R')){
                    theBoard.setNumberOfMoves(theBoard.getNumberOfMoves()+1);
                }
                TextView moves = findViewById(R.id.textView92);
                moves.setText(String.valueOf(theBoard.getNumberOfMoves()));
                theBoard.showBoard(texts);
                if(theBoard.isSolved()){
                    Toast toast = Toast.makeText(getApplicationContext(), "You won!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
    }
    public class MyOnClickListener implements View.OnClickListener
    {

        BoardArray2D theBoard;
        TextView[][] texts;
        TextInputEditText xin,yin;
        public MyOnClickListener(BoardArray2D theBoard, TextView[][] texts, TextInputEditText xin, TextInputEditText yin) {
            this.theBoard = theBoard;
            this.texts=texts;
            this.xin=xin;
            this.yin=yin;        }

        @Override
        public void onClick(View v)
        {
        }

    };

    public TextView[][] setViews(TextView[][] texts){
        //TextView[][] textsTemp = new TextView[9][9];
        texts[0][0]= findViewById(R.id.textView);
        texts[0][1]= findViewById(R.id.textView2);
        texts[0][2]= findViewById(R.id.textView3);
        texts[0][3]= findViewById(R.id.textView4);
        texts[0][4]= findViewById(R.id.textView5);
        texts[0][5]= findViewById(R.id.textView6);
        texts[0][6]= findViewById(R.id.textView7);
        texts[0][7]= findViewById(R.id.textView8);
        texts[0][8]= findViewById(R.id.textView9);
        texts[1][0]= findViewById(R.id.textView10);
        texts[1][1]= findViewById(R.id.textView11);
        texts[1][2]= findViewById(R.id.textView12);
        texts[1][3]= findViewById(R.id.textView13);
        texts[1][4]= findViewById(R.id.textView14);
        texts[1][5]= findViewById(R.id.textView15);
        texts[1][6]= findViewById(R.id.textView16);
        texts[1][7]= findViewById(R.id.textView17);
        texts[1][8]= findViewById(R.id.textView18);
        texts[2][0]= findViewById(R.id.textView19);
        texts[2][1]= findViewById(R.id.textView20);
        texts[2][2]= findViewById(R.id.textView21);
        texts[2][3]= findViewById(R.id.textView22);
        texts[2][4]= findViewById(R.id.textView23);
        texts[2][5]= findViewById(R.id.textView24);
        texts[2][6]= findViewById(R.id.textView25);
        texts[2][7]= findViewById(R.id.textView26);
        texts[2][8]= findViewById(R.id.textView27);
        texts[3][0]= findViewById(R.id.textView28);
        texts[3][1]= findViewById(R.id.textView29);
        texts[3][2]= findViewById(R.id.textView30);
        texts[3][3]= findViewById(R.id.textView31);
        texts[3][4]= findViewById(R.id.textView32);
        texts[3][5]= findViewById(R.id.textView33);
        texts[3][6]= findViewById(R.id.textView34);
        texts[3][7]= findViewById(R.id.textView35);
        texts[3][8]= findViewById(R.id.textView36);
        texts[4][0]= findViewById(R.id.textView37);
        texts[4][1]= findViewById(R.id.textView38);
        texts[4][2]= findViewById(R.id.textView39);
        texts[4][3]= findViewById(R.id.textView40);
        texts[4][4]= findViewById(R.id.textView41);
        texts[4][5]= findViewById(R.id.textView42);
        texts[4][6]= findViewById(R.id.textView43);
        texts[4][7]= findViewById(R.id.textView44);
        texts[4][8]= findViewById(R.id.textView45);
        texts[5][0]= findViewById(R.id.textView46);
        texts[5][1]= findViewById(R.id.textView47);
        texts[5][2]= findViewById(R.id.textView48);
        texts[5][3]= findViewById(R.id.textView49);
        texts[5][4]= findViewById(R.id.textView50);
        texts[5][5]= findViewById(R.id.textView51);
        texts[5][6]= findViewById(R.id.textView52);
        texts[5][7]= findViewById(R.id.textView53);
        texts[5][8]= findViewById(R.id.textView54);
        texts[6][0]= findViewById(R.id.textView55);
        texts[6][1]= findViewById(R.id.textView56);
        texts[6][2]= findViewById(R.id.textView57);
        texts[6][3]= findViewById(R.id.textView58);
        texts[6][4]= findViewById(R.id.textView59);
        texts[6][5]= findViewById(R.id.textView60);
        texts[6][6]= findViewById(R.id.textView61);
        texts[6][7]= findViewById(R.id.textView62);
        texts[6][8]= findViewById(R.id.textView63);
        texts[7][0]= findViewById(R.id.textView64);
        texts[7][1]= findViewById(R.id.textView65);
        texts[7][2]= findViewById(R.id.textView66);
        texts[7][3]= findViewById(R.id.textView67);
        texts[7][4]= findViewById(R.id.textView68);
        texts[7][5]= findViewById(R.id.textView69);
        texts[7][6]= findViewById(R.id.textView70);
        texts[7][7]= findViewById(R.id.textView71);
        texts[7][8]= findViewById(R.id.textView72);
        texts[8][0]= findViewById(R.id.textView73);
        texts[8][1]= findViewById(R.id.textView74);
        texts[8][2]= findViewById(R.id.textView75);
        texts[8][3]= findViewById(R.id.textView76);
        texts[8][4]= findViewById(R.id.textView77);
        texts[8][5]= findViewById(R.id.textView78);
        texts[8][6]= findViewById(R.id.textView79);
        texts[8][7]= findViewById(R.id.textView80);
        texts[8][8]= findViewById(R.id.textView81);

        return  texts;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
