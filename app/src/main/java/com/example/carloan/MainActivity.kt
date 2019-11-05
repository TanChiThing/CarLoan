package com.example.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan() {
        if(carPrice.text.isEmpty()) {
            carPrice.setError(getString(R.string.error_input))
            return
        }

        if(downPayment.text.isEmpty()) {
            downPayment.setError(getString(R.string.error_input))
            return
        }

        if(loanPeriod.text.isEmpty()) {
            loanPeriod.setError((getString(R.string.error_input)))
            return
        }

        if(interestRate.text.isEmpty()) {
            interestRate.setError(getString(R.string.error_input))
            return

        }

        val carPrice: Int = carPrice.text.toString().toInt()
        val downPayment: Int = downPayment.text.toString().toInt()
        val loan: Int = carPrice - downPayment
        textviewCarLoan.setText(getString(R.string.loan) + "${loan}")

        val carLoan: Int = textviewCarLoan.text.toString().toInt()
        val interestRate: Int = interestRate.text.toString().toInt()
        val loanPeriod: Int = loanPeriod.text.toString().toInt()
        val interest: Int = carLoan * interestRate * loanPeriod
        textviewInterest.setText(getString(R.string.interest) + "${interest}")

        val monthlyRepayment: Int = (carLoan + interest) / loanPeriod / 12
        textviewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")

        Toast.makeText(this, "calculate Loan : ",
            Toast.LENGTH_SHORT).show()

        Toast.makeText(this, "Calculate Interest : ",
            Toast.LENGTH_SHORT).show()

        Toast.makeText(this, "Calculate monthly repayment : ",
            Toast.LENGTH_SHORT).show()


    }

    fun reset(view: View) {
        Toast.makeText(this, "Reset",
            Toast.LENGTH_SHORT).show()

    }


}





