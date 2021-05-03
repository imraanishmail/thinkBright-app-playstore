package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup


val EXTRA_MESSAGE5 =  "com.example.thinkbright.AstronomyQuizResults.MESSAGE"
var userChoiceAstro2 = ""
var intentAstro2 = Intent()

class AstronomyQuiz2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy_quiz2)

        var radGroupAstro: RadioGroup = findViewById(R.id.radioGroupTop2)
        var saveBtn: Button = findViewById(R.id.btnSaveAstro2)
        var radEarth = RadioButton(this)
        radEarth = findViewById(R.id.radEarthQuiz2)
        var radJupiter = RadioButton(this)
        radJupiter = findViewById(R.id.radJupiterQuiz2)
        var radSaturn = RadioButton(this)
        radSaturn = findViewById(R.id.radSaturnQuiz2)
        var radNeptune = RadioButton(this)
        radNeptune = findViewById(R.id.radNeptuneQuiz2)

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
        var radJupiter = RadioButton(this)
        radJupiter = findViewById(R.id.radJupiterQuiz2)
        if (radJupiter.isChecked) {
            score++
        }

        val intent = Intent(this, AstronomyQuiz3::class.java).apply {
        }
        startActivity(intent)

        var radGroupAstro2 = findViewById<RadioGroup>(R.id.radioGroupTop2)
        var astro2CheckedId = radGroupAstro2.getCheckedRadioButtonId()
        var radBtnAstro2: RadioButton = findViewById(astro2CheckedId)
        userChoiceAstro2 = radBtnAstro2.getText().toString()
        intentAstro2 = Intent(this, AstronomyQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE5, userChoiceAstro2)
        }
    }
}