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


val EXTRA_MESSAGE10 = "com.example.thinkbright.AnimalQuizResults.MESSAGE"
var userChoiceAnimal3 = ""
var intentAnimal3 = Intent()
class AnimalsQuiz3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals_quiz3)

        var radGroupAnimal: RadioGroup = findViewById(R.id.radioGroupAnimal3)
        var saveBtn: Button = findViewById(R.id.btnSaveAnimal3)
        var radPig = RadioButton(this)
        radPig = findViewById(R.id.radPig3)
        var radElephant = RadioButton(this)
        radElephant = findViewById(R.id.radElephant3)
        var radCat = RadioButton(this)
        radCat = findViewById(R.id.radCat1)
        var radDog = RadioButton(this)
        radDog = findViewById(R.id.radDog1)

        saveBtn.setEnabled(false)

        radGroupAnimal.setOnCheckedChangeListener(
                RadioGroup.OnCheckedChangeListener{ group, checkedId ->
                    if(radPig.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radElephant.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radCat.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else if(radDog.isChecked) {
                        saveBtn.setEnabled(true)
                    }
                    else {
                        saveBtn.setEnabled(false)
                    }
                })
    }

    fun onSave(view: View) {
        var radCat = RadioButton(this)
        radCat = findViewById(R.id.radCat1)
        if (radCat.isChecked) {
            score2++
        }
        val intent = Intent(this, AnimalsQuiz4::class.java).apply {
        }
        startActivity(intent)

        var radGroupAnimal3 = findViewById<RadioGroup>(R.id.radioGroupAnimal3)
        var animal3CheckedId = radGroupAnimal3.getCheckedRadioButtonId()
        var radBtnAnimal3: RadioButton = findViewById(animal3CheckedId)
        userChoiceAnimal3 = radBtnAnimal3.getText().toString()
        intentAnimal3 = Intent(this, AnimalQuizResults::class.java).apply {
            putExtra(EXTRA_MESSAGE10, userChoiceAnimal3)
        }
    }

    fun onSwitchClick(view: View) {
        var switchCat = Switch(this)
        switchCat= findViewById(R.id.switchCat)

        if(switchCat.isChecked) {
            val catSound = MediaPlayer.create(this,R.raw.cat)
            catSound?.start()
        }
    }
}