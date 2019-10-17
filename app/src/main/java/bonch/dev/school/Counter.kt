package bonch.dev.school

class Counter(startCounter:Int = 0){
    var currentCount = startCounter
        private set

    fun increment(){
        ++currentCount
    }
}