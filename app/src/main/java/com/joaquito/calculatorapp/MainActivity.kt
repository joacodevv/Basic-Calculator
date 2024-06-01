package com.joaquito.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.method.ScrollingMovementMethod
import android.widget.Toast
import com.joaquito.calculatorapp.databinding.ActivityMainBinding
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager
import javax.script.ScriptException

class MainActivity : AppCompatActivity() {

    var check = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.inputNumber.movementMethod = ScrollingMovementMethod()
        binding.inputNumber.isActivated = true
        binding.inputNumber.isPressed = true
        var text:String

        binding.btn1.setOnClickListener {
            text = binding.inputNumber.text.toString()+"1"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn2.setOnClickListener {
            text = binding.inputNumber.text.toString()+"2"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn3.setOnClickListener {
            text = binding.inputNumber.text.toString()+"3"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn4.setOnClickListener {
            text = binding.inputNumber.text.toString()+"4"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn5.setOnClickListener {
            text = binding.inputNumber.text.toString()+"5"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn6.setOnClickListener {
            text = binding.inputNumber.text.toString()+"6"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn7.setOnClickListener {
            text = binding.inputNumber.text.toString()+"7"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn8.setOnClickListener {
            text = binding.inputNumber.text.toString()+"8"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn9.setOnClickListener {
            text = binding.inputNumber.text.toString()+"9"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn0.setOnClickListener {
            text = binding.inputNumber.text.toString()+"0"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btn00.setOnClickListener {
            text = binding.inputNumber.text.toString()+"00"
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.btnComa.setOnClickListener {
            text = binding.inputNumber.text.toString()+"."
            binding.inputNumber.setText(text)
            result(text)
        }

        binding.add.setOnClickListener {
            text = binding.inputNumber.text.toString()+"+"
            binding.inputNumber.setText(text)
            check += 1

        }

        binding.subtract.setOnClickListener {
            text = binding.inputNumber.text.toString()+"-"
            binding.inputNumber.setText(text)
            check += 1

        }

        binding.multiply.setOnClickListener {
            text = binding.inputNumber.text.toString()+"*"
            binding.inputNumber.setText(text)
            check += 1

        }

        binding.divide.setOnClickListener {
            text = binding.inputNumber.text.toString()+"÷"
            binding.inputNumber.setText(text)
            check += 1

        }

        binding.btnPercentage.setOnClickListener {
            text = binding.inputNumber.text.toString()+"%"
            binding.inputNumber.setText(text)
            check += 1

        }

        binding.equal.setOnClickListener {
            text = binding.result.text.toString()
            binding.inputNumber.setText(text)
            binding.result.text = null
        }

        binding.clear.setOnClickListener {
            binding.inputNumber.text = null
            binding.result.text = null
        }

        binding.erase.setOnClickListener {
            var backSpace: String? = null
            if (!binding.inputNumber.text.isNullOrEmpty()){
                val stringBuilder: StringBuilder = java.lang.StringBuilder(binding.inputNumber.text)
                val find = binding.inputNumber.text.toString()
                val find2 = find.last()
                if (find2.equals("+")||find2.equals("-")||find2.equals("*")||find2.equals("÷")||find2.equals("%")){

                    check -= 1
                }
                stringBuilder.deleteCharAt(binding.inputNumber.text.length-1)
                backSpace = stringBuilder.toString()
                binding.inputNumber.setText(backSpace)
                result(backSpace)
        }

    }


}

    private fun result(text: String) {
        val engine: ScriptEngine = ScriptEngineManager().getEngineByName("rhino")
        try {
            val result: Any = engine.eval(text)
            var mainResult = result.toString()
            if (check == 0){
                binding.result.text = null
            }else{
                binding.result.setText(mainResult)
            }

        }catch (e: ScriptException){
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
    }
}




