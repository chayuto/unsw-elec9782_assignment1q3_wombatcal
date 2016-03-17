package chayut.me.wombatcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    WombatCalLogic calLogic;
    TextView calDisplay ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calLogic = new WombatCalLogic();

        calDisplay = (TextView) findViewById(R.id.textViewCalDisplay);
    }

    public void onButtonPressed(View view){
        Log.d(TAG, "onButtonPressed()");

        switch (view.getId()) {
            case R.id.buttonOne:
                calDisplay.setText(calLogic.numberPress(1));
                break;
            case R.id.buttonTwo:
                calDisplay.setText(calLogic.numberPress(2));
                break;
            case R.id.buttonThree:
                calDisplay.setText(calLogic.numberPress(3));
                break;
            case R.id.buttonFour:
                calDisplay.setText(calLogic.numberPress(4));
                break;
            case R.id.buttonFive:
                calDisplay.setText(calLogic.numberPress(5));
                break;
            case R.id.buttonSix:
                calDisplay.setText(calLogic.numberPress(6));
                break;
            case R.id.buttonSeven:
                calDisplay.setText(calLogic.numberPress(7));
                break;
            case R.id.buttonEight:
                calDisplay.setText(calLogic.numberPress(8));
                break;
            case R.id.buttonNine:
                calDisplay.setText(calLogic.numberPress(9));
                break;
            case R.id.buttonZero:
                calDisplay.setText(calLogic.numberPress(0));
                break;
            case R.id.buttonPlus:
                calDisplay.setText(calLogic.opPress(WombatCalLogic.OP_PLUS));
                break;
            case R.id.buttonMinus:
                calDisplay.setText(calLogic.opPress(WombatCalLogic.OP_MINUS));
                break;
            case R.id.buttonDivide:
                calDisplay.setText(calLogic.opPress(WombatCalLogic.OP_DIVIDE));
                break;
            case R.id.buttonMultiply:
                calDisplay.setText(calLogic.opPress(WombatCalLogic.OP_MULTIPLY));
                break;
            case R.id.buttonClear:
                calDisplay.setText(calLogic.clearPress());
            default:
                break;
        }
    }




}
