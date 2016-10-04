package singltondemo.ranjeet.android.com.duplicatecharacters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {
    EditText txt;
    TextView youtext,result,Resultstag,Resultsline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txt=(EditText)findViewById(R.id.editText);
        Button btn=(Button)findViewById(R.id.button);
        youtext=(TextView)findViewById(R.id.textView2);
        result=(TextView)findViewById(R.id.textView3);
        Resultstag=(TextView)findViewById(R.id.Results);
        Resultsline=(TextView)findViewById(R.id.Resultsline);
        Resultstag.setVisibility(View.INVISIBLE);
        Resultsline.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txt.getText().toString().length()>0)
                {
                    GetDuplicate(txt.getText().toString());
                }
                else
                {
                    txt.setError("Enter your text");
                }

            }
        });


    }


    public void GetDuplicate(String text)
    {
        try {
             Log.e("Enter any word 1: ","text-"+text);

            //use ByteArrayInputStream to get the bytes of the String and convert them to InputStream.
            InputStream inputStream = new ByteArrayInputStream(text.getBytes(Charset.forName("UTF-8")));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String s = bufferedReader.readLine();
            Log.e("Enter any word 3: ","text-"+s);
            int l = s.length();
            char ch;
            String ans = "";

            for (int i = 0; i < l; i++) {
                ch = s.charAt(i);
                if (ch != ' ')
                    ans = ans + ch;
                s = s.replace(ch, ' '); //Replacing all occurrence of the current character by a space
            }
            Resultstag.setVisibility(View.VISIBLE);
            Resultsline.setVisibility(View.VISIBLE);
            youtext.setText(text);
            result.setText(ans);

        }
        catch (Exception e)
        {


    }
    }
}
