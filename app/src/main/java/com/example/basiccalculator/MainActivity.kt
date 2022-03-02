package com.example.basiccalculator
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.basiccalculator.databinding.ActivityMainBinding
import timber.log.Timber
import kotlin.math.min

class MainActivity :AppCompatActivity(){
    var sum = 0L
    var diff=0L
    var product=0L
    var div=0.0
    var plusButtonCheck=false
    var minusButtonCheck=false
    var mulButtonCheck=false
    var divButtonCheck=false
    fun addText(operation:String) {
        Timber.i("add text is called ")
        binding.editTextNumberDecimal2.append(operation)
    }
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
  binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
            binding.zeroButton.setOnClickListener {
                addText("0")
            }
            binding.oneButton.setOnClickListener {
                addText("1")
            }
            binding.twoButton.setOnClickListener {
                addText("2")
            }
            binding.threeButton.setOnClickListener {
                addText("3")
            }
            binding.fourButton.setOnClickListener {
                addText("4")
            }
            binding.fiveButton.setOnClickListener {
                addText("5")
            }
            binding.sixButton.setOnClickListener {
                addText("6")
            }
            binding.sevenButton.setOnClickListener {
                addText("7")
            }
            binding.eightButton.setOnClickListener {
                addText("8")
            }
            binding.nineButton.setOnClickListener {
                addText("9")
            }
            binding.acButton.setOnClickListener {
                binding.editTextNumberDecimal2.setText("0")
                plusButtonCheck=false
                minusButtonCheck=false
                mulButtonCheck=false
                divButtonCheck=false
            }
            binding.pointButton.setOnClickListener {
                addText(".")
            }
      binding.plusButton.setOnClickListener {

          var num1 = binding.editTextNumberDecimal2.text.toString()
          addText("+")
          binding.editTextNumberDecimal2.text.append("")
          plusButtonCheck=true

      }
        binding.divButton.setOnClickListener {
            addText("/")
            binding.editTextNumberDecimal2.text.append("")
            divButtonCheck=true
        }
        binding.mulButton.setOnClickListener{
            addText("*")
            binding.editTextNumberDecimal2.text.append("")
            mulButtonCheck=true
        }
        binding.equalsButton.setOnClickListener {
            var temp= List<String>(5){""}
            if(plusButtonCheck) {
                temp = binding.editTextNumberDecimal2.text.split("+")
                for (i in temp) {
                    sum += i.toLong()
                }
                binding.editTextNumberDecimal2.text.clear()
                plusButtonCheck=false
                binding.editTextNumberDecimal2.text.append(sum.toString())
                sum=0L
            }
            if(minusButtonCheck){
            temp=binding.editTextNumberDecimal2.text.split("-")
                Log.i("sub","$temp")
                diff= temp[0].toLong()
                for (i in 1 until temp.size) {
                    diff -= temp[i].toLong()
                }
                binding.editTextNumberDecimal2.text.clear()
                minusButtonCheck=false
                binding.editTextNumberDecimal2.text.append(diff.toString())
                diff=0L
            }
            if(divButtonCheck) {
                temp= binding.editTextNumberDecimal2.text.split("/")
                div=temp[0].toDouble()
                for (i in 1 until temp.size) {
                    div /= temp[i].toLong()
                }
                binding.editTextNumberDecimal2.text.clear()
                divButtonCheck=false
                binding.editTextNumberDecimal2.text.append(div.toString())
                div=0.0
            }
            if(mulButtonCheck) {
                temp = binding.editTextNumberDecimal2.text.split("*")
                Log.i("sub","$temp")
                product=temp[0].toLong()
                for (i in 1 until temp.size) {
                    product *= temp[i].toLong()
                }
                binding.editTextNumberDecimal2.text.clear()
                mulButtonCheck=false
                binding.editTextNumberDecimal2.text.append(product.toString())
                product=0L
            }
//            Log.i("plusbutton", "$temp")
            Log.i("plusButton", "$sum")
        }
        binding.minusButton.setOnClickListener {
            minusButtonCheck=true
            addText("-")
            var temp=binding.editTextNumberDecimal2.text.toString()
            binding.editTextNumberDecimal2.append("")
        }


    }



}


