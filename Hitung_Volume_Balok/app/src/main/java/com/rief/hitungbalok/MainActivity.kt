package com.rief.hitungbalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edt_panjang: EditText
    private lateinit var edt_lebar:EditText
    private lateinit var edt_tinggi:EditText
    private lateinit var btn_hitung:Button
    private lateinit var tv_result:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt_panjang = findViewById(R.id.edt_panjang)
        edt_lebar = findViewById(R.id.edt_lebar)
        edt_tinggi = findViewById(R.id.edt_tinggi)
        btn_hitung = findViewById(R.id.btn_hitung)
        tv_result = findViewById(R.id.tv_result)

        btn_hitung.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tv_result.text = result
        }
    }

    override fun onClick(v: View?) {
        if(v!!.id == R.id.btn_hitung){
            val inputPanjang = edt_panjang.text.toString().trim()
            val inputLebar = edt_lebar.text.toString().trim()
            val inputTinggi = edt_tinggi.text.toString().trim()

            var isEmptyFields = false

            if(inputPanjang.isEmpty()){
                isEmptyFields = true
                edt_panjang.error = "Bagian ini tidak boleh kosong"
            } else if (inputLebar.isEmpty()){
                isEmptyFields = true
                edt_lebar.error = "Bagian ini tidak boleh kosong"
            } else if (inputTinggi.isEmpty()){
                isEmptyFields = true
                edt_lebar.error = "Bagian ini tidak boleh kosong"
            }

            if(!isEmptyFields){
                val volume = inputPanjang.toDouble() * inputLebar.toDouble() * inputTinggi.toDouble()
                tv_result.text = volume.toString()
            }
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_result.text.toString())
    }
}