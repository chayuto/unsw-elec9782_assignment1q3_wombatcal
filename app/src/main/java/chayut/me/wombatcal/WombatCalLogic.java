package chayut.me.wombatcal;

import android.util.Log;

/**
 * Created by chayut on 13/03/16.
 */
public class WombatCalLogic {

    private static final String TAG = "WombatCalLogic";

    private static final int WAIT_FOR_FIRST_NUMBER = 1;
    private static final int WAIT_FOR_OPERATOR = 2;
    private static final int WAIT_For_SECOND_NUMBER = 3;

    public static final int OP_PLUS =1;
    public static final int OP_MINUS =2;
    public static final int OP_MULTIPLY=3;
    public static final int OP_DIVIDE =4;

    private static final String[] opSym = {"+","-","*","/"};

    private int firstNumber;
    private int secondNumber;
    private int calState;
    private int opCode;


    public WombatCalLogic(){
        this.clearPress();
    }

    public String clearPress(){
        Log.d(TAG,"clearPress()");
        firstNumber = 0;
        secondNumber =0;
        opCode = 0;
        calState = WAIT_FOR_FIRST_NUMBER;
        return "";
    }
    public String numberPress (int number){
        Log.d(TAG,"numberPress()" + number );

        if(number<0 || number >9) {
            return "Invalid: Logic Error";
        }

        String outString = "";
        switch (calState){
            case WAIT_FOR_FIRST_NUMBER:
            case WAIT_FOR_OPERATOR:
                firstNumber = number;
                calState = WAIT_FOR_OPERATOR; //change state
                outString = String.format("%d", firstNumber);
                break;
            case WAIT_For_SECOND_NUMBER:
                secondNumber = number;
                //calculate stuff
                float result;
                switch (opCode){
                    case OP_PLUS:
                        result = firstNumber+secondNumber;
                        outString = String.format("%d %s %d = %.0f",firstNumber,opSym[opCode-1],secondNumber,result);
                        break;
                    case  OP_MINUS:
                        result = firstNumber-secondNumber;
                        outString = String.format("%d %s %d = %.0f",firstNumber,opSym[opCode-1],secondNumber,result);
                        break;
                    case OP_MULTIPLY:
                        result = firstNumber*secondNumber;
                        outString = String.format("%d %s %d = %.0f",firstNumber,opSym[opCode-1],secondNumber,result);
                        break;
                    case OP_DIVIDE:
                        if(secondNumber != 0) {
                            result = (float) firstNumber/(float)secondNumber;
                            outString = String.format("%d %s %d = %.2f",firstNumber,opSym[opCode-1],secondNumber,result);
                        }
                        else
                            outString = "Sorry you can't divide by 0";
                        break;
                }
                calState =WAIT_FOR_FIRST_NUMBER;
                break;
            default:
                outString = "Invalid: Logic Error";
        }
        return outString;
    }
    public String opPress (int opCodePressed){
        Log.d(TAG,"opPress()" + opCodePressed );

        String outString = "";

        switch (calState){
            case WAIT_FOR_FIRST_NUMBER:
                //invalid press
                outString = "Invalid: Select a number";
                break;
            case WAIT_FOR_OPERATOR:
            case WAIT_For_SECOND_NUMBER:
                opCode = opCodePressed;
                outString = String.format("%d %s",firstNumber,opSym[opCode-1]);
                calState = WAIT_For_SECOND_NUMBER; //change state
                break;
            default:
                outString = "Invalid: Logic Error";
        }
        return outString;
    }
}
