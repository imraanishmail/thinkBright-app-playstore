package imraan.imraan.thinkbright

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup


val EXTRA_MESSAGE7 =  "com.example.thinkbright.AstronomyQuizResults.MESSAGE"
var userChoiceAstro4 = ""
var intentAstro4 = Intent()

class AstronomyQuiz4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_astronomy_quiz4)

        var radGroupAstro: RadioGroup = findViewById(R.id.radioGroupTop4)
        var saveBtn: Button = findViewById(R.id.btnSaveAstro4)
        var radEarth = RadioButton(this)
        radEarth = findViewById(R.id.radEarthQuiz4)
        var radJupiter = RadioButton(this)
        radJupiter = findViewById(R.id.radJupiterQuiz4)
        var radSaturn = RadioButton(this)
        radSaturn = findViewById(R.id.radSaturnQuiz4)
        var radNeptune = RadioButton(this)
        radNeptune = findViewById(R.id.radNeptuneQuiz4)

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
        var radNeptune = RadioButton(this)
        radNeptune = findViewById(R.id.radNeptuneQuiz4)
        if (radNeptune.isChecked) {
            score++
        }
        val intent = Intent(this, AstronomyQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE, score.toString())
        }
        startActivity(intent)

        var radGroupAstro4 = findViewById<RadioGroup>(R.id.radioGroupTop4)
        var astro4CheckedId = radGroupAstro4.getCheckedRadioButtonId()
        var radBtnAstro4: RadioButton = findViewById(astro4CheckedId)
        userChoiceAstro4 = radBtnAstro4.getText().toString()
        intentAstro4 = Intent(this, AstronomyQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE7, userChoiceAstro4)
        }
    }
}