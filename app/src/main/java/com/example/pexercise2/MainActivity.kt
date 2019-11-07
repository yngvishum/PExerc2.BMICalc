package com.example.pexercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalc.setOnClickListener{
            calcBMI();
        }

        btnReset.setOnClickListener{
            resetInput();
        }
    }

    private fun calcBMI(){
        val height : Float = editTextHeight.text.toString().toFloat();
        val weight : Float = editTextWeight.text.toString().toFloat();
        val BMI = weight / height.pow(2);
        txtBMIResult.text = String.format("%s %.2f",getString(R.string.bmi), BMI);

        if(BMI < 18.5){
            txtBMIStatus.text = String.format("%s %s", getString(R.string.status), getString(R.string.underweight));
            imgProfile.setImageResource(R.drawable.under);
        }
        else if (BMI < 24.9){
            txtBMIStatus.text = String.format("%s %s", getString(R.string.status), getString(R.string.normal));
            imgProfile.setImageResource(R.drawable.normal);
        }
        else{
            txtBMIStatus.text = String.format("%s %s", getString(R.string.status), getString(R.string.overweight));
            imgProfile.setImageResource(R.drawable.over);
        }

    }

    private fun resetInput(){
        //TODO clear all inputs and outputs
        txtBMIResult.text = getString(R.string.bmi);
        txtBMIStatus.text = getString(R.string.status);
        editTextHeight.setText(R.string.prompt_height);
        editTextWeight.setText(R.string.prompt_weight);
        imgProfile.setBackgroundResource(R.drawable.empty);
    }

}
