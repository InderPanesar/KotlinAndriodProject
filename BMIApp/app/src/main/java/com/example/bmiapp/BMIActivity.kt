package com.example.bmiapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.math.pow


class BMIActivity : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.activity_bmiresult, container, false)
        var height = arguments?.getInt("height", 0)
        var weight = arguments?.getInt("weight", 0)
        var bmi = 0.0;
        if(height != null && weight != null) {
            bmi = weight.toDouble() / (height.toDouble()/100).pow(2.0)
        }

        view.findViewById<TextView>(R.id.textView7).text = String.format("%.2f", bmi)
        view.findViewById<Button>(R.id.recalculate).setOnClickListener {
            dismiss()
        }


        return view
    }
}
