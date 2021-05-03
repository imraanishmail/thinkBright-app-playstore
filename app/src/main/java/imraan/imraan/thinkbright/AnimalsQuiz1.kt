package imraan.imraan.thinkbright

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity



val EXTRA_MESSAGE2 = "imraan.imraan.thinkbright.AnimalQuizResults.MESSAGE"
val EXTRA_MESSAGE8 = "imraan.imraan.thinkbright.AnimalQuizResults.MESSAGE"
var userChoiceAnimal1 = ""
var intentAnimal1 = Intent()
var score2 = 0

class AnimalsQuiz1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz)

        var radGroupAnimal: RadioGroup = findViewById(R.id.radioGroupAnimal1)
        var saveBtn: Button = findViewById(R.id.btnSaveAnimal1)
        var radLion = RadioButton(this)
        radLion = findViewById(R.id.radLion1)
        var radCow = RadioButton(this)
        radCow = findViewById(R.id.radCow1)
        var radPig = RadioButton(this)
        radPig = findViewById(R.id.radPig1)
        var radElephant = RadioButton(this)
        radElephant = findViewById(R.id.radElephant1)

        saveBtn.setEnabled(false)

        radGroupAnimal.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener{ group, checkedId ->
            if(radLion.isChecked) {
                saveBtn.setEnabled(true)
            }
            else if(radCow.isChecked) {
                saveBtn.setEnabled(true)
            }
            else if(radPig.isChecked) {
                saveBtn.setEnabled(true)
            }
            else if(radElephant.isChecked) {
                saveBtn.setEnabled(true)
            }
            else {
                saveBtn.setEnabled(false)
            }
        })
    }

    fun onSave(view: View) {
        var radLion = RadioButton(this)
        radLion = findViewById(R.id.radLion1)
        if (radLion.isChecked) {
            score2++
        }

        val intent = Intent(this, AnimalsQuiz2::class.java).apply {
        }
        startActivity(intent)

        var radGroupAnimal1 = findViewById<RadioGroup>(R.id.radioGroupAnimal1)
        var animal1CheckedId = radGroupAnimal1.getCheckedRadioButtonId()
        var radBtnAnimal1: RadioButton = findViewById(animal1CheckedId)
        userChoiceAnimal1 = radBtnAnimal1.getText().toString()
        intentAnimal1 = Intent(this, AnimalQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE8, userChoiceAnimal1)
        }

    }

    fun onSwitchClick(view: View) {

        var switchLion = Switch(this)
        switchLion = findViewById(R.id.switchLion)

        if(switchLion.isChecked) {
            val lionSound = MediaPlayer.create(this,R.raw.lion)
            lionSound?.start()
        }
    }
}