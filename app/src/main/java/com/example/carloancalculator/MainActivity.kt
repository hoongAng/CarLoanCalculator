package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonConfirm.setOnClickListener{
            addPlateNo(it)
        }

        buttonCalculate.setOnClickListener(){
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        val carPrice = editPrice.text.toString().toInt();
        val downPayment = editDownPayment.text.toString().toInt();
        val loanPeriod = editLoanPeriod.text.toString().toInt();
        val interestRate = editInterestRate.text.toString().toFloat();

        val loan = carPrice - downPayment

        textDisplayLoan.text = getString(R.string.displayLoan) +": ${loan}"

        val interest = loan * interestRate * loanPeriod

        textDisplayInterest.text = getString(R.string.displayInterest) +":${interest}"

        val monthlyRepayment = (loan+interest)/loanPeriod/12

        textDisplayRepayment.text = getString(R.string.displayRepayment) +":${monthlyRepayment}"
    }


    fun resetInput(view:View){
        textDisplayLoan.text = " ";
        textDisplayInterest.text = " ";
        textDisplayRepayment.text = " ";
    }

    private fun addPlateNo(view:View){
        val editText = findViewById<EditText>(R.id.platNoEdit)
        val platNo = findViewById<TextView>(R.id.textPlateNo)
        platNo.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        platNo.visibility = View.VISIBLE
    }
}
