package imraan.imraan.thinkbright

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch


val EXTRA_MESSAGE9 = "com.example.thinkbright.AnimalQuizResults.MESSAGE"
var userChoiceAnimal2 = ""
var intentAnimal2 = Intent()
class AnimalsQuiz2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz2)

        var radGroupAnimal: RadioGroup = findViewById(R.id.radioGroupAnimal2)
        var saveBtn: Button = findViewById(R.id.btnSaveAnimal2)
        var radLion = RadioButton(this)
        radLion = findViewById(R.id.radLion2)
        var radCow = RadioButton(this)
        radCow = findViewById(R.id.radCow2)
        var radPig = RadioButton(this)
        radPig = findViewById(R.id.radPig2)
        var radElephant = RadioButton(this)
        radElephant = findViewById(R.id.radElephant2)

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
        var radCow = RadioButton(this)
        radCow = findViewById(R.id.radCow2)
        if (radCow.isChecked) {
            score2++
        }
        val intent = Intent(this, AnimalsQuiz3::class.java).apply {
        }
        startActivity(intent)

        var radGroupAnimal2 = findViewById<RadioGroup>(R.id.radioGroupAnimal2)
        var animal2CheckedId = radGroupAnimal2.getCheckedRadioButtonId()
        var radBtnAnimal2: RadioButton = findViewById(animal2CheckedId)
        userChoiceAnimal2 = radBtnAnimal2.getText().toString()
        intentAnimal2 = Intent(this, AnimalQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE9, userChoiceAnimal2)
        }
    }

    fun onSwitchClick(view: View) {
        var switchCow = Switch(this)
        switchCow = findViewById(R.id.switchCow)

        if(switchCow.isChecked) {
            val cowSound = MediaPlayer.create(this,R.raw.cow)
            cowSound?.start()
        }
    }
}