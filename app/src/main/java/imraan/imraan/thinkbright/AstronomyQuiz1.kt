package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup


val EXTRA_MESSAGE =  "com.example.thinkbright.AstronomyQuizResults.MESSAGE"
val EXTRA_MESSAGE4 =  "com.example.thinkbright.AstronomyQuizResults.MESSAGE"
var score = 0
var userChoiceAstro1 = ""
var intentAstro1 = Intent()
//var radioGroupQuiz1Astro = RadioGroup()
class AstronomyQuiz1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy_quiz1)

        var radGroupAstro: RadioGroup = findViewById(R.id.radioGroupTop1)
        var saveBtn: Button = findViewById(R.id.btnSaveAstro1)
        var radEarth = RadioButton(this)
        radEarth = findViewById(R.id.radEarthQuiz1)
        var radJupiter = RadioButton(this)
        radJupiter = findViewById(R.id.radJupiterQuiz1)
        var radSaturn = RadioButton(this)
        radSaturn = findViewById(R.id.radSaturnQuiz1)
        var radNeptune = RadioButton(this)
        radNeptune = findViewById(R.id.radNeptuneQuiz1)

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
        var radEarth = RadioButton(this)
        radEarth = findViewById(R.id.radEarthQuiz1)
        if (radEarth.isChecked) {
            score++
        }
        val intent = Intent(this, AstronomyQuiz2::class.java).apply {
        }
        startActivity(intent)
        var radGroupAstro1 = findViewById<RadioGroup>(R.id.radioGroupTop1)
        var astro1CheckedId = radGroupAstro1.getCheckedRadioButtonId()
        var radBtnAstro1: RadioButton = findViewById(astro1CheckedId)
        userChoiceAstro1 = radBtnAstro1.getText().toString()
        intentAstro1 = Intent(this, AstronomyQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE4, userChoiceAstro1)
        }
    }
}