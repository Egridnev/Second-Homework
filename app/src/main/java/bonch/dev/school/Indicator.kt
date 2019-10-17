package bonch.dev.school

class Indicator(initialState:Boolean = false){
    var pressed:Boolean = initialState

    fun changeState(){

        if(!this.pressed){
            this.pressed = true
        }
    }
}