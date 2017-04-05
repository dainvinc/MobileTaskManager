package com.example.visha.androidencryptionapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static int[][] mat = new int[4][4];
    private EditText mEnterText;
    private Button mEncryptButton;
    private TextView mViewText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //EditText
        mEnterText = (EditText) findViewById(R.id.enterText);

        //Button
        mEncryptButton = (Button) findViewById(R.id.encryptButton);
        mEncryptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sometext = mEnterText.getText().toString();
                getHexMatP('~', sometext);
                mViewText.setText(getHexMatP('~', sometext).toString());
                System.out.println(getHexMatP('~', sometext));
            }
        });

        //TextView
        mViewText = (TextView) findViewById(R.id.viewText);


    }

    public int[][] getHexMatP(char s, String p) {
        int[] set = new int[p.length()];
        String str = p;
        char[] ch = new char[64];
        for(int i=0; i<p.length(); i++) {
            ch[i] = p.charAt(i);
        }
        int n =0;
        int k=0;
        for(int q=0; q<set.length; q++) {
            System.out.println();
            for(int j=0; j<16; j++) {
                try {
                    while(n < 4) {
                        mat[n][j] = (int)ch[k];
                        if(ch[k] == 0)
                            mat[n][j] = (int)s;
                        n++;
                        k++;
                    }
                    n = 0;
                } catch(Exception e) {}
            }
            //printMat();
        }
        return mat;
    }
}
