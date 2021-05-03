package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup


val EXTRA_MESSAGE6 =  "com.example.thinkbright.AstronomyQuizResults.MESSAGE"
var userChoiceAstro3 = ""
var intentAstro3 = Intent()

class AstronomyQuiz3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy_quiz3)

        var radGroupAstro: RadioGroup = findViewById(R.id.radioGroupTop3)
        var saveBtn: Button = findViewById(R.id.btnSaveAstro3)
        var radEarth = RadioButton(this)
        radEarth = findViewById(R.id.radEarthQuiz3)
        var radJupiter = RadioButton(this)
        radJupiter = findViewById(R.id.radJupiterQuiz3)
        var radSaturn = RadioButton(this)
        radSaturn = findViewById(R.id.radSaturnQuiz3)
        var radNeptune = RadioButton(this)
        radNeptune = findViewById(R.id.radNeptuneQuiz3)

        saveBtn.setEnabled(false)

        radGroupAstro.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener{ group, checkedId ->
                    if(radEarth.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radJupiter.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radSaturn.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radNeptune.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else {
                        saveBtn.setEnabled(false)
                    }
                })
    }

    fun onSave(view: View) {
        var radSaturn = RadioButton(this)
        radSaturn= findViewById(R.id.radSaturnQuiz3)
        if (radSaturn.isChecked) {
            score++
        }
        val intent = Intent(this, AstronomyQuiz4::class.java).apply {
        }
        startActivity(intent)

        var radGroupAstro3 = findViewById<RadioGroup>(R.id.radioGroupTop3)
        var astro3CheckedId = radGroupAstro3.getCheckedRadioButtonId()
        var radBtnAstro3: RadioButton = findViewById(astro3CheckedId)
        userChoiceAstro3 = radBtnAstro3.getText().toString()
        intentAstro3 = Intent(this, AstronomyQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE6, userChoiceAstro3)
        }
    }
}