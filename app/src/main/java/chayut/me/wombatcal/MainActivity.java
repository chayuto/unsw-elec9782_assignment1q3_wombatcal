package chayut.me.wombatcal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    WombatCalLogic calLogic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calLogic = new WombatCalLogic();


    }

    public void onButtonPressed(View view){
        switch (view.getId()) {

            case R.id.buttonOne:
                calLogic.numberPress(1);
                break;
            case R.id.buttonTwo:
                calLogic.numberPress(2);
                break;
            case R.id.buttonThree:
                calLogic.numberPress(3);
                break;
            case R.id.buttonFour:
                calLogic.numberPress(4);
                break;
            case R.id.buttonFive:
                calLogic.numberPress(5);
                break;
            case R.id.buttonSix:
                calLogic.numberPress(6);
                break;
            case R.id.buttonSeven:
                calLogic.numberPress(7);
                break;
            case R.id.buttonEight:
                calLogic.numberPress(8);
                break;
            case R.id.buttonNine:
                calLogic.numberPress(9);
                break;
            case R.id.buttonZero:
                calLogic.numberPress(0);
                break;
            case R.id.buttonPlus:
                calLogic.opPress(WombatCalLogic.OP_PLUS);
                break;
            case R.id.buttonMinus:
                calLogic.opPress(WombatCalLogic.OP_MINUS);
                break;
            case R.id.buttonDivide:
                calLogic.opPress(WombatCalLogic.OP_DIVIDE);
                break;
            case R.id.buttonMultiply:
                calLogic.opPress(WombatCalLogic.OP_MULTIPLY);
                break;
            case R.id.buttonClear:
                calLogic.clearPress();
            default:
                break;
        }
    }




}
